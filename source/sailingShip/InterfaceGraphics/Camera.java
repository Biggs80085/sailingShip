package sailingShip.InterfaceGraphics;


import sailingShip.Controller;
import sailingShip.creations.Creation;
import sailingShip.tiles.Tile;

public class Camera {
	
	private Controller controller;
	private float xOffset, yOffset;
	
	public Camera(Controller controller, float xOffset, float yOffset){
		this.controller = controller;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public void checkBlankSpace() {
		if(xOffset  < 0) {
			xOffset = 0;
		}else if (xOffset > controller.getMap().getWidth() * Tile.TILEWIDTH - controller.getWidth()) {
			xOffset = controller.getMap().getWidth() * Tile.TILEWIDTH - controller.getWidth() ;
		}
		if(yOffset  < 0) {
			yOffset = 0;
		}else if (yOffset > controller.getMap().getHeight() * Tile.TILEHEIGHT - controller.getHeight()) {
			yOffset = controller.getMap().getHeight() * Tile.TILEHEIGHT - controller.getHeight();
		}
	}
	
	public void centerOnEntity(Creation e){
		xOffset = e.getX() - controller.getWidth() / 2 + e.getWidth() / 2;
		yOffset = e.getY() - controller.getHeight() / 2 + e.getHeight() / 2;
		checkBlankSpace();
	}
	
	public void move(float xAmt, float yAmt){
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlankSpace();
	}

	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
}
