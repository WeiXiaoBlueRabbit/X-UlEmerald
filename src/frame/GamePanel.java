package frame;

import common.gameInterface.IDrawImage;

import javax.swing.*;
import java.awt.*;

//测试用
public class GamePanel extends JPanel {

    IDrawImage[] draws;
    private Image image;//缓冲
    private Image image_1 = Common.getImage("map_1.jpg");//背景图片

    public GamePanel(IDrawImage... draws) {
        this.draws = draws;
    }
    /**
     * 绘制缓冲
     */
    private void drawBufferedImage() {
        image = createImage(this.getWidth(), this.getHeight());
        Graphics g = image.getGraphics();
        g.drawImage(image_1, 0, 0, this.getWidth(), this.getHeight(), this);
        //绘制
        for (IDrawImage draw : this.draws) {
            draw.drawImage(g);
        }
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawBufferedImage();
        g.drawImage(image, 0, 0, this);
    }
}
