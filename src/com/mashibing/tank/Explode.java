package com.mashibing.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/*
 * 区分的更严格一些就是 敌人的坏炮弹，我方的好炮弹
 */
public class Explode extends GameObject{

	public static int width=ResourceMgr.explodes[0].getWidth();
	public static int height=ResourceMgr.explodes[1].getHeight();
	private int step=0;
	public Explode(int x,int y) {
		this.x  = x;
		this.y = y;
		//new Audio("audio/explode.wav").play();
		GameModel.getINSTANCE().add(this);
	}
	
	public void paint(Graphics g) {
		g.drawImage(ResourceMgr.explodes[step++], x, y, null);
		if(step>=ResourceMgr.explodes.length)
			GameModel.getINSTANCE().remove(this);
	}

	public  int getWidth() {
		return width;
	}

	public  int getHeight() {
		return height;
	}

	
	
}
