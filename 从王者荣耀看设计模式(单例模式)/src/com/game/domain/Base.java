package com.game.domain;

public class Base {
	private Base() {}
	private static Base base=null;
	
	public synchronized static Base getBase() {
		if(base == null) {
			base = new Base();
		}
		return base;
	}
	
	private int life = 999;
	private boolean destroy = false;

	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public boolean isDestroy() {
		return destroy;
	}
	public void setDestroy(boolean destroy) {
		this.destroy = destroy;
	}
}
