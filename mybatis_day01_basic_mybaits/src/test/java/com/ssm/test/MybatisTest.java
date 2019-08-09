package com.ssm.test;

import com.ssm.dao.IUserDao;
import com.ssm.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    /**
     * 入门
     * @param args
     */
    public static void main(String[] args) throws Exception{
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
