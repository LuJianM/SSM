package com.ssm.dao;


import com.ssm.model.Account;

import java.util.List;

/**
 * 账户的持久层接口
 */

public interface IAccountDao {
    List<Account> findAllAccount();

    Account findAccountById(int accountId);

    void saveAccount(Account account );

    void UpdateAccountById(Account account);

    void deleteAccountByID(Account account);

    Account findAccountByName(String name);
}
