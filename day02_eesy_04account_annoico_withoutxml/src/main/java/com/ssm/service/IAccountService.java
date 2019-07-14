package com.ssm.service;


import com.ssm.model.Account;

import java.util.List;

/**
 * 账户业务层
 * 1.查询所有账户信息
 * 2.查询一个账户信息
 * 3.新增一个账户
 * 4.修改一个账户
 * 5.删除一个账户
 */
public interface IAccountService {
    List<Account> findAllAccount();

    Account findAccountById(int id);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Account account);
}
