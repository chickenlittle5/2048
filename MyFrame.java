import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame {
	
	public MyFrame() {
		
		setTitle("2048");
		getContentPane().setBackground(new java.awt.Color(250,248,239,255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel title = new JLabel ( "2048" );
		
	     	setLayout( new FlowLayout() );
	     	title.setHorizontalTextPosition(JLabel.CENTER);
	     	title.setFont(new Font("Verdana", Font.PLAIN, 30));
	    	add( title );

		setSize(600, 800);
		setVisible(true);
		
	}
  
}
