package com.mashibing.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet {

	private static final int SPEED=5;
	private int x,y;
	public static int width=ResourceMgr.bulletD.getWidth();
	public static int height=ResourceMgr.bulletD.getHeight();
	private Dir dir;
	private boolean living = true;//子弹的生命
	TFrame tFrame = null;
	public Bullet(int x,int y,Dir dir,TFrame tf) {
		this.x  = x;
		this.y = y;
		this.dir=dir;
		this.tFrame = tf;
	}
	
	public void paint(Graphics g) {
		if(!living) {
			this.tFrame.bullets.remove(this);
		}
		
		/*
		 * Color color = g.getColor(); g.setColor(Color.RED); g.fillOval(x, y, width,
		 * height);
		 */
		switch (dir) {
		case LEFT:
			g.drawImage(ResourceMgr.bulletL, x, y, null);
			break;
		case UP:
			g.drawImage(ResourceMgr.bulletU, x, y, null);
			break;
		case DOWN:
			g.drawImage(ResourceMgr.bulletD, x, y, null);
			break;
		case RIGTHT:
			g.drawImage(ResourceMgr.bulletR, x, y, null);
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
		
		if(x<0||y<0||x>TFrame.GAME_WIDTH||y>TFrame.GAME_HEIGHT) living =false;
	}

	public void collideWith(Tank tank) {
		Rectangle rect1 = new Rectangle(this.x, this.y, width, height);
		Rectangle rect2 = new Rectangle(tank.getX(), tank.getY(), tank.width, tank.height);
		if(rect1.intersects(rect2)) {
			tank.die();
			this.die();
		}
		
	}

	private void die() {
		// TODO Auto-generated method stub
		this.living=false;
	}
}
