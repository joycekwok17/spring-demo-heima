package org.example.service.impl;

import org.example.service.IAccountService;
import org.springframework.stereotype.Service;

/**
 * @author Xuanchi Guo
 * @project Spring-demo
 * @created 7/8/23
 */
@Service("accountService")
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
//        int i = 1/0;
//        System.out.println("delete account failed"); // this line will not be executed
        return 0;
    }
}
