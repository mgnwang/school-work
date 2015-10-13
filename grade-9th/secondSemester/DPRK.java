import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DPRK extends JApplet { 

 public void init() {         // init() method header
  GameScreen gs = new GameScreen();   // construct GameScreen class pane object
  setContentPane(gs);   // create a content pane window for GameScreen class
 } 
}

class GameScreen extends JPanel implements MouseListener, KeyListener, FocusListener {  // removed public
	 private int [] shortArr = new int [20];  // x-coordinates array for short animals
	 private int [] tallArr = new int [20];   // x-coordinates array for tall animals
	 private int ateTall=0;     // initialize eaten tall animals number variable
	 private int short1 = 10;    // initialize short animals variable (changed to short1)
	 private int tall = 10;     // initialize tall animals variable
	 private boolean start = true;  // initialize variable for starting new window
	 private boolean outside = true;  // initialize variable for mouse exited or entered window
	 private boolean eaten = false;   // initialize variable for eaten tall animals
	 private boolean matt = false;
	 private int x = 0, y = 0;   // initialize variables for x,y mouse coordinates
	 private int min = 1, max = 280;  // set min and max random x-coordinates for animals
	 private int cover = 0;    // initialize tall x's to be covered in coverUp method
	 private boolean kim = false;
	 private boolean bomb = false;
	 private boolean afterbomb = false;
	GameScreen() {      //constructor header 
		setBackground(Color.BLUE);   // set to Blue color for the sky background drew by
		addMouseListener(this);
		addKeyListener(this);   // Register MouseListener interface
		addFocusListener(this);
	} 

	public void paintComponent(Graphics g) { //this method is completely written 
		if (start) {        // if condition to draw new window
			if (outside)       // nested if condition to draw window for mouse exited (regenerate)
				newWindow(g);      // call method to redraw window
			else         // else condition to draw window for mouse entered (animals hidden fin grass)
				hide(g);       // call method to redraw window
				start = false;       // removed, not necessary and will cause the first new window not to display
		} 
		else if (eaten) {       // else if condition to draw new window covering up eaten tall animals
			coverUp(g);       // call method to redraw window
			eaten = false;       // reset variable for each eat
		}
		if(kim == true && outside == false)
		{
			newWindow(g);
			g.setColor(Color.BLACK);
			int [] x = {130,125,145,160,175,195,190};
			int [] y = {50, 30, 20,25,20,30,50};
			g.fillPolygon(x,y,7);//hair
			g.setColor(Color.YELLOW);
			g.fillOval(155,65,10,10);//chin
			g.fillOval(130,35,60,35);//face
			g.setColor(Color.BLACK);
			g.drawLine(145,50,155,50);//eye
			g.drawLine(165,50,175,50);//eye
			g.drawLine(160,50,160,60);//nose
			g.drawLine(155,65,165,65);//mouth
			Font f = new Font("Helvetica", Font.BOLD,40);
			g.setFont(f);
			g.drawString("DPRK",10,60);
		
		}
		if( bomb==true && kim == true && outside == false)
		{
				newWindow(g);
				g.setColor(Color.GRAY);
				g.fillRect(85,30,30,90);//draw rect1 
				g.setColor(Color.DARK_GRAY);
				g.fillArc(40,110,120,120,0,180);//draw dome
				g.setColor(Color.YELLOW);
				int [] x1 = {30,10,50,10,80,100,120,190,150,190,170};
				int [] y1 = {200,140,160,80,150,90,150,80,160,140,200};
				g.fillPolygon(x1,y1,11);//draw explosion (spiky part)
				g.setColor(Color.GRAY);
				for(int i = 10; i<190; i+=30){//draw smoke fumes
					g.fillOval(i,20,30,20);
				}
				g.fillOval(0,0,20,30);//smoke fumes continued
				g.fillOval(180,0,20,30);
				g.fillRect(10,0,180,30);
				g.setColor(Color.BLACK);
				Font f = new Font("Helvetica", Font.BOLD,15);
				g.setFont(f);
				g.drawString("BOOM",10,60);
		}
		if( afterbomb == true && bomb==true && kim == true && outside == false){
			g.setColor(Color.green);    // set the drawing color to green for the grass field
			g.fillRect(0, 200, 300, 40);
			g.setColor(Color.blue);
			g.fillRect(0,0,300,200);
		}
	} 
 
