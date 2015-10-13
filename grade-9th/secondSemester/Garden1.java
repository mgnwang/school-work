//Sydney Ty
//3-15
//should work:click on rect, then type %, click, then press up
//should not work: click off rect, press up, the click on rect, click off panel, "bob", press down, type 'b'
import java.applet.Applet;
import javax.swing.*;
import java.awt.*; //vs import java.awt.event*; 
import java.awt.event.*;//import libraries

public class GardenGrows extends JApplet{
	public void init(){
		Garden fsp = new Garden();
		setContentPane(fsp);
	}
}
class Garden extends JPanel implements MouseListener, KeyListener{ //implement listeners
	boolean mod;
	boolean up;
	boolean water;
	boolean sun;
	int x;
	int y;
	
	public Garden(){
		mod = false;
		up = false;
		water = false;
		sun = false;
		addMouseListener(this); //add "ears" to Panel//add listeners in constructor
		addKeyListener(this);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawString("To add water, click on the pink rectangle and type %. To add sun, click on the rectangle and press the up key.",30,30);
		
		g.setColor(Color.PINK);
		g.fillRect(50,50,100,50);//create 100x50 pink rectangle with corner in 50,50
		
		if(x < 150 && x > 50 && y < 100 && y > 50 && mod == true){//if x1, y1 are within rect and % is true   
			water = true; //return true
			g.setColor(Color.GREEN);  //turn garden green
			g.fillRect(50,50,100,50);
		}
		
		if(x < 150 && x > 50 && y < 100 && y > 50 && up == true){
			sun = true;
		}


		if(water == true && sun == true){//if x1, y1, x2, y2 coordinates are within rect and %, up arrow is true
			g.setColor(Color.BLACK);
			for(int f = 50; f < 145; f+=20){//loop for flowers: 5x5 filled circles, flowers appear every 20 pixels in right, left, up, down in garden
				for(int j = 50; j <= 95; j+=20){
				g.fillOval(f,j,5,5);
				}
			}
		}
	}

	public void keyPressed(KeyEvent e){} //keyPressed method
	public void keyReleased(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_UP){//if input char is up
			up = true; //return true
			repaint();
		}
	}
	
	
	public void keyTyped(KeyEvent e){//keyTyped method
		if(e.getKeyChar() == '%'){//if input char is %
			mod = true; //return true
			repaint();
		}
		
	}

	public void mousePressed(MouseEvent e){} //5 mouse methods
	public void mouseReleased(MouseEvent e){}
	public void mouseClicked(MouseEvent e){
		requestFocus();
		x = e.getX();
		y = e.getY();//get coordinates of click, save as x, y
		}
		
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	
}

		
		