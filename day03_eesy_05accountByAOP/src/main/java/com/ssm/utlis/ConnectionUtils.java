package com.ssm.utlis;



import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 连接的工具类，从数据源中获取一个连接，并实现与线程的绑定。
 *
 */
public class ConnectionUtils {

    /**
     * 使用ThreadLocal保存Connection变量
     * 每个线程内部都会维护一个Map，里面存储的线程本地对象（key）和线程的变量副本（value）
     * 但是这个Map是由ThreadLocal来维护的，由ThreadLocal负责向Map获取和设置变量副本
     * public T get()：获取当前线程的副本变量值。
     * public void set(T value)：保存当前线程的副本变量值。
     * public void remove()：移除当前前程的副本变量值。
     *
     * 整个思路大概是
     * 1.从当前线程的map中取出connection
     * 2.如果当前线程中没有，就从数据源中获取一个连接，并把它存到当前线程的map中，即线程和Connection的绑定
     * 3.如果使用完当前线程，那么就可以解绑线程和Connection了。
     *
     */
    private  ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取当前线程上的连接
     * 1.从ThreadLocal上获取
     * 2.判断当前线程上是否有连接
     *
     * @return
     */
    public Connection getThreadConnection(){
        try {
            Connection conn = tl.get();
            if (conn ==null){
                conn = dataSource.getConnection();
                tl.set(conn);
            }
            return conn;
        } catch (Exception e) {
            throw new RuntimeException("连接获取异常");
        }
    }

    /**
     * 把连接和线程解绑
     */
    public void removeConnection(){
        tl.remove();
    }
}
