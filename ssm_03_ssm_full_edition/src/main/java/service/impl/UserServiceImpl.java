package service.impl;

import dao.IUserDao;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.IUserService;

import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public void login() {
        System.out.println("This is UserServiceImpl");

        List<User> users = userDao.findAll();

        for (User user: users){
            System.out.println(user);
        }


//        User user = userDao.login("123","123");
//
//        System.out.println(user.getRole());
    }
}
