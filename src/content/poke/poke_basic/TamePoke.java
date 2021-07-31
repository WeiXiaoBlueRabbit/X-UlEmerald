package content.poke.poke_basic;

public class TamePoke extends WildPoke{

    int ballType;
    //player player;   //关于player的类以后再创建

    public TamePoke(int level, int type, int status, int nature, int learn_point, int ballType /*, player player*/) {
        super(level, type, status, nature, learn_point);
    }

}
