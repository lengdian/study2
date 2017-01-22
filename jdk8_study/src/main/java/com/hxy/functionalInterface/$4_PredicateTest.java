package com.hxy.functionalInterface;

import java.util.function.Predicate;

//Predicate接口:输入判断操作，返回判断结果
public class $4_PredicateTest
{
    public static void main(String[] args)
    {
        Predicate<String> predicate=value->value.length()>=5;
        System.out.println(predicate.test("hello"));
    }

}
