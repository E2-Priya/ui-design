package org.openjfx.HtmCheck;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
    	 stage.setTitle("creating Webview");
    	   
         // create a webview object
         WebView w = new WebView();

         // get the web engine
         WebEngine e = w.getEngine();

         // load a website
         e.load("file:///home/devuser/Downloads/login-final/login_priya/login2.html");

         // create a scene
         Scene scene = new Scene(w, w.getPrefWidth(), 
                                  w.getPrefHeight());

         // set the scene
         stage.setScene(scene);

         stage.show();
     
    }

    public static void main(String[] args) {
        launch();
    }

}