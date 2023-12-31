package org.example.test;

import org.example.domain.Account;
import org.example.service.IAccountService;
import org.example.utils.TransactionManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;

import java.lang.management.PlatformLoggingMXBean;
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
PlatformTransactionManager ptm;
    @Test
    public void testTransfer() {
        as.transfer("ddd", "ccc", 100f);
    }

    @Test
    public void testSelectAll() {
        List<Account> accounts = as.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

}
