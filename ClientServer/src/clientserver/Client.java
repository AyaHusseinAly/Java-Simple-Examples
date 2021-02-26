/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleclientserver;

import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author Aya Hussein
 */
public class Client {
    Socket mySocket;
    DataInputStream dis;
    PrintStream ps;
    
    public static void main(String[] args){
        new Client();
        
    }
    public Client(){
        try{
            mySocket=new Socket("127.0.0.1",5005);
            dis=new DataInputStream(mySocket.getInputStream());
            ps=new PrintStream(mySocket.getOutputStream());
            ps.println("Test Test");
            String replyMsg=dis.readLine();
            System.out.println(replyMsg);
        }
        catch(Exception ex){
           ex.printStackTrace();}
        
        try{
            ps.close();
            dis.close();
            mySocket.close();
           
        }catch(Exception ex){
            ex.printStackTrace();}
        
        
    
    }        
    
}