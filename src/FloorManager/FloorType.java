package FloorManager;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import Main.FloorPanel;

public abstract class FloorType 
{
	protected FloorManager fm;
	
	// Name of the floor
	//private String floorName;
	
	// Grid
	private int[][] grid = new int[15][15];
	//private int gridBoxWidth = grid.length;
	private int gridBoxWidth = 40;
	//private int gridBoxHeight = grid[0].length;
	private int gridBoxHeight = 40;
	
	//private Point2D highlighted; // Point where the cursor is currently located
    private ArrayList<Point2D> selected = new ArrayList<Point2D>(); // List of points clicked with mouse
	
	// List of rooms on this floor
	protected ArrayList<RoomType> floorRooms;
	
	public abstract void init();
	
	public abstract void update();
	
	public void draw (java.awt.Graphics2D g) 
	{
		// Clear the screen
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, FloorPanel.WIDTH, FloorPanel.HEIGHT);
		
		// Draw the rooms from list
		for (int i = 0; i < floorRooms.size(); i++) 
			floorRooms.get(i).draw(g);
		
		// Draw the grid
		g.setColor(Color.BLACK);
		
		for(int i = 1; i < grid.length; i++)
		{
			g.drawLine((int) (FloorPanel.WIDTH * ((double) i / (double) grid.length)), 0, (int) (FloorPanel.WIDTH * ((double) i / (double) grid.length)), FloorPanel.HEIGHT);
		}

		for(int i = 1; i < grid[0].length; i++)
		{
			g.drawLine(0, (int) (FloorPanel.HEIGHT * ((double) i / (double) grid[0].length)), FloorPanel.WIDTH, (int) (FloorPanel.HEIGHT * ((double) i / (double) grid[0].length)));
		}
		
		// Draw the selected grid boxes
		g.setColor(Color.RED);

		for(int i = 0; i < selected.size(); i++)
		{
			g.drawRect((int) (gridBoxWidth * selected.get(i).getX()),(int) (gridBoxHeight * selected.get(i).getY()), gridBoxWidth, gridBoxHeight);
		}
	}
	public abstract void mouseClicked(MouseEvent e);
	public abstract void mouseEntered(MouseEvent e);
	public abstract void mouseExited(MouseEvent e);
	public void mousePressed(MouseEvent e)
	{
		Point2D point = new Point2D.Double((int) (((double) e.getX() / (double) FloorPanel.WIDTH) * grid.length),(int) (((double) e.getY() / (double) FloorPanel.HEIGHT) * grid[0].length));

		selected.add(point);
	}
	public abstract void mouseReleased(MouseEvent e);
	
	public abstract void keyTyped(KeyEvent e);
	public abstract void keyPressed(KeyEvent e);
	public abstract void keyReleased(KeyEvent e);
}