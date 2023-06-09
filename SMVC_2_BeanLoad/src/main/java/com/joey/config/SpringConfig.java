package com.joey.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

//3.创建Springmvc的配置文件,加载controller对应的bean
@Configuration
//2.1第一种控制bean的加载
//excludeFilters属性
@ComponentScan(value = "com.joey",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class))
public class SpringConfig {
}
