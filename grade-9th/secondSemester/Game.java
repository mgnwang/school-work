//Sydney Ty
//4-20-15

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Game extends JFrame {

	public static void main(String[] args) {
		new Game();
	}

	public Game() {
		setSize(1000, 700);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocation(0, 0);
		setResizable(false);
		Big b = new Big();
		add(b);
		setVisible(true);
	}
	
	public class Big extends JPanel{
		private Image startbaking;
		
		private CardLayout cl; //global variables
		
		public Big(){
			cl = new CardLayout();
			setLayout(cl);
			
		//	StartPanel sp = new StartPanel(); //create class instances
			Level1Start l1s = new Level1Start();
			Level1 l1 = new Level1();
			
		//	add(sp, "Start"); //add classes
			add(l1s);
			add(l1, "Level 1");
			
		}
	
	
	public class Level1Start extends JPanel implements MouseListener, MouseMotionListener{
		private int x1;
		private int y1; //global variables
		private boolean enterl1;
		private JLabel startbakinglabel;
	
		public Level1Start(){
			setBackground(Color.WHITE);
			setLayout(new BorderLayout()); //set layout
			
			Image level1 = Toolkit.getDefaultToolkit().getImage("level1.jpg");//import level1 image: north
				JLabel level1label = new JLabel(new ImageIcon(level1));
				add(level1label, BorderLayout.NORTH);
			
			
			Image cupcake = Toolkit.getDefaultToolkit().getImage("cupcake.png");//import cupcake image: east
				JLabel cupcakelabel = new JLabel(new ImageIcon(cupcake));
				add(cupcakelabel);
			
			
				startbaking = Toolkit.getDefaultToolkit().getImage("start baking.png");//import startl1 image: west
					startbakinglabel = new JLabel(new ImageIcon(startbaking));
					add(startbakinglabel, BorderLayout.WEST);
				
			addMouseListener(this);//addmouselistener
			addMouseMotionListener(this);
		}
		
		public void paintComponent(){
			if(enterl1 == true){  //if enterl1 is true
				System.out.println("true");
				startbaking = Toolkit.getDefaultToolkit().getImage("start baking highlighted.png");//import startl1 image: west
					startbakinglabel = new JLabel(new ImageIcon(startbaking));
				//image change color
			}
			else if(enterl1 == false) { //if enterl1 is false
				System.out.println("false");
				startbaking = Toolkit.getDefaultToolkit().getImage("start baking.png");//import startl1 image: west
					startbakinglabel = new JLabel(new ImageIcon(startbaking));
				//image change color back/color stays the same
			}
			add(startbakinglabel, BorderLayout.WEST);
			
		}
		//mouselistener methods
		public void mouseClicked(MouseEvent e){
			Big b = new Big();
			if(enterl1 == true)//if enterl1 == true
				cl.show(b, "Level 1");//move to next "card," Level1
		}
		
		public void mousePressed(MouseEvent e){}
		public void mouseReleased(MouseEvent e){}
		
		public void mouseEntered(MouseEvent e){}
			
		public void mouseExited(MouseEvent e){
			//if x and y are not within startl1 image
			//	enterl1 = false;
			//	repaint();//call paintcomponent
		} //mouseExited close bracket
		
		public void mouseMoved(MouseEvent e){
			x1 = e.getX(); //get x and y coordinates
			y1 = e.getY();
			
			if(x1>50 && x1<537 && y1>380 && y1<494){  //if x and y are within startl1 image
				enterl1 = true;
				System.out.println("true in mousemoved");
			}
			else{
				enterl1 = false;
				System.out.println("false in mousemoved");
			} 
			
			repaint();//call paintComponent
		}
		
		public void mouseDragged(MouseEvent e){}
			
	} //Level1Start class close bracket
	
	public class Level1 extends JPanel implements MouseListener, MouseMotionListener{
		public Level1(){
			addMouseListener(this);//add listeners
			addMouseMotionListener(this);
		}
		
		public void mouseClicked(MouseEvent e){}
		public void mousePressed(MouseEvent e){}
		public void mouseReleased(MouseEvent e){}
		public void mouseEntered(MouseEvent e){}
		public void mouseExited(MouseEvent e){}
		public void mouseMoved(MouseEvent e){}
		public void mouseDragged(MouseEvent e){}
			
	} //Level1 class close bracket
	} //Big class close bracket
}