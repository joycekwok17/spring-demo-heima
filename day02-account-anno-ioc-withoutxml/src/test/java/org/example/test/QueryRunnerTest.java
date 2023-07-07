package org.example.test;

import config.SpringConfiguration;
import org.apache.commons.dbutils.QueryRunner;
import org.example.domain.Account;
import org.example.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * @author Xuanchi Guo
 * @project Spring-demo
 * @created 7/7/23
 */
public class QueryRunnerTest {
    @Test
    public void testFindAll() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        // get the bean
        QueryRunner runner = ac.getBean("runner", QueryRunner.class);
        QueryRunner runner1 = ac.getBean("runner", QueryRunner.class);
        System.out.println(runner == runner1);
        IAccountService as = (IAccountService) ac.getBean("accountService");
        // execute method
        List<Account> accounts = as.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}
