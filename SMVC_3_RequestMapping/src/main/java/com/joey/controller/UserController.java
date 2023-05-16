package com.joey.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//2.定义controller
//2.1 使用@Controller 来定义bean

@Controller
//@RequestMapping("/user")
//设置当前操作的访问 类路径 (class)
//就不用在方法前加user  eg.@RequestMapping ("/user/save")
@RequestMapping ("/user")
public class UserController {
    //2.2 设置当前操作的访问路径
    @RequestMapping ("/save")
    //2.3 设置当前操作的返回值类型
    //方法的返回值应直接写入 HTTP 响应正文
    @ResponseBody
    public String save(){
        System.out.println("User save...");
        return "{'module':'user springmvc'}";
    }

}
