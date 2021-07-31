package content.map;

import common.gameInterface.IDrawImage;
import common.gameInterface.interface_annotation.IMap;
import content.map.common.RewardBalls;
import content.player.Player;
import frame.Constant;
import frame.Keys;

import java.awt.*;

/**
 * 位于src/content/map且继承了MapBase的类可以在被src/content/map/generator/MapGenerator.java文件检测到
 * 目前出现问题的是下面的mapMove()方法，但推测出drawImage里面的if判断也全部无效
 *
 * 建议先看src/common/EntityAttribute.java中我对注解的解释之后再看下面的代码
 * */
public class MapBase implements IDrawImage {

    private Image image;
    private RewardBalls ball_1;
    private int x,y;

    @Override
    public void drawImage(Graphics g) {
        MapBase[] allMap = Constant.gameContentLoader.allMap;

        IMap map = this.getClass().getAnnotation(IMap.class);
        if (map.mapName() == Player.player.getPlayerLocation()){
            g.drawImage(this.getImage(), this.getX(), this.getY(), map.width(), map.height(), null);

            //绘制四个方向连接的地图，我只能想到这样了，如果有其他好方法的话请将其替换
            if (map.UpLink() != "null"){
                for (MapBase anMap : allMap){
                    IMap ann = anMap.getClass().getAnnotation(IMap.class);
                    if (ann.mapName() != map.UpLink())
                        continue;
                    g.drawImage(anMap.getImage(), anMap.getX(), anMap.getY(), ann.width(), ann.height(), null);
                }
            }

            if (map.DownLink() != "null"){
                for (MapBase anMap : allMap){
                    IMap ann = anMap.getClass().getAnnotation(IMap.class);
                    if (ann.mapName() != map.DownLink())
                        continue;
                    g.drawImage(anMap.getImage(), anMap.getX(), anMap.getY(), ann.width(), ann.height(), null);
                }
            }

            if (map.LeftLink() != "null"){
                for (MapBase anMap : allMap){
                    IMap ann = anMap.getClass().getAnnotation(IMap.class);
                    if (ann.mapName() != map.LeftLink())
                        continue;
                    g.drawImage(anMap.getImage(), anMap.getX(), anMap.getY(), ann.width(), ann.height(), null);
                }
            }

            if (map.RightLink() != "null"){
                for (MapBase anMap : allMap){
                    IMap ann = anMap.getClass().getAnnotation(IMap.class);
                    if (ann.mapName() != map.RightLink())
                        continue;
                    g.drawImage(anMap.getImage(), anMap.getX(), anMap.getY(), ann.width(), ann.height(), null);
                }
            }
        }
    }

    /**
     * 通过println得知程序能执行到mapMove()方法，并且正确创建了所有地图实例
     * 问题猜想一：其判断似乎全部为false导致地图的x，y未得到更改而无法运作
     *问题猜想二：可能与我在src/frame/GamePanel.java中的paint方法写死了x，y有关？？
     * */
    public void mapMove(){

        MapBase[] allMap = Constant.gameContentLoader.allMap;
        System.out.println("x = " + this.getX() + "y = " + this.getY());

        IMap map = this.getClass().getAnnotation(IMap.class);
        if (map.mapName() == Player.player.getPlayerLocation()){
            if (Keys.UP.press() && !Keys.LEFT.press() && !Keys.RIGHT.press())
                this.setY(this.getY() + 1);
            if (Keys.DOWN.press() && !Keys.LEFT.press() && !Keys.RIGHT.press())
                this.setY(this.getY() - 1);
            if (Keys.LEFT.press())
                this.setX(this.getY() - 1);
            if (Keys.RIGHT.press())
                this.setX(this.getY() + 1);
        }

        if (map.UpLink() != "null"){
            for (MapBase anMap : allMap){
                IMap ann = anMap.getClass().getAnnotation(IMap.class);
                if (ann.mapName() != map.UpLink())
                    continue;

                if (Keys.UP.press() && !Keys.LEFT.press() && !Keys.RIGHT.press())
                    anMap.setY(anMap.getY() + 1);
                if (Keys.DOWN.press() && !Keys.LEFT.press() && !Keys.RIGHT.press())
                    anMap.setY(anMap.getY() - 1);
                if (Keys.LEFT.press())
                    anMap.setX(anMap.getY() - 1);
                if (Keys.RIGHT.press())
                    anMap.setX(anMap.getY() + 1);
            }
        }

        if (map.DownLink() != "null"){
            for (MapBase anMap : allMap){
                IMap ann = anMap.getClass().getAnnotation(IMap.class);
                if (ann.mapName() != map.DownLink())
                    continue;

                if (Keys.UP.press() && !Keys.LEFT.press() && !Keys.RIGHT.press())
                    anMap.setY(anMap.getY() + 1);
                if (Keys.DOWN.press() && !Keys.LEFT.press() && !Keys.RIGHT.press())
                    anMap.setY(anMap.getY() - 1);
                if (Keys.LEFT.press())
                    anMap.setX(anMap.getY() - 1);
                if (Keys.RIGHT.press())
                    anMap.setX(anMap.getY() + 1);
            }
        }

        if (map.LeftLink() != "null"){
            for (MapBase anMap : allMap){
                IMap ann = anMap.getClass().getAnnotation(IMap.class);
                if (ann.mapName() != map.LeftLink())
                    continue;

                if (Keys.UP.press() && !Keys.LEFT.press() && !Keys.RIGHT.press())
                    anMap.setY(anMap.getY() + 1);
                if (Keys.DOWN.press() && !Keys.LEFT.press() && !Keys.RIGHT.press())
                    anMap.setY(anMap.getY() - 1);
                if (Keys.LEFT.press())
                    anMap.setX(anMap.getY() - 1);
                if (Keys.RIGHT.press())
                    anMap.setX(anMap.getY() + 1);
            }
        }

        if (map.RightLink() != "null"){
            for (MapBase anMap : allMap){
                IMap ann = anMap.getClass().getAnnotation(IMap.class);
                if (ann.mapName() != map.RightLink())
                    continue;

                if (Keys.UP.press() && !Keys.LEFT.press() && !Keys.RIGHT.press())
                    anMap.setY(anMap.getY() + 1);
                if (Keys.DOWN.press() && !Keys.LEFT.press() && !Keys.RIGHT.press())
                    anMap.setY(anMap.getY() - 1);
                if (Keys.LEFT.press())
                    anMap.setX(anMap.getY() - 1);
                if (Keys.RIGHT.press())
                    anMap.setX(anMap.getY() + 1);
            }
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Image getImage(){
        return image;
    }
}