	public void newWindow(Graphics g) {  //fill in the blanks only 
		super.paintComponent(g);    // draw the sky background
		g.setColor(Color.green);    // set the drawing color to green for the grass field
		g.fillRect(0, 200, 300, 40);   // draw the grass field rectangle
		g.setColor(Color.red);     // set the drawing color to red for the animals
		for(int a=0; a< 20; a++) {   // this resets the arrays for each generation 
			shortArr[a]=0; 
			tallArr[a]=0; 
		} 
		for(int a=0; a<short1; a++) {   // for loop to create random short animals (changed to short1)
			shortArr[a]=(int)(Math.random()*(max-min+1) + min);   // generate random xs between 1 and 280 (removed bracket)
			g.fillRect(shortArr[a], 180, 20, 20);      // draw short animals at the random xs
		} 
		for(int a=0; a<tall; a++) {
			tallArr[a]=(int)(Math.random()*(max-min+1) + min);   // generate random xs between 1 and 280 (removed bracket)
			g.fillRect(tallArr[a], 160, 20, 40);       // draw tall animals at the random xs
		} 
	} 
 
	public void hide(Graphics g) {  //this method is completely written (to draw new window hiding animals in grass)  
		super.paintComponent(g);   // draw sky background
		g.setColor(Color.green);   // set green grass color
		g.fillRect(0, 200, 300, 40);  // draw green grass field rectangle
		g.setColor(Color.red);    // set red animals color
		for(int a=0; a<tall; a++)   // for loop to draw red animals hidden in grass
			g.fillRect(tallArr[a], 180, 20, 20); 
	} 

	public void coverUp(Graphics g) {  //fill in blanks only (method to cover up the eaten tall animals)
		g.setColor(Color.blue);    // set color to sky blue for covering up the eaten tall animals
		g.fillRect(cover, 180, 20, 20);   // fill the eaten tall animals with same sky color to cover up
	} 
 
	public void calculatenextGen() {  // this method is completely written (method to regenerate animals after consuming) 
		double q = Math.sqrt((double)(short1)/(20-ateTall));  // changed to short1
		double p = 1-q;           // p is not being used, what does it do?
		short1 = (int)(Math.pow(q, 2)*20);       // changed to short1
		tall = 20 - short1;          // changed to short1
		ateTall=0;             // reset eaten tall animals variable
	 } 

	public void mouseEntered(MouseEvent evt) {   // mouseEntered method header
		/* handle the mouse entering window, change the appropriate boolean variable, and
		call paintComponent() appropriately.*/ 
		start = true;   // set variable condition to re-draw window
		outside = false;  // set variable condition to re-draw window
		repaint();    // call paintComponent()
	} 

	public void mouseExited(MouseEvent evt) {   // mouseExited method header
		/* handle the mouse exiting window : call calculateNextGen(), change the
		appropriate boolean variable, and call paintComponent() appropriately.*/ 
		if (afterbomb == false)
		{
			calculatenextGen();  // call method to regenerate animals after consuming
			start = true;   // set variable condition to re-draw window
			outside = true; // set variable condition to re-draw window
			
		}
		requestFocus();
		repaint();    // call paintComponent()
	} 

	public void mouseClicked(MouseEvent evt) {   // mouseClicked method header
		/* handle the mouse clicking : get the position and determine if y position is
		between 80 and 100 AND x position is the same as or up to 20 higher than a value in
		tallArr. If it is, increment ateTall, change the appropriate boolean variable, and
		call paintComponent() appropriately. */ 
		x = evt.getX();  // get the mouse click x-coordinate
		y = evt.getY();  // get the mouse click y-coordinate
		if (y>=180 && y<=200)  // if condition for tall animals y's positions
			for (int a=0; a<tall; a++) // for loop to check match mouse with tall animal position
				if (x>=tallArr[a] && x<=tallArr[a]+20) { // if condition for tall animals x's positions 
		ateTall++;    // increment the tall animals eaten counter
		 start = false;   // set variable condition to re-draw window
		 eaten = true;   // set variable condition to re-draw window
		 cover = tallArr[a];  // set the tall animal x's to be covered in coverUp method
		 repaint();    // call paintComponent()
		 tallArr[a] = 0;   // reset the eaten animal
		 a = tall;    // stop the for loop so one eat per click
    }
 } 

 // you may assume all other mouse event handler methods needed are added

 public void mousePressed(MouseEvent evt) { } // MouseListener interface method header, not used

 public void mouseReleased(MouseEvent evt) { } // MouseListener interface method header, not used
  public void keyTyped(KeyEvent ke){//keyPressed()
		if (ke.getKeyChar() == 'U')
		{
			kim = true;
			repaint();
		}
		if (ke.getKeyChar() == 'S')
		{
			bomb = true;
			repaint();
		}
		if (ke.getKeyChar() == 'A')
		{
			afterbomb = true;
			repaint();
		}
	}
	public void keyReleased(KeyEvent e){}//keyReleased()
	public void keyPressed(KeyEvent e){}//keyTyped()
	public void focusGained(FocusEvent e){}//focusGained()
	public void focusLost(FocusEvent e){}//focusLost()
}