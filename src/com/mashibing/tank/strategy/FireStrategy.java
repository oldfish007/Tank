package com.mashibing.tank.strategy;

import com.mashibing.tank.Tank;
import com.mashibing.tank.abstractfactory.BaseTank;
import com.mashibing.tank.abstractfactory.RectTank;

public interface FireStrategy {

	void fire(Tank t);

	 
}
