package com.mashibing.tank;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;



public class TFrame extends Frame {

   
	


	GameModel gm = GameModel.getINSTANCE();
	public static final int GAME_WIDTH=1080,GAME_HEIGHT=960;
	public TFrame() {
		setSize(GAME_WIDTH, GAME_HEIGHT);
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
		// TODO Auto-generated method stub
		gm.paint(g);
	}
/**
 * 根据按键的状态用4个bool值记录下来	
 * @author zxh
 *
 */
	Image offScreenImage = null;
//update方法在paint方法之前调用 
//update把paint()给截获了
	@Override
	public void update(Graphics g) {
		if (offScreenImage == null) {
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.BLACK);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}

	
	
	
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
			case KeyEvent.VK_CONTROL:
				gm.myTank.fire();
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
//刚开始是静止的 按下去才走		
		private void setMainTankDir() {
			Tank myTank = gm.getMyTank();
			//坦克静止
			if(!bL && !bU && !bR && !bD) myTank.setMoving(false);
			else {
				
				myTank.setMoving(true);
				if(bL) myTank.setDir(Dir.LEFT);
				if(bR) myTank.setDir(Dir.RIGTHT);
				if(bD) myTank.setDir(Dir.DOWN);
				if(bU) myTank.setDir(Dir.UP);
			}
			
		}
		
		
	}
	
	
	

}
