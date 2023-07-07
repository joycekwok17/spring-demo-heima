package org.example.service.impl;

import org.example.dao.IAccountDao;
import org.example.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * The type Account service.
 * <bean id="accountService" class="org.example.service.impl.AccountServiceImpl"
 * scope="" init-method="" destroy-method="">
 * <property name="" value="" | ref ="">  </property>
 * </bean>
 * 1. use bean tag to create object in spring container and inject dependencies by property tag in xml file
 * 2. use annotation to create object in spring container and inject dependencies by annotation in java file
 * 3. use java config class to create object in spring container and inject dependencies by annotation in java file
 *
 * @author Xuanchi Guo
 * @Component : indicate the class is a bean in spring container
 * and the value is the id of the bean in spring container
 * (default value is the class name with first letter lower case)
 * @project Spring -demo
 * @created 7 /6/23
 */

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired // byType injection
    @Qualifier("accountDao2")
    // byName injection (if there are multiple beans with same type) (use this annotation with @Autowired)
//    @Resource(name = "accountDao2")
    private IAccountDao accountDao;

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
