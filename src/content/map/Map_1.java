package content.map;

import common.gameInterface.interface_annotation.IMap;
import content.player.Player;
import frame.Common;

import java.awt.*;

@IMap(mapName = "未白镇"/*, UpLink = "101号公路", RightLink = "map_3"*/)
public class Map_1 extends MapBase{

    private int x = 0;
    private int y = 0;
    private boolean positionInit = false;

    Image image = Common.getMapImage("wei_bai_zhen.png");

    //障碍物
    Rectangle buildings_1 = new Rectangle(0,-100,131 * 5,100 * 4);

    //陷阱、门等
    Rectangle buildings_1_door = new Rectangle(131,300,131,100);

    public int getX() {
        return x;
    }

    @Override
    public boolean isPositionInit() {
        return this.positionInit;
    }

    @Override
    public void positionInit() {
        this.positionInit = true;
    }



    @Override
    public Rectangle getCollision() {
        return this.buildings_1_door;
    }

    public void setX(int x) {
        buildings_1.setLocation(x + 524, this.y + 400);
        buildings_1_door.setLocation(x + 655,this.y + 800);
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        buildings_1.setLocation(this.x + 524, y + 400);
        buildings_1_door.setLocation(this.x + 655,y + 800);
        this.y = y;
    }

    @Override
    public Image getImage() {
        return image;
    }
}
