package sailingShip.pages;

import java.awt.Graphics;

import sailingShip.Controller;



public abstract class Page {

private static Page currentState = null;
	
	public static void setState(Page page) {
		currentState = page;
	}
	
	public static Page getState() {
		return currentState;
	}
	
	//CLASS
	
	protected Controller controller;
	
	public Page(Controller controller) {
		this.controller = controller;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics graphics);
}
