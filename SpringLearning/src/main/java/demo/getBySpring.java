package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class getBySpring {
    public static void main(String[] args) {
        ApplicationContext app=new ClassPathXmlApplicationContext("ApplicationConfigContext.xml");

        UserDao ud=(UserDao) app.getBean("hwcdao");

        ud.insert();
        ud.save();
    }
}
