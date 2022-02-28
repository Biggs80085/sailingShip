package sailingShip.creations.creatures;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import sailingShip.Controller;
import sailingShip.InterfaceGraphics.Components;

public class Genois extends Creature{

	public Genois(Controller controller, float x, float y) {
		super(controller, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		this.minVitesse = 1.5;
		this.maxVitesse = 3.5;
	}

	@Override
	public void tick() {
		getInput();
		controller.getCamera().centerOnEntity(this);
	}

	@Override
	public void render(Graphics graphics) {
		
		AffineTransform transformer = AffineTransform.getTranslateInstance((int) (x - controller.getCamera().getxOffset()), (int) (y - controller.getCamera().getyOffset()));
		
		transformer.rotate(Math.toRadians(angle));
		
		transformer.scale(0.3, 0.3);
		
	
		
		Graphics2D g2d = (Graphics2D) graphics;
		g2d.drawImage(Components.genois, transformer, null);
				
	}

}
