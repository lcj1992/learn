package proxy;

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

class Booker2 {
    synchronized void book() {
        System.out.println("book a trip ticket");
    }
}

public class CglibProxyTest {

    @Test
    public void testCglibProxy() {
        String resourcePath = ClassLoader.getSystemResource("").toString().substring(5);
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, resourcePath);
        TransactionalMethodInterceptor methodInterceptor = new TransactionalMethodInterceptor();
        Booker2 booker = new Booker2();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(booker.getClass());
        enhancer.setCallback(methodInterceptor);
        Booker2 bookerProxy = (Booker2) enhancer.create();

        bookerProxy.book();
    }
}
