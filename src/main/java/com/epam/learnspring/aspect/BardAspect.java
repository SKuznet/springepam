package com.epam.learnspring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class BardAspect {

/*    @Before("execution(* com.epam.learnspring.service.impl.KnightServiceImpl.*(..))")
    public void getSong() {
        System.out.println("lalala");
    }*/

 /*   @Pointcut("execution(* com.epam.learnspring.service.KnightService.*(..))")
    public void serviceMethod() {
    }*/

    @Before("execution(* com.epam.learnspring.service.KnightService.*(..))")
    public void getSong() {
        System.out.println("lalala");
    }
/*
    @Around("serviceMethod() && serviceMethod()")
    public Object action(ProceedingJoinPoint joinPoint) throws Throwable {
        long timeBefore = System.currentTimeMillis();
        Object object = joinPoint.proceed();
        long totalTime = System.currentTimeMillis() - timeBefore;
        System.err.println("lalala...");
        System.err.println("Knight has defeat the dragon in: " + totalTime + " ms");
        return object;
    }*/

    @Pointcut("execution(* com.epam.learnspring.service.KnightService.*(..))")
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
