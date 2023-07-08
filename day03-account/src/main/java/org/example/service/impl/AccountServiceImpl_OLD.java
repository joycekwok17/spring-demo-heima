package org.example.service.impl;

import org.example.dao.IAccountDao;
import org.example.domain.Account;
import org.example.service.IAccountService;
import org.example.utils.TransactionManager;

import java.util.List;

/**
 * @author Xuanchi Guo
 * @project Spring-demo
 * @created 7/7/23
 */
public class AccountServiceImpl_OLD implements IAccountService {
    private IAccountDao accountDao;
    private TransactionManager txManager; // 事务管理器 用于管理事务 事务的开启 提交 回滚和释放

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount() {
        try {
            // 1. start transaction
            txManager.beginTransaction();
            // 2. execute operation
            List<Account> accounts = accountDao.findAllAccount();
            // 3. commit transaction
            txManager.commit();
            // 4. return result
            return accounts;
        } catch (Exception e) {
            // 5. rollback transaction
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            // 6. release connection
            txManager.release();
        }
    }

    @Override
    public Account findAccountById(Integer accountId) {
        try {
            // 1. start transaction
            txManager.beginTransaction();
            // 2. execute operation
            Account account = accountDao.findAccountById(accountId);
            // 3. commit transaction
            txManager.commit();
            // 4. return result
            return account;
        } catch (Exception e) {
            // 5. rollback transaction
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            // 6. release connection
            txManager.release();
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            // 1. start transaction
            txManager.beginTransaction();
            // 2. execute operation
            accountDao.saveAccount(account);
            // 3. commit transaction
            txManager.commit();
        } catch (Exception e) {
            // 5. rollback transaction
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            // 6. release connection
            txManager.release();
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            // 1. start transaction
            txManager.beginTransaction();
            // 2. execute operation
            accountDao.updateAccount(account);
            // 3. commit transaction
            txManager.commit();
        } catch (Exception e) {
            // 5. rollback transaction
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            // 6. release connection
            txManager.release();
        }
    }

    @Override
    public void deleteAccount(Integer accountId) {
        try {
            // 1. start transaction
            txManager.beginTransaction();
            // 2. execute operation
            accountDao.deleteAccount(accountId);
            // 3. commit transaction
            txManager.commit();
        } catch (Exception e) {
            // 5. rollback transaction
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            // 6. release connection
            txManager.release();
        }
    }

    /**
     * transfer money from source account to target account
     *
     * @param sourceName
     * @param targetName
     * @param money
     */
    @Override
    public void transfer(String sourceName, String targetName, float money) {
        System.out.println("transfer...");
        try{
            txManager.beginTransaction();
            // 1. get source account
            Account source = accountDao.findAccountByName(sourceName);
            // 2. get target account
            Account target = accountDao.findAccountByName(targetName);
            // 3. source account - money
            source.setMoney(source.getMoney() - money);
            // 4. target account + money
            target.setMoney(target.getMoney() + money);


            // 5. update source account
            accountDao.updateAccount(source);
//            int i = 1/0;

            // 6. update target account
            accountDao.updateAccount(target);
            // 7. commit transaction
            txManager.commit();
        } catch (Exception e){
            txManager.rollback();
            e.printStackTrace();
        }finally {
            txManager.release();
        }


    }
}
