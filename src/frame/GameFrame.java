package frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import common.gameInterface.IDrawImage;
import content.GameContentLoader;
import content.GameState;
import content.map.MapBase;
import content.menu.Menu;
import content.player.Player;

public class GameFrame extends JFrame {

    //获取整个屏幕大小
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    //创建可视化窗体
    public GameFrame(){

        this.setTitle("poke");  //窗口标题
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //窗体退出方式
        //this.setResizable(false);//固定窗体

        //获取屏幕边界，其中的bottom为底部任务栏高度
        Insets screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(this.getGraphicsConfiguration());
        this.setSize(screenSize.width,screenSize.height - screenInsets.bottom);  //窗体大小

        this.init();

    }

    private void init(){
        //玩家
        Player player = Player.player;
        //设置初始位置
        player.setPlayerLocation("未白镇");
/************************下面这些不用管 *********************************************/
        List<IDrawImage> all = Constant.mapList;
        all.add(player);
        all.add(Constant.gameContentLoader);
        all.add(Menu.menu);

        all.add(Menu.atlas);//添加图鉴渲染
        all.add(Menu.pokemon);//添加宝可梦背包渲染
        all.add(Menu.bag);//添加物品背包渲染
        all.add(Menu.player);//添加玩家渲染
        all.add(Menu.setting);//添加设置渲染

        IDrawImage[] allImage = new IDrawImage[all.size()];
        all.toArray(allImage);
/********************************************************************/
        GamePanel panel = new GamePanel(allImage); //创建面板实例并将player添加进面板
        add(panel);  //将上面创建出的面板实例加入到窗体中
        this.setVisible(true);   //窗体是否可见，true为可见

        //刷新面板（重新绘制）
        Common.task(5, () -> {
            panel.repaint();
        });

        /*在窗体中添加键盘监听事件，直接传入一个键盘监听实例
         * 底下的三个覆写是自动添加的，留着就行
         */
        this.addKeyListener(new KeyListener() {

            //按键类型
            @Override
            public void keyTyped(KeyEvent e) {

            }

            //按键按下时
            @Override
            public void keyPressed(KeyEvent e) {
                Keys.add(e.getKeyCode());
            }

            //按键松开时
            @Override
            public void keyReleased(KeyEvent e) {
                Keys.remove(e.getKeyCode());
            }
        });
    }
}
