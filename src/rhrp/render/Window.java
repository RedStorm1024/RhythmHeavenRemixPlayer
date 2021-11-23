package rhrp.render;

import java.awt.Frame;
import java.awt.event.WindowAdapter;

import javax.swing.JFrame;

import rhrp.gameplay.InputListener;
import rhrp.main.Game;
import rhrp.main.Handler;

public class Window implements Runnable {
	
	private JFrame frame;
	private Canvas canvas;
	private Handler handler;
	private Game game;
	
	public Window(Handler handler) {
		this.handler = handler;
		game = handler.getGame();
	}
	
	public void init() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		canvas = new Canvas(handler);
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.add(canvas);
		frame.addKeyListener(new InputListener(handler));
	}

	public void run(){
		init();
		while(game.running) {
			try {
				frame.repaint();
			}catch(NullPointerException e) {
				System.out.println("aaaa");
			}
			try {
				Thread.sleep(16);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public JFrame getFrame() {
		return frame;
	}

	public Canvas getCanvas() {
		return canvas;
	}

}
