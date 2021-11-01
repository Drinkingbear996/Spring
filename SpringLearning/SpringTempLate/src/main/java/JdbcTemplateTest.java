import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;
import java.util.ResourceBundle;

public class JdbcTemplateTest {

    public static void main(String[] args) {

    }
    @Test
    public void test0()
    {
        ApplicationContext app=new ClassPathXmlApplicationContext("jdbcconfigcontext.xml");

        JdbcTemplate jdbcTemplate=(JdbcTemplate) app.getBean("jdbctemplate");

        int row = jdbcTemplate.update("insert into test (name,money) values ('李2',5000)");
        System.out.println(row);
    }

    //测试jdbcTemplate 开发步骤
    @Test
    public void test() throws PropertyVetoException {



        //读取配置文件
        ResourceBundle resourceBundle= ResourceBundle.getBundle("database");
        String Driver=resourceBundle.getString("jdbc.driver");
        String url=resourceBundle.getString("jdbc.url");
        String username=resourceBundle.getString("jdbc.username");
        String password=resourceBundle.getString("jdbc.password");


        //创建数据源对象
        ComboPooledDataSource comboPooledDataSource=new ComboPooledDataSource();


        //创建数据源对象
        comboPooledDataSource.setDriverClass(Driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(username);
        comboPooledDataSource.setPassword(password);


        //创建jdbctemplate
        JdbcTemplate jdbcTemplate=new JdbcTemplate();

        //设置数据源对象
        jdbcTemplate.setDataSource(comboPooledDataSource);

        //插入
        int i = jdbcTemplate.update("insert into account(name,money)  values ('TOM', 5000)");

        System.out.println(i);


    }
}
