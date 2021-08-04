package content.menu;

import content.GameState;

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
    public void setGameState() {
        //GameState.setGameState(GameState.pokemonBag);
    }

    @Override
    public void drawImage(Graphics g) {

    }
}
