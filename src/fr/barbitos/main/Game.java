package fr.barbitos.main;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.barbitos.remix.Remix;
import fr.barbitos.render.Window;
import fr.barbitos.update.Update;

public class Game{
	
	public Handler handler;
	public long currentTime, timeAtStart;
	public boolean running;
	public Update update;
	public Window window;
	
	public Remix currentRemix;

	
	public Game() {
		currentTime = 0;
		running = true;
		timeAtStart = System.currentTimeMillis();
		handler = new Handler(this);
		update = new Update(handler);
		window = new Window(handler);
		
		ObjectMapper mapper = new ObjectMapper();
		
		currentRemix = new Remix(mapper, handler);
		
		new Thread(update).start();
		new Thread(window).start();
	}


	public double getFrame(double timePassed) {
		return (30*(timePassed)/1000);
	}
	
	public double getCurrentFrame() {
		return getFrame(currentTime-timeAtStart);
	}
	
	public double getTimePassed() {
		return (currentTime-timeAtStart);
	}



}
