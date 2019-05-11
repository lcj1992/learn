package classLoader;

import org.junit.Test;

import java.util.Date;

/**
 * Created by lcj on 15-5-16.
 */
public class ClassLoaderTest {

    @Test
    public void test() throws ClassNotFoundException, InterruptedException {
//        FileClassLoader fileClassLoader = new FileClassLoader("/home/lcj/work/simple/lcj-java/target/classes");
//        String className = "Apple";
//        Class clazz = fileClassLoader.loadClass(className);
//        System.out.println(clazz.getClassLoader());

        System.out.println(new Date(1252639886000L));

        String a = "abcdedfg";
        System.out.println(a.substring(0, 5));

        System.out.println(Runtime.getRuntime().maxMemory());

        Thread.sleep(10000000L);
    }


}
