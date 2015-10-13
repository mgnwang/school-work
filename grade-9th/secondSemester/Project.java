import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;


public class Project extends JPanel implements ChangeListener{
	private JSlider s;
	private int slide;
	public Project(){//constructor
		s = new JSlider(JSlider.HORIZONTAL,0,100,0);
		s.addChangeListener(this);
		add(s);
	}
	public void paintComponent(Graphics g){//paint component method
		setBackground(Color.BLACK);
		super.paintComponent(g);
		Color weed = new Color(0,slide*2,0);
		g.setColor(weed);
		for(int c = 0; c<260; c+=60){
			for(int r = 0; r<300; r+=60){
				int [] arr1 = {r+30,r+35,r+30,r+40,r+50,r+30,r+40,r+45,r+30,r+15,r+20,r+30,r+10,r+20,r+30,r+25};
				int [] arr2 = {c+20,c+35,c+50,c+40,c+40,c+50,c+50,c+55,c+50,c+55,c+50,c+50,c+40,c+40,c+50,c+35};
				g.fillPolygon(arr1,arr2,16);
				g.drawLine(r+30,c+50,r+30,c+65);
			}
		}
		Color hair = new Color(100,60,0);
		g.setColor(hair);
		int [] arr3 = {90,80,120,150,180,220,210};
		int [] arr4 = {130,90,65,75,65,90,130};
		g.fillPolygon(arr3,arr4,7);//hair
		g.setColor(Color.YELLOW);
		g.fillOval(90,90,120,80);//face
		g.setColor(Color.BLACK);
		g.fillArc(110,125,80,40,220-slide/2,90+slide);//mouth
		g.setColor(Color.YELLOW);
		g.fillArc(110,124,80,39-slide/30,220-slide/2, 90+slide);//upper mouth arc height chages
		g.setColor(Color.BLACK);
		g.drawLine(150,130,150,145);//nose
		Color c = new Color(slide*2,0,0);
		g.setColor(c);
		g.fillOval(110,125,20,10);//eyes change color
		g.fillOval(170,125,20,10);
		g.setColor(Color.WHITE);
		g.drawString("Slide to show effects of marajuana", 50, 300);
	}
	public void stateChanged(ChangeEvent e){
		slide = s.getValue();
		repaint();
	}
}	