package content.map;

import common.gameInterface.interface_annotation.IMap;
import frame.Common;

import java.awt.*;

@IMap(mapName = "map_3", LeftLink = "未白镇")
public class Map_3 extends MapBase{
    private int x = 0;
    private int y = 0;

    Image image = Common.getMapImage("101号公路.png");

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
    public Image getImage() {
        return image;
    }
}
