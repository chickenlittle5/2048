import java.awt.Color;
import java.awt.Graphics2D;

public class Tile {
	private static final Color[] colors = {
		new Color(204,192,179), // default color
		new Color(238,228,218), // 2
		new Color(237,224,200), // 4
		new Color(242,177,121), // ...
		new Color(245,149,99),
		new Color(246,124,95),
		new Color(246,94,59),
		new Color(237,207,114),
		new Color(237,204,97),
		new Color(237,200,80,255),
		new Color(237,197,63,255),
		new Color(237,194,46,255),
		new Color(62,57,51) // >2048
	};
	
	private int power;
	
	private int x;
	private int y;
	private int size;
	private Color color;
	
	public Tile(int power, int x, int y, int size) {
		setPower(power);
		this.x = x;
		this.y = y;
		this.size = size;
	}
	
	public int getPower() {
		return power;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setPower(int power) {
		this.power = power;
		setColor();
	}
	
	public void setColor() {
		color = power < colors.length-1 ? colors[power] : colors[colors.length-1];
	}
	
	public void draw(Graphics2D g2d) {
		g2d.setColor(color);
		g2d.fillRoundRect(x, y, size, size, size/5, size/5); // corner radii = 20%
		g2d.drawRoundRect(x, y, size, size, size/5, size/5);
		
	}

	public String toString() {
		return "" + Math.pow(2, power);
	}
}
