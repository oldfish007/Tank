package com.mashibing.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
/**
 * 应该要在tank中间爆炸
 * 遍历资源类的数组
 */
public class Explods {

	
	private int x,y;
	public static int WIDTH = ResourceMgr.explodes[0].getWidth();
	public static int HEIGHT = ResourceMgr.explodes[1].getHeight();
	private TFrame tf=null;
	int step=0;
	public Explods(int x,int y,TFrame tf) {
		this.x  = x;
		this.y = y;
		this.tf = tf;
	}
//根据主战坦克的方向区分	
	public void paint(Graphics g) {
		
		g.drawImage(ResourceMgr.explodes[step++], x, y, null);
		if(step>=ResourceMgr.explodes.length)
			this.tf.explods.remove(this);//显示完自己一个，删除自己一个
	}

	
	
}
