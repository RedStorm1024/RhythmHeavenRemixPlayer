package fr.barbitos.main;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.barbitos.minigame.HoleInOne;
import fr.barbitos.minigame.Minigame;
import fr.barbitos.render.Window;
import fr.barbitos.update.Update;

public class Game{
	
	public Handler handler;
	public long currentTime, timeAtStart;
	private int currentFrame;
	public boolean running;
	public Update update;
	public Window window;
	
	public Minigame currentGame;

	
	public Game() {
		currentTime = 0;
		setCurrentFrame(0);
		running = true;
		timeAtStart = System.currentTimeMillis();
		handler = new Handler(this);
		update = new Update(handler);
		window = new Window(handler);
		
		ObjectMapper mapper = new ObjectMapper();
		
		currentGame = new HoleInOne(mapper, handler);
		
		new Thread(update).start();
		new Thread(window).start();
	}


	public int getCurrentFrame() {
		return currentFrame;
	}


	public void setCurrentFrame(int currentFrame) {
		this.currentFrame = currentFrame;
	}

}
