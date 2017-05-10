package com.hxy.InterfaceDefaultMethod;

public class $4_MyClass2 extends $5_MyInterface1Impl implements $3_MyIntreface2
{
    public static void main(String[] args)
    {
        $4_MyClass2 myClass=new $4_MyClass2();
        //调用接口实现类里面的方法：实现类的同名方法优先级高于接口里面的默认方法
        myClass.myMethod();
    }
}
