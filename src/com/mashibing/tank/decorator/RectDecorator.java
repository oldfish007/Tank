package com.mashibing.tank.decorator;

import java.awt.Color;
import java.awt.Graphics;

import com.mashibing.tank.GameObject;

/**
 * 在tank外围画一个框框，从而实现装饰器模式
 * @author zxh
 *
 */
public class RectDecorator extends GODecorator {

	
	public RectDecorator(GameObject go) {
		super(go);
	}

	@Override
	public void paint(Graphics g) {
		this.x = go.x;
		this.y = go.y;
		go.paint(g);
		Color color = g.getColor();
		g.setColor(Color.WHITE);
		g.drawRect(super.go.x, super.go.y, super.go.getWidth(), super.go.getHeight());
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
