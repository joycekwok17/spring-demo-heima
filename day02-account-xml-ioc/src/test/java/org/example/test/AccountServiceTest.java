package org.example.test;

import org.example.domain.Account;
import org.example.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author Xuanchi Guo
 * @project Spring-demo
 * @created 7/7/23
 */
public class AccountServiceTest {
    @Test
    public void testFindAll() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // get the bean
        IAccountService as = (IAccountService) ac.getBean("accountService");
        // execute method
        List<Account> accounts = as.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // get the bean
        IAccountService as = (IAccountService) ac.getBean("accountService");
        // execute method
        Account account = as.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // get the bean
        IAccountService as = (IAccountService) ac.getBean("accountService");
        // execute method
        Account account = new Account();
        account.setUsername("test");
        account.setPassword("test");
        as.saveAccount(account);
        as.findAllAccount().forEach(System.out::println);
    }

    @Test
    public void testUpdate() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // get the bean
        IAccountService as = (IAccountService) ac.getBean("accountService");
        // execute method
        Account account = as.findAccountById(3);
        account.setUsername("test_update");
        account.setPassword("test_update");
        as.updateAccount(account);
        as.findAllAccount().forEach(System.out::println);
    }

    @Test
    public void testDelete() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // get the bean
        IAccountService as = (IAccountService) ac.getBean("accountService");
        // execute method
        as.deleteAccount(4);
        as.findAllAccount().forEach(System.out::println);
    }

}
