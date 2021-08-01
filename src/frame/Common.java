package frame;

import common.gameInterface.ITimer;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Common {

    public static Image getMapImage(String imageName) {
        return new ImageIcon(Constant.RESOURCES_PATH + "map/" + imageName).getImage();
    }

    public static Image getPlayerImage(String imageName) {
        return new ImageIcon(Constant.RESOURCES_PATH + "player/" + imageName).getImage();
    }

    public static void task(long period, ITimer t) {
        java.util.Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                t.run();  //暂时无用
            }
        };
        //delay参数表示延迟多少毫秒后开始，period 参数表示间隔多少毫秒后执行依次
        timer.schedule(timerTask, 0, period);
    }
}
