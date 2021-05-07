package fr.barbitos.brcad;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import fr.barbitos.minigame.Minigame;

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
	
	public void drawStep(int animationFrame, BRCAD brcad, BufferedImage spriteSheet, Graphics2D g2D) {
		AnimationStep step = getStepToDraw(animationFrame % getFrameCount());
		if(step != null) {
			Minigame.drawSprite(brcad.getSprites()[step.getSpriteIndex()], spriteSheet, g2D);
		}
		
	}
	
}
