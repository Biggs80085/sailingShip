package sailingShip.creations;

import java.awt.Graphics;

import sailingShip.Controller;

public abstract class Creation {
	
	protected Controller controller;
	protected float x, y;
	protected int width, height;
	
	
	public Creation(Controller controller, float x, float y, int width, int height){
		this.controller = controller;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;	
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics graphics);

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
