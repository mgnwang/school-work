//Christina Lau
//3-14-15
//Drugs.java is a mini quiz that tells the reader if they learned the material taught.

import java.awt.*; //import libraries
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Drugs extends JPanel implements ActionListener{
	boolean correct, empty;
	private JCheckBox a;
	private JCheckBox b;
	private JCheckBox c;
	private JCheckBox d;
	private JCheckBox j;
	private JCheckBox i;

	public Drugs(){
		correct=false;
		empty = false;
		 a = new JCheckBox("Teeth become sparkly");
         add(a);
         a.addActionListener(this);
         
         b = new JCheckBox("Eyes turn red");
         add(b);
         b.addActionListener(this);
         
         c = new JCheckBox("Hallucinations");
         add(c);
         c.addActionListener(this);
         
         d = new JCheckBox("Teeth turn black and rot");
         add(d);
         d.addActionListener(this);
         
         j = new JCheckBox("Cheeks turn purple");
         add(j);
         j.addActionListener(this);
         
         i = new JCheckBox("Lungs get cleaned");
         add(i);
         i.addActionListener(this);
	}
	
	public void paintComponent(Graphics g){
//paint" paint "hello" or "goodbye" conditionally (use variable)
		super.paintComponent(g);//redraws background so only see one word
		Font f= new Font("Helvetica", Font.BOLD, 40);//set font serif to bold and size 40
		g.setColor(Color.red);
		g.setFont(f);
		g.drawString("Mini-Quiz:", 0, 150);//print string
		g.setColor(Color.black);
		Font h= new Font("Helvetica",Font.BOLD,12);//set font serif to bold and size 40
		g.setFont(h);
		g.drawString("What are the effects of drugs/alcohol?", 5, 175);//print string
		g.drawString("Select all the correct checkboxes above", 5, 190);//print string
         
         
		if (correct)
		{
			g.setColor(Color.yellow);
			g.fillOval(240,120 , 110, 110);//draw flower loop 
			g.setColor(Color.black);
			g.drawArc(280, 150,50, 50, 0, -180);
			g.fillOval(280, 140 , 20, 20);//draw flower loop
			g.fillOval(310, 140, 20, 20);//draw flower loop
			g.drawString("Congratulations you were correct!", 200, 250);
		}
		else
		{
			g.setColor(Color.yellow);
			g.fillOval(240,120 , 110, 110);//draw flower loop 
			g.setColor(Color.black);
			g.drawArc(280, 190,50, 50, 0, 180);
			g.fillOval(280, 140 , 20, 20);//draw flower loop
			g.fillOval(310, 140, 20, 20);//draw flower loop
			g.drawString("Sorry. Please try again!", 220, 250);
		}
	}
        
    public void actionPerformed (ActionEvent e) {
            if(b.isSelected()&&c.isSelected()&&d.isSelected()&&!a.isSelected()&&!j.isSelected()&&!i.isSelected())
				correct=true;
			else
				correct=false;
			repaint();
        }
}