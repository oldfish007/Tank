package com.mashibing.tank.cor;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.mashibing.tank.GameObject;

//链条
public class ColliderChain implements Collider {

	 private List<Collider> colliderList = new LinkedList<>();

	 public ColliderChain() {
		add(new TankTankCollider());
		add(new TankWallCollider());
		add(new BulletWallCollider());
		add(new BulletTankCollider());
		
	}
	public ColliderChain add(Collider c) {
		 colliderList.add(c);
		 return this;
	 }
	@Override
	public boolean collide(GameObject o1, GameObject o2) {
		for(int i=0; i<colliderList.size(); i++) {
			if(!colliderList.get(i).collide(o1, o2)) {
				return false;//中间遇到那个filter就断了
			}
		}
		
		return true;
	}

}
