package sailingShip.tiles;

import sailingShip.InterfaceGraphics.Components;

public class LimiteTile extends Tile{

		public LimiteTile(int id) {
			super(Components.limite, id);
		
		}
		
		@Override
		public boolean isSolid(){
			return true;
		}
	}


