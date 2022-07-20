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
	Dir dir = Dir.DOWN;
	private static final int SPEED=10;
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
 *每paint 就重绘一次
 *根据坦克的方向进行坦克的移动
 */
	@Override
	public void paint(Graphics g) {
		g.fillRect(x, y, 50, 50);
		switch(dir) {
			case LEFT:
				x-=SPEED;
				break;
			case RIGTHT:
				x+=SPEED;
				break;
			case UP:
				y-=SPEED;
				break;
			case DOWN:
				y+=SPEED;
				break;
		}
	}
	
/**
 * 根据按键的状态用4个bool值记录下来	
 * @author zxh
 *
 */
	class MyKeyListener extends KeyAdapter{
		boolean bL = false;
		boolean bU = false;
		boolean bR = false;
		boolean bD = false;
	/**
	 * 根据按键获取方向，根据方向获取主站坦克的方向
	 * 根据主战坦克的方向获取移动的方向	
	 */
		
		@Override
		public void keyPressed(KeyEvent e) {
				
			int keyCode = e.getKeyCode();
			switch (keyCode) {
			case KeyEvent.VK_LEFT:
				bL=true;
				break;
			case KeyEvent.VK_RIGHT:
				bR = true;
				break;
			case KeyEvent.VK_UP:
				bU = true;
				break;
			case KeyEvent.VK_DOWN:
				bD = true;
				break;
			default:
				break;
			}
			//按下按键后决定主战坦克的方向
			setMainTankDir();
		}
/**根据按键改变主战坦克的方向
 * 根据按键的状态改变坦克的方向，根据坦克的方向进行坦克的移动
 */
		@Override
		public void keyReleased(KeyEvent e) {
			
			int keyCode = e.getKeyCode();
			switch (keyCode) {
			case KeyEvent.VK_LEFT:
				bL=false;
				break;
			case KeyEvent.VK_RIGHT:
				bR = false;
				break;
			case KeyEvent.VK_UP:
				bU = false;
				break;
			case KeyEvent.VK_DOWN:
				bD = false;
				break;
			default:
				break;
			}
			setMainTankDir();
		}
//根据按键的状态改变坦克的方向
		
		private void setMainTankDir() {
			
			if(bL) dir = Dir.LEFT;
			if(bR) dir = Dir.RIGTHT;
			if(bD) dir = Dir.DOWN;
			if(bU) dir = Dir.UP;
		}
		
		
	}
	
	
	

}
