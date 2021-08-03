package content.menu;

import java.awt.*;

class MenuItemPokemon extends MenuItem {

    private boolean isShowInMenu;

    public MenuItemPokemon(boolean isShowInMenu){
        this.isShowInMenu = isShowInMenu;
    }

    public boolean isShowInMenu() {
        return isShowInMenu;
    }

    public void setShowInMenu(boolean showInMenu) {
        isShowInMenu = showInMenu;
    }

    @Override
    public void drawImage(Graphics g) {

    }
}
