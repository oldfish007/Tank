package com.mashibing.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {

	private static final int SPEED=8;
	private int x,y;
	public static final int WIDTH=ResourceMgr.bulletD.getWidth();
	public static final int HEIGHT=ResourceMgr.bulletD.getHeight();
	private Dir dir;
	private boolean moving=false;
	private boolean living=true;
	public Bullet(int x,int y,Dir dir) {
		this.x  = x;
		this.y = y;
		this.dir=dir;
	}
//根据主战坦克的方向区分	
	public void paint(Graphics g) {
	
		switch (dir) {
		case LEFT:
			g.drawImage(ResourceMgr.bulletL, x, y, null);
			break;
		case UP:
			g.drawImage(ResourceMgr.bulletU, x, y, null);
			break;
		case RIGTHT:
			g.drawImage(ResourceMgr.bulletR, x, y, null);
			break;
		case DOWN:
			g.drawImage(ResourceMgr.bulletD, x, y, null);
			break;
		default:
			break;
		}
		move();
	}

	private void move() {
		// TODO Auto-generated method stub
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
