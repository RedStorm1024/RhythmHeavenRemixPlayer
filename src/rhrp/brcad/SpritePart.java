package rhrp.brcad;

public class SpritePart {
	private int regionX, regionY, regionW, regionH;
	
	private int posX, posY;

	private float stretchX, stretchY;
	
	private float rotation;
    
	private boolean flipX, flipY;
    
	private byte opacity;

	public int getRegionX() {
		return regionX;
	}

	public void setRegionX(short regionX) {
		this.regionX = regionX;
	}

	public int getRegionY() {
		return regionY;
	}

	public void setRegionY(short regionY) {
		this.regionY = regionY;
	}

	public int getRegionW() {
		return regionW;
	}

	public void setRegionW(short regionW) {
		this.regionW = regionW;
	}

	public int getRegionH() {
		return regionH;
	}

	public void setRegionH(short regionH) {
		this.regionH = regionH;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(short posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(short posY) {
		this.posY = posY;
	}

	public float getStretchX() {
		return stretchX;
	}

	public void setStretchX(float stretchX) {
		this.stretchX = stretchX;
	}

	public float getStretchY() {
		return stretchY;
	}

	public void setStretchY(float stretchY) {
		this.stretchY = stretchY;
	}

	public float getRotation() {
		return rotation;
	}

	public void setRotation(float rotation) {
		this.rotation = rotation;
	}

	public boolean isFlipX() {
		return flipX;
	}

	public void setFlipX(boolean flipX) {
		this.flipX = flipX;
	}

	public boolean isFlipY() {
		return flipY;
	}

	public void setFlipY(boolean flipY) {
		this.flipY = flipY;
	}

	public byte getOpacity() {
		return opacity;
	}

	public void setOpacity(byte opacity) {
		this.opacity = opacity;
	}
}
