package org.example.test;

//import config.SpringConfiguration;

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
@ContextConfiguration(classes = org.example.config.SpringConfiguration.class)
public class AccountServiceTest2 {

    @Autowired  // no need to write setter method
    IAccountService as;

    @Test
    public void testFindAll() {
        // execute method
        List<Account> accounts = as.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testTransfer() {
        // execute method
        as.transfer("aaa", "ccc", 100f);
    }
}
