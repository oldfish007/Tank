package com.mashibing.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Tank {

	private int x,y;
	private Dir dir = Dir.DOWN;
	private static final int SPEED=10;
	private TFrame tf = null;
	//刚开始的时候moving是静止的 true才会移动
	private boolean moving = false;
	
	public static int width=ResourceMgr.tankD.getWidth();
	public static int height=ResourceMgr.tankD.getHeight();
	
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


	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		 switch (dir) {
			case LEFT:
				g.drawImage(ResourceMgr.tankL, x, y, null);
				break;
			case UP:
				g.drawImage(ResourceMgr.tankU, x, y, null);
				break;
			case DOWN:
				g.drawImage(ResourceMgr.tankD, x, y, null);
				break;
			case RIGTHT:
				g.drawImage(ResourceMgr.tankR, x, y, null);
				break;
			default:
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
		int bX = this.x+Tank.width/2-Bullet.width/2;
		int bY = this.y+Tank.height/2-Bullet.height/2;
		
		// 坦克的坐标 和 坦克的方向 
		tf.bullets.add(new Bullet(bX, bY, dir,this.tf));
		 
	}
	

}
