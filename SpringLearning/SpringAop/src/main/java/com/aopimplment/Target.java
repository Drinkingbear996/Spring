package com.aopimplment;

//被增强(吸收)的类
public class Target  implements  TargetInterface{
    @Override
    public void save() {
        System.out.println("save running...");
    }

}
