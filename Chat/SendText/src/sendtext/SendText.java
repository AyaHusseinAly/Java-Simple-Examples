/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendtext;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author Aya Hussein
 */
public class SendText extends Application {
	Thread th;

    
    @Override
    public void start(Stage primaryStage) {
    

        
        SenTextBase root = new SenTextBase();
        th= new Thread(root);
        th.start();
        
        Scene scene = new Scene(root, 600, 400);
        
        
        primaryStage.setTitle("Message Sender");
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
