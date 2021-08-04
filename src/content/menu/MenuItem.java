package content.menu;

import common.gameInterface.IDrawImage;
import content.GameState;

import java.awt.*;

public class MenuItem implements IDrawImage {

    private boolean isShowInMenu;

    public boolean isShowInMenu(){
        return false;
    }

    public void setShowInMenu(boolean showInMenu) {
        isShowInMenu = showInMenu;
    }

    public void setGameState(){}

    @Override
    public void drawImage(Graphics g) {

    }
}
