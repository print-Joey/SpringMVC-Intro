package com.joey.controller;


import com.joey.domain.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//2.定义controller
//2.1 使用@Controller 来定义bean
//Rest 风格 URl
// Create(增)  GET http://localhost:8080/SMVC_6_Rest/users  数据内容在请求体内

@RestController
//可代替
//@Controller
//@ResponseBody

@RequestMapping("/users")
public class UserController {

    //@ResponseBody  已加在类上
    @PostMapping
    //可代替
    //@RequestMapping (value = "/users",method = RequestMethod.POST)
    //value里的值已经加到类上
    public String save(@RequestBody User u){
        System.out.println("User save...");
        return "{'module':'springmvc-save()'}";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        System.out.println("user delete.." +id);
        return "{'module':'springmvc-delete()'}";
    }
    @PutMapping
    public String update(@RequestBody User u){
        System.out.println("user update..");
        return "{'module':'springmvc-update()'}";
    }
    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id){
        System.out.println("user getById..");
        return "{'module':'springmvc-getById()'}";
    }
    @GetMapping
    public String getByAll(){
        System.out.println("user getById..");
        return "{'module':'springmvc-getByAll()'}";
    }

}
