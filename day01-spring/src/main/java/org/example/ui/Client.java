package org.example.ui;

import org.example.dao.IAccountDao;
import org.example.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Xuanchi Guo
 * @project Spring-demo
 * @created 7/6/23
 */
// this class is used
public class Client {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as1 = (IAccountService) ac.getBean("accountService");
        as1.saveAccount();
//        IAccountService as2 = (IAccountService) ac.getBean("accountService");
//        System.out.println(as1);
//        System.out.println(as2);
//        System.out.println(as1 == as2);
    }
}
