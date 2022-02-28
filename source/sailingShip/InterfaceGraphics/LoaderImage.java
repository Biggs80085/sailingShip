package sailingShip.InterfaceGraphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;



public class LoaderImage {

	public static BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(LoaderImage.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
}
