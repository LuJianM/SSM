package com.ssm.service;

import com.ssm.model.Account;

import java.util.List;

/**
 * 账户业务层
 * 1.查询所有账户
 * 2.通过id查询一个账户
 * 3.新增一个账户
 * 4.通过id修改一个账户
 * 5.删除一个账户
 */
public interface IAccountService {

    List<Account> findAllAccount();

    Account findAccountById(int accountId);

    void saveAccount(Account account);

    void UpdateAccountById(Account account);

    void deleteAccountByID(Account account);

    //转账
    void transferAccounts(String outName, String entryName, float money);
}
