package fr.barbitos.render;

import java.awt.image.BufferedImage;

public class Image {
	public static BufferedImage crop(BufferedImage img, int x, int y, int w, int h) {
		return img.getSubimage(x, y, w, h);
	}

}
