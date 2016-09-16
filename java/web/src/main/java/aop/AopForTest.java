package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 16/9/13
 * Time: 上午10:57
 */
@Aspect
@Component
public class AopForTest {


    @Around("execution (* service.InnerService.*(..))")
    public Object xx(ProceedingJoinPoint pj) throws IllegalAccessException {
        Object[] args = pj.getArgs();
        for (Object arg : args) {
            if (arg instanceof Integer) {
                System.out.println((int) arg);
            }
            System.out.println(arg.getClass());
        }
        return new Object();
    }
}
