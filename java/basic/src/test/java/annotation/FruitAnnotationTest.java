package annotation;

import org.junit.Test;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * Created by lcj on 15-4-18.
 */

class Apple {

    @FruitName("Apple")
    private String appleName;

    @FruitColor(fruitColor = FruitColor.Color.RED)
    private String appleColor;

    @FruitProvider(id = 1, name = "陕西红富士集团", address = "陕西省西安市延安路89号红富士大厦")
    private String appleProvider;
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface FruitColor {

    // 颜色枚举
    enum Color {
        BLUE, RED, GREEN
    }

    // 颜色属性
    Color fruitColor() default Color.GREEN;

}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface FruitName {
    String value() default "";
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface FruitProvider {
    // 供应商id
    int id() default -1;

    // 供应商名称
    String name() default "";

    // 供应商地址
    String address() default "";
}

class FruitInfoUtil {

    static void getFruitInfo(Class<?> clazz) {
        String strFruitName = " 水果名称：";
        String strFruitColor = " 水果颜色：";
        String strFruitProvider = " 供应商信息：";

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(FruitName.class)) {
                FruitName fruitName = field.getAnnotation(FruitName.class);
                strFruitName = strFruitName + fruitName.value();
                System.out.println(strFruitName);
            } else if (field.isAnnotationPresent(FruitColor.class)) {
                FruitColor fruitColor = field.getAnnotation(FruitColor.class);
                strFruitColor = strFruitColor + fruitColor.fruitColor().toString();
                System.out.println(strFruitColor);
            } else if (field.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
                strFruitProvider = strFruitProvider + " 供应商编号：" + fruitProvider.id() + " 供应商名称：" + fruitProvider.name()
                        + " 供应商地址：" + fruitProvider.address();
                System.out.println(strFruitProvider);
            }
        }
    }
}

public class FruitAnnotationTest {

    @Test
    public void test() {
        Apple apple = new Apple();
        FruitInfoUtil.getFruitInfo(apple.getClass());
    }
}
