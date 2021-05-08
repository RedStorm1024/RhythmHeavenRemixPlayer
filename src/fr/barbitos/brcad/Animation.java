package fr.barbitos.brcad;

import java.awt.AlphaComposite;
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
				g2D.translate(100, 100);
				BufferedImage img = Image.crop(spriteSheet, part.getRegionX(), part.getRegionY(), part.getRegionW(), part.getRegionH());
				g2D.drawImage(img, part.getPosX(), part.getPosY(), null);
		        g2D.setTransform(save);
			}
		}
		
	}
	
	public void drawStep(int animationFrame, BRCAD brcad, BufferedImage spriteSheet, Graphics2D g2D) {
		drawStep(animationFrame, brcad, spriteSheet, g2D, 0, 0);
	}
}
