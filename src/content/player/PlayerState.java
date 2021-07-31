package content.player;

import common.Amount;
import common.gameInterface.IDrawImage;

import java.awt.*;

public class PlayerState implements IDrawImage {

    protected Amount poke_amount = new Amount(0, 6);//宝可梦数量
    protected Amount money_amount = new Amount(0);//金钱数量
    protected Amount badge_amount = new Amount(0);//徽章数量
    protected Amount item_amount = new Amount(0);//物品数量

    //背包有多少个分类来着？
    //protected Amount item2_amount = new Amount(0);//物品数量
    //protected Amount item3_amount = new Amount(0);//物品数量
    //protected Amount item4_amount = new Amount(0);//物品数量

    @Override
    public void drawImage(Graphics g) {

    }
}
