package content.menu;

import content.GameState;

import java.awt.*;

class MenuItemAtlas extends MenuItem {

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
        //GameState.setGameState(GameState.atlas);
    }

    @Override
    public void drawImage(Graphics g) {

    }
}
