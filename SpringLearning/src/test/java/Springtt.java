import demo.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import services.UserService;

public class Springtt {

    @Test
    //测试属性
    public static void main(String[] args) {
//        ApplicationContext app=new  ClassPathXmlApplicationContext("ApplicationConfigContext.xml");
//        UserDao userDao=(UserDao) app.getBean("hwcdao");
//        UserDao userDao1=(UserDao) app.getBean("hwcdao");
//
//        System.out.println(userDao);
//        System.out.println(userDao1);

        //scope="singleton" 打印地址相同，只有一个实例对象
        //scope="prototype" 打印地址不相同，可以有多个实例对象

       //无参构造方法
        ApplicationContext app1=new ClassPathXmlApplicationContext("ApplicationConfigContext.xml");
        UserDao userDao2=(UserDao) app1.getBean("hwcdao1");
        UserDao userDao3=(UserDao) app1.getBean("hwcdao1");

        //销毁方法
        ((ClassPathXmlApplicationContext)app1).close();




       //静态工厂创建方法
        ClassPathXmlApplicationContext app2=new ClassPathXmlApplicationContext("ApplicationConfigContext.xml");
        UserDao userDao4=(UserDao) app2.getBean("hwcdao2");

        System.out.println(userDao4);



        //实例工厂创建方法
        ClassPathXmlApplicationContext app3=new ClassPathXmlApplicationContext("ApplicationConfigContext.xml");
        UserDao userDao5=(UserDao) app3.getBean("hwcdao3");

        System.out.println(userDao5+"555");

        System.out.println("============================");


            //从 UserServices的实现类在调用 UserDao的save() 方法，再从Spring 容器中获得 UserService 进行操作、
            //在resource下的类加载文件
            ApplicationContext app4=new ClassPathXmlApplicationContext("ApplicationConfigContext.xml");
            UserService use=( UserService)app4.getBean("userservice");
            use.save();

            //文件磁盘加载文件，xml文件的绝对路径
            ApplicationContext appF=new FileSystemXmlApplicationContext("/Users/pioneerrr/IdeaProjects/demo_mAven/Spring/SpringLearning/src/main/resources/ApplicationConfigContext.xml");
            UserService useF=(UserService)appF.getBean("userservice");
            useF.save();

    }
}
