package frame;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import frame.KeyPress;

public class GameFrame extends JFrame {

    //创建按键实例，后面会用到，并且不应该再产生第二个按键实例，以后的按键的判断请直接调用该类下的key_press
    public KeyPress key_press = new KeyPress();

    //创建可视化窗体
    public GameFrame(){

        this.setTitle("poke");  //窗口标题
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //窗体退出方式
        this.setSize(500,500);  //窗体大小

        GamePanel panel = new GamePanel();  //创建一个面板，即图片,在Java中只有用new创建实例之后，程序才会分配内存给它
        this.add(panel);  //将上面创建出的实例加入到窗体中
        this.setVisible(true);   //窗体是否可见，true为可见

        /*在窗体中添加键盘监听事件，直接传入一个键盘监听实例
         * 底下的三个覆写是自动添加的，留着就行
         * */

        this.addKeyListener(new KeyListener() {

            //按键类型
            @Override
            public void keyTyped(KeyEvent e) {

            }

            //按键按下时
            @Override
            public void keyPressed(KeyEvent e) {

                //对应按下的按键，使先前定义的按键值发生改变，方便以后进行判断
                switch (e.getKeyCode()){
                    case KeyEvent.VK_UP :
                        key_press.setKey_up(true);
                        break;
                    case KeyEvent.VK_DOWN:
                        key_press.setKey_down(true);
                        break;
                    case KeyEvent.VK_LEFT:
                        key_press.setKey_left(true);
                        break;
                    case KeyEvent.VK_RIGHT:
                        key_press.setKey_right(true);
                        break;
                    case KeyEvent.VK_Z:
                        key_press.setKey_z(true);
                        break;
                    case KeyEvent.VK_X:
                        key_press.setKey_x(true);
                        break;
                    case KeyEvent.VK_ENTER:
                        key_press.setKey_enter(true);
                        break;
                    case KeyEvent.VK_BACK_SPACE:
                        key_press.setKey_backspace(true);
                        break;

                    default:
                        break;
                }
            }

            //按键松开时
            @Override
            public void keyReleased(KeyEvent e) {

                //松开后恢复按键值，方便以后进行判断
                switch (e.getKeyCode()){
                    case KeyEvent.VK_UP :
                        key_press.setKey_up(true);
                        break;
                    case KeyEvent.VK_DOWN:
                        key_press.setKey_down(true);
                        break;
                    case KeyEvent.VK_LEFT:
                        key_press.setKey_left(true);
                        break;
                    case KeyEvent.VK_RIGHT:
                        key_press.setKey_right(true);
                        break;
                    case KeyEvent.VK_Z:
                        key_press.setKey_z(true);
                        break;
                    case KeyEvent.VK_X:
                        key_press.setKey_x(true);
                        break;
                    case KeyEvent.VK_ENTER:
                        key_press.setKey_enter(true);
                        break;
                    case KeyEvent.VK_BACK_SPACE:
                        key_press.setKey_backspace(true);
                        break;

                    default:
                        break;
                }

            }
        });

    }
}
