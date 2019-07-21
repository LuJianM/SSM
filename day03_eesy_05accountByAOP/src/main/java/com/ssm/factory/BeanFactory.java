package com.ssm.factory;

import com.ssm.model.Account;
import com.ssm.service.IAccountService;
import com.ssm.utlis.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于创建Service的代理对象工厂
 */
public class BeanFactory {
    private IAccountService accountService;

    private TransactionManager transactionManager;

    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    public final void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    /**
     * 获取Service代理对象
     * @return
     */
    public IAccountService getAccountService() {
        IAccountService proxyAccountService = (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(),
                new InvocationHandler() {

                    /**
                     * 添加事务的支持
                     * @param proxy
                     * @param method
                     * @param args
                     * @return
                     * @throws Throwable
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object returnValue = null;

                        try {
                            //1.开启事务
                            transactionManager.beginTransaction();
                            System.out.println("+++++++++++++");
                            //2.执行操作
                            returnValue = method.invoke(accountService,args);

                            System.out.println("_________________");
                            //3.提交事务
                            transactionManager.commitTransaction();
                            //4.返回结果
                            return  returnValue;
                        } catch (Exception e){
                            e.printStackTrace();
                            transactionManager.rollbackTransaction();
                            throw new RuntimeException();
                        } finally {
                            transactionManager.releaseTransaction();
                        }

                    }
                });



        return proxyAccountService;
    }
}

