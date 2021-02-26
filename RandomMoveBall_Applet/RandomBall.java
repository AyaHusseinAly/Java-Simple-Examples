import java.awt.*;
import java.applet.Applet;
import java.awt.Graphics;
import java.util.Date;

public class RandomBall extends Applet implements Runnable{
		Thread th;
		int xCount;
		int yCount=100;
		int xFlag=0;
		int yFlag=0;
		public void init(){
			th= new Thread(this); //Thread class has constructor takes parameter of type Runnable
			th.start();
			
			
		}	
		public void paint(Graphics g){

			g.setColor(Color.RED);
			g.fillOval(xCount,yCount,50,50);
			
			
				
		}
			
		public void run(){ //override run method of Runnable //Thread Execute start method then run 
			while(true){


			if(xFlag==0&&yFlag==0){
				xCount+=10;
				yCount+=10;
					if(xCount>=(getWidth()-50)){
						xFlag=1;
						
					}
					if(yCount>=(getHeight()-50)){
						yFlag=1;
						
					}
			}
			else if(xFlag==1&&yFlag==1){
				xCount-=10;
				yCount-=10;
					if(xCount<=0){
						xFlag=0;
					
					}
					if(yCount<=0){
						yFlag=0;
					
					}				
			}
			else if(xFlag==1&&yFlag==0){
				xCount-=10;
				yCount+=10;
					if(xCount<=0){
						xFlag=0;
						
					}
					if(yCount>=getHeight()-50){
						yFlag=1;
						
					}		
			}
			else if(xFlag==0&&yFlag==1){
				xCount+=10;
				yCount-=10;
					if(xCount>=(getWidth()-50)){
						xFlag=1;
						
					}
					if(yCount<=0){
						yFlag=0;
						
					}			
			}
			
			repaint();
			try{
				Thread.sleep(80);
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			}
		}
	
}