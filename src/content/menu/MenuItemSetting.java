package content.menu;

import content.GameState;

import java.awt.*;

class MenuItemSetting extends MenuItem {

    private boolean isShowInMenu;

    public MenuItemSetting(boolean isShowInMenu){
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
        //GameState.setGameState(GameState.setting);
    }

    @Override
    public void drawImage(Graphics g) {

    }
}
