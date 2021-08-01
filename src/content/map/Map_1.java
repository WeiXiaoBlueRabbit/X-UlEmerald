package content.map;

import common.gameInterface.interface_annotation.IMap;
import frame.Common;

import java.awt.*;

@IMap(mapName = "未白镇", UpLink = "101号公路"/*, RightLink = "map_3"*/)
public class Map_1 extends MapBase{

    private int x = 0;
    private int y = 0;
    private boolean positionInit = false;

    Image image = Common.getMapImage("wei_bai_zhen.png");

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
    public Image getImage() {
        return image;
    }
}
