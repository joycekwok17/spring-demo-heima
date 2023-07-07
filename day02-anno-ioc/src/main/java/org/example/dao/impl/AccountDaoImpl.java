package org.example.dao.impl;

import jdk.jfr.Registered;
import org.example.dao.IAccountDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author Xuanchi Guo
 * @project Spring-demo
 * @created 7/6/23
 */
@Repository("accountDao1")
public class AccountDaoImpl
        implements IAccountDao {
    @Override
    public void saveAccount() {
        System.out.println("saved account111");
    }
}
