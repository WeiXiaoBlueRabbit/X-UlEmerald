package content.poke.poke_basic;

import java.util.ArrayList;

public class WildPoke extends PokeBasic{

    int level;
    int type;               //属性
    int status;             //状态
    int nature;             //性格

    //能力值
    int stat_HP;
    int stat_Attack;
    int stat_Defense;
    int stat_SPAttack;
    int stat_SPDefense;
    int stat_Speed;

    //个体值
    int IV_HP;
    int IV_Attack;
    int IV_Defense;
    int IV_SPAttack;
    int IV_SPDefense;
    int IV_Speed;

    //努力值
    int EV_HP;
    int EV_Attack;
    int EV_Defense;
    int EV_SPAttack;
    int EV_SPDefense;
    int EV_Speed;

    int learn_HP;        //学习力,击败宝可梦后获得的努力值
    int learn_Attack;
    int learn_Defense;
    int learn_SPAttack;
    int learn_SPDefense;
    int learn_Speed;

    //招式
    int move_1;
    int move_2;
    int move_3;
    int move_4;

    public WildPoke(int level, int type, int status, int nature, int learn_point, int value){

        this.setLevel(level);
        this.setType(type);
        this.setStatus(status);
        this.setNature(nature);
        this.setLearn_point(learn_point,value);

        this.SetStat(1,1,1,1,1,1); //暂定
        this.SetIV(0,0,0,0,0,0);           //暂定
        this.SetEV(0,0,0,0,0,0);        //暂定
    }

    //当需要设置野生宝可梦的能力值时使用
    public void SetStat(int stat_HP, int stat_Attack,int stat_Defense,
                        int stat_SPAttack,int stat_SPDefense,int stat_Speed){

        this.setStat(stat_HP);
        this.setStat(stat_Attack);
        this.setStat(stat_Defense);
        this.setStat(stat_SPAttack);
        this.setStat(stat_SPDefense);
        this.setStat(stat_Speed);
    }

    //设置IV时使用
    public void SetIV(int IV_HP,int IV_Attack,int IV_Defense,int IV_SPAttack,int IV_SPDefense,int IV_Speed){

    }

    //设置EV时使用
    public void SetEV(int EV_HP,int EV_Attack,int EV_Defense,int EV_SPAttack,int EV_SPDefense,int EV_Speed){

    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getNature() {
        return nature;
    }

    public void setNature(int nature) {
        this.nature = nature;
    }

    public int getStat(int slot) {      //只获取一个能力时使用
        switch (slot){
            case PokeBasic.stat_HP:
                return this.stat_HP;
            //还没添加完
            default:
                return 0;
        }
    }

    public void setStat(int stat) {
        switch (stat){
            case PokeBasic.stat_HP:
                this.stat_HP = stat;
                break;
            case PokeBasic.stat_Attack:
                this.stat_Attack = stat;
                break;
            //还没添加完
        }
    }

    public int getIV(int slot) {   //只获取一个IV时使用

        switch (slot){
            case PokeBasic.IV_HP:
                return  IV_HP;
            case PokeBasic.IV_Attack:
                return  IV_Attack;
            //还没添加完

            default:
                return 0;
        }
    }

    public ArrayList getAllIV(){  //获取所有IV时使用

        ArrayList all = new ArrayList();
        all.add(this.IV_HP);
        //还没添加完
        return all;
    }

    public void setIV(int slot, int value) {
        switch (slot){
            case PokeBasic.IV_HP:
                this.IV_HP = value;
                break;
            //还没添加完
        }
    }

    public int getEV(int slot) {    //只获取一个EV时使用
        switch (slot){
            case PokeBasic.EV_HP:
                return this.EV_HP;
            //还没添加完
            default:
                return 0;
        }
    }

    public ArrayList getAllEV(){

        ArrayList all = new ArrayList();
        all.add(EV_HP);
        //还没添加完
        return  all;
    }

    public void setEV(int slot,int value) {
        switch (slot){
            case PokeBasic.EV_HP:
                this.EV_HP = value;
                break;
            //还没添加完
        }
    }

/*
    *这个好像没什么用？

    public int getLearn_point(int learn_point_type) {

    }
*/

    public void setLearn_point(int learn_point_type,int value) {
        switch (learn_point_type){
            case PokeBasic.learn_HP:
                this.learn_HP = value;
                break;
            case PokeBasic.learn_Attack:
                this.learn_Attack = value;
                break;
            case PokeBasic.learn_Defense:
                this.learn_Defense = value;
                break;
            case PokeBasic.learn_SPAttack:
                this.learn_SPAttack = value;
                break;
            case PokeBasic.learn_SPDefense:
                this.learn_SPDefense = value;
                break;
            case PokeBasic.learn_Speed:
                this.learn_Speed = value;
                break;

            default:
                break;
        }
    }

    public int getMove(int slot) {
        switch (slot){
            case 1:
                return move_1;
            case 2:
                return move_2;
            case 3:
                return move_3;
            case 4:
                return move_4;

            default:
                return 0;
        }
    }

    public void setMove(int slot,int move) {
        switch (slot){
            case 1:
                this.move_1 = move;
                break;
            case 2:
                this.move_2 = move;
                break;
            case 3:
                this.move_3 = move;
                break;
            case  4:
                this.move_4 = move;
                break;

            default:
                break;
        }
    }

    //判断宝可梦是否拥有某招式
    public boolean isHaveMove(int move){
        if (this.move_1 == move|| this.move_2 == move|| this.move_3 == move||this.move_4 == move)
            return true;
        else
            return false;
    }

}
