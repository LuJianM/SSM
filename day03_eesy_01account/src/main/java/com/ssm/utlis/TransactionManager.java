package com.ssm.utlis;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 和事务相关的工具类，
 *         开启事务，提交事务，回滚事务，释放连接
 */
public class TransactionManager {

    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    /**
     * 开启事务
     */
    public void beginTransaction(){
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (Exception e) {
            throw new RuntimeException("开启事务异常");
        }
    }

    /**
     * 提交事务
     */
    public void commitTransaction(){
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (Exception e) {
            throw new RuntimeException("提交事务异常");
        }
    }

    /**
     * 回滚事务
     */
    public void rollbackTransaction(){
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (Exception e) {
            throw new RuntimeException("回滚事务异常");
        }
    }

    /**
     * 释放连接
     */
    public void releaseTransaction(){
        try {
            connectionUtils.getThreadConnection().close();//返回连接池中
            connectionUtils.removeConnection();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("释放连接异常");
        }
    }
}
