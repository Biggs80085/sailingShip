package Zoned;

import sailingShip.tiles.Tile;

public class Zone {

	private Tile tile;
	private float current;
	private float wind;
	private float wave;
	private float speedWind;
	private float speedCurrent;
	
	public Zone(Tile tile, float current, float wind, float wave, float speedCurrent ,float speedWind) {
		this.tile = tile;
		this.current = current;
		this.wind = wind;
		this.wave = wave;
		this.speedCurrent = speedCurrent;
		this.speedWind = speedWind;
		
	}

	public Tile getTile() {
		return tile;
	}

	public void setTile(Tile tile) {
		this.tile = tile;
	}

	public float getCurrent() {
		return current;
	}

	public void setCurrent(float current) {
		this.current = current;
	}

	public float getWind() {
		return wind;
	}

	public void setWind(float wind) {
		this.wind = wind;
	}
	public float getWave() {
		return wave;
	}
	public void setWave(float wave) {
		this.wave = wave;
	}
	
	public void setSpeedCurrent(float speedCurrent) {
		this.speedCurrent = speedCurrent;
	}
	public float getSpeedCurrent() {
		return speedCurrent;
	}

	public void setSpeedWind(float speedWind) {
		this.speedWind = speedWind;
	}public float getSpeedWind() {
		return speedWind;
	}

	
	
	
	
}
