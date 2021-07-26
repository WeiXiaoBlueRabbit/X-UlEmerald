package frame;

import javax.swing.*;
import java.awt.*;

//测试用
public class GamePanel extends JPanel {

    @Override
    public void paint(Graphics g) {
        super.paint(g);  //覆写必须要写super来调用父类方法
        Image image = new ImageIcon("src/resources/image/poke.jpg").getImage();  //加载图片
        g.drawImage( image,50,50,100,100,null);  //图片在窗体中的大小
    }
}
