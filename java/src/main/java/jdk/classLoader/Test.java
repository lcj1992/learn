package jdk.classLoader;

import java.util.Date;

/**
 * Created by lcj on 15-5-16.
 */
public class Test {

    public static void main(String[] args) throws ClassNotFoundException {
//        FileClassLoader fileClassLoader = new FileClassLoader("/home/lcj/work/simple/lcj-java/target/classes");
//        String className = "Apple";
//        Class clazz = fileClassLoader.loadClass(className);
//        System.out.println(clazz.getClassLoader());

        System.out.println(new Date(1252639886000L));

        String a = "abcdedfg";
        System.out.println(a.substring(0,5));
    }
}
