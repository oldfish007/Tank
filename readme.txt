这个分支引入 
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

 view 和model分离
对于外部 TFrame只与GameModel 交互 使用facade
对于内部GameModel与所有类交互充当中间件
引入策略模式进行碰撞检测