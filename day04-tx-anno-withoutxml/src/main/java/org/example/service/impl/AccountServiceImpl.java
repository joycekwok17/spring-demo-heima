package org.example.service.impl;

import org.example.dao.IAccountDao;
import org.example.dao.impl.AccountDaoImpl;
import org.example.domain.Account;
import org.example.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Xuanchi Guo
 * @project Spring-demo
 * @created 7/9/23
 */
@Service("accountService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) // read only transaction
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false) // read and write transaction
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
        int i = 1/0;
        // 6. update target account
        accountDao.updateAccount(target);
    }


}
