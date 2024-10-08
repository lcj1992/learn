package proxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Desc: java动态代理简例
 * ------------------------------------
 * Author:foolchild
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
        Booker booker = new TripTicketBooker();
        Class clazz = booker.getClass();
        Booker bookerProxy = (Booker) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new TransactionalInvocationHandler(booker));
        bookerProxy.book();
    }
}
