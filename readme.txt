界面类  
从界面需要什么就new出来
new出Tank
new出bullet
然后重绘
TankFrame界面类需要重绘的东西交给对象自己 只有自己知道自己的功能
根据按键的状态改变坦克的方向，根据坦克的方向进行坦克的移动
按下ctrl 子弹获得坦克的方向
1.0.2
如何定义主战坦克的方向
Enum Dir
根据按键改变主战坦克方向
setMainTankDir()
根据方向进行坦克的移动
怎么 样处理坦克静止状态
moving = false;
想象如何给出更多坦克，以及子弹
将坦克封装成类，理解面向对象设计中“封装”的思想
用双缓冲解决闪烁问题（不重要）
repaint - update
截获update
首先把该画出来的东西（坦克， 子弹）先画在内存的图片中，图片大小和游戏画面一致
把内存中图片一次性画到屏幕上（内存的内容复制到显存）
打出一颗子弹
按下Ctrl键，主战坦克打出一颗子弹
用面向对象的思想考虑
打出一串子弹
将子弹装在容器中



1.0.4
调整效果
换坦克图片，换炮弹图片
音乐与音效
完成爆炸功能
加入到List中
显示数量
敌人坦克简单智能化
随机移动位置
随机发射子弹
边界检测
解决new Rectangle问题
MileStone - 里程碑式的版本
Code Review and Refactoring
配置文件
PropertyMgr的单例问题
答疑
java - exe jar+jre+tool = exe

作业：
整理代码
写出首个设计模式（单例）
在内存中，如果需要某个类的对象，在程序上保证，有且只有一个该类的对象
策略模式