//Allen Kalampukattussery
//DONT DO LSD

import javax.swing.*;
import javax.swing.event.*;//import libraries
import java.awt.*;

public class Stickman extends JPanel implements ChangeListener{//class header - implement button listener(ActionL)
	private int slide=0;
	private JSlider s;

//declare global boolean
//declare a global button

public Stickman(){//constructor
	s = new JSlider(JSlider.HORIZONTAL,slide,5,0 );//construct button
	s.addChangeListener(this);//add a listener to our button
	add(s);//add button to panel
	slide=0;//initialize boolean
}
public void paintComponent(Graphics g){//paint component
	setBackground(Color.WHITE);
	super.paintComponent(g);//refresh screen ( paint background)
	g.setColor(Color.YELLOW);
	g.fillOval(100,100,100,100);
	g.setColor(Color.WHITE);
	g.fillOval(125,125,25,25);
	g.fillOval(155,125,25,25);
	g.setColor(Color.BLACK);
	g.fillOval(137,127,9,9);
	g.fillOval(167,127,9,9);
	g.setColor(Color.BLACK);
	g.drawRect(75,55,160,155);
	g.drawLine(130,175,175,175);
	g.drawString("These hallucinations are caused from LSD!",155,250);
	slide=s.getValue();
	if(slide>=1){
		g.setColor(Color.gray);
		g.fillRect(75,55,160,30);
		g.fillArc(75,80,50,10,180,180);
		g.fillArc(125,80,50,10,180,180);
		g.fillArc(175,80,60,10,180,180);
		g.setColor(Color.WHITE);
		g.fillOval(125,125,25,25);
		g.fillOval(155,125,25,25);
		g.setColor(Color.RED);
		g.fillOval(137,127,9,9);
		g.fillOval(167,127,9,9);
	}
	if(slide>=2){
		g.setColor(Color.WHITE);
		g.fillOval(125,125,25,25);
		g.fillOval(155,125,25,25);
		g.setColor(Color.RED);
		g.fillOval(137,137,9,9);
		g.fillOval(167,137,9,9);
	}
	if(slide>=3){
		g.setColor(Color.WHITE);
		g.fillOval(125,125,25,25);
		g.fillOval(155,125,25,25);
		g.setColor(Color.RED);
		g.fillOval(127,137,9,9);
		g.fillOval(157,137,9,9);
		g.drawString("1+1=Window",80,210);
	}
	if(slide>=4){
		g.setColor(Color.WHITE);
		g.fillOval(125,125,25,25);
		g.fillOval(155,125,25,25);
		g.setColor(Color.RED);
		g.fillOval(127,125,9,9);
		g.fillOval(157,125,9,9);		
		
	}
	if(slide==5){
		g.setColor(Color.BLACK);
		g.drawString("Thank you for using the program!",155,270);
	}
}
public void stateChanged(ChangeEvent e){//event handler for button(actionPerformed)
	
	
	repaint();//repaint





}
}