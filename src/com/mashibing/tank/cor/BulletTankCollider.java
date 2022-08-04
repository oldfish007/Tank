package com.mashibing.tank.cor;

import com.mashibing.tank.Bullet;
import com.mashibing.tank.Explode;
import com.mashibing.tank.GameModel;
import com.mashibing.tank.GameObject;
import com.mashibing.tank.Tank;

public class BulletTankCollider implements Collider {
 
	public boolean collide(GameObject o1, GameObject o2) {
		if(o1 instanceof Bullet && o2 instanceof Tank) {
			Bullet b = (Bullet)o1;
			Tank t = (Tank)o2;
		//TODO COPY CODE FROM METHOD collidevwith
			if(b.group==t.group) return true;
			if(b.rect.intersects(t.rect)) {
				t.die();
				b.die();
				//实例化炮弹
				int eX = t.getX()+t.getWidth()/2-Explode.width/2;
				int eY = t.getY()+t.getHeight()/2-Explode.height/2;
				new Explode(eX, eY);
				return false;
			}
			
		}else if(o1 instanceof Tank && o2 instanceof Bullet) {
			return collide(o2,o1);
		}
		return true;
	}

}
