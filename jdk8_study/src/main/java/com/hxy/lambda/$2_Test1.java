package com.hxy.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class  $2_Test1
{
    public static void main(String[] args)
    {
        List<Integer> list = Arrays.asList(1, 2, 3);

        //传统循环方式
        for (int i = 0; i < list.size(); i++) System.out.println(list.get(i));

        System.out.println("-----------------------");

        //增强的for循环方式
        for (Integer i : list) System.out.println(i);

        System.out.println("-----------------------");

        //匿名内部类方式
        list.forEach(new Consumer<Integer>()
        {
            @Override
            public void accept(Integer integer)
            {
                System.out.println(integer);
            }
        });

        System.out.println("-----------------------");

        //lambda表达式方式
        list.forEach(i -> System.out.println(i));

        System.out.println("-----------------------");

        //方法引用方式 method reference
        list.forEach(System.out::println);

    }
}
