package sailingShip;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import sailingShip.InterfaceGraphics.Camera;
import sailingShip.InterfaceGraphics.Components;
import sailingShip.Present.Present;
import sailingShip.manage.Key;
import sailingShip.manage.Mouse;
import sailingShip.pages.PageGame;
import sailingShip.pages.PageMenu;
import sailingShip.pages.Page;


public class Play implements Runnable{

	
	//States
	public PageGame pageGame;
	public PageMenu pageMenu;
		
	//Camera
	private Camera camera;
		
	//Input
	private Key key;
	private Mouse mouse;
		
	//Handler
	private Controller controller;
	
	private Present present;	
	private int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics graphics;
	
	
	public Play(String title, int width, int height) {
		
		this.width = width;
		this.height = height;
		this.title = title;
		key = new Key();
		mouse = new Mouse();
	}
	
	private void tick() {
		key.tick();
		if(Page.getState() != null)
			Page.getState().tick();
	}
	
	private void render() {
		bs = present.getCanvas().getBufferStrategy();
		if(bs == null) {
			present.getCanvas().createBufferStrategy(3);
			return;
		}
		graphics = bs.getDrawGraphics();
		// Rafraichir
		graphics.clearRect(0, 0, width, height);
		// Dessin
		
		if(Page.getState() != null) {
			Page.getState().render(graphics);
		}
		
		// Fin dessin
		
		bs.show();
		graphics.dispose();
	}
	
	private void init() {
		present = new Present(title, width, height);
		present.getFrame().addKeyListener(key);
		present.getFrame().addMouseListener(mouse);
		present.getFrame().addMouseMotionListener(mouse);
		present.getCanvas().addMouseListener(mouse);
		present.getCanvas().addMouseMotionListener(mouse);
		
		Components.init();
		
		controller = new Controller(this);
		
		camera = new Camera(controller, 0, 0);
		
		pageGame = new PageGame(controller);
		pageMenu = new PageMenu(controller);
		Page.setState(pageMenu);
	
	}
	
	public void run() {
		
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		// nb d'images par seconde est de 60
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000) {
				
				ticks = 0;
				timer = 0;
			}
		}
		stop();
	}
	
	public Key getKey(){
		return key;
	}
	public Mouse getMouse(){
		return mouse;
	}
	public Camera getCamera(){
		return camera;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	
	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
