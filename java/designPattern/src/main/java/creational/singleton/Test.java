package creational.singleton;

import creational.singleton.lazyInit.SimpleVersion;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2017/7/2
 * Time: 下午5:21
 */
public class Test {


    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        SimpleVersion singleton = SimpleVersion.getInstance();
        MyClassLoader myClassLoader = new MyClassLoader("myClassLoader");
        myClassLoader.setClassPath("/Users/lichuangjian/work/learn/java/designPattern/target/classes");
        Class singletonClass = myClassLoader.findClass("creational.singleton.lazyInit.SimpleVersion");
        System.out.println("singletonClass.getClassLoader() : " + singletonClass.getClassLoader());
        System.out.println("Singleton.class==singletonClass : " + (SimpleVersion.class == singletonClass));
        System.out.println("Singleton.class.equals(singletonClass) : " + (SimpleVersion.class.equals(singletonClass)));
        Constructor constructor1 = SimpleVersion.class.getDeclaredConstructor();
        Constructor constructor2 = SimpleVersion.class.getDeclaredConstructor();
        Constructor constructor3 = singletonClass.getDeclaredConstructor();
        System.out.println("constructor1==constructor2 : " + (constructor1 == constructor2));
        System.out.println("constructor1.equals(constructor2) : " + constructor1.equals(constructor2));
        System.out.println("constructor1==constructor : " + (constructor1 == constructor3));
        System.out.println("constructor1.equals(constructor3) : " + constructor1.equals(constructor3));
        constructor1.setAccessible(true);
        Object singleton1 = constructor1.newInstance();
        constructor2.setAccessible(true);
        Object singleton2 = constructor2.newInstance();
        constructor3.setAccessible(true);
        Object singleton3 = constructor3.newInstance();
        System.out.println("singleton : " + singleton);
        System.out.println("singleton1 : " + singleton1);
        System.out.println("singleton2 : " + singleton2);
        System.out.println("singleton3 : " + singleton3);
    }
}
