package fr.barbitos.remix.data;

import fr.barbitos.remix.Minigame;

public class Cue {
	
	public Minigame.MinigameEnum minigame;
	public int cueType;
	public double beat;
	
	public Cue(Minigame.MinigameEnum minigame, int cueType, double beat) {
		this.minigame = minigame;
		this.cueType = cueType;
		this.beat = beat;
	}
}
