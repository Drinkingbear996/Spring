package com.Annotation;

import org.springframework.stereotype.Component;

@Component("Target")
public class Target implements  TargetInterface {

    @Override
    public void init()
    {
        System.out.println("初始化完成");
    }
}
