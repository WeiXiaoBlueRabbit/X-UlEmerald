package content.menu;

import content.GameState;

import java.awt.*;

class MenuItemPlayer extends MenuItem {

    private boolean isShowInMenu;

    public MenuItemPlayer(boolean isShowInMenu){
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
        //GameState.setGameState(GameState.playerInfo);
    }

    @Override
    public void drawImage(Graphics g) {

    }
}
