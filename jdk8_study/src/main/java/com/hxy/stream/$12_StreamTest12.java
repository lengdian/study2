package com.hxy.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class $12_StreamTest12
{
    public static void main(String[] args)
    {
        List<String> list1 = Arrays.asList("Hi", "Hello", "你好");
        List<String> list2 = Arrays.asList("hxy", "hy", "zhuzhu", "yi");

        //flatmap使用
        List<String> list=list1.stream().flatMap(item -> list2.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList());
        list.forEach(System.out::println);

    }
}
