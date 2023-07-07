package org.example.dao.impl;

import org.example.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * @author Xuanchi GUO
 * @created 07.07.23
 */
@Repository("accountDao2")
public class AccountDaoImpl2 implements IAccountDao {
    /**
     * Save account.
     */
    @Override
    public void saveAccount() {
        System.out.println("saved account222");
    }
}
