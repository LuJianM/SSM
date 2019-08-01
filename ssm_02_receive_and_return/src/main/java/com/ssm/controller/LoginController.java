package com.ssm.controller;


import com.sun.xml.internal.bind.v2.util.ByteArrayOutputStreamEx;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RequestMapping("/user")
@Controller
public class LoginController {
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //解析前端穿过来的数据

        //1.将输入流转化为String类型
        ByteArrayOutputStream outputStream = new ByteArrayOutputStreamEx();
        byte[] data = new byte[4096];
        int count = -1;
        while ((count = request.getInputStream().read(data,0,4096)) != -1){
            outputStream.write(data,0,count);
        }

        String parameter = new String(outputStream.toByteArray(),"UTF-8");

        System.out.println(parameter);

        //2.
        parameter = java.net.URLDecoder.decode(parameter,"utf-8");

        //3.


    }

    @RequestMapping(value = "/findAccount")
    public String findAccont(Integer accountId,String accountName){
        System.out.println("查询了账户。。。。"+accountId+","+accountName);
        return "success";
    }

    @RequestMapping(value = "/")
    public String sayHello(){
        System.out.println("hello world!");
        return null;
    }

}
