/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlhandler;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Aya Hussein
 */
public class XMLhandler extends Application {
 
    @Override
    public void start(Stage primaryStage) {
  
        GUI root = new GUI();

        
        Scene scene = new Scene(root, 300, 300);
        
        
        primaryStage.setTitle("XML insertion");
        primaryStage.setScene(scene);
        primaryStage.show();
              

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
