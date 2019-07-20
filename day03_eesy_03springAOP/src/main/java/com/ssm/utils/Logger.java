package com.ssm.utils;

/**
 * 记录日志工具类
 */
public class Logger {

    /**
     * 用于打印日志：计划在其切入点方法执行之前执行（切入点方法就是业务层方法）
     */
    public void printLog(){
        System.out.println("Logger类中的printLog方法执行了。。。");
    }
}
