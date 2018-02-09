package cn.liuzhiping.intergration.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ControllerInterceptor {
    //@Pointcut("execution(public * cn.liuzhiping.intergration.controller.*.*(..))")
    @Pointcut("execution(public * cn.liuzhiping.intergration.controller..*())")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("before");
    }

    @Around("log()")
    public Object doLog(ProceedingJoinPoint point) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = point.proceed();
        long end = System.currentTimeMillis();
        log.info("start:" + start + ",end:" + end + ",takes:" + (end - start));
        return result;
    }
}
