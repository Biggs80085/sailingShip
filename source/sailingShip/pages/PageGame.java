package sailingShip.pages;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import sailingShip.Controller;
import sailingShip.creations.creatures.Creature;
import sailingShip.maps.Map;
import sailingShip.tiles.Tile;



public class PageGame extends Page{
	
	private Map map;
	private Creature creature;
	

	public PageGame(Controller controller) {
		super(controller);
		map = new Map(controller ,"resource/map/lightMap.txt");
		controller.setMap(map);
		
	}
	
	@Override
	public void tick() {
		
		map.tick();
		creature.tick();
		
	}

	@Override
	public void render(Graphics graphics) {
		int pos1 = (int) (creature.getY()/Tile.TILEHEIGHT);
		int pos2 = (int) (creature.getX()/Tile.TILEWIDTH);
		map.render(graphics); 
		creature.render(graphics);
		Font font2 = new Font("arial", Font.BOLD, 20);
		graphics.setColor(Color.green);
        graphics.setFont(font2);
		graphics.drawString("Wind :"+controller.getMap().getZone(pos1, pos2).getWind()+"° "+controller.getMap().getZone(pos1, pos2).getSpeedWind()+"m/h"
							, controller.getPlay().getWidth() - 250, 100);
		graphics.drawString("Current :"+controller.getMap().getZone(pos1, pos2).getCurrent()+"°  "+controller.getMap().getZone(pos1, pos2).getSpeedCurrent()+"m/h"
							, controller.getPlay().getWidth() - 250, 50);
		graphics.drawString("Wave :"+controller.getMap().getZone(pos1, pos2).getWave()+" echelle"
							, controller.getPlay().getWidth() - 250, 150);
		graphics.drawString("Speed :"+(float) creature.getVitesse()+" km/h"
				, controller.getPlay().getWidth() - 250, 200);
		graphics.drawString("Health :"+creature.getHealth()
				, controller.getPlay().getWidth() - 250, 250);
		
		
		if(creature.getHealth() == 0) {
			Font font = new Font("arial", Font.BOLD, 50);
			graphics.setColor(Color.red);
	        graphics.setFont(font);
			graphics.drawString("Game over", controller.getPlay().getWidth()/2 -140, controller.getPlay().getHeight()/2 - 10);
		}
		
	}
	
	public void setCreature(Creature c) {
		this.creature = c;
	}
}
