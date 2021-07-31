package frame;

import common.gameInterface.IDrawImage;
import content.GameContentLoader;

import java.util.List;

//这里写一些乱七八糟的东西
public abstract class Constant {

    public static List<IDrawImage> mapList;
    /**由于会用到src/content/map/generator/MapGenerator.java方法中创建出的地图实例
     * 而GameContentLoader()方法又会运行MapGenerator.java中创建地图实例的方法
     * 所以在这里先new一份GameContentLoader来给其他需要用到地图实例的方法来使用
     * */
    public static GameContentLoader gameContentLoader = new GameContentLoader();
    public final static String RESOURCES_PATH = "src/resources/image/";//资源加载路径头

}
