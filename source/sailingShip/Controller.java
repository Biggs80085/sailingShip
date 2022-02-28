package sailingShip;

import sailingShip.InterfaceGraphics.Camera;
import sailingShip.manage.Key;
import sailingShip.manage.Mouse;
import sailingShip.maps.Map;

public class Controller {

	private Play play;
	private Map map;
	
	public Controller(Play play) {
		this.play = play;
	}
	
	public Key getKey() {
		return play.getKey();
	}
	public Mouse getMouse() {
		return play.getMouse();
	}
	
	public Camera getCamera(){
		return play.getCamera();
	}
	
	public int getWidth() {
		return play.getWidth();
	}
	
	public int getHeight() {
		return play.getHeight();
	}

	public Play getPlay() {
		return play;
	}

	public void setPlay(Play play) {
		this.play = play;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}
	
	
}
