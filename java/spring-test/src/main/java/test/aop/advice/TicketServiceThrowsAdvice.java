package test.aop.advice;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2017/6/18
 * Time: 上午9:25
 */
public class TicketServiceThrowsAdvice implements ThrowsAdvice {
    public void afterThrowing(Exception ex) {
        System.out.println("after throwing .....");
    }

    public void afterThrowing(Method method, Object[] args, Object target, Exception ex){
        System.out.println("调用过程出错啦！！！！！");
    }
}
