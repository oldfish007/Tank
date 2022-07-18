package com.mashibing.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TFrame extends Frame {

	private int x=200;
	private int y=200;
	public TFrame() {
		setSize(800, 600);
		setResizable(false);
		setTitle("tank war");
		this.addKeyListener(new MyKeyListener());
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
		
		g.fillRect(x, y, 50, 50);
		x+=10;
		y+=10;
	}
	
	class MyKeyListener extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			
			System.out.println("key pressed");
		}

		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println("key released");
		}
		
		
	}
	
	
	

}
