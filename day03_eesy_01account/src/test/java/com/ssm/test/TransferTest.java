package com.ssm.test;

import com.ssm.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransferTest {

    @Test
    public void testTransferAccounts(){

        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        IAccountService as = ac.getBean("accountService",IAccountService.class);

        as.transferAccounts("我是A","我是B",100f);

    }

}
