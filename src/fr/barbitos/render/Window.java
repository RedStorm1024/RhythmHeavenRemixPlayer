package fr.barbitos.render;

import java.awt.event.WindowAdapter;

import javax.swing.JFrame;

import fr.barbitos.main.Game;
import fr.barbitos.main.Handler;

public class Window implements Runnable {
	
	JFrame frame;
	Canvas canvas;
	Handler handler;
	Game game;
	
	public Window(Handler handler) {
		this.handler = handler;
		game = handler.getGame();
	}
	
	public void init() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		canvas = new Canvas(handler);
		frame.setVisible(true);
		frame.add(canvas);
		frame.setSize(1000, 1000);
	}

	public void run(){
		init();
		while(game.running) {
			frame.repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
