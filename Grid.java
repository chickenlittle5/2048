import java.awt.*;

public class Grid extends Canvas {
	private static final int gridSegments = 4;
	private static final Color canvasColor = new Color(187,173,160);

	private Tile[][] grid;
	
	//returns the grid
	public Tile[][] getGrid () {
		return grid;
	}
	//set a value in the grid
	public void setGrid (int val, int r, int c) {
		grid[r][c].setValue(val);
	}
	
	
	public Grid(int gridSize) {
		int tileSize = gridSize / (gridSegments + 1);
		
		grid = new Tile[gridSegments][gridSegments];
		for (int r = 0; r < gridSegments; r++) {
			for (int c = 0; c < gridSegments; c++) {
				grid[r][c] = new Tile(0, c*tileSize + (c+1)*tileSize/5, r*tileSize + (r+1)*tileSize/5, tileSize);
			}
		}
		
		
		//Puts 2 random blocks at the start of the game
		int x1 = (int)(Math.random()*gridSegments);
		int y1 = (int)(Math.random()*gridSegments);
		grid[x1][y1].setRandom();
		int x2 = (int)(Math.random()*gridSegments);
		int y2 = (int)(Math.random()*gridSegments);
		while (x1 == x2 && y1 == y2) {
			x2 = (int)(Math.random()*gridSegments);
			y2 = (int)(Math.random()*gridSegments);
		}
		grid[x2][y2].setRandom();
		
		
		Dimension dimension = new Dimension(gridSize, gridSize);
		setMinimumSize(dimension);
		setMaximumSize(dimension);
		setPreferredSize(dimension);
	}
	
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g.setColor(canvasColor);
		g2d.fillRoundRect(0, 0, getWidth(), getHeight(), getWidth()/20, getHeight()/20); // corner radii = 5%
		
		for (Tile[] row: grid) {
			for (Tile tile: row) {
				tile.draw(g2d);
			}
		}
	}

}
