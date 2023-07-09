package org.example.service;

import org.example.domain.Account;

/**
 * @author Xuanchi Guo
 * @project Spring-demo
 * @created 7/9/23
 */
public interface IAccountService {
    Account findAccountById(Integer accountId);
    void transfer(String sourceName, String targetName, Float money);

}
