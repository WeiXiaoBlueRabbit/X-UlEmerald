# X-UlEmerald
口袋妖怪项目

直接用IDEA打开X-UlEmerald文件即可

## 程序运行逻辑
src/frame/Constant.java文件中创建的GameContentLoader实例会
运行所有需要运行的东西，如MapGenerator.run()方法来创建所有地图实例
其后还有运行所有地图实例中mapMove()方法的task。

在src/frame/GameFrame.java文件中将所有需要绘制的东西加入到面板中从而
将绘制的图片呈现在屏幕上

## 当前优先完成的任务：
- [x] 精灵各参数的宏定义
- [ ] 地图连接系统
- [ ] 训练师和玩家人物行为系统
- [x] 计时器Timer
- [x] 任务task
- [ ] WildPoke文件的补全(src/content/poke/poke_basic/WildPoke)
- [ ] TamePoke文件的编写(src/content/poke/poke_basic/TamePoke)
- [ ] 

## 文件：
content 游戏内容  
frame 窗体及按键输入  
resources 素材及音效  
src\content\pokemon_contests 华丽大赛  
src\content\brood 孵蛋系统
