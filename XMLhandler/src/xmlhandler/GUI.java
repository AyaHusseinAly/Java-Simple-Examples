package xmlhandler;

import java.io.File;
import java.io.FileOutputStream;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class GUI extends AnchorPane {

    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;
    protected final TextField textField;
    protected final TextField textField0;
    protected final TextField textField1;
    protected final TextField textField2;
    protected final Button button;
    protected final Button button0;
    protected final Button button1;
    protected final Button button2;
    protected final Button button3;
    protected final Button button4;
    public int counter;
    public int length =0;

    public GUI() {

        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        textField = new TextField();
        textField0 = new TextField();
        textField1 = new TextField();
        textField2 = new TextField();
        button = new Button();
        button0 = new Button();
        button1 = new Button();
        button2 = new Button();
        button3 = new Button();
        button4 = new Button();

        setId("AnchorPane");
        setPrefHeight(241.0);
        setPrefWidth(312.0);

        label.setLayoutX(29.0);
        label.setLayoutY(18.0);
        label.setPrefHeight(17.0);
        label.setPrefWidth(61.0);
        label.setText("Name");

        label0.setLayoutX(29.0);
        label0.setLayoutY(46.0);
        label0.setPrefHeight(17.0);
        label0.setPrefWidth(61.0);
        label0.setText("Phone");

        label1.setLayoutX(29.0);
        label1.setLayoutY(80.0);
        label1.setPrefHeight(17.0);
        label1.setPrefWidth(61.0);
        label1.setText("Email");

        label2.setLayoutX(29.0);
        label2.setLayoutY(110.0);
        label2.setPrefHeight(17.0);
        label2.setPrefWidth(61.0);
        label2.setText("Address");

        textField.setLayoutX(119.0);
        textField.setLayoutY(14.0);

        textField0.setLayoutX(120.0);
        textField0.setLayoutY(42.0);
        textField0.setPrefHeight(25.0);
        textField0.setPrefWidth(149.0);

        textField1.setLayoutX(119.0);
        textField1.setLayoutY(76.0);

        textField2.setLayoutX(119.0);
        textField2.setLayoutY(106.0);

        button.setLayoutX(14.0);
        button.setLayoutY(162.0);
        button.setMnemonicParsing(false);
        button.setText("Insert");

        button0.setLayoutX(138.0);
        button0.setLayoutY(162.0);
        button0.setMnemonicParsing(false);
        button0.setText("delete");

        button1.setLayoutX(194.0);
        button1.setLayoutY(162.0);
        button1.setMnemonicParsing(false);
        button1.setText("Search by name");

        button2.setLayoutX(70.0);
        button2.setLayoutY(162.0);
        button2.setMnemonicParsing(false);
        button2.setPrefHeight(25.0);
        button2.setPrefWidth(61.0);
        button2.setText("update");

        button3.setLayoutX(100.0);
        button3.setLayoutY(204.0);
        button3.setMnemonicParsing(false);
        button3.setText("Prev");

        button4.setLayoutX(143.0);
        button4.setLayoutY(204.0);
        button4.setMnemonicParsing(false);
        button4.setText("next");

        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(label2);
        getChildren().add(textField);
        getChildren().add(textField0);
        getChildren().add(textField1);
        getChildren().add(textField2);
        getChildren().add(button);
        getChildren().add(button0);
        getChildren().add(button1);
        getChildren().add(button2);
        getChildren().add(button3);
        getChildren().add(button4);
        
        counter=0;
        
        /******************************************************************************************/
       try{ 
            String path="D:/ITI/Java/XMLhandler/src/handlerlab3.xml";
            File yourFile = new File(path);
            yourFile.createNewFile(); // if file already exists will do nothing 
            FileOutputStream oFile = new FileOutputStream(yourFile, false); 
            
         File inputFile = new File(path);
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.newDocument();
         
         Element root = doc.createElement("root");
         doc.appendChild(root);
        
         TransformerFactory transformerFactory = TransformerFactory.newInstance();
         Transformer transformer = transformerFactory.newTransformer();
          

       
            EventHandler<ActionEvent> insertEv  =(ActionEvent event) -> {
                     
                try{
                    org.w3c.dom.Element employee = doc.createElement("Employee");
                    root.appendChild(employee);
                    org.w3c.dom.Element name = doc.createElement("Name");
                    name.setTextContent(textField.getText());
                    employee.appendChild(name);

                    org.w3c.dom.Element phone = doc.createElement("Phone");
                    phone.setTextContent(textField0.getText());
                    employee.appendChild( phone);

                    org.w3c.dom.Element add = doc.createElement("Address");
                    add.setTextContent(textField1.getText());
                    employee.appendChild(add);
                    
                    org.w3c.dom.Element email = doc.createElement("Email");
                    email.setTextContent(textField2.getText());
                    employee.appendChild(email);

                    
                DOMSource dom = new DOMSource(doc);
                StreamResult stream = new StreamResult(new File(path));
                transformer.transform(dom,stream);
                  length++;
                  textField.setText("");
                  textField0.setText("");
                  textField1.setText("");
                  textField2.setText("");
                  counter=0;
                  
                  }catch(Exception ex){
                  ex.printStackTrace();
                  }                
        };
            button.addEventHandler(ActionEvent.ACTION,insertEv);
            
            
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////          
          EventHandler<ActionEvent> nextEv  =(ActionEvent event) -> {
                     
                try{
                    DocumentBuilder dB = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                    Document docum = dB.parse(path);
                    docum.getDocumentElement().normalize();                       

                    NodeList nList = doc.getElementsByTagName("Employee");
        
                   
                    Node nNode = nList.item(counter);
                    Element eElement = (Element) nNode;
                    String name=eElement.getElementsByTagName("Name").item(0).getTextContent();
                    textField.setText(name);
                    String phone=eElement.getElementsByTagName("Phone").item(0).getTextContent();
                    textField0.setText(phone);                    
                    String address=eElement.getElementsByTagName("Address").item(0).getTextContent();
                    textField1.setText(address);
                    String email=eElement.getElementsByTagName("Email").item(0).getTextContent();
                    textField2.setText(email);                    
                    
                    if(counter<length-1){
                        counter++;
                    }
                  }catch(Exception ex){
                  ex.printStackTrace();
                  }                
        };
            button4.addEventHandler(ActionEvent.ACTION,nextEv);
 
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////          
          EventHandler<ActionEvent> searchEv  =(ActionEvent event) -> {
                     
                try{
                    String n= textField.getText();
                    DocumentBuilder dB = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                    Document docum = dB.parse(path);
                    docum.getDocumentElement().normalize();                       

                    NodeList nList = doc.getElementsByTagName("Employee");
                            for (int temp = 0; temp < nList.getLength(); temp++)
                            {
                                Node nNode = nList.item(temp);
                             //   System.out.println("\nCurrent Element :" + nNode.getNodeName());
                                if (nNode.getNodeType() == Node.ELEMENT_NODE)
                                {
                                    Element eElement = (Element) nNode;

                                    if(n.equals(eElement.getElementsByTagName("Name").item(0).getTextContent()))
                                    {
                                     textField.setText(eElement.getElementsByTagName("Name").item(0).getTextContent());//0 btgeb al name 
                                      
                                      textField0.setText(eElement.getElementsByTagName("Phone").item(0).getTextContent());
                                      textField1.setText(eElement.getElementsByTagName("Address").item(0).getTextContent());
                                      textField2.setText(eElement.getElementsByTagName("Email").item(0).getTextContent());
                                      
                                       counter=temp;
                                       break;
                                    
                                    }
                                }
                            }

                  }catch(Exception ex){
                  ex.printStackTrace();
                  }                
        };
            button1.addEventHandler(ActionEvent.ACTION,searchEv);            
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////          
          EventHandler<ActionEvent> prevEv  =(ActionEvent event) -> {
                     
                try{
                    DocumentBuilder dB = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                    Document docum = dB.parse(path);
                    docum.getDocumentElement().normalize();                       

                    NodeList nList = doc.getElementsByTagName("Employee");
        
                    if(counter>0){
                        counter--;
                    }           
                    Node nNode = nList.item(counter);
                    Element eElement = (Element) nNode;
                    String name=eElement.getElementsByTagName("Name").item(0).getTextContent();
                    textField.setText(name);
                    String phone=eElement.getElementsByTagName("Phone").item(0).getTextContent();
                    textField0.setText(phone);                    
                    String address=eElement.getElementsByTagName("Address").item(0).getTextContent();
                    textField1.setText(address);
                    String email=eElement.getElementsByTagName("Email").item(0).getTextContent();
                    textField2.setText(email);  

                  }catch(Exception ex){
                  ex.printStackTrace();
                  }                
        };
            button3.addEventHandler(ActionEvent.ACTION,prevEv);
  
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////          
          EventHandler<ActionEvent> delEv  =(ActionEvent event) -> {
              /*       
                try{
                    DocumentBuilder dB = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                    Document docum = dB.parse(path);
                    docum.getDocumentElement().normalize();                       

                    NodeList nList = doc.getElementsByTagName("Employee");
        
                    if(counter>0){
                        counter--;
                    }           
                    Node nNode = nList.item(counter);
                    Element eElement = (Element) nNode;
                    Element Name = (Element) eElement.getElementsByTagName("name").item(0);
                    Name.getParentNode().getParentNode().removeChild(nList.item(counter));

                    DOMSource dom = new DOMSource(docum);
                    StreamResult stream = new StreamResult(new File(path));
                    transformer.transform(dom,stream);
                    
                  textField.setText("");
                  textField0.setText("");
                  textField1.setText("");
                  textField2.setText("");
                  counter=0;
                */
            try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(path);
			NodeList employees= document.getElementsByTagName("Employee");
			//for (int i = 0; i < products.getLength(); i++) {
                        Element employee = (Element) employees.item(counter);
                        Element Name = (Element) employee.getElementsByTagName("Name").item(0);
                        Name.getParentNode().getParentNode().removeChild( employees.item(counter));
					//break;
				
			//}
                        counter--;
                        length--;
               try {
                    
			TransformerFactory transformerFa = TransformerFactory.newInstance();
			Transformer trans = transformerFa.newTransformer();
			trans.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(path);
			trans.transform(domSource, streamResult);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
                  textField.setText("");
                  textField0.setText("");
                  textField1.setText("");
                  textField2.setText("");
                  counter=0;
                        
                  }catch(Exception ex){
                  ex.printStackTrace();
                  }                
        };
            button0.addEventHandler(ActionEvent.ACTION,delEv);            
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////          
          EventHandler<ActionEvent> updateEv  =(ActionEvent event) -> {
             /*        
                try{
                    DocumentBuilder dB = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                    Document docum = dB.parse(path);
                    docum.getDocumentElement().normalize();                       

                    NodeList nList = doc.getElementsByTagName("Employee");
          
                    Node nNode = nList.item(counter);
                    Element eElement = (Element) nNode;
                    
                    eElement.getElementsByTagName("Name").item(0).setTextContent(textField.getText());
                    eElement.getElementsByTagName("Phone").item(0).setTextContent(textField0.getText());
                    eElement.getElementsByTagName("Email").item(0).setTextContent(textField1.getText());                   
                    eElement.getElementsByTagName("Address").item(0).setTextContent(textField2.getText());
 
                //transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                DOMSource dom = new DOMSource(docum);
                StreamResult stream = new StreamResult(new File(path));
                transformer.transform(dom,stream);
                    
                  textField.setText("");
                  textField0.setText("");
                  textField1.setText("");
                  textField2.setText("");
                  counter=0;
                  
                  */
                                   try {
                            DocumentBuilder dB = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                            Document docum = dB.parse(path);
                            docum.getDocumentElement().normalize();

                            NodeList nList = doc.getElementsByTagName("Employee");    //Employee (list of Employees)     
                            Node nNode = nList.item(counter);    //(temp =CurrentPosition  //array of Employee
                            if (nNode.getNodeType() == Node.ELEMENT_NODE) //if there is Employee
                            {
                            Element eElement = (Element) nNode;
                              Node name=eElement.getElementsByTagName("Name").item(0);
                           // textField.setText(eElement.getElementsByTagName("name").item(0).getTextContent());//0 btgeb al name 
                            //textField2.setText(eElement.getElementsByTagName("email").item(0).getTextContent());                              // name.setNodeValue(name.getNodeValue().toUpperCase());
                               name.setTextContent(textField.getText()); //changed value 
                               
                                Node phone=eElement.getElementsByTagName("Phone").item(0);
                                phone.setTextContent(textField0.getText());
                                
                                 Node address=eElement.getElementsByTagName("Address").item(0);
                                 address.setTextContent(textField1.getText());
                            
                             Node email=eElement.getElementsByTagName("Email").item(0);
                             email.setTextContent(textField2.getText());
                             
                            
                             
                      
                            
                   try {
                    
			TransformerFactory transformerFa = TransformerFactory.newInstance();
			Transformer trans = transformerFa.newTransformer();
			trans.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource domSource = new DOMSource(doc);
			StreamResult streamResult = new StreamResult(path);
			trans.transform(domSource, streamResult);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
                           }
                    textField.setText("");
                  textField0.setText("");
                  textField1.setText("");
                  textField2.setText("");
                  counter=0;
                                
                            
          }catch(Exception ex){
                  ex.printStackTrace();
                  }                
        };
            button2.addEventHandler(ActionEvent.ACTION,updateEv);            
                     
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
 
}
