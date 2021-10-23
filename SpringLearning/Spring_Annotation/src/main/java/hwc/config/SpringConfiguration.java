package hwc.config;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

//标志该类是spring和核心配置类
@Configuration

//扫描此包下的注解
@ComponentScan("hwc")
//   <context:component-scan base-package="hwc"></context:component-scan>

@PropertySource("classpath:jdbc.properties")
//   <context:property-placeholder location="classpath:jdbc.properties"></context:property-placeholder>
public class SpringConfiguration {

    //通过注解从配置文件xxx.properties中获取jdbc的配置
    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.url}")
    private String username;

    @Value("${jdbc.username}")
    private String password;

    @Bean("datasource") //spring会将当前方法的返回值以指定名称存储到Spring容器中
    public DataSource getDataSource() throws PropertyVetoException {



        //c3p0数据源
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);

        //账号和密码
        dataSource.setUser(username);
        dataSource.setPassword(password);

        return  dataSource;

    }
}
