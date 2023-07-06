package org.example.dao.impl;

import org.example.dao.IAccountDao;

/**
 * @author Xuanchi Guo
 * @project Spring-demo
 * @created 7/6/23
 */
//
public class AccountDaoImpl implements IAccountDao {
    @Override
    public void saveAccount() {
        System.out.println("saved account");
    }
}
