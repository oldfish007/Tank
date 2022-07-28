package com.mashibing.tank.abstractfactory;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.mashibing.tank.Group;

public abstract class BaseTank {

	public Group group  = Group.Bad;
	public Rectangle rect = new Rectangle();
	
	public abstract void paint(Graphics g); 
	
	public Group getGroup() {
		return group;
	}
	
	public abstract void die();
	public abstract void fire();

	public abstract int getX();

	public abstract int getY();
	
	

}
