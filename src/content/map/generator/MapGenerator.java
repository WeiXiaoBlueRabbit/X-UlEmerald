package content.map.generator;

import common.ClassLoaderUtils;
import common.gameInterface.IDrawImage;
import common.gameInterface.interface_annotation.IMap;
import content.map.MapBase;
import frame.Constant;

import java.awt.*;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class MapGenerator {
    private final static String MAP_PACKAGE = "content.map";//地图包路径
    private static List<IDrawImage> mapList;

    public static void run(){
        loadMapAnnotationList();
    }

    /**
     * 读取地图注解
     * */
    private static void loadMapAnnotationList(){
        mapList = new ArrayList<>();
        //加载指定路径中的所有类
        Set<Class<?>> classes = ClassLoaderUtils.loadClassByPackage(MAP_PACKAGE);
        classes.forEach(classType -> {
            //只有继承了MapBase的类才能参数后续步骤
            if (!MapBase.class.isAssignableFrom(classType)) {
                return;//是否为地图类
            }
            //获取注解
            IMap ann = classType.getAnnotation(IMap.class);
            if (ann == null) {
                return;//无IMap注解
            }
            Constructor<? extends MapBase> constructor;
            try {
                //获取类有Image参数的构造函数
                constructor = (Constructor<? extends MapBase>) classType.getConstructor();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                System.out.println("获取" + classType.getTypeName() + "构造器异常");
                return;
            }

            //给所有地图类创建实例
            ReadMapAnnotation rmann = new ReadMapAnnotation(ann, classType.getSimpleName(), constructor);
            createMapInstance(rmann);
        });
        //将所有map实例传到Constant.mapList以便使用
        Constant.mapList = mapList;
    }

    /**
     * 创建地图实例
     * */
    private static void createMapInstance(ReadMapAnnotation Annotation){

        MapBase map;
        try {
            map = Annotation.getConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("获取" + Annotation.getClassName() + "实例异常");
        }
        mapList.add(map);
    }
}
