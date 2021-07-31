package content;

import common.gameInterface.IDrawImage;
import content.map.MapBase;
import content.map.generator.MapGenerator;
import content.player.Player;
import frame.Common;
import frame.Constant;

import java.awt.*;

/**
 * 目前计划在这里加载所有需要在游戏中加载的东西
 * */
public class GameContentLoader implements IDrawImage {

    public MapBase[] allMap;

    public GameContentLoader(){

        MapGenerator.run();

        allMap = new MapBase[Constant.mapList.size()];
        Constant.mapList.toArray(allMap);

        Common.task(25, () -> {
            Player.player.action();//玩家动作
        });

        //这里运行所有创建出来的地图实例的mapMove()方法
        //地图随玩家移动的绘制，可能period小一点比较好？
        Common.task(20, () -> {
            for(MapBase anMap : allMap){
                anMap.mapMove();
            }
        });
        //TODO 在这里写更多的task
    }
    @Override
    public void drawImage(Graphics g) {

    }
}
