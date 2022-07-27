package com.mashibing.tank;

public class FourDirFireStrategy implements FireStrategy{

	@Override
	public void fire(Tank t) {
		// TODO Auto-generated method stub
		int bX = t.x + Tank.width/2 - Bullet.width/2;
		int bY = t.y + Tank.height/2 - Bullet.height/2;
		Dir[] dirs =  Dir.values();
	    for (Dir dir : dirs) {
	    	t.tf.bullets.add(new Bullet(bX, bY,dir, t.group,t.tf ));
		}
	}

}
