package com.mashibing.tank.strategy;

import com.mashibing.tank.Bullet;
import com.mashibing.tank.Tank;
import com.mashibing.tank.abstractfactory.BaseTank;

/**
 * 默认打炮弹
 * @author zxh
 *
 */
public class DefaultFireStrategy implements FireStrategy {

	@Override
	public void fire(Tank tank) {
		int bX = tank.x+Tank.width/2-Bullet.width/2;
		int bY = tank.y+Tank.height/2-Bullet.height/2;
		// 坦克的坐标 和 坦克的方向 
		tank.tf.bullets.add(new Bullet(bX, bY, tank.dir,tank.group,tank.tf));
		
	}

}
