package com.mashibing.tank;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TFrame tf = new TFrame();
		
		//先实例化5辆tank出来
		for (int i = 0; i < 6; i++) {
			tf.enemies.add(new Tank(50+i*55, 200, Dir.DOWN,Group.BAD, tf));
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
