package annotation;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Set;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2016/11/10
 * Time: 下午11:33
 */
public class ProcessorTest extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        // roundEnv.getElementsAnnotatedWith()返回使用给定注解类型的元素
        for (Element element : roundEnv.getElementsAnnotatedWith(MyAnnotation.class)) {
            System.out.println("------------------------------");
            // 判断元素的类型为Class
            if (element.getKind() == ElementKind.CLASS) {
                // 显示转换元素类型
                TypeElement typeElement = (TypeElement) element;
                // 输出元素名称
                System.out.println(typeElement.getSimpleName());
                // 输出注解属性值
                System.out.println(typeElement.getAnnotation(MyAnnotation.class).value());
            }
            System.out.println("------------------------------");
        }
        return false;
    }
}

/**
 * 编译时注解
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
@interface MyAnnotation {
    String value();
}
