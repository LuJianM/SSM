package com.ssm.service;

/**
 * 账户的业务层接口
 */
public interface IAccountService {

    /**
     * 模拟保存
     */
    void saveAccount();

    void updateAccount(int i);

    int deleteAccount();
}
