package org.example.factory;

import org.example.service.IAccountService;
import org.example.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Bean Factory
 *
 * @author Xuanchi Guo
 * @project Spring-demo
 * @created 7/8/23
 */
public class BeanFactory {
    private IAccountService accountService;
    private TransactionManager txManager; // 事务管理器 用于管理事务 事务的开启 提交 回滚和释放

    public final void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }


    public IAccountService getAccountService() {
        return (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                 accountService.getClass().getInterfaces(),
                 new InvocationHandler() {
                     @Override
                     public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                         Object returnValue = null;
                         try {
                             // 1. start transaction
                             txManager.beginTransaction();
                             // 2. execute operation
                             returnValue = method.invoke(accountService, args);
                             // 3. commit transaction
                             txManager.commit();
                             return returnValue;
                         } catch (Exception e) {
                             // 5. rollback transaction
                             txManager.rollback();
                             throw new RuntimeException(e);
                         } finally {
                             // 6. release connection
                             txManager.release();
                         }
                     }
                 }
         );
    }

    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }
}
