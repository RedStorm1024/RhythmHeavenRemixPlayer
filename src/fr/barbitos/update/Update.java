/**
 * 
 */
package fr.barbitos.update;

import fr.barbitos.main.Game;
import fr.barbitos.main.Handler;

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
			game.setCurrentFrame((int)(game.currentTime - game.timeAtStart)/33);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
