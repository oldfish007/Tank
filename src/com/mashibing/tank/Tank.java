package com.mashibing.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Tank {

	private int x,y;
	private Dir dir = Dir.DOWN;
	private static final int SPEED=5;
	private TFrame tf = null;
	//刚开始的时候moving是静止的 true才会移动
	private boolean moving = true;
	private boolean living=true;
	private Random random = new Random();
	public static final int WIDTH=ResourceMgr.goodTankL.getWidth();
	public static final int HEIGHT = ResourceMgr.goodTankL.getHeight();
	private Group group = Group.BAD;
	public boolean isMoving() {
		return moving;
	}


	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public Tank(int x, int y, Dir dir,Group group,TFrame tf) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
		this.group = group;
	}
	
	
	public Dir getDir() {
		return dir;
	}


	public void setDir(Dir dir) {
		this.dir = dir;
	}

/**
 * 根据坦克的方向确定tank移动的方向
 * @param g
 */
	public void paint(Graphics g) {
		if(!living) tf.enemies.remove(this);
		//画出tank
		switch(dir) {
			case LEFT:
				g.drawImage(this.group==Group.good?ResourceMgr.goodTankL:ResourceMgr.badTankL, x, y, null);
				break;
			case UP:
				g.drawImage(this.group==Group.good?ResourceMgr.goodTankU:ResourceMgr.badTankU, x, y, null);
				break;
			case RIGTHT:
				g.drawImage(this.group==Group.good?ResourceMgr.goodTankR:ResourceMgr.badTankR, x, y, null);
				break;
			case DOWN:
				g.drawImage(this.group==Group.good?ResourceMgr.goodTankD:ResourceMgr.badTankD, x, y, null);
				break;
		}		
		    move();
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}
	
	
	public void setY(int y) {
		this.y = y;
	}


	private void move() {
		if(!moving) return;
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
		//TODO 区分主战坦克和敌人坦克分别打炮弹任何方向移动都开会
		 if(this.group==Group.BAD&& random.nextInt(100)>95)
			 fire();
		 //先让敌人坦克自由移动
		 if(this.group==Group.BAD&&random.nextInt(100)>95)
			 randomDir();
		//边界检测
			boundsCheck();
	}

	private void boundsCheck() {
		
		if(this.x<2)x = 2;
		if(this.y<28) y = 28;
		if(this.x>TFrame.GAME_WIDTH-Tank.WIDTH-2) x =TFrame.GAME_WIDTH-Tank.WIDTH-2;
		if(this.y>TFrame.GAME_HEIGHT-Tank.HEIGHT-2) y = TFrame.GAME_HEIGHT-Tank.HEIGHT-2;
	}


	private void randomDir() {
		// TODO Auto-generated method stub
		this.dir = Dir.values()[random.nextInt(4)];
	}


//按下control 实例化界面类的那个子弹
	public void fire() {
		// 坦克的坐标 和 坦克的方向 
		//从Tank的中心打出炮弹
		int bX = this.x+Tank.WIDTH/2-Bullet.WIDTH/2;
		int bY = this.y+Tank.HEIGHT/2-Bullet.HEIGHT/2;
		//炮弹分好坏属性
		Bullet b = new Bullet(bX, bY, dir,this.group,tf);
		tf.bullets.add(b);
	}


	public void die() {

		this.living = false;
		
	}


	public Group getGroup() {
		return group;
	} 	


	public void setGroup(Group group) {
		this.group = group;
	}
	

}
