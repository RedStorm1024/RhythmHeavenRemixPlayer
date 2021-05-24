package rhrp.brcad;

public class BRCAD {
	
	private short sheetW, sheetH;
	private Sprite[] sprites;
	private Animation[] animations;

	public short getSheetW() {
		return sheetW;
	}
	public void setSheetW(short sheetW) {
		this.sheetW = sheetW;
	}
	public short getSheetH() {
		return sheetH;
	}
	public void setSheetH(short sheetH) {
		this.sheetH = sheetH;
	}
	public Sprite[] getSprites() {
		return sprites;
	}
	public void setSprites(Sprite[] sprites) {
		this.sprites = sprites;
	}
	public Animation[] getAnimations() {
		return animations;
	}
	public void setAnimations(Animation[] animations) {
		this.animations = animations;
	}
}
