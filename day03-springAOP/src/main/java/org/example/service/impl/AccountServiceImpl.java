package org.example.service.impl;

import org.example.service.IAccountService;

/**
 * @author Xuanchi Guo
 * @project Spring-demo
 * @created 7/8/23
 */
public class AccountServiceImpl implements IAccountService {
    @Override
    public void saveAccount() {
        System.out.println("save account");
    }

    @Override
    public void updateAccount(int i) {
        System.out.println("update account " + i);
    }

    @Override
    public int deleteAccount() {
        System.out.println("delete account");
        return 0;
    }
}
