package com.ssm.factory;

import com.ssm.service.IAccountService;
import com.ssm.service.impl.AccountServiceImpl;

public class InstanceFactory {
    public IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
