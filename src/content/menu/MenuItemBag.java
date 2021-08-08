package content.menu;

import content.GameState;
import frame.GameFrame;
import frame.Keys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

class MenuItemBag extends MenuItem {

    private final int BAG1 = 0;
    private final int BAG2 = 1;
    private final int BAG3 = 2;
    private final int BAG4 = 3;
    private final int BAG5 = 4;

    private int bagId;
    Image bag1 = new ImageIcon("src/resources/image/enter_menu/bag/bag1.png").getImage();
    Image bag2 = new ImageIcon("src/resources/image/enter_menu/bag/bag2.png").getImage();
    Image bag3 = new ImageIcon("src/resources/image/enter_menu/bag/bag3.png").getImage();
    Image bag4 = new ImageIcon("src/resources/image/enter_menu/bag/bag4.png").getImage();
    Image bag5 = new ImageIcon("src/resources/image/enter_menu/bag/bag5.png").getImage();
    Image[] bags = {bag1, bag2, bag3, bag4, bag5};

    private boolean isShowInMenu;

    public MenuItemBag(boolean isShowInMenu){
        this.isShowInMenu = isShowInMenu;
    }

    public boolean isShowInMenu() {
        return isShowInMenu;
    }

    public void setShowInMenu(boolean showInMenu) {
        isShowInMenu = showInMenu;
    }

    @Override
    public void setGameState() {
        GameState.setGameState(GameState.itemBag);
    }

    @Override
    public void drawImage(Graphics g) {
        if (GameState.isInItemBag) {
            g.drawImage(bags[bagId],0,0, GameFrame.screenSize.width,GameFrame.screenSize.height,null);
            if (Keys.LEFT.press()){
                if (bagId > BAG1)
                    bagId--;
                else bagId = BAG5;
                Keys.remove(KeyEvent.VK_LEFT);
            }

            if (Keys.RIGHT.press()){
                if (bagId < BAG5)
                    bagId++;
                else bagId = BAG1;
                Keys.remove(KeyEvent.VK_RIGHT);
            }

            if (Keys.Z.press()) {
                // TODO 选定道具
                Keys.remove(KeyEvent.VK_Z);
            }

            if (Keys.UP.press()) {
                // TODO 上一个道具
                Keys.remove(KeyEvent.VK_Z);
            }

            if (Keys.DOWN.press()) {
                // TODO 下一个道具
                Keys.remove(KeyEvent.VK_Z);
            }

            if (Keys.X.press()){
                //退出的过渡动画以后再做，退出前记得更改GameState,重新退回菜单界面
                GameState.setGameState(GameState.menu);
                Keys.remove(KeyEvent.VK_X);
            }
        }
    }
}
