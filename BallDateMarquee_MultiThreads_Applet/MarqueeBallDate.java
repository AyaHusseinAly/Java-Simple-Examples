import java.awt.*;
import java.applet.Applet;
import java.awt.Graphics;
import java.util.Date;

public class MarqueeBallDate extends Applet implements Runnable{
		Thread th,th1,th2;
		int xCount;
		int yCount=100;
		int xFlag=0;
		int yFlag=0;
		int count;
		Date d;
		public void init(){
			d= new Date();
			th= new Thread(new Runnable(){
						public void run(){ //override run method of Runnable //Thread Execute start method then run 
							while(true){
								d= new Date();
								repaint();
								try{
									Thread.sleep(1000);
								}
								catch(InterruptedException e){
									e.printStackTrace();
								}
				
				
			}
		}				
			}); 
			th.start();
			
			th1= new Thread(new Runnable(){
						public void run(){ //override run method of Runnable //Thread Execute start method then run 
							while(true){
								if(count<getWidth()){
									count+=30;}
								else{
									count=0;
								}
								repaint();
								try{
									Thread.sleep(500);
								}
								catch(InterruptedException e){
									e.printStackTrace();
								}
				
				
							}
						}				
			}); 
			th1.start();
			
			th2= new Thread(new Runnable(){

		public void run(){ //override run method of Runnable //Thread Execute start method then run 
			while(true){
				while(xFlag==0&&yFlag==0){
					xCount+=10;
					yCount+=10;
					if(xCount>=(getWidth()-50)){
						xFlag=1;
						break;
					}
					if(yCount>=(getHeight()-50)){
						yFlag=1;
						break;
					}
					repaint();
					try{
						Thread.sleep(80);
					}
					catch(InterruptedException e){
						e.printStackTrace();
					}
									
				}
				while(xFlag==1&&yFlag==1){
					xCount-=10;
					yCount-=10;
					if(xCount<=0){
						xFlag=0;
						break;
					}
					if(yCount<=0){
						yFlag=0;
						break;
					}					
					repaint();
					try{
						Thread.sleep(80);
					}
					catch(InterruptedException e){
						e.printStackTrace();
					}
								
				}
				
				while(xFlag==1&&yFlag==0){
					xCount-=10;
					yCount+=10;
					if(xCount<=0){
						xFlag=0;
						break;
					}
					if(yCount>=getHeight()-50){
						yFlag=1;
						break;
					}					
					repaint();
					try{
						Thread.sleep(80);
					}
					catch(InterruptedException e){
						e.printStackTrace();
					}
								
				}
				
				while(xFlag==0&&yFlag==1){
					xCount+=10;
					yCount-=10;
					if(xCount>=(getWidth()-50)){
						xFlag=1;
						break;
					}
					if(yCount<=0){
						yFlag=0;
						break;
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
				
			}); 
			th2.start();	
			
		}	
		public void paint(Graphics g){
			g.drawString(d.toString(),100,100);
			g.setColor(Color.GREEN);
			g.drawString("Java World",count,250);
			g.setColor(Color.RED);
			g.fillOval(xCount,yCount,50,50);
			
			
			
			
		
		}
			
		public void run(){}
		
	
}