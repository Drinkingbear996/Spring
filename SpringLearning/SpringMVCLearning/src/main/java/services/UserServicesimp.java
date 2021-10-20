package services;

import demo.UserDao;

public class UserServicesimp  implements  UserService{
    private UserDao userDao;

    public UserServicesimp(UserDao xx) {
        this.userDao = xx;
    }
    //依赖注入
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public void save() {
        userDao.save();
    }

    //依赖注入 --有参构造



    public UserServicesimp() {
    }
}
