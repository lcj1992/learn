package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2016/11/13
 * Time: 下午12:26
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
//        Test service = (Test) context.getBean("test");
//        System.out.println(service.getName());
        Test test    = new Test();
        System.out.println(test.getName());
    }
}
