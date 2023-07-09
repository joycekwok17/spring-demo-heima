package org.example.jdbcTemplate;

import org.example.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Xuanchi Guo
 * @project Spring-demo
 * @created 7/9/23
 */
public class JdbcTemplateDemo2 {
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jt = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        // 2. execute the method
//        jt.execute("insert into account(name, money) values('eee', 1000)");
//        jt.update("insert into account(name, money) values(?, ?)", "fff", 1000f);
//        jt.update("update account set name=?, money=? where id=?", "test", 10000f, 6);
//        jt.update("delete from account where id=?", 6);
//        List<Account> accountList = jt.query("select * from account where money = ?",
//                new BeanPropertyRowMapper<>(Account.class), 19100f); // rowMapper is provided by spring
//        accountList.forEach(System.out::println);
//        System.out.println("===================================");
//        System.out.println(accountList.isEmpty()? "No result": accountList.get(0));
        Long count = jt.queryForObject("select count(*) from account where money > ?",
                Long.class, 300f); // rowMapper is provided by spring
        System.out.println(count);
    }
}

///**
// * AccountRowMapper class implements RowMapper interface
// * to map the result set to Account object
// */
//class AccountRowMapper implements RowMapper<Account> {
//
//    @Override
//    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
//        Account account = new Account();
//        account.setId(resultSet.getInt("id"));
//        account.setName(resultSet.getString("name"));
//        account.setMoney(resultSet.getFloat("money"));
//        return account;
//    }
//}

