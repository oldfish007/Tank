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
增加打炮弹的策略模式
a> 给普通的增加default
b> 给我军增加四面打炮弹


SpringIOC
Facade
门面
Mediator
调停者
Decorator
装饰器
责任链开头

TF - 解决添加新游戏物体的问题
1：TF - Facade 门面模式  不用你到处去找 抽象出来的一个类
Frame - > 展示
GameModel -> 内部逻辑计算
2：GameObject


spring配置文件
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans.xsd">


    <bean id="d" class="com.mashibing.Driver"></bean>
    <bean id="tank" class="com.mashibing.Tank">
        <property name="driver" ref="d"></property>
    </bean>

</beans>

spring的写法：
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("app.xml");

        //Driver d = (Driver)context.getBean("driver");
        Tank t = (Tank)context.getBean("tank");

    }
}


名词用抽象类 形容词用抽象接口
抽象工厂
顶层抽象GameFactory
抽象对象
BaseTank
BaseBullet
BaseExplode
具体工厂
DefaultFactory
Rect工厂
具体工厂RectFactory 
具体类
RectTank
RectBullet
RectExplode