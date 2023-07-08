package org.example.utils;

import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This class is used to manage transaction related operations
 * such as start transaction, commit transaction, rollback transaction and release connection
 *
 * @author Xuanchi Guo
 * @project Spring-demo
 * @created 7/8/23
 */
@Component("txManager")
@Aspect // this annotation makes this class a aspect class
public class TransactionManager {
    @Autowired
    private ConnectionUtils connectionUtils;

//    public void setConnectionUtils(ConnectionUtils connectionUtils) {
//        this.connectionUtils = connectionUtils;
//    }

    /**
     * configure pointcut
     */
    @Pointcut("execution(* org.example.service.impl.*.*(..))")
    private void pt1() {
    }

    /**
     * start transaction
     */
    @Before("pt1()")
    public void beginTransaction() { // if change to beginTransaction2, then have to modify many places in AccountServiceImpl_OLD.java
        // strong coupling here, use proxy to solve this problem
        try {
            System.out.println("begin transaction ...");
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * commit transaction
     */
    @AfterReturning("pt1()")
    public void commit() {
        try {
            System.out.println("commit transaction ...");
            connectionUtils.getThreadConnection().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * rollback transaction
     */
    @AfterThrowing("pt1()")
    public void rollback() {
        try {
            System.out.println("rollback transaction ...");
            connectionUtils.getThreadConnection().rollback();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * release connection
     */
    @After("pt1()")
    public void release() {
        try {
            System.out.println("release connection ...");

            connectionUtils.getThreadConnection().close(); // close connection
            connectionUtils.removeConnection(); // remove connection from threadLocal
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
