package com.hxy.InterfaceDefaultMethod;

public interface $1_MyInterface1
{
    //接口的默认方法:引入默认方法主要是为了向后兼容
    default void myMethod()
    {
        System.out.println("MyInterface1");
    }
}
