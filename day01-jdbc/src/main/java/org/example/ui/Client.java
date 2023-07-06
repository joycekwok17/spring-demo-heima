package org.example.ui;

import org.example.factory.BeanFactory;
import org.example.service.IAccountService;

/**
 * @author Xuanchi Guo
 * @project Spring-demo
 * @created 7/6/23
 */
// this class is used
public class Client {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        for (int i = 0; i < 5; i++) {
            IAccountService as = (IAccountService) BeanFactory.getBean("B");
            System.out.println(as);
            as.saveAccount();
        }
    }
}
