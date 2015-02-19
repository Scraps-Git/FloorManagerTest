package FloorManager;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class FloorManager 
{
	private ArrayList<FloorType> floorList;
	private int currentFloor;
	
	private static final int FIRST_FLOOR = 0;
	
	public FloorManager()
	{
		floorList = new ArrayList<FloorType>();
		
		currentFloor = FIRST_FLOOR;
		floorList.add(new FirstFloor(this));
	}
	
	public void setFloor(int floor)
	{
		currentFloor = floor;
		floorList.get(currentFloor).init();
	}
	
	public void update() { floorList.get(currentFloor).update(); }	
	
	public void draw(java.awt.Graphics2D g)	{ floorList.get(currentFloor).draw(g); }
	
	public void mouseClicked(MouseEvent e) { floorList.get(currentFloor).mouseClicked(e); }
	public void mouseEntered(MouseEvent e) { floorList.get(currentFloor).mouseEntered(e); }
	public void mouseExited(MouseEvent e) { floorList.get(currentFloor).mouseExited(e); }
	public void mousePressed(MouseEvent e) 	{ floorList.get(currentFloor).mousePressed(e); }
	public void mouseReleased(MouseEvent e) { floorList.get(currentFloor).mouseReleased(e); }	
	
	public void keyTyped(KeyEvent e) { floorList.get(currentFloor).keyTyped(e); }	
	public void keyPressed(KeyEvent e) { floorList.get(currentFloor).keyPressed(e); }
	public void keyReleased(KeyEvent e) { floorList.get(currentFloor).keyReleased(e); }
}