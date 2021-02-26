package notepad.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.KeyCombination;
import javafx.stage.FileChooser;
import javafx.event.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class NotepadBase extends BorderPane {

    protected final MenuBar menuBar;
    protected final Menu menuFile;
    protected final MenuItem menuItemNew;
    protected final MenuItem menuItemOpen;
    protected final MenuItem menuItemSave;
    protected final MenuItem menuItemExit;
    protected final Menu menuEdit;
    protected final MenuItem menuItemUndo;
    protected final MenuItem menuItemCut;
    protected final MenuItem menuItemCopy;
    protected final MenuItem menuItemPaste;
    protected final MenuItem menuItemDelete;
    protected final MenuItem menuItemSelectAll;
    protected final Menu menuHelp;
    protected final MenuItem menuItemAbout;
    protected final TextArea textArea;

    public NotepadBase(Stage primaryStage) {

        menuBar = new MenuBar();
        menuFile = new Menu();
        menuItemNew = new MenuItem();
        menuItemNew.setAccelerator(KeyCombination.keyCombination("ctrl+N"));
        menuItemOpen = new MenuItem();
        menuItemOpen.setAccelerator(KeyCombination.keyCombination("ctrl+O"));
        menuItemSave = new MenuItem();
        menuItemSave.setAccelerator(KeyCombination.keyCombination("ctrl+S"));
        menuItemExit = new MenuItem();
        menuItemExit.setAccelerator(KeyCombination.keyCombination("alt+F4"));
        menuEdit = new Menu();
        menuItemUndo = new MenuItem();
        menuItemCut = new MenuItem();
        menuItemCopy = new MenuItem();
        menuItemPaste = new MenuItem();
        menuItemDelete = new MenuItem();
        menuItemSelectAll = new MenuItem();
        menuHelp = new Menu();
        menuItemAbout = new MenuItem();
        menuItemAbout.setAccelerator(KeyCombination.keyCombination("ctrl+I"));
        textArea = new TextArea();
 
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(menuBar, javafx.geometry.Pos.CENTER);

        menuFile.setMnemonicParsing(false);
        menuFile.setText("File");

        menuItemNew.setMnemonicParsing(false);
        menuItemNew.setText("New");

        menuItemOpen.setMnemonicParsing(false);
        menuItemOpen.setText("Open");

        menuItemSave.setMnemonicParsing(false);
        menuItemSave.setText("Save");

        menuItemExit.setMnemonicParsing(false);
        menuItemExit.setText("Exit");

        menuEdit.setMnemonicParsing(false);
        menuEdit.setText("Edit");

        menuItemUndo.setMnemonicParsing(false);
        menuItemUndo.setText("Undo");

        menuItemCut.setMnemonicParsing(false);
        menuItemCut.setText("Cut");

        menuItemCopy.setMnemonicParsing(false);
        menuItemCopy.setText("Copy");

        menuItemPaste.setMnemonicParsing(false);
        menuItemPaste.setText("Paste");

        menuItemDelete.setMnemonicParsing(false);
        menuItemDelete.setText("Delete");

        menuItemSelectAll.setMnemonicParsing(false);
        menuItemSelectAll.setText("Select All");

        menuHelp.setMnemonicParsing(false);
        menuHelp.setText("Help");

        menuItemAbout.setMnemonicParsing(false);
        menuItemAbout.setText("About Notepad");
        setTop(menuBar);

        BorderPane.setAlignment(textArea, javafx.geometry.Pos.CENTER);
        textArea.setPrefHeight(375.0);
        textArea.setPrefWidth(601.0);
        setLeft(textArea);

        menuFile.getItems().add(menuItemNew);
        menuFile.getItems().add(menuItemOpen);
        menuFile.getItems().add(menuItemSave);
        menuFile.getItems().add(menuItemExit);
        menuBar.getMenus().add(menuFile);
        menuEdit.getItems().add(menuItemUndo);
        menuEdit.getItems().add(menuItemCut);
        menuEdit.getItems().add(menuItemCopy);
        menuEdit.getItems().add(menuItemPaste);
        menuEdit.getItems().add(menuItemDelete);
        menuEdit.getItems().add(menuItemSelectAll);
        menuBar.getMenus().add(menuEdit);
        menuHelp.getItems().add(menuItemAbout);
        menuBar.getMenus().add(menuHelp);
        
        menuItemOpen.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                try{
                FileInputStream inStream=null;
              byte[] buffer=new byte[50];
                FileChooser fc= new FileChooser();
                
                File file=fc.showOpenDialog(primaryStage);
                if(file!=null){
                    inStream = new FileInputStream(file);
                    inStream.read(buffer);
                    
                    //System.out.println(new String(buffer));
                    //System.out.println(buffer.toString());
                    String str=new String(buffer);
                 
                    //BufferedReader reader = new BufferedReader(new FileReader(file));
                    textArea.clear();
                    textArea.appendText(str);
                    //textArea.appendText(f.getName()+"\n");
                }
                
                }catch(IOException ex){
                    System.out.println(ex.getMessage());
                    }}
            
        });

        menuItemNew.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){

                if (!(textArea.getText() == null || textArea.getText().trim().isEmpty())) {
                        FileChooser fc= new FileChooser();
                         fc.setTitle("Save Image");
                         fc.showSaveDialog(primaryStage);
                        textArea.clear();  
                }
                      
            
            }
        });        
        
        menuItemSave.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                try{
                FileOutputStream outStream=null;
                String content = textArea.getText();
                byte[] buffer=content.getBytes();
                FileChooser fc= new FileChooser();
                fc.setTitle("Save file");
                File file=fc.showSaveDialog(primaryStage);  
                if (file != null) {
                    outStream = new FileOutputStream(file);
                    outStream.write(buffer);
                    BufferedReader reader = new BufferedReader(new FileReader(file));
         
            }
            }catch(IOException ex){
                    System.out.println(ex.getMessage());
                    }}
        });   
        
        menuItemExit.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
               Platform.exit();
            }
        });         

        menuItemUndo.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
               textArea.undo();
            }
        });  
        
        menuItemCut.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
               textArea.cut();
            }
        }); 
        menuItemCopy.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
               textArea.copy();
            }
        });         
        menuItemPaste.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
               textArea.paste();
            }
        }); 
        menuItemDelete.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
               textArea.deleteText(textArea.getSelection());
            }
        });
        menuItemSelectAll.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
               textArea.selectAll();
            }
        });   
  menuItemAbout.setOnAction((ActionEvent e) -> {
      Alert alert=new Alert(AlertType.INFORMATION);
      alert.setHeight(80);
      alert.setWidth(100);
      alert.setTitle("About");
      alert.setHeaderText("Welcome");
      alert.setContentText("This is NotPad developed by \n Aya Hussein");
      alert.showAndWait();
        });
    }
}
