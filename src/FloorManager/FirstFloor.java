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
		
		tileGrid = new TileGrid(26);
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
		boolean found = false;
		int i = 0;
		int tileX, tileY, tileW, tileH, minX, maxX, minY, maxY;
		tileW = tileGrid.getWidth();
		tileH = tileGrid.getHeight();
		tileX = (e.getX() / tileW) * tileW;
		tileY = (e.getY() / tileH) * tileH;
		minX = Math.min(tileX, tileX + tileW);
		maxX = Math.max(tileX, tileX + tileW);
		minY = Math.min(tileY, tileY + tileH);
		maxY = Math.max(tileY, tileY + tileH);
		while (!found && i < floorRooms.size())
		{
			if (floorRooms.get(i).findRoom(maxX, minX, maxY, minY))
			{
				floorRooms.get(i).selectRoom();
				found = true;
			}
			i++;
		}
		
		// If the above loop found a matching room
		if (found)
		{
			// Select all tiles containing the room
		}
		// Otherwise, select the clicked tile
		else
			tileGrid.mousePressed(e);
	}
	public void mouseReleased(MouseEvent e) {}

	// Mouse listener events
	public void mouseMoved(MouseEvent e) 
	{
		boolean found = false;
		int i = 0;
		int tileX, tileY, tileW, tileH, minX, maxX, minY, maxY;
		tileW = tileGrid.getWidth();
		tileH = tileGrid.getHeight();
		tileX = (e.getX() / tileW) * tileW;
		tileY = (e.getY() / tileH) * tileH;
		minX = Math.min(tileX, tileX + tileW);
		maxX = Math.max(tileX, tileX + tileW);
		minY = Math.min(tileY, tileY + tileH);
		maxY = Math.max(tileY, tileY + tileH);
		while (!found && i < floorRooms.size())
		{
			// If the room is NOT selected (don't highlight rooms that have been selected)
			if (!floorRooms.get(i).isSelected())
			{
				// If the room is found
				if (floorRooms.get(i).findRoom(maxX, minX, maxY, minY))
				{
					// If the room is not already highlighted
					if (!floorRooms.get(i).isHighlighted())
						floorRooms.get(i).highlightRoom();
					found = true;
				}
				// If the room is not found
				else
				{
					// If the room is highlighted
					if (floorRooms.get(i).isHighlighted())
						floorRooms.get(i).highlightRoom();
				}
			}
			i++;
		}
		
		// If the above loop found a matching room
		if (found)
		{
			// Select all tiles containing the room
		}
		// Otherwise, select the clicked tile
	}
	public void mouseDragged(MouseEvent e) {}
	
	// Keyboard events
	public void keyTyped(KeyEvent e) {}	
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
}