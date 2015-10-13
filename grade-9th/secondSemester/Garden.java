//Megan Wang
//2-25-15
//Testing Plan:
//Should Work: click in the rectangle, then % is typed or up arrow is pressed
//Should not work: typing and then clicking, clicking outside the rectangle, click off panel
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class JAppletPgm extends JApplet{
	public void init(){
		Garden gn = new Garden();
		setContentPane(gn);
	}
}

class Garden extends JPanel implements MouseListener, KeyListener, FocusListener{//class header, implement MouseListener and KeyListener
	boolean ground, click, sun, water;
	public Garden(){//constructor
		ground = false;//instantiate variables to false
		click = false;
		sun = false;
		water = false;
		addMouseListener(this);
		addFocusListener(this);
		addKeyListener(this);//add Listeners
	}
	public void paintComponent(Graphics g){//paint component method
		super.paintComponent(g);
		g.setColor(Color.PINK);
		g.fillRect(50,50,100,50);
		if(click==true && ground==false && water==true){
			g.setColor(Color.GREEN);
			g.fillRect(50,50,100,50);
			ground = true;
		}
		else if(click==true && ground==true && sun==true ){
			for(int w = 50; w < 150; w+=20){
				for(int h = 50; h<100; h+=20){
					g.setColor(Color.PINK);
					g.fillOval(w,h,5,5);
				}
			}
		}
	}
	public void mousePressed(MouseEvent e){}//mousePressed()
	public void mouseReleased(MouseEvent e){}//mouseReleased()
	public void mouseClicked(MouseEvent e){//mouseClicked()
		int x = e.getX();
		int y = e.getY();
		if((x>50 && x<150) && (y>50 && y<100)){//if mouse is clicked within the content pane, click = true
			requestFocus();//request focus
			click = true;
		}
	}	
	public void mouseEntered(MouseEvent e){}//mouseEntered()
	public void mouseExited(MouseEvent e){}//mouseExited()
	public void keyPressed(KeyEvent e){//keyPressed()
		if(e.getKeyChar()=='%')
			water = true;
		else if(e.getKeyCode == KeyEvent.VK_Up)
			sun = true;
		requestFocus();
	}
	public void keyReleased(KeyEvent e){}//keyReleased()
	public void keyTyped(KeyEvent e){}//keyTyped()
}
		