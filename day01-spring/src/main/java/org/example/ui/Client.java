package org.example.ui;

import org.example.dao.IAccountDao;
import org.example.dao.impl.AccountDaoImpl;
import org.example.service.IAccountService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * The type Client.
 *
 * @author Xuanchi Guo
 * @project Spring -demo
 * @created 7 /6/23
 */
public class Client {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws BeansException the beans exception
     */
    public static void main(String[] args) throws BeansException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        System.out.println("Bean names: " + Arrays.toString(ac.getBeanNamesForType(AccountDaoImpl.class)));

//        IAccountService as = (IAccountService) ac.getBean("accountService");
        IAccountDao adao = (IAccountDao) ac.getBean("accountDao");
//        System.out.println(as);
        System.out.println(adao);

    }
}
