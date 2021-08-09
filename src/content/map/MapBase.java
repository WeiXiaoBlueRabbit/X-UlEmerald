package content.map;

import common.gameInterface.IDrawImage;
import common.gameInterface.interface_annotation.IMap;
import content.GameState;
import content.map.common.RewardBalls;
import content.player.Player;
import frame.Constant;
import frame.GameFrame;
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
    private boolean isRunning = false;
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

                g.drawImage(this.getImage(), this.getX(), this.getY(),
                        map.width() + (int)(Constant.scale_width*1.443) ,
                        map.height() + (int)(Constant.scale_height*1.942) , null);

            //绘制四个方向连接的地图，我只能想到这样了，如果有其他好方法的话请将其替换
            if (!map.UpLink().equals("null")){
                for (MapBase anMap : allMap){
                    IMap ann = anMap.getClass().getAnnotation(IMap.class);
                    if (!ann.mapName().equals(map.UpLink()))
                        continue;

                    if (anMap.isPositionInit() == false){
                        anMap.setY(-map.height() + this.getY());
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
                        anMap.setY(map.height() + this.getY());
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
                        anMap.setX(-map.width() + this.getX());
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
                        anMap.setX(map.width() + this.getX());
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

        IMap map = this.getClass().getAnnotation(IMap.class);

        if (GameState.isInField == true) {
            if (map.mapName().equals(Player.player.getPlayerLocation())) {
                if (!isMoving()) {
                    if (Keys.UP.press() && !Keys.LEFT.press() && !Keys.RIGHT.press()) {
                        Player.player.setCollisionBox(Player.player.getX(),Player.player.getY() - 99);
                        if (!Player.player.getCollisionBox().intersects(Player.player_2.getCollisionBox())
                                && !this.isCollision() || this.isTrap())
                            direction = "上";
                    } else if (Keys.DOWN.press() && !Keys.LEFT.press() && !Keys.RIGHT.press()) {
                        Player.player.setCollisionBox(Player.player.getX(),Player.player.getY() + 99);
                        if (!Player.player.getCollisionBox().intersects(Player.player_2.getCollisionBox())
                                && !this.isCollision() || this.isTrap())
                            direction = "下";
                    } else if (Keys.LEFT.press()) {
                        Player.player.setCollisionBox(Player.player.getX() - 130,Player.player.getY());
                        if (!Player.player.getCollisionBox().intersects(Player.player_2.getCollisionBox())
                                && !this.isCollision() || this.isTrap())
                            direction = "左";
                    } else if (Keys.RIGHT.press()) {
                        Player.player.setCollisionBox(Player.player.getX() + 130,Player.player.getY());
                        if (!Player.player.getCollisionBox().intersects(Player.player_2.getCollisionBox())
                                && !this.isCollision() || this.isTrap())
                            direction = "右";
                    }
                }
                doMoving();
                //System.out.println(map.mapName() + "  " + "x = " + this.getX() + " y = " + this.getY());
                System.out.println(this.getCollision().getBounds());
                System.out.println(Player.player.getCollisionBox().getBounds());
                System.out.println(this.isTrap());
            }

            if (!map.UpLink().equals("null")) {
                for (MapBase anMap : allMap) {
                    IMap ann = anMap.getClass().getAnnotation(IMap.class);
                    if (!ann.mapName().equals(map.UpLink()))
                        continue;
                    upLink = anMap;
                }
            }

            if (!map.DownLink().equals("null")) {
                for (MapBase anMap : allMap) {
                    IMap ann = anMap.getClass().getAnnotation(IMap.class);
                    if (!ann.mapName().equals(map.DownLink()))
                        continue;
                    downLink = anMap;

                }
            }

            if (!map.LeftLink().equals("null")) {
                for (MapBase anMap : allMap) {
                    IMap ann = anMap.getClass().getAnnotation(IMap.class);
                    if (!ann.mapName().equals(map.LeftLink()))
                        continue;
                    leftLink = anMap;

                }
            }

            if (!map.RightLink().equals("null")) {
                for (MapBase anMap : allMap) {
                    IMap ann = anMap.getClass().getAnnotation(IMap.class);
                    if (!ann.mapName().equals(map.RightLink()))
                        continue;
                    rightLink = anMap;

                }
            }
        }
    }
    public boolean isMoving() {
        if (moving != 0)
            return true;
        return false;
    }

    /***
     * 上下一格 = 100
     * 左右一格 = 131
     */
    public void doMoving() {
        if (direction.equals("无"))
            return;

        if (0 == moving) {
            if (Keys.X.press())
                isRunning = true;
            else isRunning = false;
        }

        if (moving < 15 && !isRunning) {
            moving++;

            if (moving == 15) {
                if (direction.equals("上")) {
                    this.setY(this.getY() + 2);
                    Player.player_2.setY(Player.player_2.getY() + 2);
                    if (upLink != null)
                        upLink.setY(upLink.getY() + 2);
                    if (downLink != null)
                        downLink.setY(downLink.getY() + 2);
                    if (leftLink != null)
                        leftLink.setY(leftLink.getY() + 2);
                    if (rightLink != null)
                        rightLink.setY(rightLink.getY() + 2);
                } else if (direction.equals("下")) {
                    this.setY(this.getY() - 2);
                    Player.player_2.setY(Player.player_2.getY() - 2);
                    if (upLink != null)
                        upLink.setY(upLink.getY() - 2);
                    if (downLink != null)
                        downLink.setY(downLink.getY() - 2);
                    if (leftLink != null)
                        leftLink.setY(leftLink.getY() - 2);
                    if (rightLink != null)
                        rightLink.setY(rightLink.getY() - 2);
                } else if (direction.equals("左")) {
                    this.setX(this.getX() + 5);
                    Player.player_2.setX(Player.player_2.getX() + 5);
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
                    Player.player_2.setX(Player.player_2.getX() - 5);
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
                if (direction.equals("上")) {
                    this.setY(this.getY() + 7);
                    Player.player_2.setY(Player.player_2.getY() + 7);
                    if (upLink != null)
                        upLink.setY(upLink.getY() + 7);
                    if (downLink != null)
                        downLink.setY(downLink.getY() + 7);
                    if (leftLink != null)
                        leftLink.setY(leftLink.getY() + 7);
                    if (rightLink != null)
                        rightLink.setY(rightLink.getY() + 7);
                } else if (direction.equals("下")) {
                    this.setY(this.getY() - 7);
                    Player.player_2.setY(Player.player_2.getY() - 7);
                    if (upLink != null)
                        upLink.setY(upLink.getY() - 7);
                    if (downLink != null)
                        downLink.setY(downLink.getY() - 7);
                    if (leftLink != null)
                        leftLink.setY(leftLink.getY() - 7);
                    if (rightLink != null)
                        rightLink.setY(rightLink.getY() - 7);
                } else if (direction.equals("左")) {
                    this.setX(this.getX() + 9);
                    Player.player_2.setX(Player.player_2.getX() + 9);
                    if (upLink != null)
                        upLink.setX(upLink.getX() + 9);
                    if (downLink != null)
                        downLink.setX(downLink.getX() + 9);
                    if (leftLink != null)
                        leftLink.setX(leftLink.getX() + 9);
                    if (rightLink != null)
                        rightLink.setX(rightLink.getX() + 9);
                } else if (direction.equals("右")) {
                    this.setX(this.getX() - 9);
                    Player.player_2.setX(Player.player_2.getX() - 9);
                    if (upLink != null)
                        upLink.setX(upLink.getX() - 9);
                    if (downLink != null)
                        downLink.setX(downLink.getX() - 9);
                    if (leftLink != null)
                        leftLink.setX(leftLink.getX() - 9);
                    if (rightLink != null)
                        rightLink.setX(rightLink.getX() - 9);
                }
            }
        } else if (moving < 8 && isRunning) {
            moving++;

            if (moving == 8) {
                if (direction.equals("上")) {
                    this.setY(this.getY() + 2);
                    Player.player_2.setY(Player.player_2.getY() + 2);
                    if (upLink != null)
                        upLink.setY(upLink.getY() + 2);
                    if (downLink != null)
                        downLink.setY(downLink.getY() + 2);
                    if (leftLink != null)
                        leftLink.setY(leftLink.getY() + 2);
                    if (rightLink != null)
                        rightLink.setY(rightLink.getY() + 2);
                } else if (direction.equals("下")) {
                    this.setY(this.getY() - 2);
                    Player.player_2.setY(Player.player_2.getY() - 2);
                    if (upLink != null)
                        upLink.setY(upLink.getY() - 2);
                    if (downLink != null)
                        downLink.setY(downLink.getY() - 2);
                    if (leftLink != null)
                        leftLink.setY(leftLink.getY() - 2);
                    if (rightLink != null)
                        rightLink.setY(rightLink.getY() - 2);
                } else if (direction.equals("左")) {
                    this.setX(this.getX() + 5);
                    Player.player_2.setX(Player.player_2.getX() + 5);
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
                    Player.player_2.setX(Player.player_2.getX() - 5);
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
                if (direction.equals("上")) {
                    this.setY(this.getY() + 14);
                    Player.player_2.setY(Player.player_2.getY() + 14);
                    if (upLink != null)
                        upLink.setY(upLink.getY() + 14);
                    if (downLink != null)
                        downLink.setY(downLink.getY() + 14);
                    if (leftLink != null)
                        leftLink.setY(leftLink.getY() + 14);
                    if (rightLink != null)
                        rightLink.setY(rightLink.getY() + 14);
                } else if (direction.equals("下")) {
                    this.setY(this.getY() - 14);
                    Player.player_2.setY(Player.player_2.getY() - 14);
                    if (upLink != null)
                        upLink.setY(upLink.getY() - 14);
                    if (downLink != null)
                        downLink.setY(downLink.getY() - 14);
                    if (leftLink != null)
                        leftLink.setY(leftLink.getY() - 14);
                    if (rightLink != null)
                        rightLink.setY(rightLink.getY() - 14);
                } else if (direction.equals("左")) {
                    this.setX(this.getX() + 18);
                    Player.player_2.setX(Player.player_2.getX() + 18);
                    if (upLink != null)
                        upLink.setX(upLink.getX() + 18);
                    if (downLink != null)
                        downLink.setX(downLink.getX() + 18);
                    if (leftLink != null)
                        leftLink.setX(leftLink.getX() + 18);
                    if (rightLink != null)
                        rightLink.setX(rightLink.getX() + 18);
                } else if (direction.equals("右")) {
                    this.setX(this.getX() - 18);
                    Player.player_2.setX(Player.player_2.getX() - 18);
                    if (upLink != null)
                        upLink.setX(upLink.getX() - 18);
                    if (downLink != null)
                        downLink.setX(downLink.getX() - 18);
                    if (leftLink != null)
                        leftLink.setX(leftLink.getX() - 18);
                    if (rightLink != null)
                        rightLink.setX(rightLink.getX() - 18);
                }
            }

        } else if (!Keys.UP.press() && !Keys.DOWN.press() && !Keys.LEFT.press() && !Keys.RIGHT.press()){
            moving = 0;
            direction = "无";
        } else {
            moving = 0;
            direction = "无";
            this.mapMove();
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

    public void positionInit(){}

    public boolean isCollision(){
        return false;
    }

    public boolean isTrap(){
        return false;
    }

    public Rectangle getCollision(){
        return null;
    }

    public Image getImage(){
        return image;
    }
}
