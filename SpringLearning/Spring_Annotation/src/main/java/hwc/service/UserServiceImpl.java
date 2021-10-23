package hwc.service;

import hwc.dao.UserDao;
import hwc.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;


// <bean id="UserService" class="hwc.service.UserServiceImpl"></bean>

@Component("UserService")
public class UserServiceImpl  implements  UserService{

    // <property name="userDao" ref="UserDao"> </property>
//    @Autowired
//    @Qualifier("UserDao") //对应bean的id
    @Resource(name = "UserDao")

    /**
     * @Autowired 是按照类型从从容器中匹配的
     * @@Autowired +@Qualifier(bean中id的值)
     * @Resource(name = bean中id的值)
     * */

   private UserDao userDao;


   private  String value;
    public void setUserDao(UserDao userDao) {
        this.userDao=userDao;
    }

    @Override
    public void save()
    {
        userDao.save();
    }

    @PostConstruct
    public void init()
    {
        System.out.println("Service对象的初始化方法");
    }

    @PreDestroy
    public void destroy()
    {
        System.out.println("Service对象的销毁方法");
    }

}
