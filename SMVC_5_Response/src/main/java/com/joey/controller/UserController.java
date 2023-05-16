package com.joey.controller;


import com.joey.domain.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
//2.定义controller
//2.1 使用@Controller 来定义bean

@Controller
@RequestMapping("/user")
public class UserController {
    //2.2 设置当前操作的访问路径
    @RequestMapping ("/save")
    //2.3 设置当前操作的返回值类型
    //@ResponseBody  >  方法的返回值应直接写入 HTTP 响应正文
    @ResponseBody
    public String save(){
        System.out.println("User save...");
        return "{'module':'springmvc'}";
    }

    //http://localhost:8080/SMVC_4_ReqParam_war/user/commonParam?name=Joey

    //http://localhost:8080/SMVC_4_ReqParam_war/user/commonParam?name=%E5%8A%A0%E6%B2%B9

    //普通参数(Common parameter Passed: ==>Joey
    //2.2 设置当前操作的访问路径
    @RequestMapping ("/commonParam")
    //2.3 设置当前操作的返回值类型
    //@ResponseBody  >  方法的返回值应直接写入 HTTP 响应正文
    @ResponseBody
    public String commonParam(String name){
        System.out.println("普通参数(Common parameterP) Passed: ==>" + name);
        return "{'module':'springmvc-commonParam'}";
    }
    //http://localhost:8080/SMVC_4_ReqParam_war/user/commonParamDiffName?name=Joey&age=12
    //普通参数:请求参数(commonParam?name=Joey)和形参名不同(String username)
    @RequestMapping ("/commonParamDiffName")
    @ResponseBody
    public String commonParamDiffName(@RequestParam("name") String username, int age){
        System.out.println("普通参数(Common parameterP) Passed(name): ==>" + username);
        System.out.println("普通参数(Common parameterP) Passed(age): ==>" + age);
        return "{'module':'springmvc-commonParamDiffName'}";
    }

    //http://localhost:8080/SMVC_4_ReqParam_war/user/pojo?name=Joey&age=12
    //POJO参数:请求参数(name=Joey&age=12)
    @RequestMapping ("/pojo")
    @ResponseBody
    public String pojo(User user){
        System.out.println("POJO参数(POJO) Passed(User): ==>" + user);
        return "{'module':'springmvc-pojo'}";
    }
    //http://localhost:8080/SMVC_4_ReqParam_war/user/pojoCPojo?name=Joey&age=12&address.city=bj
    //POJO嵌套pojo参数:请求参数(name=Joey&age=12&address.city=bj)
    @RequestMapping ("/pojoCPojo")
    @ResponseBody
    public String pojoContainPojo(User user){
        System.out.println("POJOCPOJO参数(POJO) Passed(User): ==>" + user);
        return "{'module':'POJOCpojo'}";
    }

    //http://localhost:8080/SMVC_4_ReqParam_war/user/array?interest=bike&interest=swim
    //数组参数:请求参数(interest=bike&interest=swim)
    @RequestMapping ("/array")
    @ResponseBody
    public String arrayParam(String[] interests){
        System.out.println("数组参数 Passed(arrayParam): ==>" + Arrays.toString(interests));
        return "{'module':'arrayParam'}";
    }

    //http://localhost:8080/SMVC_4_ReqParam_war/user/list?interest=bike&interest=swim
    //集合参数:请求参数(interest=bike&interest=swim)
    @RequestMapping ("/list")
    @ResponseBody

    //要加@RequestParam  不然Spring会以为这是个pojo对象 然后调用<init>方法
    public String listParam(@RequestParam List<String> interests){
        System.out.println("集合参数 Passed(listParam): ==>" + (interests));
        return "{'module':'listParam'}";
    }

    //Json数据------------------------------------------------------------------------------------------------------------------------------
    //一共三种:  普通集合   普通pojo   pojo集合
    //如何发json格式的pojo【精准空降到 06:11】
    // https://www.bilibili.com/video/BV1Fi4y1S7ix/?p=51&share_source=copy_web&vd_source=55f4dd637d87e2d8d6f878cb7f1dd0a0&t=371
    //http://localhost:8080/SMVC_4_ReqParam_war/user/json
    //4.2.3 - JSON数据传输  第三步
    //json 普通集合参数:请求参数(["bike","swim"])
    @RequestMapping ("/json")
    @ResponseBody

    //要加@RequestBody (JSON) 不然Spring会以为这是个pojo对象 然后调用<init>方法
    public String jsonParam(@RequestBody List<String> interests){
        System.out.println("json参数 Passed(jsonParam): ==>" + (interests));
        return "{'module':'jsonParam'}";
    }


    //http://localhost:8080/SMVC_4_ReqParam_war/user/jsonpojo

    // json POJO参数:
    @RequestMapping ("/jsonpojo")
    @ResponseBody

    //要加@RequestBody (JSON) 不然Spring会以为这是个pojo对象 然后调用<init>方法
    public String pojoJsonParam(@RequestBody User u){
        System.out.println("json pojo参数 Passed(json pojo): ==>" + (u));
        return "{'module':'jsonpojo'}";
    }

    //集合参数: json格式
    @RequestMapping("/jsonlistpojo")
    @ResponseBody
    public String listPojoJson(@RequestBody List<User> list){
        System.out.println("list pojo json Passed(json pojo): ==>"+list.toString());
        return "{'module':'listPojoJson'}";
    }

    //日期数据-------------------------------------------------------------------VVVVVVVVVVVVVVVV
    @RequestMapping("/date")
    @ResponseBody
    public String date(Date date,
                       @RequestParam("date1") @DateTimeFormat(pattern = "yyyy-mm-dd") Date d1,
                       @RequestParam("date2")@DateTimeFormat(pattern="yyyy/mmm/dd HH:mm:ss") Date d2){
        System.out.println("参数传递 Date ==>"+date);
        System.out.println("参数传递 Date1 \"yyyy-mm-dd\" ==>"+d1);
        System.out.println("参数传递 Date2 \"yyyy/mmm/dd HH:mm:ss\" ==>"+d2);
        return "{'module':'date'}";
    }


}
//要加@RequestParam  不然Spring会以为这是个pojo对象 然后调用<init>方法
//org.apache.catalina.core.StandardWrapperValve.invoke Servlet.service() for servlet [dispatcher] in context with path
// [/SMVC_4_ReqParam_war] threw exception [Request processing failed: java.lang.IllegalStateException:
// No primary or single unique constructor found for interface java.util.List] with root cause