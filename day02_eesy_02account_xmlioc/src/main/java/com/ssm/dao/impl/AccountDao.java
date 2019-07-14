package com.ssm.dao.impl;

import com.ssm.dao.IAccountDao;
import com.ssm.model.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AccountDao  implements IAccountDao {
    private QueryRunner runner;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public List<Account> findAllAccount() {
        try {
            return runner.query("select * from account", new BeanListHandler<Account>(Account.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Account findAccountById(int accountId) {
        try {
            return runner.query("select * from account where id = ?", new BeanHandler<Account>(Account.class),accountId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void saveAccount(Account account) {
        try {
            runner.update("insert into account(name,money) value(?, ?)",account.getName(),account.getMoney());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void UpdateAccountById(Account account) {
        try {
            runner.update("update account set name=?,money=? where id = ?",account.getName(),account.getMoney(),account.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAccountByID(Account account) {
        try {
            runner.update("delete from account where id =? ",account.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
