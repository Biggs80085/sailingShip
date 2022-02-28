package sailingShip.maps;



import java.awt.Graphics;

import Zoned.Zone;
import sailingShip.Controller;
import sailingShip.readMaps.ReadMap;
import sailingShip.tiles.Tile;

public class Map {
	
	private Controller controller;

	private int width, height;

	private int[][] tiles;
	
	
	
	private Zone[][] zones;

	
	public Map(Controller controller, String path) {
		
		this.controller = controller;
		
		loadmap(path);
		loadZone();
	}
	
	private void loadmap(String path) {
		String file = ReadMap.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = ReadMap.parseInt(tokens[0]);
		height = ReadMap.parseInt(tokens[1]);
		
		tiles = new int[height][width];
		
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				tiles[y][x] = ReadMap.parseInt(tokens[(x + y * width) + 2]);
			}
		}
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics graphics) {
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				zones[y][x].getTile().render(graphics,(int) (x * Tile.TILEWIDTH - controller.getCamera().getxOffset()) ,(int) (y * Tile.TILEHEIGHT - controller.getCamera().getyOffset()) );
			}
		}
	}
	
	public Tile getTile(int x, int y){
		if(x<0 || y<0 || x >= width || y >= height)
			return Tile.seaTile ;
		
		Tile t = Tile.tiles[tiles[y][x]];
		if(t == null)
			return Tile.limiteTile;
		return t;
	}
	
	private void loadZone() {
		
		zones = new Zone[height][width];
		
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				
				if(x < 5 && y < 5) {
					zones[y][x] = new Zone(getTile(x, y), 70, 90, 1, 50, 20);
				}else if(x >= 5 && x < 10  && y < 5) {
					zones[y][x] = new Zone(getTile(x, y), 80, 60, 0, 10, 10);
				}else if(x >= 10 && x < 15  && y < 5) {
					zones[y][x] = new Zone(getTile(x, y), 75, 80, 2, 50, 100);
				}else if(x >= 15 && y < 5) {
					zones[y][x] = new Zone(getTile(x, y), 90, 50, 1, 60, 20);
				}
				
				else if(x < 5 && y >= 5 && y < 10) {
					zones[y][x] = new Zone(getTile(x, y), 10, 60, 0, 10, 80);
				}else if(x >= 5 && x < 10  && y >= 5 && y < 10) {
					zones[y][x] = new Zone(getTile(x, y), 50, 60, 2, 60, 50);
				}else if(x >= 10 && x < 15  && y >= 5 && y < 10) {
					zones[y][x] = new Zone(getTile(x, y), 60, 100, 3, 30, 100);
				}else if(x >= 15 && y >= 5 && y < 10) {
					zones[y][x] = new Zone(getTile(x, y), 140, 100, 1, 60, 100);
				}
				
				else if(x < 5 && y >= 10 && y < 15) {
					zones[y][x] = new Zone(getTile(x, y), 10, 60, 0, 10, 80);
				}else if(x >= 5 && x < 10  && y >= 10 && y < 15) {
					zones[y][x] = new Zone(getTile(x, y), 40, 90, 4, 100, 100);
				}else if(x >= 10 && x < 15  && y >= 10 && y < 15) {
					zones[y][x] = new Zone(getTile(x, y), 40, 100, 1, 10, 10);
				}else if(x >= 15 && y >= 10 && y < 15) {
					zones[y][x] = new Zone(getTile(x, y), 160, 50, 2, 20, 90);
				}
				
				else if(x < 5 && y >= 25) {
					zones[y][x] = new Zone(getTile(x, y), 10, 90, 1, 50, 20);
				}else if(x >= 5 && x < 10  && y >= 15) {
					zones[y][x] = new Zone(getTile(x, y), 210, 140, 4, 10, 50);
				}else if(x >= 10 && x < 15  && y >= 15) {
					zones[y][x] = new Zone(getTile(x, y), 230, 110, 2, 60, 10);
				}else if(x >= 15 && y >= 15) {
					zones[y][x] = new Zone(getTile(x, y), 280, 60, 0, 10, 10);
				}
				
				else {
					zones[y][x] = new Zone(getTile(x, y), 0, 0, 0, 0, 0);
				}
				
			}
		}
		
	}
	
	public Zone getZone(int x, int y) {
		return zones[y][x];
	}
	
	//Getters
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}


}
