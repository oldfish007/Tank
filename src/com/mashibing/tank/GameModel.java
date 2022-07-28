package com.mashibing.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import com.mashibing.tank.cor.ColliderChain;

/*
 * 把view层TFrame里面的集合全部进来
 * 界面曾需要什么找GameModel去要
 */
public class GameModel {

	private static GameModel INSTANCE = new GameModel();
	// List<Bullet> bullets = new ArrayList<>();
		// List<Tank> tanks = new ArrayList<>();
		// List<Explode> explodes = new ArrayList<>();
	private List<GameObject> objects = new ArrayList<>();
	
	static {
		INSTANCE.init();	
	}
	//主战坦克
	Tank myTank;
	ColliderChain chain = new ColliderChain();
	
	public Tank getMyTank() {
		// TODO Auto-generated method stub
		return myTank;
	}

	public GameModel() {}
	
	public void init() {
		//初始化主战坦克
		//主战坦克
	    myTank = new Tank(200,400,Dir.DOWN,Group.Good);
	    int count = Integer.parseInt((String)PropertyMgr.get("initTankCount"));
		//初始化敌人坦克
		for (int i = 0; i < count; i++) {
			//tf.enemys.add(tf.gf.createTank(50+i*50, 200, Dir.DOWN,Group.Bad, tf));'
			add(new Tank(50 + i * 80, 200, Dir.DOWN, Group.Bad));
		}
		
		//初始化枪
		add(new Wall(150, 150, 200, 50));
		add(new Wall(550, 150, 200, 50));
		add(new Wall(300, 300, 50, 200));
		add(new Wall(550, 300, 50, 200));
		
	}
	
	public static GameModel getINSTANCE() {
		return INSTANCE;
	}

	public void add(GameObject o) {
		this.objects.add(o);
	}
	
	public void remove(GameObject o) {
		this.objects.remove(o);
	}
	
     
	public void paint(Graphics g) {
	
		Color color = g.getColor();
		g.setColor(Color.white);
		/*
		 * g.drawString("子弹的数量"+bullets.size(), 10, 60);
		 * g.drawString("敌人的数量"+enemys.size(), 10, 80);
		 * g.drawString("爆炸的数量"+explodes.size(), 10, 100);
		 */
		g.setColor(color);
		myTank.paint(g);
		//画出敌人坦克
		for (int i = 0; i <objects.size(); i++) {
			objects.get(i).paint(g);
		}
		//碰撞
		for(int i=0;i<objects.size();i++) {
			for(int j = i+1;j<objects.size();j++) {
				GameObject o1 = objects.get(i);
				GameObject o2 = objects.get(j);
				chain.collide(o1, o2);
			}
		}
			
	}

	
	
}
