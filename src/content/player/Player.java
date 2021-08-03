package content.player;

import common.EntityAttribute;
import common.gameInterface.interface_annotation.IElement;
import content.map.MapBase;
import frame.Keys;

import java.awt.*;

@IElement(value = "player.png", width = 130, height = 145)
public class Player extends EntityAttribute {

    protected PlayerState playerState;//玩家状态 (走路、跑步、骑车)
    protected String playerLocation;//玩家处于哪个地点

    //创建玩家实例
    public static Player player = new Player();
    /**
    * 玩家初始位置
    * */
    public Player() {
        super(100, 100);
        this.playerState = new PlayerState();
    }

    public String getPlayerLocation() {
        return playerLocation;
    }

    public void setPlayerLocation(String playerLocation) {
        this.playerLocation = playerLocation;
    }

    public PlayerState getPlayerState() {
        return playerState;
    }

    public void setPlayerState(PlayerState playerState) {
        this.playerState = playerState;
    }

    /**
     * 覆写action方法从而实现玩家的动作行为
     * */
    @Override
    public void action() {
        // TODO
        /**
        if (Keys.UP.press() && !Keys.LEFT.press() && !Keys.RIGHT.press())
            this.y--;
        if (Keys.DOWN.press() && !Keys.LEFT.press() && !Keys.RIGHT.press())
            this.y++;
        if (Keys.LEFT.press())
            this.x--;
        if (Keys.RIGHT.press())
            this.x++;
         */
        super.action();
    }

     // 考虑要不要将xMove方法与xMove方法合并进action方法中

    @Override
    protected void xMove() {

    }

    @Override
    protected void yMove() {

    }

    @Override
    public void drawImage(Graphics g) {
        super.drawImage(g);
        this.playerState.drawImage(g);
    }
}
