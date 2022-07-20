package com.mashibing.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {

	private static final int SPEED=1;
	private int x,y;
	private static int width=20,height=20;
	private Dir dir;
	
	public Bullet(int x,int y,Dir dir) {
		this.x  = x;
		this.y = y;
		this.dir=dir;
	}
	
	public void paint(Graphics g) {
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
	}
}
