package content.menu;

import java.awt.*;

class MenuItemBag extends MenuItem {

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
    public void drawImage(Graphics g) {

    }
}
