package org.example.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author Xuanchi Guo
 * @project Spring-demo
 * @created 7/8/23
 */
@Component("logger")
@Aspect // this annotation makes this class a aspect class
public class Logger {
    @Pointcut("execution(* org.example.service.impl.*.*(..))")
    private void pt1() {
    }

    /**
     *
     */
    @Before("pt1()")
    public void beforePrintLog() {
        System.out.println("Logger before Print Log ...");
    }

    @AfterReturning("pt1()")
    public void afterReturningPrintLog() {
        System.out.println("Logger after Returning print Log ...");
    }

    @AfterThrowing("pt1()")
    public void afterThrowingPrintLog() {
        System.out.println("Logger after Throwing Print Log ...");
    }

    @After("pt1()")
    public void afterPrintLog() {
        System.out.println("Logger after Print Log ...");
    }

//    @Around("pt1()")
    public Object aroundPrintLog(ProceedingJoinPoint proceedingJoinPoint) {
        Object rtValue = null;
        Object[] args = proceedingJoinPoint.getArgs();
        try {
            System.out.println("Logger around Print Log before..."); // before

            proceedingJoinPoint.proceed();
            System.out.println("Logger around Print Log  after returning..."); // after returning

        } catch (Throwable e) {
            System.out.println("Logger around Print Log exception..."); // exception
            throw new RuntimeException(e);
        } finally {
            System.out.println("Logger around Print Log after..."); // after
        }
        return rtValue;
    }

}
