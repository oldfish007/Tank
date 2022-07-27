package com.mashibing.tank;

/**
 * 默认打炮弹
 * @author zxh
 *
 */
public class DefaultFireStrategy implements FireStrategy {

	@Override
	public void fire(Tank t) {
		int bX = t.x+Tank.width/2-Bullet.width/2;
		int bY = t.y+Tank.height/2-Bullet.height/2;
		 
		// 坦克的坐标 和 坦克的方向 
		t.tf.bullets.add(new Bullet(bX, bY, t.dir,t.group,t.tf));
		
	}

}
