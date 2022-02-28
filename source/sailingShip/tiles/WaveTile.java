package sailingShip.tiles;

import sailingShip.InterfaceGraphics.Components;

public class WaveTile extends Tile{
	public WaveTile(int id) {
		super(Components.wave, id);
	
	}
	
	@Override
	public boolean isPene(){
		return true;
	}
}
