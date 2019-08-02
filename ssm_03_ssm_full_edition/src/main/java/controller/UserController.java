package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.IUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private IUserService userService = null;

    @RequestMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response){
        System.out.println("hello world!");
        userService.login();
    }
}
