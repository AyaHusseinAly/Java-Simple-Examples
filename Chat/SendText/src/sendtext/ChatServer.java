/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendtext;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

/**
 *
 * @author Aya Hussein
 */
public class ChatServer {
    ServerSocket serverSocket;
    public ChatServer(){
        try{
        serverSocket = new ServerSocket(5005);
        while(true){
            Socket s=serverSocket.accept();
            new ChatHandler(s);
        }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
   public static void main(String[] args){
       new ChatServer();
   } 
}
class ChatHandler extends Thread{
    DataInputStream dis;
    PrintStream ps;
    static Vector<ChatHandler> clientsVector=new Vector<ChatHandler>();
    public ChatHandler(Socket cs){
        try{
        dis=new DataInputStream(cs.getInputStream());
        ps=new PrintStream(cs.getOutputStream());
        clientsVector.add(this);
        start();
        }        
        catch(IOException ex){
            ex.printStackTrace();
        }
        
    }
    public void run(){
        while(true){
            try{
            String str=dis.readLine();
            System.out.println(str);
            sendMessageToAll(str);
            }
            catch(IOException ex){
            ex.printStackTrace();
        }
        }
    }
    void sendMessageToAll(String msg){
        for(ChatHandler ch: clientsVector){
            ch.ps.println(msg);
        }
    }

}
