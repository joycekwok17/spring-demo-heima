package org.example.jdbcTemplate;

import org.example.dao.IAccountDao;
import org.example.dao.impl.AccountDaoImpl;
import org.example.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Xuanchi Guo
 * @project Spring-demo
 * @created 7/9/23
 */
public class JdbcTemplateDemo3 {
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountDao accountDao = ac.getBean("accountDao", AccountDaoImpl.class);
        Account account = accountDao.findAccountById(1);
        System.out.println(account);
        account.setMoney(3000f);
        accountDao.updateAccount(account);
        System.out.println(account);
    }
}

