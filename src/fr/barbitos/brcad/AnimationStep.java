package fr.barbitos.brcad;

public class AnimationStep {
	private short delay, spriteIndex;

    private float stretchX, stretchY;
    
    private float rotation;
    
    private byte opacity;

	public short getDelay() {
		return delay;
	}

	public void setDelay(short delay) {
		this.delay = delay;
	}

	public short getSpriteIndex() {
		return spriteIndex;
	}

	public void setSpriteIndex(short spriteIndex) {
		this.spriteIndex = spriteIndex;
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

	public byte getOpacity() {
		return opacity;
	}

	public void setOpacity(byte opacity) {
		this.opacity = opacity;
	}
}
