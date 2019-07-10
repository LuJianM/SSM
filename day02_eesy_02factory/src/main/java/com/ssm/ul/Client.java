package com.ssm.ul;

import com.ssm.factory.BeanFactory;
import com.ssm.service.IAccountService;
import com.ssm.service.impl.AccountServiceImpl;

/**
 * 模拟表现层
 */
public class Client {
    public static void main(String[] args){
        //IAccountService as = new AccountServiceImpl();
//        IAccountService as  = (IAccountService) BeanFactory.getBean("accountService");
//        as.saveAccount();
        for (int i =0;i<5;i++){
            IAccountService as = (IAccountService) BeanFactory.getBean("accountService");
            System.out.println(as);
        }
    }
}
