/*
 * SmokeLung.java
 * Per. 6
 * 3-16-15
 * Part of Whirligig.java project
 * Don't Smoke
 */

import javax.swing.*;  //import libraries
import java.awt.*;
import java.awt.event.*;

public class SmokeLung extends JPanel implements ActionListener{

	private boolean isGood;  //declare global boolean
	private JButton b;  //declare global button
	private JButton bb;
	
	public SmokeLung(){  //constructor header
		
		setLayout(null);
		b = new JButton("Press");  //construct button
		b.setBounds(150, 30, 75, 20);
		b.addActionListener(this);  //add listener to our button
		add(b);  //add button to panel
		isGood = true;  //initialize boolean
		
	}
	
	public void paintComponent(Graphics g){  //paintComponent
	
		super.paintComponent(g);  //refresh screen (paint background)
		
		//ADD ARROW
		Font f = new Font("Helvetica", Font.BOLD, 12);
		g.setFont(f);
		if(!isGood){      
			g.drawString("Press to see a Non-Smoker's lungs", 100, 20);
			g.drawString("Smoker's Lungs", 150, 150);
			int [] lx = {150, 100, 100, 175, 175};
			int [] ly = {200, 275, 325, 325, 200};
			Color c = new Color(80,35,10);
			g.setColor(c);
			g.fillPolygon(lx, ly, 5);
			g.setColor(Color.black);
			g.drawPolygon(lx, ly, 5);
			int [] llx = {225, 275, 275, 200, 200};
			int [] lly = {200, 275, 325, 325, 200};
			g.setColor(c);
			g.fillPolygon(llx, lly, 5);
			g.setColor(Color.black);
			g.drawPolygon(llx, lly, 5);
			g.setColor(Color.black);
			g.fillRect(175, 175, 25, 100);
			g.setColor(Color.black);
			g.drawRect(175, 175, 25, 100);
			g.setColor(Color.black);
			g.fillOval(175, 300, 50, 25);
			g.setColor(Color.black);
			g.drawOval(175, 300, 50, 25);

			g.drawLine(175, 250, 150, 225);
			g.drawLine(175, 275, 130, 275);
			g.drawLine(175, 300, 150, 315);
			
			g.drawLine(200, 250, 225, 225);
			g.drawLine(200, 275, 245, 275);
			
		}
		
		else{
		
			g.drawString("Press to see a Smoker's lungs", 110, 20);
		
			g.drawString("Non-Smoker's Lungs", 125, 150);
			
			int [] lx = {150, 100, 100, 175, 175};
			int [] ly = {200, 275, 325, 325, 200};
			g.setColor(Color.pink);
			g.fillPolygon(lx, ly, 5);
			g.setColor(Color.black);
			g.drawPolygon(lx, ly, 5);
			int [] llx = {225, 275, 275, 200, 200};
			int [] lly = {200, 275, 325, 325, 200};
			g.setColor(Color.pink);
			g.fillPolygon(llx, lly, 5);
			g.setColor(Color.black);
			g.drawPolygon(llx, lly, 5);
			g.setColor(Color.magenta);
			g.fillRect(175, 175, 25, 100);
			g.setColor(Color.black);
			g.drawRect(175, 175, 25, 100);
			g.setColor(Color.magenta);
			g.fillOval(175, 300, 50, 25);
			g.setColor(Color.black);
			g.drawOval(175, 300, 50, 25);
			g.setColor(Color.magenta);
			g.drawLine(175, 250, 150, 225);
			g.drawLine(175, 275, 130, 275);
			g.drawLine(175, 300, 150, 315);
			
			g.drawLine(200, 250, 225, 225);
			g.drawLine(200, 275, 245, 275);
			
		}
		
	}
		
	public void actionPerformed(ActionEvent e){  //event handler for button (actionPerformed)
	
		if(isGood){
			
			isGood = false;  //change boolean
			
		}
		else if(!isGood){
		
			isGood = true;
			
		}
			
		repaint();  //repaint
	
	}
	
}
