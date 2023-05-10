import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game extends JFrame implements KeyListener {
	private static final int frameSize = 800;
	private static final Color frameColor = new Color(250,248,239);
	
	private Grid grid;
	private boolean playing;
	
	public Game() {
		setTitle("2048");
		setSize(frameSize, frameSize);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(frameColor);
		
		grid = new Grid(frameSize * 5/8);

		add(Box.createVerticalGlue());
		add(Box.createVerticalGlue());
		add(Box.createVerticalGlue());
		add(grid);
		add(Box.createVerticalGlue());

		addKeyListener(this);
		
	}

	public void keyPressed(KeyEvent e) {
		//if (playing) {}
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_W) {
			System.out.println("W");
		} else if (key == KeyEvent.VK_A) {
			System.out.println("A");
		} else if (key == KeyEvent.VK_S) {
			System.out.println("S");
		} else if (key == KeyEvent.VK_D) {
			System.out.println("D");
		}
	}

	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
	
}
