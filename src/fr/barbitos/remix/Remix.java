package fr.barbitos.remix;


import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.barbitos.main.Game;
import fr.barbitos.main.Handler;
import fr.barbitos.minigame.HoleInOneFever;
import fr.barbitos.minigame.*;
import fr.barbitos.remix.data.MinigameChange;
import fr.barbitos.remix.data.RemixData;
import fr.barbitos.render.Canvas;

public class Remix {
	
	private ObjectMapper mapper;
	private Handler handler;
	private Game game;
	
	public Minigame currentGame;
	public RemixData data;
	
	
	public Remix(ObjectMapper mapper, Handler handler) {
		this.mapper = mapper;
		this.handler = handler;
		this.game = handler.getGame();
		
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
		double beat = timePassed*data.getBPM()/60000;
		
		MinigameChange lastChange = null;
		for(MinigameChange change : data.getChanges()) {
			if(change.getBeat() > beat) {
				break;
			}
			lastChange = change;
		}
		
		if(!currentGame.getClass().toString().equals("class fr.barbitos.minigame." + lastChange.getMinigame().toString())) {
			try {
				this.currentGame = (Minigame)Class.forName("fr.barbitos.minigame." + data.getChanges()[0].getMinigame().toString()).getDeclaredConstructor(ObjectMapper.class, Handler.class).newInstance(mapper, handler);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		currentGame.draw(g2D, c, beat, data.getBPM(), data.getCues());
		g2D.drawString(String.valueOf(beat), 10, 10);
	}
	
	public void changeMinigame(Minigame.MinigameEnum minigame) {

	}
}
