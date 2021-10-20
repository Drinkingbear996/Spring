package Injection_Of_Other_DataTypes;

import Injection_Of_Other_DataTypes.admin.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Properties;


public class ReferenceDataType {
    private List<String> list;
    private Map<String, User> map;
    private Properties properties;

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, User> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public  void save()
    {
        System.out.println(list);
        System.out.println(map);
        System.out.println(properties);
    }



    public static void main(String[] args) {
        ApplicationContext app=new  ClassPathXmlApplicationContext("ApplicationConfigContext.xml");
        ReferenceDataType rdt=(ReferenceDataType) app.getBean("ReferenceType");
        rdt.save();
    }
}
