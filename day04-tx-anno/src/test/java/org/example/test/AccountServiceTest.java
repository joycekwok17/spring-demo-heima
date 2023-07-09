package org.example.test;

//import config.SpringConfiguration;

import org.example.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Xuanchi Guo
 * @project Spring-demo
 * @created 7/7/23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml") // import configuration file
public class AccountServiceTest {

    @Autowired  // no need to write setter method
    IAccountService as;

    @Test
    public void testTransfer() {
        // execute method
        as.transfer("aaa", "bbb", 100f);
    }


}
