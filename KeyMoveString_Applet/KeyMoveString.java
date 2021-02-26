import java.awt.*; 
import java.awt.event.*;  
import java.applet.Applet;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;

public class KeyMoveString extends Applet{  
	int x=100;
	int y=100;
	public void init() {  
   		this.addKeyListener(new moveListener());
    
	} 

	public void paint(Graphics g) {
			g.drawString("Java World",x,y);
		
	}	
	
	class moveListener implements KeyListener{
		public void keyPressed(KeyEvent e) {
    
			int code = e.getKeyCode();

			if (code == KeyEvent.VK_LEFT){
				if(x>0){
					x-=20;
				}
			}

			if (code == KeyEvent.VK_RIGHT){
			if(x<getWidth()-65){
					x+=20;
				}
			}
			
			if (code == KeyEvent.VK_UP){
				if(x>0){
					y-=20;
				}
			}

			if (code == KeyEvent.VK_DOWN){
				if(x<getHeight()-10){
					y+=20;
				}
			}
			
			repaint();
			
		}
		public void keyReleased(KeyEvent e) {}
		public void keyTyped(KeyEvent e) {}
	}
	
}  