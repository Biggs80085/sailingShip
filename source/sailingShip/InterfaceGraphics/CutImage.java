package sailingShip.InterfaceGraphics;

import java.awt.image.BufferedImage;

public class CutImage {

	private BufferedImage picture;
	
	public CutImage(BufferedImage picture) {
		this.picture = picture;
	}
	
	public BufferedImage crop(int x, int y, int width, int height) {
		 return picture.getSubimage(x, y, width, height);
	}
	
}
