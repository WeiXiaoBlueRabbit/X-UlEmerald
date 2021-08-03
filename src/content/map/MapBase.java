package content.map;

import common.gameInterface.IDrawImage;
import common.gameInterface.interface_annotation.IMap;
import content.GameState;
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
    private int moving;
    private String direction = "无";

    private MapBase upLink = null;
    private MapBase downLink = null;
    private MapBase leftLink = null;
    private MapBase rightLink = null;

    @Override
    public void drawImage(Graphics g) {
        MapBase[] allMap = Constant.gameContentLoader.allMap;

        IMap map = this.getClass().getAnnotation(IMap.class);
        if (map.mapName().equals(Player.player.getPlayerLocation())){
            g.drawImage(this.getImage(), this.getX(), this.getY(), map.width(), map.height(), null);

            //绘制四个方向连接的地图，我只能想到这样了，如果有其他好方法的话请将其替换
            if (!map.UpLink().equals("null")){
                for (MapBase anMap : allMap){
                    IMap ann = anMap.getClass().getAnnotation(IMap.class);
                    if (!ann.mapName().equals(map.UpLink()))
                        continue;

                    if (anMap.isPositionInit() == false){
                        anMap.setY(-map.height());
                        anMap.positionInit();
                    }
                    g.drawImage(anMap.getImage(), anMap.getX(), anMap.getY(), ann.width(), ann.height(), null);
                }
            }

            if (!map.DownLink().equals("null")){
                for (MapBase anMap : allMap){
                    IMap ann = anMap.getClass().getAnnotation(IMap.class);
                    if (!ann.mapName().equals(map.DownLink()))
                        continue;

                    if (anMap.isPositionInit() == false){
                        anMap.setY(map.height());
                        anMap.positionInit();
                    }
                    g.drawImage(anMap.getImage(), anMap.getX(), anMap.getY(), ann.width(), ann.height(), null);
                }
            }

            if (!map.LeftLink().equals("null")){
                for (MapBase anMap : allMap){
                    IMap ann = anMap.getClass().getAnnotation(IMap.class);
                    if (!ann.mapName().equals(map.LeftLink()))
                        continue;

                    if (anMap.isPositionInit() == false){
                        anMap.setX(-map.width());
                        anMap.positionInit();
                    }
                    g.drawImage(anMap.getImage(), anMap.getX(), anMap.getY(), ann.width(), ann.height(), null);
                }
            }

            if (!map.RightLink().equals("null")){
                for (MapBase anMap : allMap){
                    IMap ann = anMap.getClass().getAnnotation(IMap.class);
                    if (!ann.mapName().equals(map.RightLink()))
                        continue;

                    if (anMap.isPositionInit() == false){
                        anMap.setX(map.width());
                        anMap.positionInit();
                    }
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
    public void mapMove() {

        MapBase[] allMap = Constant.gameContentLoader.allMap;
        System.out.println("x = " + this.getX() + " y = " + this.getY());

        IMap map = this.getClass().getAnnotation(IMap.class);

        if (GameState.isInField == true) {
            if (map.mapName().equals(Player.player.getPlayerLocation())) {
                if (!isMoving()) {
                    if (Keys.UP.press() && !Keys.LEFT.press() && !Keys.RIGHT.press()) {
                        direction = "上";
                    } else if (Keys.DOWN.press() && !Keys.LEFT.press() && !Keys.RIGHT.press()) {
                        direction = "下";
                    } else if (Keys.LEFT.press()) {
                        direction = "左";
                    } else if (Keys.RIGHT.press()) {
                        direction = "右";
                    }
                }
                //doMoving();
            }

            if (!map.UpLink().equals("null")) {
                for (MapBase anMap : allMap) {
                    IMap ann = anMap.getClass().getAnnotation(IMap.class);
                    if (!ann.mapName().equals(map.UpLink()))
                        continue;
                    upLink = anMap;

                    //doMoving(anMap);
                }
            }

            if (!map.DownLink().equals("null")) {
                for (MapBase anMap : allMap) {
                    IMap ann = anMap.getClass().getAnnotation(IMap.class);
                    if (!ann.mapName().equals(map.DownLink()))
                        continue;
                    downLink = anMap;

                    //doMoving(anMap);
                }
            }

            if (!map.LeftLink().equals("null")) {
                for (MapBase anMap : allMap) {
                    IMap ann = anMap.getClass().getAnnotation(IMap.class);
                    if (!ann.mapName().equals(map.LeftLink()))
                        continue;
                    leftLink = anMap;

                    //doMoving(anMap);
                }
            }

            if (!map.RightLink().equals("null")) {
                for (MapBase anMap : allMap) {
                    IMap ann = anMap.getClass().getAnnotation(IMap.class);
                    if (!ann.mapName().equals(map.RightLink()))
                        continue;
                    rightLink = anMap;

                    //doMoving(anMap);
                }
            }
        }
    }
    public boolean isMoving() {
        if (moving != 0)
            return true;
        return false;
    }

    public void doMoving() {
        if (direction.equals("无"))
            return;

        if (moving < 26) {
            moving++;

            if (direction.equals("上")) {
                this.setY(this.getY() + 5);
                if (upLink != null)
                    upLink.setY(upLink.getY() + 5);
                if (downLink != null)
                    downLink.setY(downLink.getY() + 5);
                if (leftLink != null)
                    leftLink.setY(leftLink.getY() + 5);
                if (rightLink != null)
                    rightLink.setY(rightLink.getY() + 5);
            } else if (direction.equals("下")) {
                this.setY(this.getY() - 5);
                if (upLink != null)
                    upLink.setY(upLink.getY() - 5);
                if (downLink != null)
                    downLink.setY(downLink.getY() - 5);
                if (leftLink != null)
                    leftLink.setY(leftLink.getY() - 5);
                if (rightLink != null)
                    rightLink.setY(rightLink.getY() - 5);
            } else if (direction.equals("左")) {
                this.setX(this.getX() + 5);
                if (upLink != null)
                    upLink.setX(upLink.getX() + 5);
                if (downLink != null)
                    downLink.setX(downLink.getX() + 5);
                if (leftLink != null)
                    leftLink.setX(leftLink.getX() + 5);
                if (rightLink != null)
                    rightLink.setX(rightLink.getX() + 5);
            } else if (direction.equals("右")) {
                this.setX(this.getX() - 5);
                if (upLink != null)
                    upLink.setX(upLink.getX() - 5);
                if (downLink != null)
                    downLink.setX(downLink.getX() - 5);
                if (leftLink != null)
                    leftLink.setX(leftLink.getX() - 5);
                if (rightLink != null)
                    rightLink.setX(rightLink.getX() - 5);
            }
        } else {
            moving = 0;
            direction = "无";
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

    public boolean isPositionInit(){
        return false;
    }

    public void positionInit(){

    }

    public Image getImage(){
        return image;
    }
}
