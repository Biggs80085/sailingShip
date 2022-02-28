package sailingShip.tiles;


import sailingShip.InterfaceGraphics.Components;

public class GrassTile extends Tile{

	public GrassTile(int id) {
		super(Components.grass, id);
	
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}
}
