//Matthew Crooks
//3-17-15
//a layout page for my slider

import java.awt.*;
import javax.swing.event.*;
import javax.swing.*;

	public class Alcohol extends JPanel implements ChangeListener{//class header implement change listener
		private static boolean halfway;
		private static JSlider alco;
		private static int value;
		
		public Alcohol(){//use default flow layout
			halfway = false;
			alco = new JSlider(JSlider.HORIZONTAL, 10, 350, 10);
			alco.addChangeListener(this);
			add(alco);
        }

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		int [] x = {100, 300, 290, 110};
		int [] y = {260, 260, 290, 290};
		int [] triX = {175, 225, 200};
		int [] triY = {205, 205, 235};
		Color face = new Color(100,60,0);
		g.setColor(face);
		g.fillOval(40, 205, 20, 20); 
		g.fillOval(342, 205, 20, 20);
		g.fillOval(50, 80, 300, 250);
		g.setColor(Color.RED);
		g.fillPolygon(x,y,4);
		g.setColor(face);
		g.setColor(Color.BLACK);
		g.drawString("Slide to the right to see the effects of alcohol", 50, 50);
		g.fillPolygon(triX,triY,3);
		g.setColor(Color.WHITE);
		g.fillOval(150, 120, 20, 20); 
		g.fillOval(250, 120, 20, 20);
		g.setColor(Color.BLACK);
		g.fillOval(157, 123, 4, 4);
		g.fillOval(257, 123, 4, 4);
		if(value >= 115){
			g.setColor(Color.PINK);
			g.fillOval(80, 200, 45, 45);
			g.fillOval(280, 200, 45, 45);
            g.setColor(Color.RED);
            for(int counter = 155; counter <= 165; counter += 10){
                g.drawLine(counter, 120, counter, 140);
            }
            for(int counter2 = 255; counter2 <= 265; counter2 += 10){
                g.drawLine(counter2, 120, counter2, 140);
            }
		}
        if(value >= 240){
            g.setColor(Color.RED);
            g.fillOval(80, 200, 45, 45);
            g.fillOval(280, 200, 45, 45);
        }
    }
    public void stateChanged(ChangeEvent e){
		value = alco.getValue();
		repaint();
    }
}

        //this almost definetly wont run just you know what to do to fix it cuz it's a lot/ exactly like yours and theres all the concepts there anyway
		


//make it 400 x 400

//write text, Move the slider further to the right to see the effects of alcohol.

//draw an oval to make the face color is brown

//draw 2 ovals to make the eyes and 2 smaller eyes in the 2 circles

//draw 2 nostrils = 2 lines on the nose

//draw 2 circles on the cheeks that are just there for when the slider goes further to the right 

//create a 4 sided polygon with a line that splits it in half to make a mouth

//when the slider gets halfway across make lines go across his eyes

//as the slider is at the end then the cheeks turn red