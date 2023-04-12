package Load.LoadTestMqtt;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App extends Application
{
	public static void main(String[] args) 
    {
        Application.launch(args);
    }
     
    @Override
    public void start(Stage stage) throws IOException
    {

        FXMLLoader loader = new FXMLLoader();
 
        String fxmlDocPath = "E:\\JavaFX_training\\LoadTestMqtt\\src\\main\\java\\Load\\LoadTestMqtt\\Myfxml.fxml";
        FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);


        VBox root = (VBox) loader.load(fxmlStream);
        root.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(10))));
 

        Scene scene = new Scene(root);
        

        stage.setScene(scene);
        stage.setResizable(true);  
        stage.setTitle("A simple FXML Example");
   
        stage.show();
    }

}
