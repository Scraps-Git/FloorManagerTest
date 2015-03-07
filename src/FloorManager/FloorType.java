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
	}
	
	// Mouse events
	public abstract void mouseClicked(MouseEvent e);
	public abstract void mouseEntered(MouseEvent e);
	public abstract void mouseExited(MouseEvent e);
	public abstract void mousePressed(MouseEvent e);
	public abstract void mouseReleased(MouseEvent e);
	
	// Mouse listener events
	public abstract void mouseMoved(MouseEvent e);
	public abstract void mouseDragged(MouseEvent e);
	
	// Keyboard events
	public abstract void keyTyped(KeyEvent e);
	public abstract void keyPressed(KeyEvent e);
	public abstract void keyReleased(KeyEvent e);
}