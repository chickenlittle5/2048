import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game extends JFrame implements KeyListener {
	private static final int FRAME_SIZE = 800;
	private static final Color FRAME_COLOR = new Color(250,248,239);
	
	private Grid grid;
	private ScorePanel score;
	private boolean playing;
	
	public Game() {
		setTitle("2048");
		setSize(FRAME_SIZE, FRAME_SIZE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(FRAME_COLOR);
		
		grid = new Grid(FRAME_SIZE * 5/8);
		grid.setBackground(FRAME_COLOR);
		score = new ScorePanel(FRAME_SIZE * 1/7);
		score.setBackground(FRAME_COLOR);

		add(Box.createVerticalGlue());
		add(score);
		add(Box.createVerticalGlue());
		add(Box.createVerticalGlue());
		add(grid);
		add(Box.createVerticalGlue());

		playing = true;
		addKeyListener(this);
	}
	
	public void keyPressed(KeyEvent e) {
		if (!playing)
			return;

		String direction;
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_W) {
			direction = "UP";
		} else if (key == KeyEvent.VK_A) {
			direction = "LEFT";
		} else if (key == KeyEvent.VK_S) {
			direction = "DOWN";
		} else if (key == KeyEvent.VK_D) {
			direction = "RIGHT";
		} else {
			return;
		}

		int[] scoreDiff = grid.shiftTiles(direction);
		// if merged or shifted
		if (scoreDiff[0] > 0 || scoreDiff[1] > 0) {
			score.add(scoreDiff[0]);
			if (grid.spawn())
				grid.repaint();
		}
		// no merge or shift + can't move = lose
		else if (!grid.canMove()) {
			playing = false;
		}
	}

	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
}
