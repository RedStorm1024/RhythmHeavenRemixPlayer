package fr.barbitos.brcad;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import fr.barbitos.minigame.Minigame;
import fr.barbitos.render.Image;
import javafx.scene.transform.Affine;

public class Animation {
	private AnimationStep[] steps;

	public AnimationStep[] getSteps() {
		return steps;
	}

	public void setSteps(AnimationStep[] steps) {
		this.steps = steps;
	}
	
	public AnimationStep getStepToDraw(int animationFrame) {
		int x = 0;
		for(AnimationStep step: steps) {
			x += step.getDelay();
			if(x >= animationFrame) return step;
		}
		return null;
	}
	
	public int getFrameCount() {
		int x = 0;
		for(AnimationStep step: steps) {
			x += step.getDelay();
		}
		return x;
	}
	
	public void drawStep(int animationFrame, BRCAD brcad, BufferedImage spriteSheet, Graphics2D g2D, int x, int y) {
		AnimationStep step = getStepToDraw(animationFrame % getFrameCount());
		if(step != null) {
			Sprite s = brcad.getSprites()[step.getSpriteIndex()];
			for (SpritePart part : s.getParts()) {
				AffineTransform save = g2D.getTransform();
				
				g2D.translate(part.getPosX(), part.getPosY());
				
				g2D.translate(part.getRegionW()*part.getStretchX()/2, part.getRegionH()*part.getStretchY()/2);
				g2D.rotate(Math.toRadians(part.getRotation()));

				if(part.isFlipX()) g2D.scale(-1, 1);
				if(part.isFlipY()) g2D.scale(1, -1);
				g2D.translate(-part.getRegionW()*part.getStretchX()/2, -part.getRegionH()*part.getStretchY()/2);
				
				g2D.scale(part.getStretchX(), part.getStretchY());
				
				float alpha = (part.getOpacity() & 0xff) / 255f;
				
				AlphaComposite composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
				g2D.setComposite(composite);
				
				
				BufferedImage img = Image.crop(spriteSheet, part.getRegionX(), part.getRegionY(), part.getRegionW(), part.getRegionH());
				g2D.drawImage(img, 0, 0, null);
				
				/*g2D.scale(1/part.getStretchX(), 1/part.getStretchY());
				g2D.translate(part.getRegionW()*part.getStretchX()/2, part.getRegionH()*part.getStretchY()/2);
				g2D.drawLine(-10, 0, 10, 0);
				g2D.drawLine(0, -10, 0, 10);
		        draw crosses at the middle of the sprites*/
				
				g2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
				g2D.setTransform(save);
			}
		}
		
	}
	
	public void drawStep(int animationFrame, BRCAD brcad, BufferedImage spriteSheet, Graphics2D g2D) {
		drawStep(animationFrame, brcad, spriteSheet, g2D, 0, 0);
	}
}
