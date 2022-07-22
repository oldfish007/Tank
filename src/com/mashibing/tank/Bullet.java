package com.mashibing.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
/*
 * 区分的更严格一些就是 敌人的坏炮弹，我方的好炮弹
 */
public class Bullet {

	private static final int SPEED=8;
	private int x,y;
	public static int width=ResourceMgr.bulletD.getWidth();
	public static int height=ResourceMgr.bulletD.getHeight();
	private Dir dir;
	private boolean living = true;//子弹的生命
	TFrame tFrame = null;
    private Group group = Group.Bad;
	
	Rectangle rect = new Rectangle();
	
	
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Bullet(int x,int y,Dir dir,Group group,TFrame tf) {
		this.x  = x;
		this.y = y;
		this.dir=dir;
		this.group = group;
		this.tFrame = tf;
		rect.x = this.x;
		rect.y = this.y;
		rect.width = width;
		rect.height = height;
	}
	
	public void paint(Graphics g) {
		if(!living) {
			this.tFrame.bullets.remove(this);
		}
		
		/*
		 * Color color = g.getColor(); 
		 * g.setColor(Color.RED);
		 *  g.fillOval(x, y, width,height);
		 * 
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
		rect.x = this.x;
		rect.y = this.y;
		
		if(x<0||y<0||x>TFrame.GAME_WIDTH||y>TFrame.GAME_HEIGHT) living =false;
	}

	public void collideWith(Tank tank) {
		//如果我们是一波的 就不检测了退出循环
		if(this.group==tank.getGroup()) return;
		//TODO 用一个rect来记录子弹的位置
		/*
		 * Rectangle rect1 = new Rectangle(this.x, this.y, width, height); Rectangle
		 * rect2 = new Rectangle(tank.getX(), tank.getY(), tank.width, tank.height);
		 */		
		if(rect.intersects(tank.rect)) {
			tank.die();
			this.die();
			int eX = tank.getX()+Tank.width/2-Explode.width/2;
			int eY = tank.getY()+Tank.height/2-Explode.height/2;
			//碰撞上了以后实例化一个爆炸
			this.tFrame.explodes.add(new Explode(eX, eY, tFrame));
		}
		
	}

	private void die() {
		this.living=false;
	}
}
