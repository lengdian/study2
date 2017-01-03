package com.hxy.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test3_4
{
    public static void main(String[] args)
    {
//        TheInterface ti=() -> {};
//        System.out.println(ti.getClass().getInterfaces()[0]);
//
//        TheInterface2 ti2=() -> {};
//        System.out.println(ti2.getClass().getInterfaces()[0]);
//
//        new Thread(() -> System.out.println("hello world")).start();

        List<String> list= Arrays.asList("hello","world","hello world");
        List<String> list2=new ArrayList<>();
        // 传统复制方法
//        list.forEach(item -> list2.add(item.toUpperCase()));
//        list2.forEach(item -> System.out.println(item));

        //流（stream）
        list.stream().map(item -> item.toUpperCase()).forEach(item -> System.out.println(item));

//        list.forEach(item -> System.out.println(item.toUpperCase()));

    }
}

@FunctionalInterface
interface TheInterface{
    void theMethod();
}

@FunctionalInterface
interface TheInterface2{
    void theMethod2();
}
