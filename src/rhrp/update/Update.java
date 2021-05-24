/**
 * 
 */
package rhrp.update;

import rhrp.main.Game;
import rhrp.main.Handler;

/**
 * @author valen
 *
 */
public class Update implements Runnable{
	
	private Handler handler;
	private Game game;
	
	
	public Update(Handler handler) {
		this.handler = handler;
		game = handler.getGame();
	}

	public void run() {
		while(game.running) {
			game.currentTime = System.currentTimeMillis();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
