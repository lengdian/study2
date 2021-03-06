package com.hxy.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class $4_Test3
{
    public static void main(String[] args)
    {
        //lambda表达式返回的是对象，具体是什么类型的对象需要上下文信息才能判断
        //        TheInterface ti=() -> {};
        //        System.out.println(ti.getClass().getInterfaces()[0]);
        //        TheInterface2 ti2=() -> {};
        //        System.out.println(ti2.getClass().getInterfaces()[0]);
        //
        //        new Thread(() -> System.out.println("hello world")).start();

        List<String> list = Arrays.asList("hello", "world", "hello world");
        List<String> list2 = new ArrayList<>();
        // lambda表达式复制方法
        // list.forEach(item -> list2.add(item.toUpperCase()));
        // list2.forEach(item -> System.out.println(item));

        //流（stream）+lambda表达式
        list.stream().map(item -> item.toUpperCase()).forEach(item -> System.out.println(item));

        //流+方法引用
        list.stream().map(String::toUpperCase).forEach(System.out::println);

    }
}

@FunctionalInterface
interface TheInterface
{
    void theMethod();
}

@FunctionalInterface
interface TheInterface2
{
    void theMethod2();
}
