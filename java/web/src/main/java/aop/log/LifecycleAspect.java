package aop.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2017/2/10
 * Time: 下午2:55
 */
@Aspect
@Component
public class LifecycleAspect {

    @Around(value = "@annotation(lifecycle))")
    public Object intercept(ProceedingJoinPoint joinPoint, Lifecycle lifecycle) throws Throwable {
        Result result = (Result) joinPoint.proceed();
        System.out.println("what the fuck!");
        System.out.println(result.getName());
        System.out.println(lifecycle.name());
        return result;
    }
}

