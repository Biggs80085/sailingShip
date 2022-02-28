package sailingShip.creations.creatures;





import sailingShip.Controller;
import sailingShip.creations.Creation;
import sailingShip.tiles.Tile;

public abstract class Creature extends Creation{
	
	public static final int DEFAULT_HEALTH = 100;
	public static final int DEFAULT_CREATURE_WIDTH = 64,
							DEFAULT_CREATURE_HEIGHT = 128;
	
	protected double minVitesse;
	protected double maxVitesse;
	
	protected int health;
	
	protected double angle = 0;
	protected double vitesse = 0;
	
	
	public Creature(Controller controller, float x, float y, int width, int height) {
		super(controller, x, y, width, height);
		health = DEFAULT_HEALTH;
	}
	
	protected boolean collisionSolid(int x, int y) {
		return controller.getMap().getTile(x, y).isSolid();
	}
	protected boolean collisionPene(int x, int y) {
		return controller.getMap().getTile(x, y).isPene();
	}
	
	protected void getInput(){
			
		int pos1 = (int) (y/Tile.TILEHEIGHT);
		int pos2 = (int) (x/Tile.TILEWIDTH);

		if(!collisionSolid((int) x / Tile.TILEWIDTH, (int) (y + 10)/ Tile.TILEHEIGHT) && !collisionSolid((int) (x + 10) / Tile.TILEWIDTH, (int) (y + 10)/ Tile.TILEHEIGHT) ){
		
			if(angle < ((controller.getMap().getZone(pos1, pos2).getWind() / 2) + controller.getMap().getZone(pos1, pos2).getCurrent() * 3) / 3 +20 &&
				angle > ((controller.getMap().getZone(pos1, pos2).getWind() / 2) + controller.getMap().getZone(pos1, pos2).getCurrent() * 3 ) / 3 -20) {
				vitesse=maxVitesse - controller.getMap().getZone(pos1, pos2).getWave()/10 + 
						(controller.getMap().getZone(pos1, pos2).getCurrent() +controller.getMap().getZone(pos1, pos2).getWind())/200;
				
			}else {
				vitesse=minVitesse + (controller.getMap().getZone(pos1, pos2).getCurrent() +controller.getMap().getZone(pos1, pos2).getWind())/200;
			}
			
		}else {
			health = 0;	
		}
		if(!collisionPene((int) x / Tile.TILEWIDTH, (int) (y + 10)/ Tile.TILEHEIGHT) && !collisionPene((int) (x + 10) / Tile.TILEWIDTH, (int) (y + 10)/ Tile.TILEHEIGHT) ){
		
			if(angle < ((controller.getMap().getZone(pos1, pos2).getWind() / 2) + controller.getMap().getZone(pos1, pos2).getCurrent() * 3 ) / 3 + 20 &&
				angle > ((controller.getMap().getZone(pos1, pos2).getWind() / 2) + controller.getMap().getZone(pos1, pos2).getCurrent() * 3 ) / 3 - 20) {
				vitesse=maxVitesse - controller.getMap().getZone(pos1, pos2).getWave()/10 + 
					     (controller.getMap().getZone(pos1, pos2).getCurrent() +controller.getMap().getZone(pos1, pos2).getWind())/200;
			}else {
				vitesse=minVitesse + (controller.getMap().getZone(pos1, pos2).getCurrent() + controller.getMap().getZone(pos1, pos2).getWind())/200;
			}
			
		}else {	
			if(health != 0)
				health -= 1;	
		}
		
		if(health > 0) {
			if(controller.getKey().left) {
				angle -= 1;
				if(angle<0) {
					angle=359;
				}
			}
				
			if(controller.getKey().right) {
				angle += 1;
				if(angle>359) {
					angle=0;
				}
			}
			x += vitesse*Math.sin(Math.toRadians(angle));
			y += vitesse*Math.cos(Math.toRadians(180-angle));
			
		}
	
	}
	
	
	
	//GETTERS SETTERS
	
	public double getMinVitesse() {
		return minVitesse;
	}

	public void setMinVitesse(double minVitesse) {
		this.minVitesse = minVitesse;
	}

	public double getMaxVitesse() {
		return maxVitesse;
	}

	public void setMaxVitesse(double maxVitesse) {
		this.maxVitesse = maxVitesse;
	}
	public double getVitesse() {
		return vitesse;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	


	
}
