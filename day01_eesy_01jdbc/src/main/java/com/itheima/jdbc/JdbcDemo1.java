package com.itheima.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcDemo1 {
    public static void main(String[] args) throws Exception{
        //Class.forName("com.mysql.jdbc.Driver");
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=utf-8", "root", "123456");
        PreparedStatement ps = conn.prepareStatement("insert into account(name, money) values(?,?)");
        ps.setString(1,"bbb");
        ps.setFloat(2,2000);
        ps.executeUpdate();
        ps.close();
        conn.close();
    }
}
