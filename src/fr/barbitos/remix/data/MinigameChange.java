package fr.barbitos.remix.data;

import fr.barbitos.minigame.Minigame.MinigameEnum;

public class MinigameChange {
	private MinigameEnum minigame; 
	private double beat;
	
	public MinigameEnum getMinigame() {
		return minigame;
	}

	public void setMinigame(MinigameEnum minigame) {
		this.minigame = minigame;
	}

	public double getBeat() {
		return beat;
	}

	public void setBeat(double beat) {
		this.beat = beat;
	}

}
