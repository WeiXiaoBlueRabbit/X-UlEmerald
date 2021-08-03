package content.map;

import common.gameInterface.interface_annotation.IMap;
import frame.Common;

import java.awt.*;

@IMap(mapName = "map_3", LeftLink = "未白镇")
public class Map_3 extends MapBase{

    private int x = 0;
    private int y = 0;
    private boolean positionInit = false;

    Image image = Common.getMapImage("Road_101.png");

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

    @Override
    public boolean isPositionInit() {
        return this.positionInit;
    }

    @Override
    public void positionInit() {
        this.positionInit = true;
    }

    @Override
    public Image getImage() {
        return image;
    }
}
