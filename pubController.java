package FxmlTrail.FxmlTrail;

import java.util.ArrayList;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class pubController {
	@FXML
	TextField sendAllText,sendText;
	@FXML
	Label selectLabel,msgTitle, enterLabel, sendParticilarLabel, welcomeLabel, msgAllUserLabel, sendAllTitleLabel;
	@FXML
	Button sendBtn, sendAllBtn;
	@FXML
	VBox subList, msgToUserBox, homeVboxPub, msgAllUser,message;

	public CheckBox pcheckBox;
	
	public CheckBox getPcheckBox() {
		return pcheckBox;
	}

	public void setPcheckBox(CheckBox pcheckBox) {
		this.pcheckBox = pcheckBox;
	}

	String Username;
	String topic = "connected";
	MqttClient publisher;
	String broker = "tcp://localhost:1883";
	ArrayList checkboxList = new ArrayList();
	ArrayList selectedList = new ArrayList();

	@FXML
	public void initialize() throws MqttException {

		this.publisher = new MqttClient(broker, "publisher");
		publisher.setCallback(mCallback);
		publisher.connect();
		publisher.subscribe(topic);
		publisher.subscribe("disconnect");
		/* styles */
		message.setStyle(
				"-fx-background-color: white; " + "-fx-effect: dropshadow(three-pass-box, black, 10, 0, 0, 0);");

		Font font = Font.font("Times New Roman", FontWeight.BOLD, 13);
		msgTitle.setFont(font);
		selectLabel.setFont(font);
		enterLabel.setFont(font);
		welcomeLabel.setFont(font);
		msgAllUserLabel.setFont(font);
		sendParticilarLabel.setFont(font);
		sendAllTitleLabel.setFont(font);
		sendAllBtn.setFont(font);
		sendBtn.setFont(font);
		msgToUserBox.setStyle(
				"-fx-background-color: white; " + "-fx-effect: dropshadow(three-pass-box, black, 10, 0, 0, 0);");
		subList.setStyle(
				"-fx-background-color: white; " + "-fx-effect: dropshadow(three-pass-box, black, 10, 0, 0, 0);");
		msgAllUser.setStyle(
				"-fx-background-color: white; " + "-fx-effect: dropshadow(three-pass-box, black, 10, 0, 0, 0);");
		msgToUserBox.setPadding(new Insets(0, 20, 10, 20));
		msgToUserBox.setSpacing(10);
		homeVboxPub.setSpacing(10);
		msgAllUser.setSpacing(10);
		msgAllUser.setPadding(new Insets(0, 20, 10, 20));
		homeVboxPub.setPadding(new Insets(0, 20, 10, 20));
		subList.setPadding(new Insets(5, 20, 10, 20));
		subList.setSpacing(6.5);
		message.setPadding(new Insets(5, 20, 10, 10));
		message.setSpacing(6.5);
	}

	@FXML
	void sendAll() throws MqttPersistenceException, MqttException {
		String msg = sendAllText.getText();
		sendAllText.clear();
		MqttMessage mqttMessage = new MqttMessage(msg.getBytes());
		String sendAll = "Comman";
		publisher.publish(sendAll, mqttMessage);
	}

	@FXML
	void send() throws MqttException {
		System.out.println("send method");

		String msg = sendText.getText();
		sendText.clear();
		MqttMessage mqttMessage = new MqttMessage(msg.getBytes());

		System.out.println(msg);

		System.out.println(selectedList);
		for (int i = 0; i < selectedList.size(); i++) {
			System.out.println("username " + selectedList.get(i));
			String topic = "PrivateMsg " + selectedList.get(i);
			System.out.println("publishing on topic " + topic);
			publisher.publish(topic, mqttMessage);
		}

	}

	void addNewCheck(String username) {

		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {

					CheckBox checkBox = new CheckBox(username);
					checkBox.setId(username);
					checkBox.selectedProperty()
							.addListener((ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
								System.out.println("new_val " + new_val);
								System.out.println("old_val " + old_val);
								if (new_val) {
									addList(username);
								} else {
									remove(username);
								}
							});

					subList.getChildren().add(checkBox);
					addUsersList(username);
					setPcheckBox(checkBox);

				} catch (Exception e) {
					System.out.println("Exception" + e);
				}
			}

		});

	}

	private final MqttCallbackExtended mCallback = new MqttCallbackExtended() {
		@Override
		public void connectComplete(boolean reconnect, String brokerAddress) {
			System.out.println("Connection complete ");
		}

		@Override
		public void connectionLost(Throwable ex) {
			System.out.println("Connection lost");
		}

		@Override
		public void deliveryComplete(IMqttDeliveryToken deliveryToken) {
			System.out.println("delivery compeleted " + deliveryToken.getClient().getClientId());
		}

		@Override
		public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
			System.out.println("Message arrived to publisher " + mqttMessage);
			String msg = mqttMessage.toString();

			if (msg.startsWith("I m disconnecting ")) {
				System.out.println("message box children " + message.getChildren());
				System.out.println("User disconnected : " + msg);
				String[] arr = msg.split("- ");
				String username = arr[1];
				System.out.println("Username checkbox need to be deleted " + username);
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						try {
							 message.setSpacing(10.0);
							 HBox messageBox= new HBox();
							 messageBox.setSpacing(6.5);
							 messageBox.setPadding(new Insets(10, 10, 10, 10));

							Label messageText = new Label(msg);
							Button ack = new Button("Acknowledge");
							ack.setMaxWidth(100.0);
							ack.setMaxHeight(10.0);
							Font font = Font.font("Times New Roman", FontWeight.BOLD, 13);
							ack.setFont(font);
							
							ack.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {

									messageBox.getChildren().removeAll(messageText, ack);
									message.getChildren().remove(messageBox);
									subList.getChildren().remove(getPcheckBox().getId().equals(username));

								}
							});
							messageBox.getChildren().addAll(messageText, ack);
							message.getChildren().add(messageBox);

						} catch (Exception e) {
							System.out.println("Exception" + e);
						}
					}
				});

			} else {
				String[] arrSplit = msg.split(", ");
				Username = arrSplit[1];
				System.out.println("Username connected " + Username);
				addNewCheck(Username);
			}
		}

	};

	private void addList(String username) {

		if (!selectedList.contains(username)) {
			System.out.println("username is not in list ");
			selectedList.add(username);
			System.out.println("username added to list " + selectedList);
		} else {

			System.out.println("username added already so so nothing");
		}
	}

	private void remove(String username) {

		if (selectedList.contains(username)) {
			System.out.println("user addded to list so removing");
			selectedList.remove(username);
			System.out.println("username removed " + selectedList);
		} else {
			System.out.println("user is not added to list yet so do nothing");
		}

	}

	private void addUsersList(String username) {
		checkboxList.add(username);

	}
}
