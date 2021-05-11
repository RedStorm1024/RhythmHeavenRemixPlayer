package fr.barbitos.remix.data;

public class RemixData {
	
	private double bpm; //BPM change might be implemented later
	private Cue[] cues; //Every game's cue, pattern change etc.
	private MinigameChange[] changes; //Every time the minigame shown changes, cues from games other that the current game will still be processed but not visible/audible
	
	
	public double getBPM() {
		return bpm;
	}
	public void setBPM(double bpm) {
		this.bpm = bpm;
	}
	public Cue[] getCues() {
		return cues;
	}
	public void setCues(Cue[] cues) {
		this.cues = cues;
	}
	public MinigameChange[] getChanges() {
		return changes;
	}
	public void setChanges(MinigameChange[] changes) {
		this.changes = changes;
	}
}
