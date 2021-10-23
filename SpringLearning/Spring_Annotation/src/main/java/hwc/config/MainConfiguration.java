package hwc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//标志着这是一个spring文件
@Configuration

@ComponentScan("hwc")
//主配置类导入分配置类（数据库的配置）
@Import(SpringConfiguration.class)
public class MainConfiguration {

}
