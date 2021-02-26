package sendtext;

import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.Socket;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;

public class SenTextBase extends AnchorPane implements Runnable{

    protected final TextArea textArea;
    protected final TextField textField;
    protected final Button button;
    
    Socket mySocket;
    DataInputStream dis;
    PrintStream ps;
    String str;

    public SenTextBase() {

        textArea = new TextArea();
        textField = new TextField();
        button = new Button("Default");

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(399.0);
        setPrefWidth(600.0);

        textArea.setPrefHeight(366.0);
        textArea.setPrefWidth(600.0);

        textField.setLayoutY(366.0);
        textField.setPrefHeight(30.0);
        textField.setPrefWidth(505.0);

        button.setLayoutX(507.0);
        button.setLayoutY(366.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(30.0);
        button.setPrefWidth(92.0);
        button.setText("Send");

        
      
        getChildren().add(textArea);
        getChildren().add(textField);
        getChildren().add(button);

        TextInputDialog td = new TextInputDialog(); 
 
        td.showAndWait(); 
        str=td.getEditor().getText();   
        try{
                    mySocket=new Socket("127.0.0.1",5005);

        }
        catch(Exception ex){
                  ex.printStackTrace();
                  }
       /*   
            button.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent event) {
		textArea.appendText(str+": "+textField.getText()+"\n");
		textField.setText("");
            }
        });
            */                    
      /*       
            button.setOnAction((ActionEvent event)->{
                textArea.appendText(str+": "+textField.getText()+"\n");
                textField.setText("");
        });
 */
                 EventHandler<ActionEvent> ev  =(ActionEvent event) -> {
                  //textArea.appendText(str+": "+textField.getText()+"\n");        
                  try{
                  ps=new PrintStream(mySocket.getOutputStream());
                  ps.println(str+": "+textField.getText()+"\n");
                  textField.setText("");
                  }catch(Exception ex){
                  ex.printStackTrace();
                  }
                        
        };
              button.addEventHandler(ActionEvent.ACTION,ev);
              textField.addEventHandler(ActionEvent.ACTION,ev);

    }

    @Override
    public void run() {
        while(true){
         try{
            dis=new DataInputStream(mySocket.getInputStream());
            String replyMsg=dis.readLine();
            textArea.appendText(replyMsg + " \n");
            //textArea.appendText(" \n");
            System.out.println(replyMsg);
        }
        catch(Exception ex){
           ex.printStackTrace();}       
    }
    }
}
