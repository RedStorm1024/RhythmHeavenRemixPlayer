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
import fr.barbitos.brcad.BRCAD;
import fr.barbitos.brcad.Sprite;
import fr.barbitos.main.Game;
import fr.barbitos.main.Handler;

public class HoleInOne extends Minigame{

	@SuppressWarnings("unused")
	private static final int 
	GOLF_BG_BG_SKY = 0, 
	GOLF_BG_BG_CLOUD = 1, 
	GOLF_BG_BG_AIRPLANE = 2, 
	GOLF_BG_BG_BIRD = 3, 
	GOLF_BG_BG_SEA_GULL = 4, 
	GOLF_BG_BG_SEA = 5, 
	GOLF_BG_BG_ISLAND = 6, 
	GOLF_BG_BG_GROUND = 7, 
	GOLF_BG_BALL = 8, 
	GOLF_BG_LEAF_00 = 9, 
	GOLF_BG_LEAF_01 = 10, 
	GOLF_BG_LEAF_02 = 11, 
	GOLF_BG_BALL_S_OK = 12, 
	GOLF_BG_BALL_L_OK = 13, 
	GOLF_BG_BALL_S_THROUGH = 14, 
	GOLF_BG_BALL_L_THROUGH = 15, 
	GOLF_BG_ZOOM_00 = 16, 
	GOLF_BG_ZOOM_01 = 17, 
	GOLF_BG_ZOOM_02 = 18, 
	GOLF_BG_ZOOM_03 = 19, 
	GOLF_BG_ZOOM_04 = 20, 
	GOLF_BG_WHALE_WAIT = 21, 
	GOLF_BG_WHALE_OK = 22, 
	GOLF_BG_WHALE_HIDE = 23, 
	GOLF_BG_SPLASH_00 = 24, 
	GOLF_BG_SPLASH_01 = 25, 
	GOLF_BG_SPLASH_02 = 26, 
	GOLF_BG_TEST_00 = 27;	
	
	
	@SuppressWarnings("unused")
	private static final int
	GOLF_BG_EFFECT_SPLASH_SHOW = 0,
	GOLF_BG_EFFECT_SPLASH_HIDE = 1,
	GOLF_BG_EFFECT_SPLASH_LOOP = 2,
	GOLF_BG_EFFECT_RIPPLE = 3,
	GOLF_BG_EFFECT_BALL = 4,
	GOLF_BG_EFFECT_RAINBOW = 5,
	GOLF_BG_EFFECT_CELLANIM0 = 6,
	GOLF_BG_EFFECT_CELLANIM1 = 7,
	GOLF_BG_EFFECT_CELLANIM2 = 8;

	@SuppressWarnings("unused")
	private static final int
	GOLF_MONKEY_MONKEY_BEAT = 0,
	GOLF_MONKEY_MONKEY_WAIT = 1,
	GOLF_MONKEY_MONKEY_READY_S = 2,
	GOLF_MONKEY_MONKEY_READY_L = 3,
	GOLF_MONKEY_MONKEY_PITCH = 4,
	GOLF_MONKEY_MONKEY_TURN = 5,
	GOLF_MONKEY_MONKEY_INST_WAIT = 6,
	GOLF_MONKEY_MONKEY_INST_TALK = 7,
	GOLF_MONKEY_MONKEY_INST_BLINK = 8,
	GOLF_MONKEY_MONKEY_INST_LETS = 9,
	GOLF_MONKEY_MONKEY_INST_SORRY = 10,
	GOLF_MONKEY_MONKEY_INST_OSII = 11,
	GOLF_MONKEY_MONKEY_INST_DODO = 12,
	GOLF_MONKEY_MONKEY_INST_GOOD = 13,
	GOLF_MONKEY_MONKEY_INST_UHOUHO = 14,
	GOLF_MONKEY_MONKEY_EFFECT = 15,
	GOLF_MONKEY_MONKEY_SHADOW = 16,
	GOLF_MONKEY_MONKEY_FACE_JUST = 17,
	GOLF_MONKEY_MONKEY_FACE_MISS = 18,
	GOLF_MONKEY_MONKEY_FACE_SAD = 19,
	GOLF_MONKEY_MONKEY_FACE_TALK = 20,
	GOLF_MONKEY_GORILLA_BEAT_0 = 21,
	GOLF_MONKEY_GORILLA_BEAT_1 = 22,
	GOLF_MONKEY_GORILLA_BEAT_2 = 23,
	GOLF_MONKEY_GORILLA_READY_00 = 24,
	GOLF_MONKEY_GORILLA_READY_01 = 25,
	GOLF_MONKEY_GORILLA_READY_02 = 26,
	GOLF_MONKEY_GORILLA_PITCH = 27,
	GOLF_MONKEY_GORILLA_INST_TALK = 28,
	GOLF_MONKEY_GORILLA_INST_UHOUHO = 29,
	GOLF_MONKEY_GORILLA_INST_SORRY = 30,
	GOLF_MONKEY_GORILLA_SHADOW = 31,
	GOLF_MONKEY_BALL_S = 32,
	GOLF_MONKEY_BALL_L = 33,
	GOLF_MONKEY_BALL_SPIN_S = 34,
	GOLF_MONKEY_BALL_SPIN_L = 35,
	GOLF_MONKEY_BALL_SHADOW_S = 36,
	GOLF_MONKEY_BALL_SHADOW_L = 37,
	GOLF_MONKEY__MONKEY_FACE_HAPPY_00 = 38,
	GOLF_MONKEY__MONKEY_FACE_HAPPY_01 = 39,
	GOLF_MONKEY__MONKEY_INST_GOOD = 40;
	
