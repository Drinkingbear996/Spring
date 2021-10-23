package hwc.dao;


import org.springframework.stereotype.Component;

//    <bean id="UserDao" class="hwc.dao.UserDaoImpl"></bean>


@Component("UserDao")
public class UserDaoImpl  implements UserDao{
    @Override
    public void save() {
        System.out.println("save running!");
    }

    public static void main(String[] args) {
        UserDao userDao=new UserDaoImpl();
        userDao.save();
    }
}
