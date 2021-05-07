package fr.barbitos.brcad;

import java.util.ArrayList;

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
	
}
