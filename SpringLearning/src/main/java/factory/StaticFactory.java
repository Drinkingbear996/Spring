package factory;

import demo.UserDao;
import demo.UserDaoimpl;

public class StaticFactory {

    public  static UserDao  getUserDao()
    {
        return new UserDaoimpl();
    }


}

