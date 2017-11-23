package com.hxy.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

//流的使用
public class $11_StreamTest11
{
    public static void main(String[] args)
    {
        List<String> list = Arrays.asList("hello welcome", "world hello", "hello world hello", "hello welcome");

        //去重操作
        list.stream().flatMap(item -> Arrays.stream(item.split(" "))).distinct().forEach(System.out::println);

    }
}
