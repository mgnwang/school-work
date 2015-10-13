import javax.swing.*;
import java.awt.*;//import libraries
import java.awt.event.*;
import javax.swing.event.*;
//import java.applet.Applet;

public class PanelMeth extends JPanel {

 JButton doMeth;
 public boolean doMethPressed = false;

 public void paintComponent(Graphics g) {

  if (doMethPressed==false)
  {
     setBackground(Color.WHITE);
     super.paintComponent(g);
     g.setColor(Color.BLACK);
     g.drawString("Press Button to do Meth",50,50);
     g.setColor(Color.YELLOW);
     g.fillOval(50,60,230,260);
     g.setColor(Color.BLACK);
     g.drawOval(160,180,25,25);
     g.setColor(Color.WHITE);
     g.fillOval(120,145,20,20);
     g.fillOval(195,145,20,20);
     g.setColor(Color.BLACK);
     g.fillOval(128,153,5,5);
     g.fillOval(203,153,5,5);
     g.setColor(Color.RED);
     g.fillRect(128,220,80,55);
     g.setColor(Color.WHITE);
     g.fillRect(128,220,10,15);
     g.fillRect(139,220,10,15);
     g.fillRect(150,220,10,15);
     g.fillRect(161,220,10,15);
     g.fillRect(172,220,10,15);
     g.fillRect(183,220,10,15);
     g.fillRect(194,220,10,15);

    //bottom teeth
    g.fillRect(128,260,10,15);
    g.fillRect(139,260,10,15);
    g.fillRect(150,260,10,15);
    g.fillRect(161,260,10,15);
    g.fillRect(172,260,10,15);
    g.fillRect(183,260,10,15);
    g.fillRect(194,260,10,15);
  }
  else
  {
      g.setColor(Color.YELLOW);
      g.fillOval(50,60,230,260);
      g.setColor(Color.BLACK);
      g.drawOval(160,180,25,25);
      g.setColor(Color.WHITE);
      g.fillOval(120,145,20,20);
      g.fillOval(195,145,20,20);
      g.setColor(Color.RED);
      g.fillOval(128,153,5,5);
      g.fillOval(203,153,5,5);
      g.setColor(Color.RED);
      g.fillRect(128,220,80,55);
      g.setColor(Color.YELLOW);
      g.fillRect(128,220,10,15);
      g.fillRect(139,220,10,15);
      g.setColor(Color.BLACK);
      g.fillRect(161,220,10,15);
      g.setColor(Color.YELLOW);
      g.fillRect(172,220,10,15);
      g.setColor(Color.BLACK);
      g.fillRect(183,220,10,15);
      //bottom teeth
      g.setColor(Color.YELLOW);
      g.fillRect(128,260,10,15);
      g.fillRect(150,260,10,15);
      g.setColor(Color.BLACK);
      g.fillRect(161,260,10,15);
      g.setColor(Color.YELLOW);
      g.fillRect(172,260,10,15);
      g.fillRect(194,260,10,15);
      g.setColor(Color.BLACK);
      g.drawString("Don't do Meth",50,350);
      g.setColor(Color.RED);
      g.fillOval(107,85,10,10);
      g.fillOval(165,125,10,10);
      g.fillOval(146,189,10,10);
      g.fillOval(132,234,10,10);
  }
}

	public  PanelMeth() {
       doMeth = new JButton("Do Meth");
       doMeth.addActionListener(new ActionListener()
       {
			public void actionPerformed(ActionEvent e) 
			{
				if(e.getSource() == doMeth)
				{
					doMethPressed = true;
					repaint();
				}
			}
		});
       add(doMeth);
  }

  

}