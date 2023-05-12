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
	
	//Spawns a random block every turn but also checks if there is no block in the spot
		public void spawn () {
			int x1 = (int)(Math.random()*4);
			int y1 = (int)(Math.random()*4);
			Tile [][] board = grid.getGrid();
			boolean full = true;
			for(int r = 0; r < 4; r++) {
				for (int c = 0; c<4;c++) {
					if (board[r][c].getValue() == 0) full = false;
				}
			}
			if(!full) {
				while (board[x1][y1].getValue() != 0) {
					 x1 = (int)(Math.random()*4);
					 y1 = (int)(Math.random()*4);
				}
				System.out.println(x1 + " " + y1);
				grid.setGrid(2, x1, y1);
			}
			
			
			grid.repaint();
			
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
