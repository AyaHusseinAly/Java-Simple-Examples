package notepad.java;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
/**
 * @author Aya Hussein
**/
public class NotePadJava extends Application {
    
    @Override
    public void start(Stage primaryStage) {

        NotepadBase root = new NotepadBase(primaryStage);        
        Scene scene = new Scene(root, 600, 500);
        
        primaryStage.setTitle("Notepad");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
