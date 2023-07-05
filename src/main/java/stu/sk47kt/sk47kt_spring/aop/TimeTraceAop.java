package stu.sk47kt.sk47kt_spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Aspect
@Component
public class TimeTraceAop {

    @Around("execution(* stu.sk47kt.sk47kt_spring.service..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START:" + joinPoint.toString());
        try{
            return joinPoint.proceed();
        }
        finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish-start;
            System.out.println("END:" + joinPoint.toString() + " " + timeMs + "ms");
        }

    }
}
