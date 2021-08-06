package content.player;

import common.EntityAttribute;
import common.gameInterface.interface_annotation.IElement;
import content.map.MapBase;
import frame.Keys;

import java.awt.*;

@IElement(value = "player.png", width = 131, height = 145)
public class Player extends EntityAttribute {

    protected PlayerState playerState;//玩家状态 (走路、跑步、骑车)
    protected String playerLocation;//玩家处于哪个地点
    protected Rectangle CollisionBox;

    //创建玩家实例
    public static Player player = new Player(786,232);
    public static Player player_2 = new Player(917,232);
    /**
    * 玩家初始位置
    * */
    public Player(int x, int y) {
        super(x,y);
        this.setCollisionBox(x,y);
        this.playerState = new PlayerState();
    }

    public String getPlayerLocation() {
        return playerLocation;
    }

    public void setPlayerLocation(String playerLocation) {
        this.playerLocation = playerLocation;
    }

    public void setCollisionBox(int x,int y){
        CollisionBox = new Rectangle(x + 25,y + 25,this.width - 50,this.height - 50);
    }

    public Rectangle getCollisionBox(){
        return CollisionBox;
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
    public void setX(int x) {
        this.setCollisionBox(x,this.y);
        super.setX(x);
    }

    @Override
    public void setY(int y) {
        this.setCollisionBox(this.x,y);
        super.setY(y);
    }

    @Override
    public void drawImage(Graphics g) {
        super.drawImage(g);
        this.playerState.drawImage(g);
    }
}
