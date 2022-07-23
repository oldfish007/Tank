package com.mashibing.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Tank {

	private int x,y;
	private Dir dir = Dir.DOWN;
	private static final int SPEED=5;
	private TFrame tf = null;
	//刚开始的时候moving是静止的 true才会移动
	private boolean moving = false;
	public static final int WIDTH=ResourceMgr.goodTankL.getWidth();
	public static final int HEIGHT = ResourceMgr.goodTankL.getHeight();
	public boolean isMoving() {
		return moving;
	}


	public void setMoving(boolean moving) {
		this.moving = moving;
	}


	public Tank(int x, int y, Dir dir,TFrame tf) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
	}
	
	
	public Dir getDir() {
		return dir;
	}


	public void setDir(Dir dir) {
		this.dir = dir;
	}

/**
 * 根据坦克的方向确定tank移动的方向
 * @param g
 */
	public void paint(Graphics g) {
		
		//画出tank
		switch(dir) {
			case LEFT:
				g.drawImage(ResourceMgr.goodTankL, x, y, null);
				break;
			case UP:
				g.drawImage(ResourceMgr.goodTankU, x, y, null);
				break;
			case RIGTHT:
				g.drawImage(ResourceMgr.goodTankR, x, y, null);
				break;
			case DOWN:
				g.drawImage(ResourceMgr.goodTankD, x, y, null);
				break;
		}		
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

//按下control 实例化界面类的那个子弹
	public void fire() {
		// 坦克的坐标 和 坦克的方向 
		//从Tank的中心打出炮弹
		int bX = this.x+Tank.WIDTH/2-Bullet.WIDTH/2;
		int bY = this.y+Tank.HEIGHT/2-Bullet.HEIGHT/2;
		Bullet b = new Bullet(bX, bY, dir);
		tf.bullets.add(b);
	}
	

}
