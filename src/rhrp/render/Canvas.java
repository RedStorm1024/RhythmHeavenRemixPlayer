package rhrp.render;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

import rhrp.main.Game;
import rhrp.main.Handler;

public class Canvas extends JComponent {
	
	private Handler handler;
	private Game game;
	
	private static final long serialVersionUID = 1L;

	public Canvas(Handler handler) {
		this.handler = handler;
		game = handler.getGame();
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		
		game.currentRemix.update(g2D, this);
	}	
}
