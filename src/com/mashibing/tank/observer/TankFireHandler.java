package com.mashibing.tank.observer;

import com.mashibing.tank.Tank;

public class TankFireHandler implements TankFireObserver {

	@Override
	public void actinoForm(TankFireEvent event) {
		// TODO Auto-generated method stub
		Tank t = event.getSource();
		t.fire();

	}

}
