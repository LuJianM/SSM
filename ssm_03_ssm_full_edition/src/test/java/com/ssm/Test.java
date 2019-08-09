package com.ssm;

import dao.IUserDao;
import model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class Test {

    @org.junit.Test
    public void run1() throws  Exception{
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        SqlSessionFactory factory = builder.build(in);

        SqlSession session = factory.openSession();

        IUserDao userDao = session.getMapper(IUserDao.class);

        List<User> users = userDao.findAll();

        for (User user: users){
            System.out.println(user);
        }
        session.close();

        in.close();
    }
}
