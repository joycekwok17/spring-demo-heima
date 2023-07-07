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
        IAccountService as1 = (IAccountService) ac.getBean("accountServiceImpl");
        IAccountDao adao = ac.getBean("accountDao1", IAccountDao.class); // getBean(String id, Class<T> requiredType)
        IAccountDao adao2 = ac.getBean("accountDao2", IAccountDao.class);
        as1.saveAccount();

    }
}
