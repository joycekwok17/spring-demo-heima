package org.example.service.impl;

import org.example.dao.IAccountDao;
import org.example.dao.impl.AccountDaoImpl;
import org.example.domain.Account;
import org.example.service.IAccountService;
import org.example.utils.TransactionManager;

import java.util.List;

/**
 * @author Xuanchi Guo
 * @project Spring-demo
 * @created 7/7/23
 */
public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao;
//    private TransactionManager txManager; // 事务管理器 用于管理事务 事务的开启 提交 回滚和释放
//
//    public void setTxManager(TransactionManager txManager) {
//        this.txManager = txManager;
//    }


    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }

    @Override
    public void transfer(String sourceName, String targetName, float money) {
        // 2.1 find source account
        Account source = accountDao.findAccountByName(sourceName);
        // 2.2 find target account
        Account target = accountDao.findAccountByName(targetName);
        // 2.3 source account - money
        source.setMoney(source.getMoney() - money);
        // 2.4 target account + money
        target.setMoney(target.getMoney() + money);
        // 2.5 update source account
        accountDao.updateAccount(source);
//        int i = 1 / 0;
        // 2.6 update target account
        accountDao.updateAccount(target);
    }

    public void setAccountDao(AccountDaoImpl accountDao) {
        this.accountDao = accountDao;
    }
}
