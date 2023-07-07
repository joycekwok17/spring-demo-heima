package org.example.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.example.dao.IAccountDao;
import org.example.domain.Account;

import java.util.List;

/**
 * @author Xuanchi Guo
 * @project Spring-demo
 * @created 7/7/23
 */
public class AccountDaoImpl implements IAccountDao {
    private QueryRunner runner;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    @Override
    public List<Account> findAllAccount() {
        try{
            return runner.query("select * from tb_user",new BeanListHandler<Account>(Account.class));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAccountById(Integer accountId) {
        try{
            return runner.query("select * from tb_user where id = ?",new BeanHandler<Account>(Account.class),accountId);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAccount(Account account) {
        try{
            runner.update("insert into tb_user(username,password) values(?,?)",account.getUsername(), account.getPassword());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAccount(Account account) {
        try{
            runner.update("update tb_user set username=?, password=? where id=?",account.getUsername(), account.getPassword(),account.getId());
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteAccount(Integer accountId) {
        try{
            runner.update("delete from tb_user where id = ?",accountId);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
