package rhrp.gameplay;

import java.util.ArrayList;

public class RemixInputs {
	
	private ArrayList<Input> primaryInputs, secondaryInputs; //Every input, if added in the base remix file they will be played back

	public RemixInputs() {
		this.primaryInputs = new ArrayList<Input>();
		this.secondaryInputs = new ArrayList<Input>();
	}
	
	public ArrayList<Input> getPrimaryInputs() {
		return primaryInputs;
	}
	public void setPrimaryInputs(ArrayList<Input> primaryInputs) {
		this.primaryInputs = primaryInputs;
	}
	public ArrayList<Input> getSecondaryInputs() {
		return secondaryInputs;
	}
	public void setSecondaryInputs(ArrayList<Input> secondaryInputs) {
		this.secondaryInputs = secondaryInputs;
	}
	public void addPrimaryInput(Input input) {
		this.primaryInputs.add(input);
	}
	public void addSecondaryInput(Input input) {
		this.secondaryInputs.add(input);
	}
}
