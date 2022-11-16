package HtmlNCss.HtmlNCss;

import javafx.application.Application;
import javafx.concurrent.Worker;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {


    @Override
    public void start(Stage stage) throws IOException {
    	 WebView browser = new WebView();

    	    browser.getEngine().getLoadWorker()
    	            .stateProperty()
    	            .addListener((obs, old, neww) ->
    	            {
    	                if (neww == Worker.State.SUCCEEDED)
    	                {
    	               
    	                    JSObject bridge = (JSObject) browser.getEngine()
    	                            .executeScript("window");
    	                    bridge.setMember("adder", new Adder());
    	                }
    	            });
    	 WebEngine w = browser.getEngine();
    	   w.load("file:///E:/JavaFX_training/HtmlNCss/src/main/java/HtmlNCss/HtmlNCss/MYHTML.html");
    

    	    Scene scene = new Scene(browser,browser.getPrefWidth(), 
    	    		browser.getPrefHeight());
    	    System.out.println("inside");
    	    stage.setTitle("HTML page");
    	    stage.setScene(scene);
    	    stage.show();}

    public static void main(String[] args) {
        launch();
    }

}