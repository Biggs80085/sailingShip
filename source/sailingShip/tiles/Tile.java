package sailingShip.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;



public class Tile {

	//STATIC STUFF HERE
	
		public static Tile[] tiles = new Tile[256];
		
		public static Tile limiteTile = new LimiteTile(0);
		public static Tile icebergTile = new IcebergTile(1);
		public static Tile grassTile = new GrassTile(2);
		public static Tile seaTile = new SeaTile(3);
		public static Tile waveTile = new WaveTile(4);
		
		//CLASS
		
		public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
		
		protected BufferedImage texture;
		protected final int id;
		
		protected float current;
		protected float wind;
		
		public Tile(BufferedImage texture, int id) {
			this.texture = texture;
			this.id = id;
			
			tiles[id] = this;
			
		}
		
		public void tick() {
			
		}
		
		public void render(Graphics graphics, int x, int y) {
			graphics.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
		}
		
		public boolean isSolid() {
			return false;
		}
		public boolean isPene() {
			return false;
		}
		
		public int getId() {
			return id;
		}
		
		public float getCurrent() {
			return current;
		}
		
		public float getWind() {
			return wind;
		}
		
		public void setCurrent(float c) {
			this.current = c;
		}
		
		public void setWind(float w) {
			this.wind = w;
		}
}
