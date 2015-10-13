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
	s = new JSlider(JSlider.HORIZONTAL,slide,100,0);//construct button
	s.addChangeListener(this);//add a listener to our button
	add(s);//add button to panel
	slide=0;//initialize boolean
}
public void paintComponent(Graphics g){//paint component
	setBackground(Color.WHITE);
	super.paintComponent(g);//refresh screen ( paint background)

	
	g.setColor(Color.GREEN);
	g.fillArc(95-slide/15,110-slide/10,120+slide/10,120+slide/10,0,180);//draw dome
	Color smoke = new Color(255-slide*2,255-slide*2,255-slide*2);
	g.setColor(smoke);
	g.fillArc(95,110,120,120,0,180);//draw dome
	if(slide>=50){
		g.setColor(Color.MAGENTA);
		int [] x1 = {85,65,105,65,135,155,175,245,205,245,225};
		int [] y1 = {210,150,170,90,160,100,160,90,170,150,210};
		g.fillPolygon(x1,y1,11);//draw explosion (spiky part)
		g.setColor(Color.CYAN);
		g.drawString("1+1=Window",85,210);
	}
	g.setColor(Color.YELLOW);
	g.fillOval(100,100,100,100);
	g.setColor(Color.WHITE);
	g.fillOval(125,125,25,25);
	g.fillOval(155,125,25,25);
	g.setColor(Color.BLACK);
	g.fillOval(137,127,9,9);
	g.fillOval(167,127,9,9);
	g.setColor(Color.BLACK);
	g.drawRect(65,55,180,155);
	g.drawArc(123,165,60,slide/4,180,180);
	g.drawString("These hallucinations are caused from LSD",80,250);
	Color c = new Color(255-slide*2,255-slide/2,255-slide/2);
	g.setColor(c);
	g.fillRect(65,55,180,30);
	g.fillArc(75,80,55,10,180,180);
	g.fillArc(125,80,55,10,180,180);
	g.fillArc(175,80,55,10,180,180);

	if(slide<=5||(slide>=20 && slide<=25)||(slide>=45 && slide<=50)||(slide>=65 && slide<=70)||(slide>=85 && slide<=90)){
		g.setColor(Color.WHITE);
		g.fillOval(125,125,25,25);
		g.fillOval(155,125,25,25);
		g.setColor(Color.RED);
		g.fillOval(137,127,9,9);
		g.fillOval(167,127,9,9);
	}
	if((slide>=5 && slide<=10)||(slide>=25 && slide<=30)||(slide>=50 && slide<=55)||(slide>=70 && slide<=75)||(slide>=90 && slide<=95)){
		g.setColor(Color.WHITE);
		g.fillOval(125,125,25,25);
		g.fillOval(155,125,25,25);
		g.setColor(Color.RED);
		g.fillOval(137,137,9,9);
		g.fillOval(167,137,9,9);
	}
	if((slide>=10 && slide<=15)||(slide>=30 && slide<=35)||(slide>=55 && slide<=60)||(slide>=75 && slide<=80)||(slide>=95 && slide<=100)){
		g.setColor(Color.WHITE);
		g.fillOval(125,125,25,25);
		g.fillOval(155,125,25,25);
		g.setColor(Color.RED);
		g.fillOval(127,137,9,9);
		g.fillOval(157,137,9,9);
	}
	if((slide>=15 && slide<=20)||(slide>=35 && slide<=40)||(slide>=60 && slide<=65)||(slide>=80 && slide<=85)){
		g.setColor(Color.WHITE);
		g.fillOval(125,125,25,25);
		g.fillOval(155,125,25,25);
		g.setColor(Color.RED);
		g.fillOval(127,125,9,9);
		g.fillOval(157,125,9,9);		
		
	}
	g.setColor(Color.BLACK);
	g.drawRect(65,55,180,155);

}
public void stateChanged(ChangeEvent e){//event handler for button(actionPerformed)
	slide=s.getValue();
	repaint();//repaint
}
}