package com.hxy.decorator;

//该类是具体装饰角色
public class ConcreteDecorator2 extends Decorator
{
    public ConcreteDecorator2(Component component)
    {
        super(component);
    }

    @Override
    public void doSomething()
    {
        super.doSomething();
        this.doAnotherThing();
    }

    private void doAnotherThing()
    {
        System.out.println("功能C");
    }
}
