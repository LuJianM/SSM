package com.ssm.factory;

import com.ssm.service.IAccountService;
import com.ssm.service.impl.AccountServiceImpl;

public class StaticFactory {
    public static IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
