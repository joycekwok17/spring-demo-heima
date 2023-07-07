package org.example.test;

import config.SpringConfiguration;
import org.example.domain.Account;
import org.example.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author Xuanchi Guo
 * @project Spring-demo
 * @created 7/7/23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
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
        account.setUsername("newhello");
        account.setPassword("new dsf");
        as.saveAccount(account);
        as.findAllAccount().forEach(System.out::println);
    }

    @Test
    public void testUpdate() {
        // execute method
        Account account = as.findAccountById(3);
        account.setUsername("wangwu");
        account.setPassword("345");
        as.updateAccount(account);
        as.findAllAccount().forEach(System.out::println);
    }

    @Test
    public void testDelete() {
        // execute method
        as.deleteAccount(6);
        as.findAllAccount().forEach(System.out::println);
    }

}
