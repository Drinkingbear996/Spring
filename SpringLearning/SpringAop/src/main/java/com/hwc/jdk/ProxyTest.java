package com.hwc.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {

      final   Target target=new Target();

      //增强对象
        Advice advice=new Advice();


       //返回值就是 动态生成的代理对象
        TargetInterface proxy=(TargetInterface) Proxy.newProxyInstance(
                //目标对象相同的接口字节码对象数组
                target.getClass().getClassLoader(),

                //目标对象的类加载器
                target.getClass().getInterfaces(),
                new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //前置增强
                advice.before();
                Object invoke= method.invoke(target,args);
                //后置增强
                advice.After();
                return  invoke;
            }
        });

        //调用代理
        proxy.save();
    }


}
