package fr.barbitos.minigame;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import fr.barbitos.brcad.Sprite;
import fr.barbitos.brcad.SpritePart;
import fr.barbitos.render.Image;

public abstract class Minigame {
	
	public Minigame() {}
	
	public void draw(Graphics2D g2D) {}
	
	public void drawSprite(Sprite s, BufferedImage spriteSheet, Graphics2D g2D) {
		for(SpritePart part: s.getParts()) {
			BufferedImage img = Image.crop(spriteSheet, part.getRegionX(), part.getRegionY(), part.getRegionW(), part.getRegionH());
			
			float angle = part.getRotation();
			
			img = Image.scale(img, part.getStretchX(), part.getStretchY());
			if(part.isFlipX()) img = Image.flipX(img);
			if(part.isFlipY()) img = Image.flipY(img);
			
			double oldWidth = img.getWidth();
			double oldHeight = img.getHeight();
			
			img = Image.rotate(img, angle);
			
			float alpha = (part.getOpacity() & 0xff) / 255f;
			
			AlphaComposite composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
			g2D.setComposite(composite);
	
			int drawX = (int)(part.getPosX() - img.getWidth()/2 + oldWidth/2);
			int drawY = (int)(part.getPosY() - img.getHeight()/2 + oldHeight/2);
			
			g2D.drawImage(img, drawX, drawY, null);
		}
	}
	
}
