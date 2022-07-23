package com.mashibing.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet {

	private static final int SPEED=8;
	private int x,y;
	public static final int WIDTH=ResourceMgr.bulletD.getWidth();
	public static final int HEIGHT=ResourceMgr.bulletD.getHeight();
	private Dir dir;
	private boolean moving=false;
	private boolean living=true;
	private Group group = Group.BAD;
	private TFrame tf;
	public Bullet(int x,int y,Dir dir,Group group,TFrame tf) {
		this.x  = x;
		this.y = y;
		this.dir=dir;
		this.tf = tf;
		this.group = group;
	}
//根据主战坦克的方向区分	
	public void paint(Graphics g) {
		if(!living) {
			tf.bullets.remove(this);
		}
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
	/**
	 * tank 形参是都是6个敌人的
	 * @param tank
	 */
	public void collectWith(Tank tank) {
        //同一家的子弹就不互相伤害了
		if(this.group==tank.getGroup()) return;
		//TODO  用一个rect来记录子弹的位置
		Rectangle rect1 = new Rectangle(this.x, this.y, WIDTH, HEIGHT);
		Rectangle rect2 = new Rectangle(tank.getX(), tank.getY(), Tank.WIDTH, Tank.HEIGHT);
		
		if(rect1.intersects(rect2)) {
			//移除敌人坦克集合
			tank.die();
			this.die();
			//同时爆炸 且爆炸会有很多 
			int eX = tank.getX()+Tank.WIDTH/2-Explods.WIDTH/2;
			int eY = tank.getY()+Tank.HEIGHT/2-Explods.HEIGHT/2;
			this.tf.explods.add(new Explods(eX, eY, tf));
			
		}
	}
	private void die() {
		// TODO Auto-generated method stub
		this.living=false;
	}
	
}
