package FxmlTrail.FxmlTrail;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class LoginController  {
	
	@FXML
	private TextField textUsername;
	
	@FXML
	private TextField textPassword;
	
	@FXML
	private VBox vbox;
	
	@FXML
	private Label usernameLabel,passLabel,loginLabel;
	
	@FXML
	private Button btn;
	
	private static  String username;
	private String password;
	String fxmlDocPath = "E:\\JavaFX_training\\FxmlTrail\\src\\main\\java\\FxmlTrail\\FxmlTrail\\subHome.fxml";
	String fxmlDocPath2;
	FileInputStream fxmlStream2;
	 VBox root2;
	 VBox root; 
	  AnchorPane pane;
	  @FXML	
	  public void initialize() {
		  Font font = Font.font("Times New Roman", FontWeight.BOLD, 13);
		  usernameLabel.setFont(font);
		  passLabel.setFont(font);
		  btn.setFont(font);
		  loginLabel.setFont(font);
	  }
	
	@FXML
	private void login() throws IOException
	{
		this.username = textUsername.getText();
		this.password = textPassword.getText();
	
	
		System.out.println("Username : "+username);
		System.out.println("Password : "+password);      
		
		
		  vbox.getScene().getWindow().hide();
		  FXMLLoader loader = new FXMLLoader(); 
		
		  
		 
		  if(username!= null && username.equals("pub")) {
			  System.out.println("user publisher");
			  fxmlDocPath2 = "E:\\JavaFX_training\\FxmlTrail\\src\\\\main\\java\\FxmlTrail\\FxmlTrail\\AddUser.fxml";
	          fxmlDocPath = "E:\\JavaFX_training\\FxmlTrail\\src\\main\\java\\FxmlTrail\\FxmlTrail\\pubHome.fxml";
	          fxmlStream2 = new FileInputStream(fxmlDocPath2);
	          root2 = (VBox) loader.load(fxmlStream2);
	          root2.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(10))));
	          
	          TabPane tabPane = new TabPane();
			  tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
			  Tab tab1 = new Tab();
			  tab1.setText("MESSAGE");
			  tab1.setStyle("-fx-font-weight: bold;");
			  
			  Tab tab2 = new Tab();
			  tab2.setText("ADD USER");
			  tab2.setStyle("-fx-font-weight: bold;");
			  FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);

		        tabPane.getTabs().addAll(tab1,tab2);
		        pane = new AnchorPane();
		        AnchorPane.setTopAnchor(tabPane, 15.0);
		        AnchorPane.setRightAnchor(tabPane, 15.0);
		        AnchorPane.setBottomAnchor(tabPane, 15.0);
		        AnchorPane.setLeftAnchor(tabPane, 15.0);
		        pane.getChildren().addAll(tabPane);
		        VBox root = (VBox) loader.load(fxmlStream);
		        tab1.setContent(root);
		        root.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(10))));	        
		        tab2.setContent(root2);
		  }
		 
		  else {
			  FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
			  root = (VBox) loader.load(fxmlStream);
		  }
	        
	        

	        Stage stage = new Stage();
	     
	        
	        Platform.runLater(new Runnable() {
	            @Override
	            public void run() {
	                try {
	        	        if(username!= null && username.equals("pub")) {
	        	        	System.out.println("stage for pub");
	        	        stage.setScene(new Scene(pane,450,600));
	        	        stage.setResizable(false);  	        	} 
	        	        else {
	        	        	 stage.setScene(new Scene(root,300,300));
	        	        }
	                } catch (Exception e) {
	                   System.out.println("Exception" +e);
	                }
	            }
	        });

	       
	        stage.setTitle("Home page");
	        stage.show();
		
	}
	public static String getUsername() {
		return username;
	}
	

}
