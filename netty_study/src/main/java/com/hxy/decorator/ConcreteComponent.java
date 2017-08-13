package com.hxy.decorator;

//该类是一个具体构建角色
public class ConcreteComponent implements Component
{
    @Override
    public void doSomething()
    {
        System.out.println("功能A");
    }
}
