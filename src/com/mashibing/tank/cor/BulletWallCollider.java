package com.mashibing.tank.cor;

import com.mashibing.tank.Bullet;
import com.mashibing.tank.Explode;
import com.mashibing.tank.GameModel;
import com.mashibing.tank.GameObject;
import com.mashibing.tank.Wall;

public class BulletWallCollider implements Collider{

	
	@Override
	public boolean collide(GameObject o1, GameObject o2) {
		
		if(o1 instanceof Bullet && o2 instanceof Wall) {
			Bullet b = (Bullet)o1;
			Wall w = (Wall)o2;
			
			if(b.rect.intersects(w.rect)) {
				b.die();
				int eX = b.x;
				int eY = b.y;
				new Explode(eX, eY);
			}
		}else if(o1 instanceof Wall && o2 instanceof Bullet) {
			return collide(o2,o1);
		}
		return true;
	}

}