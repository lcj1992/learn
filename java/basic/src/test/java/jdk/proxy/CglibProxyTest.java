package jdk.proxy;

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
    synchronized void addBook() {
        System.out.println("增加图书的普通方法...");
    }

    synchronized void borrow() {
        System.out.println("借阅一本书...");
    }
}

public class CglibProxyTest {
    @Test
    public void cglibProxy() {
        TransactionalMethodInterceptor methodInterceptor = new TransactionalMethodInterceptor();
        CglibBooker cglibBooker = new CglibBooker();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(cglibBooker.getClass());
        enhancer.setCallback(methodInterceptor);
        CglibBooker bookerProxy = (CglibBooker) enhancer.create();
        bookerProxy.addBook();
        bookerProxy.borrow();
    }
}
