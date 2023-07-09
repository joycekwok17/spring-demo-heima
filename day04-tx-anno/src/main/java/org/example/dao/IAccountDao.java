package org.example.dao;

import org.example.domain.Account;

/**
 * @author Xuanchi Guo
 * @project Spring-demo
 * @created 7/9/23
 */
public interface IAccountDao {
    Account findAccountById(Integer accountId);

    Account findAccountByName(String accountName);

    void updateAccount(Account account);
}
