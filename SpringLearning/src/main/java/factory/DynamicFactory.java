package factory;

import demo.UserDao;
import demo.UserDaoimpl;

public class DynamicFactory {
    public   UserDao getUserDao()
    {
        return new UserDaoimpl();
    }
}
