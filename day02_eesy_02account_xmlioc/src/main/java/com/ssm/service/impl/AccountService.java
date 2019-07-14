package com.ssm.service.impl;

import com.ssm.dao.IAccountDao;
import com.ssm.model.Account;
import com.ssm.service.IAccountService;

import java.util.List;

/**
 * 使用Alt+Insert，快速实现接口方法
 */
public class AccountService implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    public Account findAccountById(int accountId) {
        return accountDao.findAccountById(accountId);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void UpdateAccountById(Account account) {
        accountDao.UpdateAccountById(account);
    }

    public void deleteAccountByID(Account account) {
        accountDao.deleteAccountByID(account);
    }
}
