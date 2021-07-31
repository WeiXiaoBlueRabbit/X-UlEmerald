package common;

public class Amount {

    private int value;//初始值
    private int maxValue;//最大值
    private int minValue;//最小值

    public Amount(int value) {
        this(value, Integer.MAX_VALUE);
    }

    public Amount(int value, int maxValue) {
        this.value = value;
        this.maxValue = maxValue;
        this.minValue = 0;

    }

    /**
     * 数量是否正确 当数量大于最小值时表示正确
     *
     * @return
     */
    public boolean isCorrect() {
        return value > minValue;
    }

    /**
     * 按基数增加
     */
    public void add(int addValue) {
        //大于最大值时等于最大值
        int i = this.value + addValue;
        this.value = i < this.maxValue ? i : this.maxValue;
    }

    public int getValue() {
        return value;
    }
}
