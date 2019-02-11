package com.epam.learnspring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BardAspect {

    /*@Before("execution(* com.epam.learnspring.service.impl.KnightServiceImpl.*(..))")
    public void getSong() {
        System.out.println("lalala");
    }*/

    @Pointcut("execution(* com.epam.learnspring.service.impl.KnightServiceImpl.getAchievement(..))")
    public void serviceMethod() {

    }

    @Around("serviceMethod()")
    public Object action(ProceedingJoinPoint joinPoint) throws Throwable {
        long timeBefore = System.currentTimeMillis();
        Object object = joinPoint.proceed();
        long totalTime = System.currentTimeMillis() - timeBefore;
        System.err.println("lalala...");
        System.err.println("Knight defeat a dragon by " + totalTime + " ms");
        return object;
    }

    @After("execution(* com.epam.learnspring.service.impl.KnightServiceImpl.*(..))")
    public void afterAction() {
        System.out.println("finished");
    }
}
