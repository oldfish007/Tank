package com.mashibing.tank;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TFrame tf = new TFrame();
		
		//初始化地方坦克
		for (int i = 0; i < 5; i++) {
			tf.enemys.add(new Tank(50+i*30, 200, Dir.DOWN, tf));
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
