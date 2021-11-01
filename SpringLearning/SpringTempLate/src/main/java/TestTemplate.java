import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:jdbcconfigcontext.xml")
public class TestTemplate {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    //查询一个 //queryForObject 返回的是一个对象实例 （泛型是返回的对象类型）
    @Test
    public void testQueryOne(){
        Account account = jdbcTemplate.queryForObject("select * from test where name=?", new BeanPropertyRowMapper<Account>(Account.class), "张三");
        System.out.println(account);
    }

    //聚合查询 //queryForObject 返回的是一个对象实例（java.util包封装的类）
    @Test
    public void testQueryCount(){
        Long count = jdbcTemplate.queryForObject("select count(*) from test", Long.class);
        System.out.println(count);
    }

    //查询全部
    @Test
    public void test1() //query 返回的是一个集合 （泛型是返回的集合类型）
    {
        List<Account> accountList = jdbcTemplate.query("select * from test", new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(accountList);
    }

}
