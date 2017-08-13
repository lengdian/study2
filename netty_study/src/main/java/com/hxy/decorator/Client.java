package com.hxy.decorator;

public class Client
{
    public static void main(String[] args)
    {
        //装饰模式实现
        Component component=new ConcreteDecorator2(new ConcreteDecorator1(new ConcreteComponent()));
        component.doSomething();
    }
}
