import java.awt.*; 
import java.awt.event.*;  
import java.applet.Applet;
public class BallStopStart extends Applet implements Runnable{
		Thread th;
		int xCount;
		int yCount=100;
		int xFlag=0;
		int yFlag=0;  
		
	int x=0;
	volatile int stopStartFlag=0;
	Button stop,start;
	
	public void init() {  
		th= new Thread(this); 
		th.start();
	
   		stop=new Button("Stop"); 
		
		stop.addActionListener(new StopButtonListener());
		add(stop);	
		
		start=new Button("Start"); 
		start.addActionListener(new StartButtonListener());
		add(start);	
    
	} 
		public void run(){ 
			while(true){

			if(stopStartFlag==0){
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
	public void paint(Graphics g) {
			g.setColor(Color.RED);
			g.fillOval(xCount,yCount,50,50);			
		
	}	
	
	class StartButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			stopStartFlag=0;
			
		}
	}
	
	class StopButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			stopStartFlag=1;
			
		}
	}	
}  