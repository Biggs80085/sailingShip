package sailingShip.tiles;

import sailingShip.InterfaceGraphics.Components;

public class IcebergTile extends Tile{
	public IcebergTile(int id) {
		super(Components.iceberg, id);
	
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}
}