	@SuppressWarnings("unused")
	private static final int 
	GOLFMAN_GOLFMAN_READY = 0,
	GOLFMAN_GOLFMAN_BEAT = 1,
	GOLFMAN_GOLFMAN_JUST = 2,
	GOLFMAN_GOLFMAN_MISS = 3,
	GOLFMAN_GOLFMAN_THROUGH = 4,
	GOLFMAN_GOLFMAN_THROUGH_GORILLA = 5,
	GOLFMAN_GOLFMAN_OUT = 6,
	GOLFMAN_GOLFMAN_WAIT = 7,
	GOLFMAN_GOLFMAN_LOOK = 8,
	GOLFMAN_GOLFMAN_GREET = 9,
	GOLFMAN_GOLFMAN_SHADOW = 10,
	GOLFMAN_GOLFMAN_TEST1 = 11,
	GOLFMAN_GOLFMAN_TEST2 = 12,
	GOLFMAN_GOLFMAN_TEST3 = 13;	

	private static final int SCREEN_OFFSET_X = 95, SCREEN_OFFSET_Y = 282;
	private static final int SCREEN_WIDTH = 836, SCREEN_HEIGHT = 454;
	
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
			holeInOneMonkey = mapper.readValue(new File("Games/HoleInOne/Sprites/golf_monkey.json"), BRCAD.class);
			holeInOneGolfman = mapper.readValue(new File("Games/HoleInOne/Sprites/golf_golfman.json"), BRCAD.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void draw(Graphics2D g2D) {
		int frame = game.getCurrentFrame();
		
		holeInOneBG.getAnimations()[GOLF_BG_BG_SKY].drawStep(frame, holeInOneBG, holeInOneBGSpriteSheet, g2D, frame, 0);
		//holeInOneBG.getAnimations()[GOLF_BG_BG_CLOUD].drawStep(frame, holeInOneBG, holeInOneBGSpriteSheet, g2D);
		//holeInOneBG.getAnimations()[GOLF_BG_BG_AIRPLANE].drawStep(frame, holeInOneBG, holeInOneBGSpriteSheet, g2D);
		//holeInOneBG.getAnimations()[GOLF_BG_BG_BIRD].drawStep(frame, holeInOneBG, holeInOneBGSpriteSheet, g2D);
		//holeInOneBG.getAnimations()[GOLF_BG_BG_SEA].drawStep(frame, holeInOneBG, holeInOneBGSpriteSheet, g2D, frame, 0);
		//holeInOneBG.getAnimations()[GOLF_BG_BG_ISLAND].drawStep(frame, holeInOneBG, holeInOneBGSpriteSheet, g2D);
		//holeInOneBG.getAnimations()[GOLF_BG_BG_GROUND].drawStep(frame, holeInOneBG, holeInOneBGSpriteSheet, g2D);
		
		/*Animation anim = holeInOneMonkey.getAnimations()[GOLF_MONKEY_MONKEY_BEAT];
		Sprite sprite = holeInOneMonkey.getSprites()[anim.getStepToDraw(frame % anim.getFrameCount()).getSpriteIndex()];
		int offset = sprite.getParts()[0].getPosY() - 482;*/
		

		/*holeInOneMonkey.getAnimations()[GOLF_MONKEY_MONKEY_SHADOW].drawStep(frame, holeInOneMonkey, holeInOneMonkeySpriteSheet, g2D, SCREEN_OFFSET_X, SCREEN_OFFSET_Y);
		holeInOneMonkey.getAnimations()[GOLF_MONKEY_MONKEY_BEAT].drawStep(frame, holeInOneMonkey, holeInOneMonkeySpriteSheet, g2D);
		holeInOneMonkey.getAnimations()[GOLF_MONKEY_MONKEY_FACE_JUST].drawStep(frame, holeInOneMonkey, holeInOneMonkeySpriteSheet, g2D);
		*/
	}
}

