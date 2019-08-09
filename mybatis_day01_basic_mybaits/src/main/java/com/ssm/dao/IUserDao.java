package com.ssm.dao;

import com.ssm.domain.User;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface IUserDao {
    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();
}
