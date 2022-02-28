package sailingShip.InterfaceGraphics;

import java.awt.image.BufferedImage;


public class Components {

	private static final int width = 64, height = 64;
	
	public static BufferedImage grass, limite, sea, iceberg, wave;
	public static BufferedImage trinquette, genois, sprinkler;
	
	public static void init() {
		
		CutImage picture = new CutImage(LoaderImage.loadImage("/texture/mapBoat.png"));
		
		trinquette = picture.crop(width * 2, height, width, height * 2);
		genois = picture.crop(width * 3, height, width, height * 2);
		sprinkler = picture.crop(width * 4, height, width, height * 2);
		
		limite = picture.crop(width * 3, 0, width, height);
		sea = picture.crop(0, 0, width, height);
		grass = picture.crop(width * 2, 0, width, height);
		iceberg = picture.crop(width * 4, 0, width, height);
		wave = picture.crop(width, 0, width, height);
		
	}
}
