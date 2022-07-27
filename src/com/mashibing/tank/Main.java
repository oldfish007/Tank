package com.mashibing.tank;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TFrame tf = new TFrame();
		int count = Integer.parseInt((String)PropertyMgr.get("initTankCount"));
		//初始化敌人坦克
		for (int i = 0; i < count; i++) {
			tf.enemys.add(new Tank(50+i*50, 200, Dir.DOWN,Group.Bad, tf));
		}
		
		while(true) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tf.repaint();
		}
		
		
		
	}

}
