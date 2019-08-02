package service.impl;

import org.springframework.stereotype.Service;
import service.IUserService;

@Service(value = "userService")
public class UserServiceImpl implements IUserService {
    @Override
    public void login() {
        System.out.println("This is UserServiceImpl");
    }
}
