package jdk.proxy;

import org.junit.Test;
import sun.security.action.GetBooleanAction;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.AccessController;

/**
 * Desc: java动态代理简例
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 16/8/20
 * Time: 下午3:02
 */
interface Booker {
    void book();
}

class TripTicketBooker implements Booker {

    @Override
    public void book() {
        System.out.println("book a trip ticket");
    }
}

class TransactionalInvocationHandler implements InvocationHandler {

    private Object target;

    TransactionalInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("begin transaction");
        Object object = method.invoke(target, args);
        System.out.println("end transaction");
        return object;
    }
}

public class DynamicProxyTest {


    @Test
    public void testDynamicProxy() {
        System.out.println(AccessController.doPrivileged(new GetBooleanAction("sun.misc.ProxyGenerator.saveGeneratedFiles")).booleanValue());
        Booker booker = new TripTicketBooker();
        Class clazz = booker.getClass();
        Booker bookerProxy = (Booker) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new TransactionalInvocationHandler(booker));
        bookerProxy.book();
    }
}
