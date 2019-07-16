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

    /**
     * 转账功能
     * 1.根据名称查询转出账户
     * 2.根据名称查询转入账户
     * 3.转出账户金额减少
     * 4.转入账户金额增加
     * 5.更新转出账户
     * 6.更新转入账户
     * @param entryName 转入账户
     * @param outName   转出账户
     * @param money     转账金额
     */
    public void transferAccounts(String outName, String entryName, float money) {
        Account source = accountDao.findAccountByName(outName);
        Account target = accountDao.findAccountByName(entryName);

        source.setMoney(source.getMoney()-money);
        target.setMoney(target.getMoney()+money);

        accountDao.UpdateAccountById(source);
        accountDao.UpdateAccountById(target);
    }
}
