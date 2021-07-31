package common.gameInterface.interface_annotation;

import common.Direction;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface IElement {

    String NOTHING = "NOTHING";
    String value() default NOTHING;//图片

    Direction direction() default Direction.LEFT;//方向

    int width() default 50;//宽度

    int height() default 50;//高度
}
