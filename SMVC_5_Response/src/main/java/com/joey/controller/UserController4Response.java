package com.joey.controller;

import com.joey.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

// SpringMVC 响应
@Controller
@RequestMapping("/u4res")
public class UserController4Response {

//响应跳转页面
    @RequestMapping("/redirect")
    public String redirect(){
        System.out.println("Redirect to page.jsp");
        return "page.jsp";
    }

    //响应文字
    @RequestMapping("/text")
    //@ResponseBody 才能把返回值加在网页的body里
    @ResponseBody
    public String text(){
        System.out.println("text()");
        return "response text";
    }
    //响应Json数据
    @RequestMapping("/jsonpojo")
    @ResponseBody
    public User jsonPojo(){
        User user = new User();
        user.setName("Joey");
        user.setAge(22);
        return user;

    }

    //响应Json List数据
    @RequestMapping("/jsonlistpojo")
    @ResponseBody
    public List<User> jsonListPojo(){
        User u1 = new User();
        u1.setName("Joey");
        u1.setAge(22);

        User u2 = new User();
        u2.setName("Tom");
        u2.setAge(21);

        List<User> users = new ArrayList<>();
        users.add(u1);
        users.add(u2);
        return users;

    }
}
