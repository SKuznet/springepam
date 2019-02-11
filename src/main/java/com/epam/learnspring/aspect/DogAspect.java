package com.epam.learnspring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DogAspect {

    @Pointcut("execution(* com.epam.learnspring.model.impl.FirstDogImpl.getBark(..))")
    public void seriveMethod() {

    }

        @Before("seriveMethod()")
    public void beforeHunt() {
        System.out.println("Before hunt");
    }

    @Around("seriveMethod()")
    public Object action(ProceedingJoinPoint joinPoint) throws Throwable {
        System.err.println("Before bark");
        Object obj = joinPoint.proceed();
        System.err.println("After bark");
        return obj;
    }

    @After("seriveMethod()")
    public void afterHunt() {
        System.out.println("After hunt");
    }
}
