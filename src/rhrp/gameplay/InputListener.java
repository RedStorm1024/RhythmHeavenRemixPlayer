package rhrp.gameplay;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import rhrp.main.Game;
import rhrp.main.Handler;
import rhrp.remix.Remix;

public class InputListener implements KeyListener {
	
	Handler handler;
	Remix remix;
	Game game;
	
	public InputListener(Handler handler) {
		this.handler = handler;
		this.game = handler.getGame();
		this.remix = handler.getGame().currentRemix;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		remix.inputs.addPrimaryInput(new Input(remix.getBeat(game.getTimePassed(), remix.data.getBPM())));
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}
