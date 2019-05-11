package jdk.proxy;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * Desc: cglib动态代理简例
 * ------------------------------------
 * Author:foolchild
 * Date: 16/8/20
 * Time: 下午3:31
 */
class TransactionalMethodInterceptor implements MethodInterceptor {

    public Object intercept(Object obj, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("begin transaction");
        Object result = methodProxy.invokeSuper(obj, objects);
        System.out.println("end transaction");
        return result;
    }
}

class CglibBooker {
    synchronized void book() {
        System.out.println("book a trip ticket");
    }
}

public class CglibProxyTest {
    public static void main(String[] args) {
        String resourcePath = ClassLoader.getSystemResource("").toString().substring(5);
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, resourcePath);
        TransactionalMethodInterceptor methodInterceptor = new TransactionalMethodInterceptor();
        CglibBooker cglibBooker = new CglibBooker();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(cglibBooker.getClass());
        enhancer.setCallback(methodInterceptor);
        CglibBooker bookerProxy = (CglibBooker) enhancer.create();
        bookerProxy.book();
    }
}
