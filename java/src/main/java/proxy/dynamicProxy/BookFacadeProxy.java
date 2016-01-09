package proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by lcj on 15-9-13.
 */
public class BookFacadeProxy implements InvocationHandler {

    private Object target;

    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
        //要绑定接口，java动态代理的缺陷
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object  result = null;
        System.out.println("事务开始");
        result = method.invoke(target,args);
        System.out.println("事务结束");
        return result;
    }
}
