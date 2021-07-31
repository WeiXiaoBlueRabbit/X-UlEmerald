package content.map;

import common.gameInterface.interface_annotation.IMap;
import content.map.common.RewardBalls;
import frame.Common;
import frame.Constant;

import java.awt.*;

@IMap(mapName = "map_3")
public class Map_3 extends MapBase{
    private int x = 0;
    private int y = 0;

    Image image = Common.getImage("poke.jpg");

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
