package content.map.generator;

import common.gameInterface.interface_annotation.IMap;
import content.map.MapBase;

import java.lang.reflect.Constructor;

public class ReadMapAnnotation {

    private String mapName;
    private String UpLink;
    private String DownLink;
    private String LeftLink;
    private String RightLink;
    private String className;//类名，这个是为了在使用try抛出异常时找到是哪个文件出了问题
    private Constructor<? extends MapBase> constructor;//类构造器

    public ReadMapAnnotation(IMap mapAnnotation, String className, Constructor<? extends MapBase> constructor){
        this.mapName = mapAnnotation.mapName();
        this.UpLink = mapAnnotation.UpLink();
        this.DownLink = mapAnnotation.DownLink();
        this.LeftLink = mapAnnotation.LeftLink();
        this.RightLink = mapAnnotation.RightLink();
        this.className = className;
        this.constructor = constructor;
    }

    public String getMapName() {
        return mapName;
    }

    public String getUpLink() {
        return UpLink;
    }

    public String getDownLink() {
        return DownLink;
    }

    public String getLeftLink() {
        return LeftLink;
    }

    public String getRightLink() {
        return RightLink;
    }

    public String getClassName() {
        return className;
    }

    public Constructor<? extends MapBase> getConstructor() {
        return constructor;
    }
}
