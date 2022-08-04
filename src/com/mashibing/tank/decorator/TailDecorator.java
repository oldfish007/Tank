package com.mashibing.tank.decorator;

import java.awt.Color;
import java.awt.Graphics;

import com.mashibing.tank.GameObject;

public class TailDecorator extends GODecorator {

	public TailDecorator(GameObject go) {
		super(go);
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		this.x = go.x;
		this.y = go.y;
		go.paint(g);
		Color color = g.getColor();
		g.setColor(Color.WHITE);
		g.drawLine(go.x, go.y, go.x+go.getWidth(), go.y+go.getHeight());
		g.setColor(color);
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return super.go.getWidth();
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return super.go.getHeight();
	}

}
