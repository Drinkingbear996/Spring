package com.aopimplment;

//增强类

import javafx.beans.binding.ObjectExpression;
import org.aspectj.lang.ProceedingJoinPoint;

/**
  * 通俗点说就是MyAspect吸收了Target方法，通过before在吸收的方法前输出（或通过after在吸收的方法后输出）
  * */
public class MyAspect {

    //在原方法的主干上增强
    public void before()
    {
        System.out.println("前置增强。。。。");
    }


 //Proceeding JoinPoint 正在执行的连接点===切点
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕前增强");
        Object proceed =proceedingJoinPoint.proceed();//切点方法

        System.out.println("环绕后增强");
        return  proceed;
    }
   //抛出异常所对应的方法
    public void MyAspectException()
    {
        System.out.println("save running");
    }

    //不管抛不抛出异常，最终方法都要执行
    public void finallyRunning()
    {
        System.out.println("最终增强");
    }

}
