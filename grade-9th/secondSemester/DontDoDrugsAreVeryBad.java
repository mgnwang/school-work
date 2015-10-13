/*
 * DontDoDrugsAreVeryBad.java
 * Per. 6
 * 3-16-15
 * Part of Whirligig.java project
 * Don't Do Drugs, Kids
 */
//height = 300
//width = 560
import javax.swing.*;  //import libraries
import java.awt.*;
import java.awt.event.*;

public class DontDoDrugsAreVeryBad extends JPanel{
	
	public DontDoDrugsAreVeryBad(){  //constructor header
		
	}
	
	public void paintComponent(Graphics g){  //paintComponent
	
		super.paintComponent(g);  //refresh screen (paint background)
		
		Font f = new Font("Helvetica", Font.BOLD, 40);
		g.setFont(f);
		g.drawString("DON'T ABUSE", 40, 130);
		g.drawString("SUBSTANCES", 40, 180);
	    f = new Font("Helvetica", Font.BOLD, 50);
	    g.setFont(f);
		g.drawString("KIDS", 120, 240);
		
	}

}

