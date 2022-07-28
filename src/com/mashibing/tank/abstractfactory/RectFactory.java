package com.mashibing.tank.abstractfactory;

import com.mashibing.tank.Dir;
import com.mashibing.tank.Group;
import com.mashibing.tank.TFrame;

public class RectFactory extends GameFactory {

	 

	@Override
	public BaseTank createTank(int x, int y, Dir dir, Group group, TFrame tf) {
		// TODO Auto-generated method stub
		return new RectTank(x, y, dir, group, tf);
	}
 

	@Override
	public BaseExplode crateExplode(int x, int y, TFrame tf) {
		// TODO Auto-generated method stub
		return new RectExplode(x, y, tf);
	}

	@Override
	public BaseBullet createBullet(int x, int y, Dir dir, Group group, TFrame tf) {
		// TODO Auto-generated method stub
		return new RectBullet(x, y, dir, group, tf);
	}

}
