import java.awt.*;
import javax.swing.*;

public class Game extends JFrame {
	private static final int frameSize = 800;
	private static final Color frameColor = new Color(250,248,239);
	
	private Grid grid;
	
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
	}
}
