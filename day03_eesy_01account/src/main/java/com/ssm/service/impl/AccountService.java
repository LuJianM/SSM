package com.ssm.service.impl;

import com.ssm.dao.IAccountDao;
import com.ssm.model.Account;
import com.ssm.service.IAccountService;
import com.ssm.utlis.TransactionManager;

import java.util.List;

/**
 * 使用Alt+Insert，快速实现接口方法
 */
public class AccountService implements IAccountService {

    private IAccountDao accountDao;

    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {
        try {
            //1. 开启事务
            transactionManager.beginTransaction();
            //2. 执行操作
            List<Account> accounts = accountDao.findAllAccount();

            //3. 提交事务
            transactionManager.commitTransaction();

            return accounts;
        } catch (Exception e) {
            e.printStackTrace();
            //4. 回滚事务
            transactionManager.rollbackTransaction();
        }finally {
            transactionManager.releaseTransaction();
        }
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
        try {
            transactionManager.beginTransaction();

            Account source = accountDao.findAccountByName(outName);
            Account target = accountDao.findAccountByName(entryName);


            source.setMoney(source.getMoney()-money);
            target.setMoney(target.getMoney()+money);

            accountDao.UpdateAccountById(source);

            int i = 1/0;

            accountDao.UpdateAccountById(target);

            transactionManager.commitTransaction();
        } catch (Exception e) {
            //5.回滚事务
            transactionManager.rollbackTransaction();
            System.out.println("回滚完毕");
            e.printStackTrace();
        } finally {
            //6.释放连接
            transactionManager.releaseTransaction();
        }
    }
}
