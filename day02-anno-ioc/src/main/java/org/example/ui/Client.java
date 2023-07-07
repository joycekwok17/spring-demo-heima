package org.example.ui;

import org.example.dao.IAccountDao;
import org.example.service.IAccountService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * The type Client.
 *
 * @author Xuanchi Guo
 * @project Spring -demo
 * @created 7 /7/23
 */
public class Client {
    public static void main(String[] args) throws BeansException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as1 = (IAccountService) ac.getBean("accountService");
        as1.saveAccount();

    }
}
