package com.ssm.dao.impl;

import com.ssm.dao.IAccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountdao")
public class AccountDao implements IAccountDao {
    public void saveAccount() {
        System.out.println("dao层-账户已保存！");
    }
}
