package content.menu;

import common.gameInterface.IDrawImage;

import java.awt.*;

public class MenuItem implements IDrawImage {

    private boolean isShowInMenu;

    public boolean isShowInMenu(){
        return false;
    }

    public void setShowInMenu(boolean showInMenu) {
        isShowInMenu = showInMenu;
    }

    @Override
    public void drawImage(Graphics g) {

    }
}
