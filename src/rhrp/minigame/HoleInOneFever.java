package rhrp.minigame;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import rhrp.brcad.BRCAD;
import rhrp.main.Game;
import rhrp.main.Handler;
import rhrp.remix.data.Cue;
import rhrp.render.Canvas;

public class HoleInOneFever extends Minigame{

	//BG animation names
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

	//BG effect animation names
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

	//Monkey/Mandrill animation names
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

	//Golfman animation names
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

	private static enum MonkeyState{
		BEAT,
		BEAT_JUST,
		BEAT_MISS,
		BEAT_SAD,
		READY,
		PITCH,
		TURN
	};
	
	private static enum MandrillState{
		PITCH,
		BEAT,
		READY_S,
		READY_L,
		TURN
	};
	
	private static final int SCREEN_OFFSET_X = 90, SCREEN_OFFSET_Y = 280;
	private static final int CAMERA_WIDTH = 832, CAMERA_HEIGHT = 468;
	
	private Handler handler;
	private Game game;
	
	public BRCAD holeInOneBG, holeInOneBGE, holeInOneMonkey, holeInOneGolfman;
	public BufferedImage holeInOneBGSpriteSheet, holeInOneBGESpriteSheet, holeInOneMonkeySpriteSheet, holeInOneGolfmanSpriteSheet;
	
