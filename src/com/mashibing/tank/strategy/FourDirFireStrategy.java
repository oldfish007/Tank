package com.mashibing.tank.strategy;

import com.mashibing.tank.Bullet;
import com.mashibing.tank.Dir;
import com.mashibing.tank.GameModel;
import com.mashibing.tank.Tank;

public class FourDirFireStrategy implements FireStrategy{

	@Override
	public void fire(Tank tank) {
		// TODO Auto-generated method stub
		int bX = tank.x + Tank.width/2 - Bullet.width/2;
		int bY = tank.y + Tank.height/2 - Bullet.height/2;
		Dir[] dirs =  Dir.values();
	    for (Dir dir : dirs) {
	    	GameModel.getINSTANCE().add(new Bullet(bX, bY,dir, tank.group));
		}
	}

}
