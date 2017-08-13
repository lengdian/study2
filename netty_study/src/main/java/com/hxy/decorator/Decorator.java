package com.hxy.decorator;

//该类是装饰角色
public class Decorator implements Component
{
    private Component component;

    public Decorator(Component component)
    {
        this.component = component;
    }

    @Override
    public void doSomething()
    {
        component.doSomething();
    }
}
