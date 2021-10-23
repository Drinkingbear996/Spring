package hwc.web;

import hwc.config.SpringConfiguration;
import hwc.service.UserService;
import hwc.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserController {
    public static void main(String[] args) {

        //利用注解配置文件加载
        ApplicationContext app=new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserService userService=(UserService)app.getBean("UserService");
        userService.save();





    }
}
