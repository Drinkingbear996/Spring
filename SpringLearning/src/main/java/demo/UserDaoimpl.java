package demo;

public class UserDaoimpl implements  UserDao{

    public UserDaoimpl() {
        System.out.println("userdao的构造方法");
    }

    public void save() {
        System.out.println("save running");
    }

    public void insert() {
        System.out.println("insert running");
    }

    @Override
    public void init() {
        System.out.println("初始化方法....");
    }

    @Override
    public void destroy() {
        System.out.println("销毁方法....");
    }
}
