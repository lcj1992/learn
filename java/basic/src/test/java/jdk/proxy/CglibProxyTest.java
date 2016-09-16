package jdk.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 16/8/20
 * Time: 下午3:31
 */
class BookProxyCglib implements MethodInterceptor {

    Object getInstance(Object target) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public Object intercept(Object obj, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("事务开始");
        methodProxy.invokeSuper(obj, objects);
        System.out.println("事务结束");
        System.out.println("-----------------");
        return null;
    }
}

class BookProxyImpl {
    synchronized void  addBook() {
        System.out.println("增加图书的普通方法...");
    }

    synchronized void borrow(){
        System.out.println("借阅一本书...");
    }
}

public class CglibProxyTest {
    @Test
    public void cglibProxy(){
        BookProxyCglib cglib = new BookProxyCglib();
        BookProxyImpl bookProxyImpl = (BookProxyImpl) cglib.getInstance(new BookProxyImpl());
        bookProxyImpl.addBook();
        bookProxyImpl.borrow();
    }
}
