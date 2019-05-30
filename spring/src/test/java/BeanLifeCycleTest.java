import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/29
 * Time: 下午11:47
 */
public class BeanLifeCycleTest {

    @Test
    public void testBeanLifeCycle() {


        ApplicationContext factory = new ClassPathXmlApplicationContext("spring-context.xml");

        Person person = factory.getBean("person", Person.class);

        ((ClassPathXmlApplicationContext) factory).registerShutdownHook();
    }
}
