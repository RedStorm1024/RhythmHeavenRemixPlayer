package fr.barbitos.minigame;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.barbitos.brcad.Animation;
import fr.barbitos.brcad.AnimationStep;
import fr.barbitos.brcad.BRCAD;
import fr.barbitos.main.Game;
import fr.barbitos.main.Handler;

public class HoleInOne extends Minigame{
	
	private Handler handler;
	private Game game;
	
	public BRCAD holeInOneBG, holeInOneBGE, holeInOneMonkey, holeInOneGolfman;
	public BufferedImage holeInOneBGSpriteSheet, holeInOneBGESpriteSheet, holeInOneMonkeySpriteSheet, holeInOneGolfmanSpriteSheet;
	
	public HoleInOne(ObjectMapper mapper, Handler handler) {
		this.handler = handler;
		this.game = handler.getGame();
		try {
			holeInOneBGSpriteSheet = ImageIO.read(new File("Games/HoleInOne/Sprites/golf_bg.png"));
			holeInOneBGESpriteSheet = ImageIO.read(new File("Games/HoleInOne/Sprites/golf_bg_effect.png"));
			holeInOneMonkeySpriteSheet = ImageIO.read(new File("Games/HoleInOne/Sprites/golf_monkey.png"));
			holeInOneGolfmanSpriteSheet = ImageIO.read(new File("Games/HoleInOne/Sprites/golf_golfman.png"));
		}catch (IOException e) {
			e.printStackTrace();
		}
		try {
			holeInOneBG = mapper.readValue(new File("Games/HoleInOne/Sprites/golf_bg.json"), BRCAD.class);
			holeInOneBGE = mapper.readValue(new File("Games/HoleInOne/Sprites/golf_bg_effect.json"), BRCAD.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void draw(Graphics2D g2D) {
		for(int i = 0; i <= 7; i++) {
			Animation anim = holeInOneBG.getAnimations()[i];

			int frame = game.getCurrentFrame();
			AnimationStep step = anim.getStepToDraw(frame % anim.getFrameCount());
			if(step != null) {
				drawSprite(holeInOneBG.getSprites()[step.getSpriteIndex()], holeInOneBGSpriteSheet, g2D);
			}
		}
	/*drawSprite(game.holeInOneBG.getSprites()[4], g2D);
	drawSprite(game.holeInOneBG.getSprites()[5], g2D);
	drawSprite(game.holeInOneBG.getSprites()[11], g2D);
	drawSprite(game.holeInOneBG.getSprites()[13], g2D);
	drawSprite(game.holeInOneBG.getSprites()[20], g2D);
	drawSprite(game.holeInOneBG.getSprites()[115], g2D);
	*/
	}
}

