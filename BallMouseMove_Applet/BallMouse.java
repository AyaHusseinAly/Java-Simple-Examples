import java.awt.*; 
import java.awt.event.*;  
import java.applet.Applet;
public class BallMouse extends Applet {

		int x=50;
		int y=50;

	
	public void init() {  
		this.addMouseMotionListener(new MoveBall());
    
	} 
		
	public void paint(Graphics g) {
			g.setColor(Color.BLUE);
			g.fillOval(x,y,50,50);			
		
	}	
	
	class MoveBall implements MouseMotionListener{
		public void mouseDragged(MouseEvent e){
			
			x=e.getX();
			y=e.getY(); 
			repaint();			
			
			
		}
		public void mouseMoved(MouseEvent e){
			
			
		}		
	}
	
	
}  