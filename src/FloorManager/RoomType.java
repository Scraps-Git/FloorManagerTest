package FloorManager;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class RoomType 
{
	// Name of the room
	private String name;
	
	// Position
	private int x;
	private int y;
	
	// Dimensions
	private int height;
	private int width;
	
	// Colors and font
	private final static Font textFont = new Font("Arial", Font.BOLD, 12);
	private final static Color textColor = Color.WHITE;
	private final static Color colorUnselectedBox = Color.GRAY; 
	private final static Color colorUnselectedBorder = Color.DARK_GRAY;
	private final static Color colorHighlightedBox = Color.BLUE;
	private final static Color colorHighlightedBorder = new Color(0,0,128); // Navy blue
	private final static Color colorSelectedBox = new Color(255,165,0); // Orange
	private final static Color colorSelectedBorder = new Color(255,69,0); // Orange red
	
	public RoomType (String name, int x, int y, int h, int w)
	{
		this.name = name;
		this.x = x;
		this.y = y;
		this.height = h;
		this.width = w;
	}
	
	public void draw (Graphics2D g)
	{
		g.setColor(colorUnselectedBorder);
		g.drawRect(x, y, height, width);
		g.setColor(colorUnselectedBox);
		g.fillRect(x, y, height, width);
		g.setColor(textColor);
		g.setFont(textFont);
		g.drawString(name, x + (width / 2), y + (height / 2));
	}
}
