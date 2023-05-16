import com.joey.config.SpringConfig;
import com.joey.config.SpringMvcConfig;
import com.joey.controller.UserController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        //注册配置类

        ctx.register(SpringConfig.class);

        ctx.refresh();
        UserController uc=ctx.getBean(UserController.class);
        System.out.println(uc);
    }
}
    //Exception in thread "main" java.lang.IllegalStateException: org.springframework.context.annotation.AnnotationConfigApplicationContext@7506e922 has not been refreshed yet
    //    at org.springframework.context.support.AbstractApplicationContext.assertBeanFactoryActive(AbstractApplicationContext.java:1119)
    //    at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1149)
    //    at App.main(App.java:16)


//因为没refresh
//ctx.refresh();