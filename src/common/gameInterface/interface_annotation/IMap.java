package common.gameInterface.interface_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface IMap {
    String mapName() default "null";
    
    String UpLink() default "null";

    String DownLink() default "null";

    String LeftLink() default "null";

    String RightLink() default "null";

    int x() default 0;

    int y() default 0;

    int width() default 2620;

    int height() default 2000;
}
