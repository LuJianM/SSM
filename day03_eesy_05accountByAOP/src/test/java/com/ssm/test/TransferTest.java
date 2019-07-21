package com.ssm.test;

import com.ssm.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:bean.xml")
public class TransferTest {

//    @Autowired
//    @Qualifier("proxyAccountService")
//    private IAccountService as;

    @Test
    public void testTransferAccounts(){

        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        IAccountService as = ac.getBean("proxyAccountService",IAccountService.class);

        as.transferAccounts("我是A","我是B",100f);

    }

}
