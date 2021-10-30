package com.Annotation;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("MyAspect")
@Aspect //标注当前Aspect是一个切面类
public class MyAspect {


    //由于很多通知的切面表达式都相同 我们可以将它抽取出来
    @Pointcut("execution(* com.Annotation.*.*(..))")
    public void MyPointcut() {}

    //配置前置通知

    //增强方法A
    @Pointcut("MyAspect.MyPointcut()")
    public void initPrepare()
    {
        System.out.println("初始化之前准备");
    }





    //增强方法B
    @Pointcut("MyAspect.MyPointcut()")
    public void initCompleted()
    {
        System.out.println("初始化完成后");
    }
}
