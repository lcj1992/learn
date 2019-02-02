package test.aop.advice;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2017/6/18
 * Time: 上午9:27
 */
public class TicketServiceAroundAdvice  implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("AROUND_ADVICE:BEGIN....");
        Object returnValue = invocation.proceed();
        System.out.println("AROUND_ADVICE:END.....");
        return returnValue;
    }
}
