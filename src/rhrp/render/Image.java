package rhrp.render;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;

public class Image {
	public static BufferedImage crop(BufferedImage img, int x, int y, int w, int h) {
		return img.getSubimage(x, y, w, h);
	}
	
	public static BufferedImage rotate(BufferedImage img, float angle) {
		double rads = Math.toRadians(angle);
		double sin = Math.abs(Math.sin(rads));
		double cos = Math.abs(Math.cos(rads));
		double w = Math.floor(img.getWidth() * cos + img.getHeight() * sin);
		double h = Math.floor(img.getHeight() * cos + img.getWidth() * sin);
		BufferedImage rotatedImg = new BufferedImage((int)w, (int)h, img.getType());
		AffineTransform at = new AffineTransform();
		at.translate(w/2, h/2);
		at.rotate(rads,0, 0);
		at.translate(-img.getWidth()/2, -img.getHeight()/2);
		AffineTransformOp rotateOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
		rotateOp.filter(img,rotatedImg);
		return rotatedImg;
	}
	
	public static BufferedImage scale(BufferedImage img, float x, float y) {
		float w = x*img.getWidth();
		float h = y*img.getHeight();
		BufferedImage scaledImage = new BufferedImage((int)w, (int)h, img.getType());
		AffineTransform at = new AffineTransform();
		at.scale(x, y);
		AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
		scaledImage = scaleOp.filter(img, scaledImage);
		return scaledImage;
	}
	
	public static BufferedImage flipX(BufferedImage img) {
		BufferedImage scaledImage = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
		AffineTransform at = new AffineTransform();
		at.scale(-1, 1);
		at.translate(-img.getWidth(), 0);
		AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
		scaledImage = scaleOp.filter(img, scaledImage);
		return scaledImage;
	}
	
	public static BufferedImage flipY(BufferedImage img) {
		BufferedImage scaledImage = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
		AffineTransform at = new AffineTransform();
		at.scale(1, -1);
		at.translate(0, -img.getHeight());
		AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
		scaledImage = scaleOp.filter(img, scaledImage);
		return scaledImage;
	}

}
