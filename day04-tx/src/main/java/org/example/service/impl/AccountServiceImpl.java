package org.example.service.impl;

import org.example.dao.IAccountDao;
import org.example.domain.Account;
import org.example.service.IAccountService;

/**
 * @author Xuanchi Guo
 * @project Spring-demo
 * @created 7/9/23
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("transfer...");
        // 1. find the source account
        Account source = accountDao.findAccountByName(sourceName);
        // 2. find the target account
        Account target = accountDao.findAccountByName(targetName);
        // 3. source account loses money
        source.setMoney(source.getMoney() - money);
        // 4. target account gains money
        target.setMoney(target.getMoney() + money);
        // 5. update source account
        accountDao.updateAccount(source);
        // 6. update target account
        accountDao.updateAccount(target);
    }
}
