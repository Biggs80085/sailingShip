package sailingShip.pages;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import sailingShip.Controller;
import sailingShip.InterfaceGraphics.LoaderImage;
import sailingShip.creations.creatures.Genois;
import sailingShip.creations.creatures.Sprinkler;
import sailingShip.creations.creatures.Trinquette;



public class PageMenu extends Page{

	BufferedImage trinquette = LoaderImage.loadImage("/texture/trinquette.png");
	BufferedImage genois = LoaderImage.loadImage("/texture/genois.png");
	BufferedImage sprinkler = LoaderImage.loadImage("/texture/sprinkler.png");
	
	public PageMenu(Controller controller) {
		super(controller);
	}
	
	@Override
	public void tick() {
		if(controller.getPlay().getMouse().getMouseX() >= 350 
				&& controller.getPlay().getMouse().getMouseX() <= 450 
				&& controller.getPlay().getMouse().getMouseY() >= 250 
				&& controller.getPlay().getMouse().getMouseY() <= 350 ) {
			
			if(controller.getMouse().isLeftPressed()) {
				Page.setState(controller.getPlay().pageGame);
				controller.getPlay().pageGame.setCreature(new Trinquette(controller, 240, 640));
			}
		}
		
		if(controller.getPlay().getMouse().getMouseX() >= 150 
				&& controller.getPlay().getMouse().getMouseX() <= 250 
				&& controller.getPlay().getMouse().getMouseY() >= 250 
				&& controller.getPlay().getMouse().getMouseY() <= 350) {
			if(controller.getMouse().isLeftPressed()) {
				Page.setState(controller.getPlay().pageGame);
				controller.getPlay().pageGame.setCreature(new Genois(controller, 240, 640));
			}
		}
		
		if(controller.getPlay().getMouse().getMouseX() >= 550 
				&& controller.getPlay().getMouse().getMouseX() <= 650 
				&& controller.getPlay().getMouse().getMouseY() >= 250 
				&& controller.getPlay().getMouse().getMouseY() <= 350) {
			if(controller.getMouse().isLeftPressed()) {
				Page.setState(controller.getPlay().pageGame);
				controller.getPlay().pageGame.setCreature(new Sprinkler(controller, 240, 640));
			}
		}		
	}

	@Override
	public void render(Graphics graphics) {
	
		Font font = new Font("arial", Font.BOLD, 20);
        graphics.setFont(font);
		graphics.drawString("Choose a type of boat to start playing", 220, 120);
		graphics.drawString("Trinquette", 150, 400);
		graphics.drawString("Genois", controller.getPlay().getWidth()/2-50, 400);
		graphics.drawString("Sprinkler", controller.getPlay().getHeight()-50, 400);
		
		graphics.drawImage(trinquette, 150, controller.getPlay().getHeight()/2-50, 100, 100, null);
		graphics.drawImage(genois, controller.getPlay().getWidth()/2-50, controller.getPlay().getHeight()/2-50, 100, 100, null);
		graphics.drawImage(sprinkler, controller.getPlay().getHeight()-50, controller.getPlay().getHeight()/2-50, 100, 100, null);

	}
}
