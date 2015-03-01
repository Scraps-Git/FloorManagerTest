package FloorManager;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Grid.TileGrid;

public class FirstFloor extends FloorType 
{
	private TileGrid tileGrid;
	
	public FirstFloor (FloorManager fm)
	{
		this.fm = fm;
		init();
	}
	
	public void init ()
	{
		floorRooms = new ArrayList<RoomType>();
		this.floorRooms.add(new RoomType("Room 1", 10, 10, 135, 140));
		this.floorRooms.add(new RoomType("Room 2", 170, 170, 155, 160));
		
		tileGrid = new TileGrid(40);
	}
	
	public void update () {}
	
	public void draw (Graphics2D g)
	{
		super.draw(g);
		tileGrid.draw(g);
	}
	
	// Mouse events
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e)
	{
		System.out.println("x = " + e.getX() + ", y = " + e.getY());
		tileGrid.selectTile(e.getX(), e.getY());
	}
	public void mouseReleased(MouseEvent e) {}	
	
	// Keyboard events
	public void keyTyped(KeyEvent e) {}	
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
}