package org.openjfx.hellofx;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

	@Override
	public void start(Stage stage) {
		VBox root = new VBox();
		root.setSpacing(20);
		Scene scene = new Scene(root, Color.ALICEBLUE);

		// setting title for stage
		stage.setTitle("This is JAVA FX ");

		// Setting the stage as fixed
		stage.setWidth(420);
		stage.setHeight(420);
		stage.setResizable(false);

		// Setting Image as icon
		/*
		 * Image icon = new Image("ICON_FX.jpeg"); stage.getIcons().add(icon);
		 */

		Text text = new Text();
		text.setText("Welcome");
		text.setFill(Color.BLACK);
		root.getChildren().add(text);

		Line line = new Line();
		line.setStartX(55);
		root.getChildren().add(line);

		/*
		 * Image image = new Image("ICON_FX.png"); ImageView iv = new ImageView(image);
		 * iv.setX(50); iv.setY(50); root.getChildren().add(iv);
		 */

		Button button = new Button("THIS IS BUTTON");
		button.setOnAction(new EventHandler<ActionEvent>() {
			 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Button was clicked !");
            }
        });
		root.getChildren().add(button);

		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}