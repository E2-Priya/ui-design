package Load.LoadTestMqtt;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class Controller {

	@FXML
	private TextField inputText;
	
	@FXML
	private FlowPane Listing;
	
	static Label usernameLabel;
	String username;
	
	MqttClient publisher;
	MqttClient subscriber;
	String broker = "tcp://localhost:1883";

	public void initialize() throws MqttException {
		this.publisher = new MqttClient(broker, "publisher");
		publisher.setCallback(mCallback);
		publisher.connect();
		publisher.subscribe("ConnectedConfirm");
		Listing.setHgap(10);
	}

	private final MqttCallbackExtended mCallback = new MqttCallbackExtended() {
		public void connectComplete(boolean reconnect, String brokerAddress) {
			System.out.println("connection completed");

		}

		public void connectionLost(Throwable ex) {

		}

		public void deliveryComplete(IMqttDeliveryToken deliveryToken) {

		}

		public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
			System.out.println("Message arrived "+mqttMessage);
			
			String msg = mqttMessage.toString();
			String[] arrSplit = msg.split(", ");	
			username = arrSplit[1];
			addnewLabel(username);
			}
		}

	};

	@FXML
	private void submit() throws MqttException {
		String numUsersToBeCreated = inputText.getText();
		int users = Integer.parseInt(numUsersToBeCreated);
		String userId; 
		String msg ;
		MqttMessage mqttMsg ;
		for(int i =1; i<=users ; i++) {
			System.out.println("Users "+i);
			userId = "user"+i;
			subscriber = new MqttClient(broker, userId);
			subscriber.setCallback(mCallback);
			subscriber.connect();	
			msg ="User connected, "+userId;
			mqttMsg = new MqttMessage(msg.getBytes());
			subscriber.publish("ConnectedConfirm", mqttMsg);
		}

	}
	
	

	 void addnewLabel(final String username) {
		 Platform.runLater(new Runnable() {
	            public void run() {
	                try {	
	                	usernameLabel = new Label();
	                	usernameLabel.setText(username);
	            		Listing.getChildren().addAll(usernameLabel);   
	                } catch (Exception e) {
	                   System.out.println("Exception" +e);
	                }
	            }
	        });
		
	}
}
