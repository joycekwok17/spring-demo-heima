package org.example.test;

import org.example.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Xuanchi Guo
 * @project Spring-demo
 * @created 7/8/23
 */
public class AOPTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // get the proxy object
        IAccountService as = (IAccountService) ac.getBean("accountService");
        // execute the method
        as.updateAccount(2);
        as.saveAccount();
        as.deleteAccount();
    }
}
