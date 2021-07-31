package frame;

import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

public enum Keys {

    UP(KeyEvent.VK_UP),
    DOWN(KeyEvent.VK_DOWN),
    LEFT(KeyEvent.VK_LEFT),
    RIGHT(KeyEvent.VK_RIGHT),
    Z(KeyEvent.VK_Z),
    X(KeyEvent.VK_X),
    ENTER(KeyEvent.VK_ENTER),
    BACKSPACE(KeyEvent.VK_BACK_SPACE);

    private final static Set<Integer> keySet = new HashSet<>();//按键

    Keys(int keyValue) {
        this.keyValue = keyValue;
    }

    private int keyValue;//键值

    /**
     * 是否使用了某键
     *
     * @return
     */
    public boolean press() {
        return keySet.contains(keyValue);
    }

    /**
     * 添加按键
     *
     * @param keyCode
     */
    public static void add(int keyCode) {
        keySet.add(keyCode);
    }

    /**
     * 移除按键
     *
     * @param keyCode
     */
    public static void remove(int keyCode) {
        keySet.remove(keyCode);
    }
}
