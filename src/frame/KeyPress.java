package frame;

public class KeyPress {

    private boolean key_up;
    private boolean key_down;
    private boolean key_left;
    private boolean key_right;
    private boolean key_z;
    private boolean key_x;
    private boolean key_enter;
    private boolean key_backspace;

    //创建结构体，方便生成实例
    public KeyPress(){}

    //读取按键是否按下，按下返回true，未按下返回false，这里是为了方便日后的判断
    public boolean isKey_up() {
        return key_up;
    }

    public void setKey_up(boolean key_up) {
        this.key_up = key_up;
    }

    public boolean isKey_down() {
        return key_down;
    }

    public void setKey_down(boolean key_down) {
        this.key_down = key_down;
    }

    public boolean isKey_left() {
        return key_left;
    }

    public void setKey_left(boolean key_left) {
        this.key_left = key_left;
    }

    public boolean isKey_right() {
        return key_right;
    }

    public void setKey_right(boolean key_right) {
        this.key_right = key_right;
    }

    public boolean isKey_z() {
        return key_z;
    }

    public void setKey_z(boolean key_z) {
        this.key_z = key_z;
    }

    public boolean isKey_x() {
        return key_x;
    }

    public void setKey_x(boolean key_x) {
        this.key_x = key_x;
    }

    public boolean isKey_enter() {
        return key_enter;
    }

    public void setKey_enter(boolean key_enter) {
        this.key_enter = key_enter;
    }

    public boolean isKey_backspace() {
        return key_backspace;
    }

    public void setKey_backspace(boolean key_backspace) {
        this.key_backspace = key_backspace;
    }
}
