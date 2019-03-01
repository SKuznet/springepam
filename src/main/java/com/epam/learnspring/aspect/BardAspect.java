package com.epam.learnspring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BardAspect {

    @Before("execution(* com.epam.learnspring.service.impl.BarbarianServiceImpl.*(..))")
    public void getSong() {
        System.out.println("lalalala");
    }

    @Around("execution(* com.epam.learnspring.service.impl.BarbarianServiceImpl.getAchievement(..))")
    public Object action(ProceedingJoinPoint joinPoint) throws Throwable {
        long timeBefore = System.currentTimeMillis();
        Object obj = joinPoint.proceed();
        long totalTime = System.currentTimeMillis() - timeBefore;
        System.err.println("Traalala...");
        System.err.println("Knight defeat a dragon by " + totalTime + "ms.");
        return obj;
    }

    @After("execution(* com.epam.learnspring.service.impl.BarbarianServiceImpl.*(..))")
    public void getSongAfter() {
        System.out.println("HAHAHA");
    }

}