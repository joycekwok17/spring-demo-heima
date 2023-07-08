package org.example.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author Xuanchi Guo
 * @project Spring-demo
 * @created 7/8/23
 */
public class Logger {
    /**
     *
     */
    public void beforePrintLog() {
        System.out.println("Logger before Print Log ...");
    }
    public void afterReturningPrintLog() {
        System.out.println("Logger after Returning print Log ...");
    }

    public void afterThrowingPrintLog() {
        System.out.println("Logger after Throwing Print Log ...");
    }
    public void afterPrintLog() {
        System.out.println("Logger after Print Log ...");
    }

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
        }
        finally {
            System.out.println("Logger around Print Log after..."); // after
        }
        return rtValue;
    }

}
