import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame {
	
	public MyFrame() {
		
		setTitle("2048");
		getContentPane().setBackground(new java.awt.Color(250,248,239,255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lbl = new JLabel ( "2048" );
		
	     	setLayout( new FlowLayout() );
	    	add( lbl );

		setSize(600, 800);
		setVisible(true);
		
	}
  
}
