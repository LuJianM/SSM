package com.ssm.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/user")
@Controller
public class LoginController {
    @RequestMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response){

        System.out.println("hello world");
    }
}
