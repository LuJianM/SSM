package com.ssm.service.impl;

import com.ssm.dao.IAccountDao;
import com.ssm.dao.impl.AccountDao;
import com.ssm.service.IAccountService;

import java.util.PriorityQueue;

public class AccountServiceImpl implements IAccountService {


    private IAccountDao accountDao = new AccountDao();

    public AccountServiceImpl(){
        System.out.println("AccountServiceImpl被实例化了！");
    }

    public void saveAccount(){
        accountDao.saveAccount();
    }
}
