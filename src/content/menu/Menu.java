package content.menu;

import common.gameInterface.IDrawImage;
import content.GameState;
import frame.Keys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashSet;
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

    public static final int atlas = 1;
    public static final int pokemon = 2;
    public static final int bag = 3;
    public static final int player = 4;
    public static final int save = 5;
    public static final int setting = 6;
    public static final int exit = 7;

    public static Set<Integer> menuList;

    int x = 1335;
    int y = 6;
    int width = 560;
    int height = 98;
    int drawIndex;
    int selectIndex;

    public static Menu menu = new Menu();

    public Menu(){
        menuList = new HashSet<>();

        menuList.add(atlas);
        menuList.add(pokemon);
        menuList.add(bag);
        menuList.add(player);
        menuList.add(save);
        menuList.add(setting);
        menuList.add(exit);
    }

    @Override
    public void drawImage(Graphics g) {
        if (GameState.isInField && Keys.ENTER.press()) {
            GameState.setGameState(GameState.menu);
            selectIndex = 1;
            Keys.remove(KeyEvent.VK_ENTER);
        }
        else if (GameState.isInMenu && Keys.ENTER.press() || GameState.isInMenu && Keys.X.press()) {
            GameState.setGameState(GameState.field);
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

            if (menuList.contains(atlas)){
                g.drawImage(atlasIcon,x + 128,y + (drawIndex - 1) * height + 10,95,95,null);
                g.drawString("图鉴",x + 222,y + (drawIndex * height) - 10);
                drawIndex++;
            }

            if (menuList.contains(pokemon)){
                g.drawImage(pokemonIcon,x + 128,y + (drawIndex - 1) * height + 10,95,95,null);
                g.drawString("宝可梦",x + 222,y + (drawIndex * height) - 10);
                drawIndex++;
            }

            if (menuList.contains(bag)){
                g.drawImage(bagIcon,x + 128,y + (drawIndex - 1) * height + 10,95,95,null);
                g.drawString("背包",x + 222,y + (drawIndex * height) - 10);
                drawIndex++;
            }

            if (menuList.contains(player)){
                g.drawImage(playerIcon,x + 128,y + (drawIndex - 1) * height + 10,95,95,null);
                g.drawString("小茂",x + 222,y + (drawIndex * height) - 10);
                drawIndex++;
            }

            if (menuList.contains(save)){
                g.drawImage(saveIcon,x + 128,y + (drawIndex - 1) * height + 10,95,95,null);
                g.drawString("保存",x + 222,y + (drawIndex * height) - 10);
                drawIndex++;
            }

            if (menuList.contains(setting)){
                g.drawImage(settingIcon,x + 128,y + (drawIndex - 1) * height + 10,95,95,null);
                g.drawString("设置",x + 222,y + (drawIndex * height) - 10);
                drawIndex++;
            }

            if (menuList.contains(exit)){
                g.drawImage(exitIcon,x + 128,y + (drawIndex - 1) * height + 10,95,95,null);
                g.drawString("退出",x + 222,y + (drawIndex * height) - 10);
                drawIndex++;
            }

            g.drawImage(bottomImage,x,y + ((menuList.size()+1) * height),width,height,null);

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
                switch (selectIndex){

                    case 1:
                        if (menuList.contains(atlas)){
                            // TODO 调用图鉴的方法
                            break;
                        }else if (menuList.contains(pokemon)){
                            // TODO 调用宝可梦背包的方法
                            break;
                        }else if (menuList.contains(bag)){
                            // TODO 背包
                            break;
                        } else if (menuList.contains(player)){
                            // TODO 玩家信息
                            break;
                        }else if (menuList.contains(save)){
                            // TODO 保存
                            break;
                        }else if (menuList.contains(setting)){
                            // TODO 设置
                            break;
                        }else if (menuList.contains(exit)){
                            GameState.setGameState(GameState.field);
                            Keys.remove(KeyEvent.VK_Z);
                            break;
                        }
                        break;
                    case 2:
                        if (menuList.contains(pokemon)){
                            // TODO 调用宝可梦背包的方法
                            break;
                        }else if (menuList.contains(bag)){
                            // TODO 背包
                            break;
                        } else if (menuList.contains(player)){
                            // TODO 玩家信息
                            break;
                        }else if (menuList.contains(save)){
                            // TODO 保存
                            break;
                        }else if (menuList.contains(setting)){
                            // TODO 设置
                            break;
                        }else if (menuList.contains(exit)){
                            GameState.setGameState(GameState.field);
                            Keys.remove(KeyEvent.VK_Z);
                            break;
                        }
                        break;
                    case 3:
                        if (menuList.contains(bag)){
                            // TODO 背包
                            break;
                        } else if (menuList.contains(player)){
                            // TODO 玩家信息
                            break;
                        }else if (menuList.contains(save)){
                            // TODO 保存
                            break;
                        }else if (menuList.contains(setting)){
                            // TODO 设置
                            break;
                        }else if (menuList.contains(exit)){
                            GameState.setGameState(GameState.field);
                            Keys.remove(KeyEvent.VK_Z);
                            break;
                        }
                        break;
                    case 4:
                        if (menuList.contains(player)){
                            // TODO 玩家信息
                            break;
                        }else if (menuList.contains(save)){
                            // TODO 保存
                            break;
                        }else if (menuList.contains(setting)){
                            // TODO 设置
                            break;
                        }else if (menuList.contains(exit)){
                            GameState.setGameState(GameState.field);
                            Keys.remove(KeyEvent.VK_Z);
                            break;
                        }
                        break;
                    case 5:
                        if (menuList.contains(save)){
                            // TODO 保存
                            break;
                        }else if (menuList.contains(setting)){
                            // TODO 设置
                            break;
                        }else if (menuList.contains(exit)){
                            GameState.setGameState(GameState.field);
                            Keys.remove(KeyEvent.VK_Z);
                            break;
                        }
                        break;
                    case 6:
                        if (menuList.contains(setting)){
                            // TODO 设置
                            break;
                        }else if (menuList.contains(exit)){
                            GameState.setGameState(GameState.field);
                            Keys.remove(KeyEvent.VK_Z);
                            break;
                        }
                        break;
                    case 7:
                        if (menuList.contains(exit)){
                            GameState.setGameState(GameState.field);
                            Keys.remove(KeyEvent.VK_Z);
                            break;
                        }
                    default:
                        break;
                }
            }

            g.drawImage(arrowIcon,x + 50,y + selectIndex * height + 25,70,70,null);
        }

    }
}
