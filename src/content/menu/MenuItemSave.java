package content.menu;

import java.awt.*;

class MenuItemSave extends MenuItem {

    private boolean isShowInMenu;

    public MenuItemSave(boolean isShowInMenu){
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
