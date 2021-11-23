package rhrp.remix;


import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import rhrp.gameplay.RemixInputs;
import rhrp.main.Game;
import rhrp.main.Handler;
import rhrp.minigame.*;
import rhrp.remix.data.MinigameChange;
import rhrp.remix.data.RemixData;
import rhrp.render.Canvas;

public class Remix {
	
	private ObjectMapper mapper;
	private Handler handler;
	private Game game;
	
	public Minigame currentGame;
	public RemixData data;
	public RemixInputs inputs;
	
	//INPUT/CUES:
	/* Each cue gets divided into every input the cue contains (for example the go-go-go from figure fighter gets divided into 3, might add decorative cues without any input related to them)
	 * For each subcue, they'll have a timing related to it and variables telling if the cue has been satisfied and which input satisfied it + methods to know how good the timing was (barely, miss, perfect...)
	 * Whenever a new input happens, it checks for every subcue if it is already satisfied and if it hasn't been, if the input is in the timing of the subcue
	 * Store information in the input variable about which subcue it satisfied, if it did
	 * Most likely, every visuals will care either about:
	 * -The last subcue (monkey preparing to throw a golfball)
	 * -The last input (golfman trying to hit a golfball)
	 * -Every subcue in a certain time range around current beat (the golfballs flying)
	 * -Every input in a certain time range before the current beat (imagine you are the monkey in hole in one and every input throws a golfball, the golfballs would )*/
	
	public Remix(ObjectMapper mapper, Handler handler) {
		this.mapper = mapper;
		this.handler = handler;
		this.game = handler.getGame();
		this.inputs = new RemixInputs();
		this.currentGame = new HoleInOneFever(mapper, handler);
		try {
			this.data = mapper.readValue(new File("Remix/testRemix.json"), RemixData.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	public void update(Graphics2D g2D, Canvas c) {
		double timePassed = game.getTimePassed();
		double beat = getBeat(timePassed, data.getBPM());
		
		MinigameChange lastChange = null;
		for(MinigameChange change : data.getChanges()) {
			if(change.getBeat() > beat) {
				break;
			}
			lastChange = change;
		}
		
		if(!currentGame.getClass().toString().equals("class rhrp.minigame." + lastChange.getMinigame().toString())) {
			try {
				this.currentGame = (Minigame)Class.forName("rhrp.minigame." + data.getChanges()[0].getMinigame().toString()).getDeclaredConstructor(ObjectMapper.class, Handler.class).newInstance(mapper, handler);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		currentGame.draw(g2D, c, beat, data.getBPM(), data.getCues());
		g2D.drawString(String.valueOf(beat), 10, 10);
		int inputSize = inputs.getPrimaryInputs().size();
		g2D.drawString(String.valueOf(inputSize), 10, 20);
		if(inputSize > 0) {
			g2D.drawString(String.valueOf(inputs.getPrimaryInputs().get(inputSize-1).beat), 10, 30);
		}
	}
	
	public void changeMinigame(Minigame.MinigameEnum minigame) {

	}
	
	public double getBeat(double timePassed, double BPM) {
		return timePassed*BPM/60000;
	}
}
