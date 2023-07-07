package org.example.test;

import org.example.domain.Account;
import org.example.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author Xuanchi Guo
 * @project Spring-demo
 * @created 7/7/23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml") // if you have multiple xml files, you can use {"classpath:bean.xml", "classpath:bean2.xml"}
public class AccountServiceTest {
    @Autowired
    private IAccountService as;
    @Test
    public void testFindAll() {
           // execute method
        List<Account> accounts = as.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {
     // execute method
        Account account = as.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave() {
       // execute method
        Account account = new Account();
        account.setUsername("test");
        account.setPassword("test");
        as.saveAccount(account);
        as.findAllAccount().forEach(System.out::println);
    }

    @Test
    public void testUpdate() {
        // execute method
        Account account = as.findAccountById(3);
        account.setUsername("test_update");
        account.setPassword("test_update");
        as.updateAccount(account);
        as.findAllAccount().forEach(System.out::println);
    }

    @Test
    public void testDelete() {
        // execute method
        as.deleteAccount(4);
        as.findAllAccount().forEach(System.out::println);
    }

}
