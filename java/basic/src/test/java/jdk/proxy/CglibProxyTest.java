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
 * Author:lichuangjian@meituan.com
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
    @Test
    public void cglibProxy() {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/lichuangjian/");
        TransactionalMethodInterceptor methodInterceptor = new TransactionalMethodInterceptor();
        CglibBooker cglibBooker = new CglibBooker();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(cglibBooker.getClass());
        enhancer.setCallback(methodInterceptor);
        CglibBooker bookerProxy = (CglibBooker) enhancer.create();
        bookerProxy.book();
    }
}
