package fr.barbitos.remix.data;

import fr.barbitos.minigame.Minigame.MinigameEnum;

public class Cue {
	
	private MinigameEnum minigame; //What minigame the cue is from, variations of minigames (sequels and remix versions) count as different minigames
	private int cueType; //Cue type is defined by the minigame it's from, so a value can mean vastly different things between 2 minigames
	private double beat; //When the important part of the cue happens (input for games like hole in one, pattern change for keep the beat games, not sure for call and response)
						//what to do will be handled by the cue's minigame class
	

	public MinigameEnum getMinigame() {
		return minigame;
	}

	public void setMinigame(MinigameEnum minigame) {
		this.minigame = minigame;
	}

	public int getCueType() {
		return cueType;
	}

	public void setCueType(int cueType) {
		this.cueType = cueType;
	}

	public double getBeat() {
		return beat;
	}

	public void setBeat(double beat) {
		this.beat = beat;
	}
}
