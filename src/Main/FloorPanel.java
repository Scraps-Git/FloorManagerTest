package Main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import FloorManager.FloorManager;

public class FloorPanel extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener
{
	// Dimensions of the panel
	public static final int WIDTH = 600;
	public static final int HEIGHT = 600;
	
	// Game thread
	private Thread thread;
	private boolean running;
	private int FPS = 60;
	private long targetTime = 1000 / FPS;
	
	// Graphics
	private BufferedImage image;
	private Graphics2D g2;
	
	// Floor Manager
	private FloorManager fm;
	
	public FloorPanel()	
	{		
		super();
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		addMouseMotionListener(this);
		addMouseListener(this);
		addKeyListener(this);
		setFocusable(true);
	}
	
	public void addNotify() 
	{		
		super.addNotify();
		if(thread == null) {
			thread = new Thread(this);
			addKeyListener(this);
			thread.start();
		}
	}
	
	public void init() 
	{		
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		
		g2 = (Graphics2D) image.getGraphics();
				
		running = true;
		
		fm = new FloorManager();
	}
	
	public void run()
	{		
		init();
		
		long start;
		long elapsed;
		long wait;
		
		while(running) 
		{
			start = System.nanoTime();
			
			update();
			draw();
			drawToScreen();
			
			elapsed = System.nanoTime() - start;
			
			wait = targetTime - elapsed / 1000000;
			if (wait < 0)
				wait = 5;
			
			try { Thread.sleep(wait); }
			catch(Exception e) { e.printStackTrace(); }
		}
	}
	
	private void update() 
	{
		fm.update();
	}
	
	private void draw() 
	{
		fm.draw(g2);
	}
	
	private void drawToScreen() 
	{
		Graphics g3 = getGraphics();
		g3.drawImage(image, 0, 0, WIDTH, HEIGHT, null);
		g3.dispose();
	}	
	
	public void mouseClicked(MouseEvent e) { fm.mouseClicked(e); }
	public void mouseEntered(MouseEvent e) { fm.mouseEntered(e); }
	public void mouseExited(MouseEvent e) {	fm.mouseExited(e); }
	public void mousePressed(MouseEvent e) 	{ fm.mousePressed(e); }
	public void mouseReleased(MouseEvent e) { fm.mouseReleased(e); }
	
	public void mouseMoved(MouseEvent e) { fm.mouseMoved(e); }
	public void mouseDragged(MouseEvent e) { fm.mouseDragged(e); }
	
	public void keyTyped(KeyEvent e) { fm.keyTyped(e); }	
	public void keyPressed(KeyEvent e) { fm.keyPressed(e); }
	public void keyReleased(KeyEvent e) { fm.keyReleased(e); }
}