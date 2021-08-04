package content;

public class GameState {

    public static boolean isInStart = false;//开始界面，选人物、起名
    public static boolean isInField = true;//在地图上，可走动、对话等
    public static boolean isInBattle = false;//在战斗中
    public static boolean isInMenu = false;//打开enter菜单
    public static boolean isInItemBag = false;//打开物品背包
    public static boolean isInPokemonBag = false;//打开宝可梦背包
    public static boolean isInAtlas = false;//查看图鉴
    public static boolean isInPlayerInfo = false;//查看玩家信息
    public static boolean isInSetting = false;//打开设置
    public static boolean isInDialogue = false;//对话中

    public static final int start = 1;
    public static final int field = 2;
    public static final int battle = 3;
    public static final int menu = 4;
    public static final int itemBag = 5;
    public static final int pokemonBag = 6;
    public static final int atlas = 7;
    public static final int playerInfo = 8;
    public static final int setting = 9;
    public static final int dialogue = 10;

    public static void setGameState(int state){
        switch (state){
            case start:
                isInStart = true;

                isInField = false;
                isInBattle = false;
                isInMenu = false;
                isInItemBag = false;
                isInPokemonBag = false;
                isInAtlas = false;
                isInPlayerInfo = false;
                isInSetting = false;
                isInDialogue = false;
                break;
            case field:
                isInStart = false;

                isInField = true;

                isInBattle = false;
                isInMenu = false;
                isInItemBag = false;
                isInPokemonBag = false;
                isInAtlas = false;
                isInPlayerInfo = false;
                isInSetting = false;
                isInDialogue = false;
                break;
            case battle:
                isInStart = false;
                isInField = false;

                isInBattle = true;

                isInMenu = false;
                isInItemBag = false;
                isInPokemonBag = false;
                isInAtlas = false;
                isInPlayerInfo = false;
                isInSetting = false;
                isInDialogue = false;
                break;
            case menu:
                isInStart = false;
                isInField = false;
                isInBattle = false;

                isInMenu = true;

                isInItemBag = false;
                isInPokemonBag = false;
                isInAtlas = false;
                isInPlayerInfo = false;
                isInSetting = false;
                isInDialogue = false;
                break;
            case itemBag:
                isInStart = false;
                isInField = false;
                isInBattle = false;
                isInMenu = false;

                isInItemBag = true;

                isInPokemonBag = false;
                isInAtlas = false;
                isInPlayerInfo = false;
                isInSetting = false;
                isInDialogue = false;
                break;
            case pokemonBag:
                isInStart = false;
                isInField = false;
                isInBattle = false;
                isInMenu = false;
                isInItemBag = false;

                isInPokemonBag = true;

                isInAtlas = false;
                isInPlayerInfo = false;
                isInSetting = false;
                isInDialogue = false;
                break;
            case atlas:
                isInStart = false;
                isInField = false;
                isInBattle = false;
                isInMenu = false;
                isInItemBag = false;
                isInPokemonBag = false;

                isInAtlas = true;

                isInPlayerInfo = false;
                isInSetting = false;
                isInDialogue = false;
                break;
            case playerInfo:
                isInStart = false;
                isInField = false;
                isInBattle = false;
                isInMenu = false;
                isInItemBag = false;
                isInPokemonBag = false;
                isInAtlas = false;

                isInPlayerInfo = true;

                isInSetting = false;
                isInDialogue = false;
                break;
            case setting:
                isInStart = false;
                isInField = false;
                isInBattle = false;
                isInMenu = false;
                isInItemBag = false;
                isInPokemonBag = false;
                isInAtlas = false;
                isInPlayerInfo = false;

                isInSetting = true;

                isInDialogue = false;
                break;
            case dialogue:
                isInStart = false;
                isInField = false;
                isInBattle = false;
                isInMenu = false;
                isInItemBag = false;
                isInPokemonBag = false;
                isInAtlas = false;
                isInPlayerInfo = false;
                isInSetting = false;

                isInDialogue = true;
                break;
            default:
                break;
        }
    }

}
