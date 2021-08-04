package content.menu;

import content.GameState;
import frame.GameFrame;
import frame.Keys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

class MenuItemAtlas extends MenuItem {

    Image image = new ImageIcon("src/resources/image/enter_menu/atlas/summary.png").getImage();
    private boolean isShowInMenu;

    public MenuItemAtlas(boolean isShowInMenu){
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
        //我在每个元素里都写了底下这个，使用前把双斜杠去掉就可以了
        GameState.setGameState(GameState.atlas);
    }

    @Override
    public void drawImage(Graphics g) {
        //这个判断很重要
        if (GameState.isInAtlas){
            g.drawImage(this.image,0,0, GameFrame.screenSize.width,GameFrame.screenSize.height,null);
            if (Keys.UP.press()){
                // TODO
                Keys.remove(KeyEvent.VK_UP);//防止按一次移动太多
            }

            if (Keys.DOWN.press()){
                // TODO
                Keys.remove(KeyEvent.VK_DOWN);
            }

            if (Keys.LEFT.press()){
                // TODO  按左好像是一次往前推7格
                Keys.remove(KeyEvent.VK_LEFT);
            }

            if (Keys.RIGHT.press()){
                // TODO  往后推7格
                Keys.remove(KeyEvent.VK_RIGHT);
            }

            if (Keys.ENTER.press()){
                // TODO  从下往上出现一个界面
                Keys.remove(KeyEvent.VK_ENTER);
            }

            if (Keys.Z.press()){
                // TODO
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
