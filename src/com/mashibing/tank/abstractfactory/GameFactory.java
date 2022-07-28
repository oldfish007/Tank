package com.mashibing.tank.abstractfactory;

import com.mashibing.tank.Dir;
import com.mashibing.tank.Group;
import com.mashibing.tank.TFrame;

public abstract class GameFactory {

		
	public abstract BaseTank createTank(int x,int y,Dir dir,Group group,TFrame tf);
	public abstract BaseExplode crateExplode(int x,int y,TFrame tf);
	public abstract BaseBullet createBullet(int x,int y,Dir dir,Group group,TFrame tf);
	
	
}
