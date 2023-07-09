package org.example.jdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author Xuanchi Guo
 * @project Spring-demo
 * @created 7/9/23
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        // prepare the data source Spring's built-in data source
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/newDB?serverTimezone=UTC");
        ds.setUsername("root");
        ds.setPassword("password");

        // 1. get the object
        JdbcTemplate jt = new JdbcTemplate(ds);
//        jt.setDataSource(ds);

        // 2. execute the method
        jt.execute("insert into account(name, money) values('ddd', 1000)");
    }
}
