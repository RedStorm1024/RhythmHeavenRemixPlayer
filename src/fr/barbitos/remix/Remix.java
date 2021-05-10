package fr.barbitos.remix;


import java.awt.Graphics2D;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.barbitos.main.Game;
import fr.barbitos.main.Handler;
import fr.barbitos.render.Canvas;

public class Remix {
	
	private ObjectMapper mapper;
	private Handler handler;
	private Game game;
	
	public Minigame currentGame;
	public double BPM;
	
	
	public Remix(ObjectMapper mapper, Handler handler) {
		this.mapper = mapper;
		this.handler = handler;
		this.game = handler.getGame();
		
		this.currentGame = new HoleInOne(mapper, handler);
		this.BPM = 150;
	}
	
	public void update(Graphics2D g2D, Canvas c, double timePassed) {
		double beat = timePassed*BPM/60000;
		currentGame.draw(g2D, c, beat, BPM);
		g2D.drawString(String.valueOf(beat), 10, 10);
	}
}
