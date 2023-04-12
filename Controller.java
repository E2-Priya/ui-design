package Load.LoadTestMqtt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;

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
	
	@FXML
	private TextField message;
	
	static ArrayList usersList = new ArrayList();
	String sendALLTopic = "sendAll";
	
	static Label usernameLabel;
	String username;
	
	MqttClient publisher;
	MqttClient subscriber;
	String broker = "tcp://localhost:1883";

	public void initialize() throws MqttException, FileNotFoundException {
	
		
		  File file = new File("E:\\mqtt-analysis\\mqttLoadTest.txt");
	      PrintStream stream = new PrintStream(file);
	      System.out.println("From now on "+file.getAbsolutePath()+" will be your console");
	      System.setOut(stream);
		
		this.publisher = new MqttClient(broker, "publisher");
		publisher.setCallback(mCallback);
		publisher.connect();
		publisher.subscribe("ConnectedConfirm",2);
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
			
			String msg = mqttMessage.toString();
			if(msg.startsWith("User connected, ")) {
			System.out.println("Message arrived "+mqttMessage);
			String[] arrSplit = msg.split(", ");	
			username = arrSplit[1];
			addnewLabel(username);
			}
			
			else {
				   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");  
				   LocalDateTime now = LocalDateTime.now(); 
				   System.out.println(msg+" at the time - " +dtf.format(now) );
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
			userId = "user"+i;
			subscriber = new MqttClient(broker, userId);
			subscriber.setCallback(mCallback);
			subscriber.connect();	
			usersList.add(userId);
			msg ="User connected, "+userId;
			mqttMsg = new MqttMessage(msg.getBytes());
			subscriber.publish("ConnectedConfirm", mqttMsg);
		}

	}
	
	@FXML
	void send() throws MqttPersistenceException, MqttException {
		String msg;
		MqttMessage mqttMsg;
		subscriber.subscribe(sendALLTopic,2);
		for(int i=0;i<usersList.size();i++) {
			msg = "Msg : '"+message.getText()+  "' received to the user "+ usersList.get(i);
			mqttMsg = new MqttMessage(msg.getBytes());
			mqttMsg.setQos(2);			
			publisher.publish(sendALLTopic, mqttMsg);
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
