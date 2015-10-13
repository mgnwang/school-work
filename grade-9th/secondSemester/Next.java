import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Next extends JFrame {
	private Start st;
	public static void main(String[]args){
		Next g = new Next();
	}     
	public Next(){
		super("Next");
		setSize(500,500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocation(0,0);
		setResizable(false);
		st = new Start();
		setContentPane(st);
		setVisible(true);
	}
class Start extends JPanel implements ActionListener{
	private CardLayout cl;
	private JButton button;
	private Red r;
	private Blue b;
	private Yellow y;
	private JPanel p1;
	public Start(){
		p1 = new JPanel();
		r = new Red();
		b = new Blue();
		y = new Yellow();
		button = new JButton("Next");
		button.addActionListener(this);
		cl = new CardLayout();
		p1.setLayout(cl);
		p1.add(r,"red");
		p1.add(b,"blue");
		p1.add(y,"yellow");
		add(button);
		add(p1);
		cl.first(p1);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==button){
			cl.next(p1);
		}
	}
}

class Red extends JPanel{
	public Red(){}
	public void paintComponent(Graphics g){
		setBackground(Color.RED);
		super.paintComponent(g);
	}
}
class Blue extends JPanel{
	public Blue(){}
	public void paintComponent(Graphics g){
		setBackground(Color.BLUE);
		super.paintComponent(g);
	}
} 
class Yellow extends JPanel{
	public Yellow(){}
	public void paintComponent(Graphics g){
		setBackground(Color.YELLOW);
		super.paintComponent(g);
	}
}
}		
