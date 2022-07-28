package com.mashibing.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Wall extends GameObject{
	
	int width,height;
	public Rectangle rect;
	
	public Wall(int x,int y,int w, int h) {
		super();
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
		this.rect = new Rectangle(x,y,width, height);
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		Color color = g.getColor();
		g.setColor(Color.GREEN);
		g.fillRect(x, y, width, height);
		g.setColor(color);
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return height;
	}
	
	 
}
