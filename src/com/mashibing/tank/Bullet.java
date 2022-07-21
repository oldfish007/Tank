package com.mashibing.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {

	private static final int SPEED=5;
	private int x,y;
	private static int width=20,height=20;
	private Dir dir;
	private boolean live = true;//子弹的生命
	TFrame tFrame = null;
	public Bullet(int x,int y,Dir dir,TFrame tf) {
		this.x  = x;
		this.y = y;
		this.dir=dir;
		this.tFrame = tf;
	}
	
	public void paint(Graphics g) {
		if(!live) {
			this.tFrame.bullets.remove(this);
		}
		
		Color color = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(x, y, width, height);
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
		
		if(x<0||y<0||x>TFrame.GAME_WIDTH||y>TFrame.GAME_HEIGHT) live =false;
	}
}
