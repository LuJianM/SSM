package com.ssm.service.impl;

import com.ssm.dao.IAccountDao;
import com.ssm.dao.impl.AccountDao;
import com.ssm.service.IAccountService;

import java.util.Date;
import java.util.PriorityQueue;

public class AccountServiceImpl implements IAccountService {

    public AccountServiceImpl(String name, String name1, Integer age, Date brithday) {
        this.name = name;
        this.name1 = name1;
        this.age = age;
        this.brithday = brithday;
    }

    public String name;
    public String name1;
    public Integer age;
    public Date brithday;

    @Override
    public String toString() {
        return "AccountServiceImpl{" +
                "name='" + name + '\'' +
                ", name1='" + name1 + '\'' +
                ", age=" + age +
                ", brithday=" + brithday +
                '}';
    }

    public AccountServiceImpl(){
        System.out.println("AccountServiceImpl被实例化了！");
    }

    public void saveAccount(){
        System.out.println("保存账户成功！");
        //accountDao.saveAccount();
    }



    public void init(){
        System.out.println("AccountServiceImpl对象创建了");
    }

    public void destory(){
        System.out.println("AccountServiceImpl对象销毁了");
    }
}
