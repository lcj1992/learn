package jdk.proxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 16/8/20
 * Time: 下午3:02
 */
interface Booker {
    void book();
}

class BookerImpl implements Booker {

    private static int counter = 0;

    @Override
    public void book() {
        try {
            Thread.sleep(10);
            System.out.println("go to bookStore to buy a book, counter: " + (counter++));
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class BookerProxy implements InvocationHandler {

    private Object target;

    Object bind(Object target) {
        this.target = target;
        // 动态代理只针对接口,看下边的target.getClass().getInterfaces()
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("go to bookStore by bus");
        Object object = method.invoke(target, args);
        System.out.println("go home");
        return object;
    }
}

public class DynamicProxyTest {

    @Test
    public void dynamicProxyTest() throws InterruptedException {
        BookerProxy proxy = new BookerProxy();
        Booker booker = (Booker) proxy.bind(new BookerImpl());
        for (int i = 0; i < 1000; i++) Executors.newSingleThreadExecutor().execute(() -> booker.book());
        Thread.sleep(100000);
    }
}
