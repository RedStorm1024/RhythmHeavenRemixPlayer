package rhrp.main;

import com.fasterxml.jackson.databind.ObjectMapper;

import rhrp.gameplay.InputListener;
import rhrp.remix.Remix;
import rhrp.render.Window;
import rhrp.update.Update;

public class Game{
	
	public Handler handler;
	public long currentTime, timeAtStart;
	public boolean running;
	public Update update;
	public Window window;
	
	public Remix currentRemix;
	public double FPS;
	
	public Game() {
		currentTime = 0;
		running = true;
		timeAtStart = System.currentTimeMillis();
		handler = new Handler(this);
		update = new Update(handler);
		window = new Window(handler);
		

		
		FPS = 60;
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		currentRemix = new Remix(mapper, handler);
		
		new Thread(update).start();
		new Thread(window).start();
	}


	public double getFrame(double timePassed) {
		return (FPS*(timePassed)/1000);
	}
	
	public double getCurrentFrame() {
		return getFrame(currentTime-timeAtStart);
	}
	
	public double getTimePassed() {
		return (currentTime-timeAtStart);
	}



}