package com.mashibing.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TFrame extends Frame {

	public TFrame() {
		setSize(800, 600);
		setResizable(false);
		setTitle("tank war");
		setVisible(true);
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
	}
/**
 *窗口重新绘制的时候 需要用这个方法
 *系统递给你的画笔
 */
	@Override
	public void paint(Graphics g) {
		
		g.fillRect(200, 200, 50, 50);
	}
	
	
	

}
