package common;

/**
 * 给实体增加方向属性
 * */
public enum Direction {

    LEFT {
        @Override
        public boolean left() {
            return true;
        }
    },

    RIGHT {
        @Override
        public boolean right() {
            return true;
        }
    },

    UP {
        @Override
        public boolean up() {
            return true;
        }

    },

    DOWN {
        @Override
        public boolean down() {
            return true;
        }
    };

    public boolean left() {
        return false;
    }

    public boolean right() {
        return false;
    }

    public boolean up() {
        return false;
    }

    public boolean down() {
        return false;
    }
}
