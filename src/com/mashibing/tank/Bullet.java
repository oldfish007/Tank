package com.mashibing.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;



/*
 * 区分的更严格一些就是 敌人的坏炮弹，我方的好炮弹
 */
public class Bullet extends GameObject {

	private static final int SPEED = 8;
	public static int width = ResourceMgr.bulletD.getWidth();
	public static int height = ResourceMgr.bulletD.getHeight();

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	private Dir dir;
	private boolean living = true;// 子弹的生命
	public Group group = Group.Bad;

	public Rectangle rect = new Rectangle();

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Bullet(int x, int y, Dir dir, Group group) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.group = group;
		rect.x = this.x;
		rect.y = this.y;
		rect.width = width;
		rect.height = height;
		
		GameModel.getINSTANCE().add(this);
		
	}

	public void paint(Graphics g) {
		if (!living) {
			GameModel.getINSTANCE().remove(this);
		}

		/*
		 * Color color = g.getColor(); g.setColor(Color.RED); g.fillOval(x, y,
		 * width,height);
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
		switch (dir) {
		case LEFT:
			x -= SPEED;
			break;
		case RIGTHT:
			x += SPEED;
			break;
		case UP:
			y -= SPEED;
			break;
		case DOWN:
			y += SPEED;
			break;
		}
		rect.x = this.x;
		rect.y = this.y;

		if (x < 0 || y < 0 || x > TFrame.GAME_WIDTH || y > TFrame.GAME_HEIGHT)
			living = false;
	}

	
	public void die() {
		this.living = false;
	}
}