	public HoleInOneFever(ObjectMapper mapper, Handler handler) {
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
	
	public void draw(Graphics2D g2D, Canvas c, double beat, double BPM, Cue[] cues) {
		int frame = (int)game.getCurrentFrame();
		
		holeInOneBG.getAnimations()[GOLF_BG_BG_SKY].drawStep(frame, holeInOneBG, holeInOneBGSpriteSheet, g2D, c, SCREEN_OFFSET_X, SCREEN_OFFSET_Y, CAMERA_WIDTH, CAMERA_HEIGHT);
		holeInOneBG.getAnimations()[GOLF_BG_BG_CLOUD].drawStep(frame, holeInOneBG, holeInOneBGSpriteSheet, g2D, c, SCREEN_OFFSET_X, SCREEN_OFFSET_Y, CAMERA_WIDTH, CAMERA_HEIGHT);
		holeInOneBG.getAnimations()[GOLF_BG_BG_SEA].drawStep(frame, holeInOneBG, holeInOneBGSpriteSheet, g2D, c, SCREEN_OFFSET_X, SCREEN_OFFSET_Y, CAMERA_WIDTH, CAMERA_HEIGHT);
		holeInOneBG.getAnimations()[GOLF_BG_BG_ISLAND].drawStep(frame, holeInOneBG, holeInOneBGSpriteSheet, g2D, c, SCREEN_OFFSET_X, SCREEN_OFFSET_Y, CAMERA_WIDTH, CAMERA_HEIGHT, 0, -9);
		holeInOneBG.getAnimations()[GOLF_BG_BG_GROUND].drawStep(frame, holeInOneBG, holeInOneBGSpriteSheet, g2D, c, SCREEN_OFFSET_X, SCREEN_OFFSET_Y, CAMERA_WIDTH, CAMERA_HEIGHT);
		
		double timePassed = (beat/BPM)*60000;
		
		int golfmanAnimation = GOLFMAN_GOLFMAN_BEAT,
			zoomAnimation = -1;
		MonkeyState	monkeyAnimationState = MonkeyState.BEAT;
		MandrillState mandrillAnimationState = MandrillState.BEAT;
		double 	golfmanAnimationStartBeat = beat - beat%1,
				zoomAnimationStartBeat = beat - beat%1,
				monkeyAnimationStartBeat = beat - beat%1,
				mandrillAnimationStartBeat = beat - beat%1;
		
		for(Cue cue : cues) {//Golfman animation state
			double cueBeat = cue.getBeat();
			double beatDifference = beat - cueBeat;
			if(Math.floor(beatDifference) == -1) {
				golfmanAnimationStartBeat = cueBeat-1;
				if(golfmanAnimation == GOLFMAN_GOLFMAN_JUST) {
					golfmanAnimationStartBeat += getBeatsFromFrames(3, game.FPS, BPM);
				}
				golfmanAnimation = GOLFMAN_GOLFMAN_READY;
			}
			if(Math.floor(beatDifference + getBeatsFromFrames(7, game.FPS, BPM)) == 0) {
				golfmanAnimation = GOLFMAN_GOLFMAN_THROUGH;
				golfmanAnimationStartBeat = cueBeat - getBeatsFromFrames(7, game.FPS, BPM);
			}
			if(Math.floor(beatDifference) == 0) { //TODO change to reflect inputs when implemented
				golfmanAnimation = GOLFMAN_GOLFMAN_JUST;
				golfmanAnimationStartBeat = cueBeat;
				if(frame - game.getFrame((cueBeat/BPM)*60000) < 3) {
					break;
				}
			}
		}
		
		for(Cue cue : cues) {//Zoom animation state
			double cueBeat = cue.getBeat();
			double beatDifference = beat - cueBeat;
			if(beatDifference >= 2 && beatDifference <= 6) {
				zoomAnimationStartBeat = cueBeat+2;
				zoomAnimation = GOLF_BG_ZOOM_00;
			}
		}
		
		for(Cue cue : cues) {//Monkey animation state
			double cueBeat = cue.getBeat();
			double beatDifference = beat - cueBeat;
			if(Math.floor(beatDifference) == -2) {
				if(monkeyAnimationState != MonkeyState.PITCH) {
					monkeyAnimationStartBeat = cueBeat-2;
					monkeyAnimationState = MonkeyState.READY;
				}
			}else if(Math.floor(beatDifference) == -1) {
				monkeyAnimationStartBeat = cueBeat-1;
				monkeyAnimationState = MonkeyState.PITCH;
			}
		}
		

		
		
		int framesSinceGolfmanAnimationBeat = (int)(game.getFrame(timePassed) - getFramesFromBeats(golfmanAnimationStartBeat, game.FPS, BPM));
		holeInOneGolfman.getAnimations()[GOLFMAN_GOLFMAN_SHADOW].drawStep(0, holeInOneGolfman, holeInOneGolfmanSpriteSheet, g2D, c, SCREEN_OFFSET_X, SCREEN_OFFSET_Y, CAMERA_WIDTH, CAMERA_HEIGHT, 215, 160);
		holeInOneGolfman.getAnimations()[golfmanAnimation].drawStep(framesSinceGolfmanAnimationBeat, holeInOneGolfman, holeInOneGolfmanSpriteSheet, g2D, c, SCREEN_OFFSET_X, SCREEN_OFFSET_Y, CAMERA_WIDTH, CAMERA_HEIGHT, 215, 160);
		
		int framesSinceZoomAnimationBeat = (int)(game.getFrame(timePassed) - getFramesFromBeats(zoomAnimationStartBeat, game.FPS, BPM));
		if(zoomAnimation != -1) holeInOneBG.getAnimations()[zoomAnimation].drawStep(framesSinceZoomAnimationBeat, holeInOneBG, holeInOneBGSpriteSheet, g2D, c, SCREEN_OFFSET_X, SCREEN_OFFSET_Y, CAMERA_WIDTH, CAMERA_HEIGHT, 60, -10);	
		
		int framesSinceMonkeyAnimationBeat = (int)(game.getFrame(timePassed) - getFramesFromBeats(monkeyAnimationStartBeat, game.FPS, BPM));
		holeInOneMonkey.getAnimations()[GOLF_MONKEY_MONKEY_SHADOW].drawStep(framesSinceMonkeyAnimationBeat, holeInOneMonkey, holeInOneMonkeySpriteSheet, g2D, c, SCREEN_OFFSET_X, SCREEN_OFFSET_Y, CAMERA_WIDTH, CAMERA_HEIGHT, -20, 160);
		if(monkeyAnimationState == MonkeyState.READY) {
			holeInOneMonkey.getAnimations()[GOLF_MONKEY_MONKEY_READY_S].drawStep(framesSinceMonkeyAnimationBeat, holeInOneMonkey, holeInOneMonkeySpriteSheet, g2D, c, SCREEN_OFFSET_X, SCREEN_OFFSET_Y, CAMERA_WIDTH, CAMERA_HEIGHT, -20, 160);
		}else if (monkeyAnimationState == MonkeyState.PITCH) {
			holeInOneMonkey.getAnimations()[GOLF_MONKEY_MONKEY_PITCH].drawStep(framesSinceMonkeyAnimationBeat, holeInOneMonkey, holeInOneMonkeySpriteSheet, g2D, c, SCREEN_OFFSET_X, SCREEN_OFFSET_Y, CAMERA_WIDTH, CAMERA_HEIGHT, -20, 160);
		}else {
			holeInOneMonkey.getAnimations()[GOLF_MONKEY_MONKEY_BEAT].drawStep(framesSinceMonkeyAnimationBeat, holeInOneMonkey, holeInOneMonkeySpriteSheet, g2D, c, SCREEN_OFFSET_X, SCREEN_OFFSET_Y, CAMERA_WIDTH, CAMERA_HEIGHT, -20, 160);
			int test = holeInOneMonkey.getAnimations()[GOLF_MONKEY_MONKEY_BEAT].getStepToDraw(framesSinceMonkeyAnimationBeat).getSpriteIndex();
			int monkeyHeadOffsetY =  holeInOneMonkey.getSprites()[test].getParts()[0].getPosY() - 482;
			holeInOneMonkey.getAnimations()[GOLF_MONKEY_MONKEY_FACE_JUST].drawStep(-1, holeInOneMonkey, holeInOneMonkeySpriteSheet, g2D, c, SCREEN_OFFSET_X, SCREEN_OFFSET_Y, CAMERA_WIDTH, CAMERA_HEIGHT, -19, 133 + monkeyHeadOffsetY);
		}
		
		
		double cameraStretch = Math.min((double)c.getWidth()/(double)CAMERA_WIDTH, (double)c.getHeight()/(double)CAMERA_HEIGHT);
		
		g2D.fillRect(0, 0, (int)(c.getWidth() - CAMERA_WIDTH*cameraStretch)/2, c.getHeight());
		g2D.fillRect(c.getWidth() - (int)(c.getWidth() - CAMERA_WIDTH*cameraStretch)/2, 0, (int)(c.getWidth() - CAMERA_WIDTH*cameraStretch)/2, c.getHeight());
		g2D.fillRect(0, 0, c.getWidth(), (int)(c.getHeight() - CAMERA_HEIGHT*cameraStretch)/2);
		g2D.fillRect(0, c.getHeight() - (int)(c.getHeight() - CAMERA_HEIGHT*cameraStretch)/2, c.getWidth(), (int)(c.getHeight() - CAMERA_HEIGHT*cameraStretch)/2);
		
	}
}

