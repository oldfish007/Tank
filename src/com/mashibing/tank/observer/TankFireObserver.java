package com.mashibing.tank.observer;

import java.io.Serializable;

public interface TankFireObserver extends Serializable{

	void actinoForm(TankFireEvent event);

}
