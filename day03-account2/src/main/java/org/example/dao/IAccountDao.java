package org.example.dao;

import org.example.domain.Account;

import java.util.List;

/**
 * @author Xuanchi Guo
 * @project Spring-demo
 * @created 7/7/23
 */
public interface IAccountDao {
    List<Account> findAllAccount();
    Account findAccountById(Integer accountId);
    void saveAccount(Account account);
    void updateAccount(Account account);
    void deleteAccount(Integer accountId);
    Account findAccountByName(String accountName);
}
