package com.ssm.service.impl;

import com.ssm.dao.IAccountDao;
import com.ssm.dao.impl.AccountDao;
import com.ssm.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.PriorityQueue;


//使用@Component创建对象(无参构造器)，对象名为accountService，若不配置对象，则对象名为accountServiceImpl
@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    public AccountServiceImpl(){
        System.out.println("AccountServiceImpl被实例化了！");
    }

    public void saveAccount(){

        accountDao.saveAccount();
    }

}
