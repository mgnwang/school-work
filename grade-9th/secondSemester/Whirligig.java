import javax.swing.*;  //import libraries
import java.awt.*;
import java.awt.event.*;

public class Whirligig extends JApplet{
	public void init(){
		Whirl w = new Whirl();
		setContentPane(w);
	}
}
class Whirl extends JPanel{
	public Whirl(){
		setLayout(new GridLayout(2,4,0,0));
		Project weed = new Project();
		SmokeLung smoke = new SmokeLung();
		Stickman lsd = new Stickman();
		Alcohol alc = new Alcohol();
		PanelMeth meth = new PanelMeth();
		DontDoDrugsAreVeryBad dont = new DontDoDrugsAreVeryBad();
		Drugs quiz = new Drugs();
		add(weed);
		add(smoke);
		add(lsd);
		add(alc);
		add(meth);
		add(quiz);
		add(dont);
		
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
	}
}