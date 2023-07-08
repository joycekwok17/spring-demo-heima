package org.example.utils;

/**
 * This class is used to manage transaction related operations
 * such as start transaction, commit transaction, rollback transaction and release connection
 * @author Xuanchi Guo
 * @project Spring-demo
 * @created 7/8/23
 */
public class TransactionManager {
    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    /**
     * start transaction
     */
    public void beginTransaction() { // if change to beginTransaction2, then have to modify many places in AccountServiceImpl_OLD.java
        // strong coupling here, use proxy to solve this problem
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * commit transaction
     */
    public void commit() {
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * rollback transaction
     */
    public void rollback() {
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * release connection
     */
    public void release() {
        try {
            connectionUtils.getThreadConnection().close(); // close connection
            connectionUtils.removeConnection(); // remove connection from threadLocal
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
