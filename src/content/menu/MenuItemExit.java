package content.menu;

import content.GameState;
import frame.Keys;

import java.awt.*;
import java.awt.event.KeyEvent;

class MenuItemExit extends MenuItem {

    private boolean isShowInMenu;

    public MenuItemExit(boolean isShowInMenu){
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
        GameState.setGameState(GameState.field);
        Menu.menuList.removeAll(Menu.menuList);
        Keys.remove(KeyEvent.VK_ENTER);
    }

}
