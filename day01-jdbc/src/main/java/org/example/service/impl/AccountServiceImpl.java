package org.example.service.impl;

import org.example.dao.IAccountDao;
import org.example.dao.impl.AccountDaoImpl;
import org.example.factory.BeanFactory;
import org.example.service.IAccountService;

/**
 * @author Xuanchi Guo
 * @project Spring-demo
 * @created 7/6/23
 */
//
public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao;

    {
        try {
            accountDao = (IAccountDao) BeanFactory.getBean("A");
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAccount() {
        int i=1;
        accountDao.saveAccount();
        System.out.println(i++);
    }
}
