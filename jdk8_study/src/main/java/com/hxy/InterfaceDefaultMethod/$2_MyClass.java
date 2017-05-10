package com.hxy.InterfaceDefaultMethod;

public class $2_MyClass implements $1_MyInterface1,$3_MyIntreface2
{
    @Override
    public void myMethod()
    {
//        System.out.println("myClass");
        //特殊语法方式判定使用哪个接口的默认方法
        $3_MyIntreface2.super.myMethod();
    }

    public static void main(String[] args)
    {
        $2_MyClass myClass=new $2_MyClass();
        myClass.myMethod();
    }
}
