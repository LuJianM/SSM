package com.ssm.service.impl;

import com.ssm.dao.IAccountDao;
import com.ssm.dao.impl.AccountDao;
import com.ssm.factory.BeanFactory;
import com.ssm.service.IAccountService;

import java.util.PriorityQueue;

public class AccountServiceImpl implements IAccountService {


    //private IAccountDao accountDao = new AccountDao();
    private  IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accuountDao");

    public void saveAccount(){
        accountDao.saveAccount();
    }
}
