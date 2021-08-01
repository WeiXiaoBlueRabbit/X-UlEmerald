package content.map;

import common.gameInterface.interface_annotation.IMap;
import frame.Common;

import java.awt.*;

@IMap(mapName = "101号公路"/*, DownLink = "map_1"*/)
public class Map_2 extends MapBase{

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
