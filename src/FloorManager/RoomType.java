package FloorManager;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

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
	
	// Status
	private boolean selected;
	private boolean highlighted;
	
	// Colors and font
	private final static Font TEXT_FONT = new Font("Arial", Font.BOLD, 12);
	private final static Color TEXT_COLOR = Color.WHITE;
	private final static Color BORDER = Color.DARK_GRAY;
	private final static Color UNSELECTED_BOX = Color.GRAY; 
	private final static Color HIGHLIGHTED_BOX = new Color(102,255,255); // Light blue
	private final static Color SELECTED_BOX = new Color(255,165,0); // Orange
	
	public RoomType(String name, int x, int y, int h, int w)
	{
		this.name = name;
		this.x = x;
		this.y = y;
		this.height = h;
		this.width = w;
	}
	
	public void selectRoom()
	{
		if (selected == false)
			selected = true;
		else
			selected = false;		
	}
	
	public void highlightRoom()
	{
		if (highlighted == false)
			highlighted = true;
		else
			highlighted = false;		
	}
	
	public boolean findRoom(int maxX, int minX, int maxY, int minY) {
		//System.out.println("minX " + minX + " >= " + this.x + " or " + "maxX " + maxX + " >= " + this.x);
		//System.out.println("minX " + minX + " < " + (this.x + this.width) + " or " + "maxX " + maxX + " < " + (this.x + this.width));
		//System.out.println("minY " + minY + " >= " + this.y + " or " + "maxY " + maxY + " >= " + this.y);
		//System.out.println("minY " + minY + " < " + (this.y + this.height) + " or " + "maxY " + maxY + " < " + (this.y + this.height));
		if ((minX >= this.x || maxX >= this.x) 
				&& (minX < this.x + this.width || maxX < this.x + this.width)
				&& (minY >= this.y || maxY >= this.y)
				&& (minY < this.y + this.height || maxY < this.y + this.height))
			return true;
		else
			return false;
	}
	
	public boolean isSelected() {
		return selected;
	}
	
	public boolean isHighlighted() {
		return highlighted;
	}
	
	public void draw(Graphics2D g)
	{
		if (this.isSelected())
		{
			g.setColor(BORDER);
			g.drawRect(x-1, y-1, height+1, width+1);
			g.setColor(SELECTED_BOX);
			g.fillRect(x, y, height, width);
		}
		else if (this.isHighlighted())
		{
			g.setColor(BORDER);
			g.drawRect(x-1, y-1, height+1, width+1);
			g.setColor(HIGHLIGHTED_BOX);
			g.fillRect(x, y, height, width);
		}
		else
		{
			g.setColor(BORDER);
			g.drawRect(x-1, y-1, height+1, width+1);
			g.setColor(UNSELECTED_BOX);
			g.fillRect(x, y, height, width);
		}
		g.setColor(TEXT_COLOR);
		g.setFont(TEXT_FONT);
		g.drawString(name, x + (width / 2), y + (height / 2));
	}
}
