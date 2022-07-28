package com.mashibing.tank.abstractfactory;

import com.mashibing.tank.Bullet;
import com.mashibing.tank.Dir;
import com.mashibing.tank.Explode;
import com.mashibing.tank.Group;
import com.mashibing.tank.TFrame;
import com.mashibing.tank.Tank;

public  class DefaultFactory extends GameFactory {

	@Override
	public BaseTank createTank(int x, int y, Dir dir, Group group, TFrame tf) {
		// TODO Auto-generated method stub 
		return new Tank(x, y, dir, group, tf);
	}

	@Override
	public BaseExplode crateExplode(int x, int y, TFrame tf) {
		return new Explode(x, y, tf);
	}

	@Override
	public BaseBullet createBullet(int x, int y, Dir dir, Group group, TFrame tf) {
		return new Bullet(x, y, dir, group, tf);
	}

	 

}
