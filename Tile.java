import java.awt.*;

public class Tile {
	private static final Color[] TILE_COLORS = {
		new Color(204,192,179), 	// default color
		new Color(238,228,218), 	// 2
		new Color(237,224,200), 	// 4
		new Color(242,177,121), 	// 8
		new Color(245,149,99), 		// 16
		new Color(246,124,95), 		// 32
		new Color(246,94,59), 		// 64
		new Color(237,207,114), 	// 128
		new Color(237,204,97), 		// 256
		new Color(237,200,80,255), 	// 512
		new Color(237,197,63,255), 	// 1024
		new Color(237,194,46,255), 	// 2048
		new Color(62,57,51) 		// > 2048
	};
	private static final Color[] TEXT_COLORS = {
		new Color(119, 110, 101), 	// value <= 4
		new Color(249, 246, 242)
	};
	
	private int value;
	
	private int x;
	private int y;
	private int size;

	private Color color;
	private Color textColor;
	
	public static int logBase2(int value) {
		if (value <= 1)
			return 0;
		return 1 + logBase2(value/2);
	}
  /**
    * Constructor for the Tile object 
    * @author - Kevin Tsoi
    * @param x - x location on Grid
    * @param y - y location on Grid
    * @param size - size of tile
    */
	public Tile(int value, int x, int y, int size) {
		setValue(value);
		this.x = x;
		this.y = y;
		this.size = size;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
		setColor();
	}
	
	//Sets a random value of either 2 or 4
	public void setRandom() {
		int[] rand = {2,4};
		setValue(rand[(int)(Math.random()*rand.length)]);
		
	}
	
	public void setColor() {
		int power = logBase2(value);
		color = power < TILE_COLORS.length ? TILE_COLORS[power] : TILE_COLORS[TILE_COLORS.length-1];
		textColor = power <= 2 ? TEXT_COLORS[0] : TEXT_COLORS[1];
	}

	public void swap(Tile t) {
		int temp = value;
		setValue(t.getValue());
		t.setValue(temp);
	}

	public void merge(Tile t) {
		setValue(value*2);
		t.setValue(0);
	}
	
	public void draw(Graphics2D g2d) {
		g2d.setColor(color);
		g2d.fillRoundRect(x, y, size, size, size/5, size/5); // corner radii = 20%
		g2d.drawRoundRect(x, y, size, size, size/5, size/5);
		
		if (value > 0) {
			String text = toString();
			Font f = new Font("Helvetica", Font.BOLD, size*1/2 - (text.length()-1)*3); // smaller font for larger numbers
			FontMetrics fm = g2d.getFontMetrics(f);
			
			g2d.setFont(f);
			g2d.setColor(textColor);
			g2d.drawString(text, x + (size - fm.stringWidth(text))/2, fm.getAscent() + y + (size - fm.getHeight())/2);
		}
	}

	public String toString() {
		return "" + value;
	}
}
