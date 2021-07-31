package common;

import common.gameInterface.IDrawImage;
import common.gameInterface.interface_annotation.IElement;
import content.player.Player;
import frame.Common;

import java.awt.*;

/**
 * 要想创建可以渲染到面板中的实体只需要继承该EntityAttribute
 * 并根据需要重写其方法即可
 *
 * 图片的载入等只需要添加注释头@IElement即可
 * 例子请看src/content/player/Player.java
 * */
public abstract class EntityAttribute implements IDrawImage {

    protected int x, y;//坐标
    protected int width, height;//大小
    protected Image image;//绘制图像 朝向为左

    protected Direction direction;//方向
    protected float xSpeed, ySpeed;//x轴与y轴的移动速度

    /*
    * 用于玩家
    * */
    public EntityAttribute(){
        this.width = 50;
        this.height = 50;
        this.direction = Direction.DOWN;
    }

    public EntityAttribute(int x, int y) {
        //只要继承该类，即可读取到到其添加的注解
        IElement element = this.getClass().getAnnotation(IElement.class);
        this.width = element.width();
        this.height = element.height();
        this.direction = element.direction();
        this.x = x;
        this.y = y;
        //图片处理
        String imageName = element.value();
        this.image = Common.getImage(imageName);
    }

    /**
     * 动作
     */
    public void action() {
        this.xMove();
        this.yMove();
    }

    /**
     * 水平移动
     */
    protected void xMove() {
        this.x += direction.right() ? xSpeed : -xSpeed;
    }

    /**
     * 竖直移动
     */
    protected void yMove() {
        this.y += direction.up() ? ySpeed : -ySpeed;
    }

    /**
     * 获取自身矩形
     *
     * @return
     */
    public Rectangle getRectangle() {
        return new Rectangle(this.x, this.y, this.width, this.height);
    }

    /**
     * 是否与矩形相交  这里的矩形可视为碰撞箱
     * @param element
     * @return
     */
    public <E extends EntityAttribute> boolean intersects(E element) {
        return this.getRectangle().intersects(element.getRectangle());
    }

    /**
     * 当元素满足自身离开条件时,从列表移除
     */
    public boolean remove(Player player) {
        return false;
    }


    @Override
    public void drawImage(Graphics g) {
        g.drawImage(this.getImage(), this.x, this.y, this.width, this.height, null);
    }

    protected Image getImage() {
        return image;
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

    public float getxSpeed() {
        return xSpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public int getWidth() {
        return width;
    }

    public Direction getDirection() {
        return direction;
    }
}
