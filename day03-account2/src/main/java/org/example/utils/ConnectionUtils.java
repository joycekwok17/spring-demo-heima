package org.example.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Xuanchi Guo
 * @project Spring-demo
 * @created 7/8/23
 */
@Component("connectionUtils")
public class ConnectionUtils {
    private ThreadLocal<Connection> tl = new ThreadLocal<>();
    @Autowired
    private DataSource dataSource;

//    public void setDataSource(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    public Connection getThreadConnection() {
        try {
            Connection conn = tl.get(); // get connection from threadLocal
            if (conn == null) {

                conn = dataSource.getConnection(); // get connection from dataSource
                tl.set(conn); // save connection to threadLocal
            }
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * remove connection from threadLocal
     */
    public void removeConnection() {
        tl.remove();
    }
}
