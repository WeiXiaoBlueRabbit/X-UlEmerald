package content.menu;

import common.gameInterface.IDrawImage;
import content.GameState;
import frame.Keys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Menu implements IDrawImage {

    Image topImage = new ImageIcon("src/resources/image/enter_menu/top.png").getImage();
    Image centreImage = new ImageIcon("src/resources/image/enter_menu/centre.png").getImage();
    Image bottomImage = new ImageIcon("src/resources/image/enter_menu/bottom.png").getImage();

    Image atlasIcon = new ImageIcon("src/resources/image/enter_menu/atlas.png").getImage();
    Image pokemonIcon = new ImageIcon("src/resources/image/enter_menu/pokemon.png").getImage();
    Image bagIcon = new ImageIcon("src/resources/image/enter_menu/bag.png").getImage();
    Image playerIcon = new ImageIcon("src/resources/image/enter_menu/player.png").getImage();
    Image saveIcon = new ImageIcon("src/resources/image/enter_menu/save.png").getImage();
    Image settingIcon = new ImageIcon("src/resources/image/enter_menu/setting.png").getImage();
    Image exitIcon = new ImageIcon("src/resources/image/enter_menu/exit.png").getImage();

    Image arrowIcon = new ImageIcon("src/resources/image/enter_menu/arrow.png").getImage();

/*
    public static final int atlas = 1;
    public static final int pokemon = 2;
    public static final int bag = 3;
    public static final int player = 4;
    public static final int save = 5;
    public static final int setting = 6;
    public static final int exit = 7;

    public static Set<Integer> menuList;
*/

    public static List<MenuItem> menuList;
    public static final MenuItemAtlas atlas = new MenuItemAtlas(true);
    public static final MenuItemPokemon pokemon = new MenuItemPokemon(false);
    public static final MenuItemBag bag = new MenuItemBag(true);
    public static final MenuItemPlayer player = new MenuItemPlayer(true);
    public static final MenuItemSave save = new MenuItemSave(true);
    public static final MenuItemSetting setting = new MenuItemSetting(true);
    public static final MenuItemExit exit = new MenuItemExit(true);

    Graphics g;

    int x = 1335;
    int y = 6;
    int width = 560;
    int height = 98;
    int drawIndex;
    int selectIndex;

    public static Menu menu = new Menu();

    public Menu(){
        menuList = new ArrayList<>();
    }

    @Override
    public void drawImage(Graphics g) {
        this.g = g;
        if (GameState.isInField && Keys.ENTER.press()) {
            GameState.setGameState(GameState.menu);

            menuList.add(atlas);
            menuList.add(pokemon);
            menuList.add(bag);
            menuList.add(player);
            menuList.add(save);
            menuList.add(setting);
            menuList.add(exit);

            selectIndex = 1;
            Keys.remove(KeyEvent.VK_ENTER);
        }
        else if (GameState.isInMenu && Keys.ENTER.press() || GameState.isInMenu && Keys.X.press()) {
            GameState.setGameState(GameState.field);
            menuList.removeAll(menuList);
            Keys.remove(KeyEvent.VK_ENTER);
            Keys.remove(KeyEvent.VK_X);
        }

        if (GameState.isInMenu) {

            drawIndex = 2;

            g.drawImage(topImage,x,y,width,height,null);
            for (int a = 0;a != menuList.size();a++){
                g.drawImage(centreImage,x,y + ((a+1) * height),width,height,null);
            }
            //设置字体
            g.setFont(new Font("黑体", Font.PLAIN, 95));

            if (menuList.contains(atlas) && atlas.isShowInMenu()){
                g.drawImage(atlasIcon,x + 128,y + (drawIndex - 1) * height + 10,95,95,null);
                g.drawString("图鉴",x + 222,y + (drawIndex * height) - 10);
                drawIndex++;
            }else if (!atlas.isShowInMenu()){
                menuList.remove(atlas);
            }

            if (menuList.contains(pokemon) && pokemon.isShowInMenu()){
                g.drawImage(pokemonIcon,x + 128,y + (drawIndex - 1) * height + 10,95,95,null);
                g.drawString("宝可梦",x + 222,y + (drawIndex * height) - 10);
                drawIndex++;
            }else if (!pokemon.isShowInMenu()){
                menuList.remove(pokemon);
            }

            if (menuList.contains(bag) && bag.isShowInMenu()){
                g.drawImage(bagIcon,x + 128,y + (drawIndex - 1) * height + 10,95,95,null);
                g.drawString("背包",x + 222,y + (drawIndex * height) - 10);
                drawIndex++;
            }else if (!bag.isShowInMenu()){
                menuList.remove(bag);
            }

            if (menuList.contains(player) && player.isShowInMenu()){
                g.drawImage(playerIcon,x + 128,y + (drawIndex - 1) * height + 10,95,95,null);
                g.drawString("小茂",x + 222,y + (drawIndex * height) - 10);
                drawIndex++;
            }else if (!player.isShowInMenu()){
                menuList.remove(player);
            }

            if (menuList.contains(save) && save.isShowInMenu()){
                g.drawImage(saveIcon,x + 128,y + (drawIndex - 1) * height + 10,95,95,null);
                g.drawString("保存",x + 222,y + (drawIndex * height) - 10);
                drawIndex++;
            }else if (!save.isShowInMenu()){
                menuList.remove(save);
            }

            if (menuList.contains(setting) && setting.isShowInMenu()){
                g.drawImage(settingIcon,x + 128,y + (drawIndex - 1) * height + 10,95,95,null);
                g.drawString("设置",x + 222,y + (drawIndex * height) - 10);
                drawIndex++;
            }else if (!setting.isShowInMenu()){
                menuList.remove(setting);
            }

            if (menuList.contains(exit) && exit.isShowInMenu()){
                g.drawImage(exitIcon,x + 128,y + (drawIndex - 1) * height + 10,95,95,null);
                g.drawString("退出",x + 222,y + (drawIndex * height) - 10);
                drawIndex++;
            }else if (!exit.isShowInMenu()){
                menuList.remove(exit);
            }

            g.drawImage(bottomImage,x,y + ((menuList.size() + 1) * height),width,height,null);

            if (Keys.UP.press()){
                selectIndex--;
                if (selectIndex == 0)
                    selectIndex = menuList.size();
                Keys.remove(KeyEvent.VK_UP);
            }

            if (Keys.DOWN.press()){
                selectIndex++;
                if (selectIndex > menuList.size())
                    selectIndex = 1;
                Keys.remove(KeyEvent.VK_DOWN);
            }

            if (Keys.Z.press()){
                System.out.println(menuList);
                switch (selectIndex){
                    case 1:
                        menuList.get(0).drawImage(this.g);
                        break;

                    case 2:
                        menuList.get(1).drawImage(this.g);
                        break;

                    case 3:
                        menuList.get(2).drawImage(this.g);
                        break;

                    case 4:
                        menuList.get(3).drawImage(this.g);
                        break;

                    case 5:
                        menuList.get(4).drawImage(this.g);
                        break;

                    case 6:
                        menuList.get(5).drawImage(this.g);
                        break;

                    case 7:
                        menuList.get(6).drawImage(this.g);
                        break;
                    default:
                        break;
                }
            }

            g.drawImage(arrowIcon,x + 50,y + selectIndex * height + 25,70,70,null);
        }

    }
}

