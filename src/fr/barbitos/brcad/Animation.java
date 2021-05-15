package fr.barbitos.brcad;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import fr.barbitos.render.Canvas;
import fr.barbitos.render.Image;

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
	
	public void drawStep(int animationFrame, BRCAD brcad, BufferedImage spriteSheet, Graphics2D g2D, Canvas c, int cameraOffsetX, int cameraOffsetY, int cameraWidth, int cameraHeight, int x, int y) {
		if(animationFrame == -1 || animationFrame >= getFrameCount()) animationFrame = getFrameCount() - 1;
		AnimationStep step = getStepToDraw(animationFrame % getFrameCount());
		if(step != null) {
			Sprite s = brcad.getSprites()[step.getSpriteIndex()];
			for (SpritePart part : s.getParts()) {
				AffineTransform save = g2D.getTransform();
				
				double cameraStretch = Math.min((double)c.getWidth()/(double)cameraWidth, (double)c.getHeight()/(double)cameraHeight);
				
				g2D.translate((c.getWidth() - cameraWidth*cameraStretch)/2, (c.getHeight() - cameraHeight*cameraStretch)/2);
				g2D.translate(-cameraOffsetX * cameraStretch, -cameraOffsetY * cameraStretch);
				g2D.translate(part.getPosX() * cameraStretch, part.getPosY() * cameraStretch);
				g2D.translate(x * cameraStretch, y * cameraStretch);
				
				
				g2D.scale(cameraStretch, cameraStretch);
				g2D.translate(part.getRegionW()*part.getStretchX()/2, part.getRegionH()*part.getStretchY()/2);
				g2D.rotate(Math.toRadians(part.getRotation()));

				if(part.isFlipX()) g2D.scale(-1, 1);
				if(part.isFlipY()) g2D.scale(1, -1);
				
				g2D.translate(-part.getRegionW()*part.getStretchX()/2, -part.getRegionH()*part.getStretchY()/2);
				
				g2D.scale(part.getStretchX(), part.getStretchY());
				
				float alpha = (part.getOpacity() & 0xff) / 255f;
				alpha *= (step.getOpacity() & 0xff) / 255f;
				
				AlphaComposite composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
				g2D.setComposite(composite);
				
				
				BufferedImage img = Image.crop(spriteSheet, part.getRegionX(), part.getRegionY(), part.getRegionW(), part.getRegionH());
				g2D.drawImage(img, 0, 0, null);
				
				g2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
				
				//g2D.setColor(Color.RED);
				//g2D.drawRect(0, 0, part.getRegionW(), part.getRegionH());
				//g2D.setColor(Color.BLACK);
				
				g2D.setTransform(save);
			}
		}
		
	}
	
	public void drawStep(int animationFrame, BRCAD brcad, BufferedImage spriteSheet, Graphics2D g2D, Canvas c, int cameraOffsetX, int cameraOffsetY, int cameraWidth, int cameraHeight) {
		drawStep(animationFrame, brcad, spriteSheet, g2D, c, cameraOffsetX, cameraOffsetY, cameraWidth, cameraHeight, 0, 0);
	}
}
