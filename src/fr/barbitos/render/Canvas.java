package fr.barbitos.render;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

import fr.barbitos.main.Game;
import fr.barbitos.main.Handler;

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

		
		game.currentGame.draw(g2D, this);
	}
}
