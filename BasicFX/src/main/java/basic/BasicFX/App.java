package basic.BasicFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

	private static Scene scene;

	@Override
	public void start(Stage stage) throws IOException {
		/*stage.setX(300);
		stage.setY(300);
		stage.setHeight(400);
		stage.setWidth(400);

		VBox root = new VBox();
		root.setMinSize(100, 100);
		Text text = new Text("Hello");
		
		
		root.getChildren().add(text);
		root.setStyle("-fx-background-color: darkslateblue;");

		VBox vbox = new VBox();
		vbox.setMinSize(100, 100);
		Text text1 = new Text("Hello2");
		vbox.getChildren().add(text1);
		vbox.setStyle("-fx-background-color: orange;");
		
		/*VBox vbox = new VBox();
		FileInputStream input = new FileInputStream("/home/devuser/Downloads/ICON_FX.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        vbox.getChildren().add(imageView);
        
		VBox v1 = new VBox();
		v1.setMinSize(100, 50);
		v1.setMaxSize(300, 50);
		v1.setStyle("-fx-background:black");
		Button b1 = new Button("CLICK");
		b1.setMinSize(200, 100);
		b1.setPrefSize(400, 100);
		v1.getChildren().add(b1);
		
		
		Text text11 = new Text("This is text");
		text11.setFontSmoothingType(FontSmoothingType.LCD);
		
		VBox main = new VBox();
		main.getChildren().addAll(vbox, root,v1,text11);
		Scene mainScene = new Scene(main, 300, 300);
        
       
		stage.setScene(mainScene);

		stage.show();
	
		
		*/
		
		 TabPane tabPane = new TabPane();

	        Tab tab1 = new Tab("HTML", new Label("This is HTML"));
	        Tab tab2 = new Tab("FXML"  , new Label("This is FXML"));
	        Tab tab3 = new Tab("FX" , new Label("This is FX"));
	        
	        tab1.setClosable(false);
	        tab2.setClosable(false);
	        tab3.setClosable(false);
	        


	        tabPane.getTabs().add(tab1);
	        tabPane.getTabs().add(tab2);
	        tabPane.getTabs().add(tab3);
	        
	     
	        tabPane.setTabMinWidth(150);

	        VBox vBox = new VBox(tabPane);

	        Scene scene = new Scene(vBox);

	        stage.setScene(scene);
	        stage.setTitle("JavaFX App");
	        stage.setX(300);
			stage.setY(300);
			stage.setHeight(400);
			stage.setWidth(510);
			stage.setResizable(false);
	        stage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}