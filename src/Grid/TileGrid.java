package Grid;

import java.awt.Color;
import java.awt.event.MouseEvent;

import Main.FloorPanel;

public class TileGrid 
{
	public Tile[][] map;
	private int tileSize;
	private int numRows;
	private int numCols;
	private int width;
	private int height;
	
	// Draws double-lined tiles; may enable for ease of visibility
	private static final boolean DOUBLE_LINED = false;
	
	public TileGrid(int tileSize)
	{
		// Determining number of rows and columns
		this.tileSize = tileSize;
		numRows = FloorPanel.HEIGHT / tileSize;
		numCols = FloorPanel.WIDTH / tileSize;
		width = tileSize;
		height = tileSize;
		
		// Initializing the array
		map = new Tile[numRows][numCols];
		
		// Initializing each object in the array
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++)	{
				map[i][j] = new Tile();
			}
		}
	}
	
	public void selectTile(int x, int y)
	{
		// Find the target row and column 
		int targetRow = x / width;
		int targetCol = y / height;
		
		// If the tile is already selected, deselect it, otherwise select it
		if (map[targetRow][targetCol].isSelected())
			map[targetRow][targetCol].deselect();
		else
			map[targetRow][targetCol].select();
	}
	
	public int getRows() {
		return numRows;
	}
	
	public int getCols() {
		return numCols;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void draw(java.awt.Graphics2D g)
	{
		// Draw all unselected tiles with black
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				if (!map[i][j].isSelected()) {
					g.setColor(Color.BLACK);
				
					// Drawing a line from top left (0, 0) to top right (1, 0)
					if (DOUBLE_LINED)
						g.drawLine(i * height, j * width + 1, (i + 1) * height, j * width + 1);
					else
						g.drawLine(i * height, j * width, (i + 1) * height, j * width);
					// Drawing a line from top left (0, 0) to bottom left (0, 1)
					if (DOUBLE_LINED)
						g.drawLine(i * height + 1, j * width, i * height + 1, (j + 1) * width);
					else
						g.drawLine(i * height, j * width, i * height, (j + 1) * width);
					// Drawing a line from bottom left (0, 1) to bottom right (1, 1)
					g.drawLine(i * height, (j + 1) * width, (i + 1) * height, (j + 1) * width);
					// Drawing a line from top right (1, 0) to bottom right (1, 1)
					g.drawLine((i + 1) * height, j * width, (i + 1) * height, (j + 1) * width);
				}
			}
		}
		
		// Draw all selected tiles with red (this requires a second loop so as to not be overwritten by the first loop)
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				if (map[i][j].isSelected())	{
					g.setColor(Color.RED);
				
					// Drawing a line from top left (0, 0) to top right (1, 0)
					if (DOUBLE_LINED)
						g.drawLine(i * height, j * width + 1, (i + 1) * height, j * width + 1);
					else
						g.drawLine(i * height, j * width, (i + 1) * height, j * width);
					// Drawing a line from top left (0, 0) to bottom left (0, 1)
					if (DOUBLE_LINED)
						g.drawLine(i * height + 1, j * width, i * height + 1, (j + 1) * width);
					else
						g.drawLine(i * height, j * width, i * height, (j + 1) * width);
					// Drawing a line from bottom left (0, 1) to bottom right (1, 1)
					g.drawLine(i * height, (j + 1) * width, (i + 1) * height, (j + 1) * width);
					// Drawing a line from top right (1, 0) to bottom right (1, 1)
					g.drawLine((i + 1) * height, j * width, (i + 1) * height, (j + 1) * width);
				}
			}
		}
	}
	
	public void mousePressed(MouseEvent e)
	{
		this.selectTile(e.getX(), e.getY());
	}
}