package com.epam.learnspring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BardAspect {

//    @Before("execution(* com.epam.learnspring.service.impl.KnightServiceImpl.*(..))")
//    public void getSong() {
//        System.out.println("lalala");
//    }

    @Pointcut("execution(* com.epam.learnspring.service.impl.KnightServiceImpl.getAchievement(..))")
    public void seriveMethod() {

    }

    @Around("seriveMethod()")
    public Object action(ProceedingJoinPoint joinPoint) throws Throwable {
        long timeBefore = System.currentTimeMillis();
        Object obj = joinPoint.proceed();
        long totalTime = System.currentTimeMillis() - timeBefore;
        System.err.println("Lalala...");
        System.err.println("Knight defeat a dragon by " + totalTime + "ms.");
        return obj;
    }
}
