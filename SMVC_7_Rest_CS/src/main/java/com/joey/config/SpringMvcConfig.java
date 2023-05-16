package com.joey.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//3.创建Springmvc的配置文件,加载controller对应的bean
@Configuration
@ComponentScan({"com.joey.controller","com.joey.config"})
//4.2.2 - JSON数据传输  第二步 开启Webmvc 启动由Json数据转换成我们对象的这个功能
@EnableWebMvc
public class SpringMvcConfig {
}
