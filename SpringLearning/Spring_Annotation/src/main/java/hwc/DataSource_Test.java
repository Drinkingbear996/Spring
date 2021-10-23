package hwc;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DataSource_Test {


    @Test
    public void test1() throws PropertyVetoException, SQLException {

        //c3p0数据源
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mysql?serverTimezone=Asia/Shanghai");

        //账号和密码
        dataSource.setUser("root");
        dataSource.setPassword("12345678");

        //连接数据库
        Connection connection=dataSource.getConnection();
        System.out.println(connection);
        connection.close();



    }
    @Test
    public void  test2() throws PropertyVetoException, SQLException {

        //Druid数据源
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mysql");

        //账号和密码
        dataSource.setUsername("root");
        dataSource.setPassword("12345678");

        //连接数据库
         DruidPooledConnection connection=dataSource.getConnection();
        System.out.println(connection);
        connection.close();



    }

    @Test
    //手动测试创建 c3p0 数据源,（加载properties配置文件）
    public void  test3() throws PropertyVetoException, SQLException {
     //1.读取配置文件
        ResourceBundle resourceBundle=ResourceBundle.getBundle("jdbc");

        String Driver=resourceBundle.getString("jdbc.driver");
        String url=resourceBundle.getString("jdbc.url");
        String username=resourceBundle.getString("jdbc.username");
        String password=resourceBundle.getString("jdbc.password");

     //2.创建数据源对象 设置连接参数
        ComboPooledDataSource dataSource=new ComboPooledDataSource();

        //3.set方法，通过配置文件配置
        dataSource.setDriverClass(Driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);

        dataSource.close();

    }

    @Test
    //测试spring容器产生数据源对象
    public void test4() throws SQLException {
        ApplicationContext app=new ClassPathXmlApplicationContext("ApplicationContextConfig.xml");

        ComboPooledDataSource dataSource=(ComboPooledDataSource) app.getBean("datasource");

        Connection connection=dataSource.getConnection();

        System.out.println(connection);
    }

}
