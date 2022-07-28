package com.mashibing.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

import com.mashibing.tank.abstractfactory.BaseTank;
import com.mashibing.tank.abstractfactory.RectTank;
import com.mashibing.tank.strategy.DefaultFireStrategy;
import com.mashibing.tank.strategy.FireStrategy;

public class Tank extends BaseTank{

	public int x,y;
	public Dir dir = Dir.DOWN;
	private static final int SPEED=5;
	public TFrame tf = null;
	//刚开始的时候moving是静止的 true才会移动
	private boolean moving = true;
	private Random random = new Random();
	private boolean living=true;
	public static int width=ResourceMgr.goodTankL.getWidth();
	public static int height=ResourceMgr.goodTankD.getHeight();
	 
	FireStrategy fs ;
	public Group getGroup() {
		return group;
	}


	public void setGroup(Group group) {
		this.group = group;
	}


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
		this.group = group;
		this.tf = tf;
		rect.x = this.x;
		rect.y = this.y;
		rect.width = width;
		rect.height = height;
		//我军用四面炮弹
		if(this.group==Group.Good) {
			String goodFSName = (String)PropertyMgr.get("goodFS");
			try {
				fs = (FireStrategy) Class.forName(goodFSName).getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}else {
			fs = new DefaultFireStrategy();
		}	
	}
	
	
	public Dir getDir() {
		return dir;
	}


	public void setDir(Dir dir) {
		this.dir = dir;
	}


	public void paint(Graphics g) {
		if(!living) tf.enemys.remove(this);
		switch (dir) {
			case LEFT:
				g.drawImage(this.group == Group.Good?ResourceMgr.goodTankL:ResourceMgr.badTankL,x,y,null);
				break;
			case UP:
				g.drawImage(this.group == Group.Good?ResourceMgr.goodTankU:ResourceMgr.badTankU, x, y, null);
				break;
			case DOWN:
				g.drawImage(this.group == Group.Good?ResourceMgr.goodTankD:ResourceMgr.badTankD, x, y, null);
				break;
			case RIGTHT:
				g.drawImage(this.group == Group.Good?ResourceMgr.goodTankR:ResourceMgr.badTankR, x, y, null);
				break;
			default:
				break;
		}
		move();
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
		//目前的问题是敌我 都自动  发射炮弹 
		//好炮弹得由玩家控制，坏炮弹随机发射
		if(this.group == Group.Bad && random.nextInt(100) > 95) 
			this.fire();
		if(this.group == Group.Bad && random.nextInt(100) > 95) 
		    randomDir();
		
		//边界检测
		boundsCheck();
		rect.x = this.x;
		rect.y = this.y;
		
	}

	private void boundsCheck() {
		if(this.group==Group.Good) 
			System.out.println(x);
		    System.out.println(y);
		    
		if(this.x<2) x = 2;
	    if(this.y<28) y = 28;
	    if(this.x>TFrame.GAME_WIDTH-Tank.width-2) x =TFrame.GAME_WIDTH-Tank.width-2;
	    if(this.y>TFrame.GAME_HEIGHT-Tank.height-2) y = TFrame.GAME_HEIGHT-Tank.height-2;
	}


	private void randomDir() {
		this.dir = Dir.values()[random.nextInt(4)];
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


	//按下control 实例化界面类的那个子弹
	@Override
	public void fire() {
		//fs.fire(this);
		int bX = this.x+Tank.width/2-Bullet.width/2;
		int bY = this.y+Tank.height/2-Bullet.height/2;
		Dir[] dirs = Dir.values();
		for (Dir dir : dirs) {
			tf.gf.createBullet(bX, bY, dir, group, tf);
		}
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		this.living=false;
	}
	

}
