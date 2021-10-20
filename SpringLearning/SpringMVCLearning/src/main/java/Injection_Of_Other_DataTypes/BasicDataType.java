package Injection_Of_Other_DataTypes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BasicDataType  {


    private String username;
    private  int age;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void save()
    {
        System.out.println("age="+age);
        System.out.println("username="+username);
        System.out.println("running。。。。。。");
    }

    public static void main(String[] args) {

        //通过spring获取对象
        ApplicationContext app=new ClassPathXmlApplicationContext("ApplicationConfigContext.xml");
        BasicDataType bdt=(BasicDataType)app.getBean("BasicType");
        bdt.save();

    }
}
