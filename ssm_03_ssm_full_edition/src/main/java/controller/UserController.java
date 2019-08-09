package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.IUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    IUserService userService = null;

    @Autowired
    DataSource dataSource = null;

    @RequestMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response){
        System.out.println("hello world!");
        System.out.println(dataSource);
        userService.login();
    }
}
