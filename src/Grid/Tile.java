package Grid;

public class Tile
{
	// Type
	private int type;
	
	// Status
	private boolean selected;
	
	// Tile types
	public static final int WALKABLE = 0;
	public static final int UNWALKABLE = 1;
	
	// Default tile; no parameters
	public Tile() {
		this.type = 0;
		this.selected = false;
	}
	
	// Create tile with given type
	public Tile(int type) {
		this.type = type;
		this.selected = false;
	}
	
	public boolean isWalkable() {
		return (type == 0);
	}
	
	public boolean isSelected() {
		return selected;
	}
	
	public void select() {
		selected = true;
	}
	
	public void deselect() {
		selected = false;
	}
}