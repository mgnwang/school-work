import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonProgram extends JPanel implements ActionListener
{
	private boolean pressed1;
	private boolean pressed2;
	private JButton a;
	private JButton b;
		
	public ButtonProgram()
	{
		pressed1 = false; 
		pressed2 = false;
		
		a = new JButton("Blue"); 
		add(a); 
		b = new JButton("Red"); 
		add(b);  
		a.addActionListener(this); 
		
	}
	
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		
		if(pressed1)
		{
			g.setColor(Color.BLUE);
			pressed1 = false;
		}
		else if(pressed2)
		{
			g.setColor(Color.RED);
			pressed2 = false;
		}
		
		else
			g.setColor(Color.GREEN);
			
		g.fillOval(100,300,300,100);	
		
	}
	
	public void actionPerformed(ActionEvent e)	
	{	
		if(e.getSource() == a && pressed1 == false)
		{
			pressed1 = true; 
			a.setText("Reset");
			repaint();
		}
		  //repaint();
	 	else // else
		{
			a.setText("Blue"); 
			repaint();
		}	
				//repaint();

		if(e.getSouce() == b && pressed2 == false)
		{
			pressed2 = true; 	
			b.setText("Reset");
			repaint();
		
		}
		//		repaint();

		else // else
		{
			b.setText("Red"); 
			repaint();	
		}
		repaint();
	
	}
	
		
}