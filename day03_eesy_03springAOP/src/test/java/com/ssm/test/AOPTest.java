package com.ssm.test;

import com.ssm.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.String;
/**
 * Aoptest
 */


public class AOPTest {
    @Test
    public void textAop(){
        //1.获取容器
        ApplicationContext as = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        IAccountService ac = as.getBean("accountServiceImpl",IAccountService.class);
        //3.执行方法
        ac.saveAccount();

    }
}
