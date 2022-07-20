package com.mashibing.tank;

import java.awt.Graphics;

public class Tank {

	private int x,y;
	private Dir dir = Dir.DOWN;
	private static final int SPEED=10;
	//刚开始的时候moving是静止的 true才会移动
	private boolean moving = false;
	
	public boolean isMoving() {
		return moving;
	}


	public void setMoving(boolean moving) {
		this.moving = moving;
	}


	public Tank(int x, int y, Dir dir) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	
	
	public Dir getDir() {
		return dir;
	}


	public void setDir(Dir dir) {
		this.dir = dir;
	}


	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		
		g.fillRect(x, y, 50, 50);
		
		
		move();
	}


	private void move() {
		if(!moving) return;
		switch(dir) {
			case LEFT:
				x-=SPEED;
				break;
			case RIGTHT:
				x+=SPEED;
				break;
			case UP:
				y-=SPEED;
				break;
			case DOWN:
				y+=SPEED;
				break;
		}
	}
	

}
