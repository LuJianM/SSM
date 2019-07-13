package com.ssm.service.impl;

import com.ssm.service.IAccountService;

import java.util.Date;

public class AccountServiceImpl2 implements IAccountService {



    public String name;
    public String name1;
    public Integer age;
    public Date brithday;

    public void setName(String name) {
        this.name = name;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }

    @Override
    public String toString() {
        return "AccountServiceImpl{" +
                "name='" + name + '\'' +
                ", name1='" + name1 + '\'' +
                ", age=" + age +
                ", brithday=" + brithday +
                '}';
    }

//    public AccountServiceImpl2(){
//        System.out.println("AccountServiceImpl被实例化了！");
//    }

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
