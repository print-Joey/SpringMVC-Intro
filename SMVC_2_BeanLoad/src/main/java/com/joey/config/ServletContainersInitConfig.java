package com.joey.config;


import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;


//2.2 第二种 控制bean的加载
public class ServletContainersInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {


    @Override
    protected Class<?>[] getRootConfigClasses() {
        System.out.println("getRootConfigClasses");
        return new Class[]{SpringConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
////4.定义一个Servlet容器启动的配置类,在里面加载spring的配置
//public class ServletContainersInitConfig extends AbstractDispatcherServletInitializer {
//
//    //加载springMVC的容器配置
//    @Override
//    protected WebApplicationContext createServletApplicationContext() {
//        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
//        ctx.register(SpringMvcConfig.class);
//
//        return ctx;
//    }
//
//    //设置哪些请求归springMVC处理
//    @Override
//    protected String[] getServletMappings() {
//        return new String[]{"/"};
//    }
//    //加载spring的容器配置
//    @Override
//    protected WebApplicationContext createRootApplicationContext() {
//        return null;
//    }
//}
