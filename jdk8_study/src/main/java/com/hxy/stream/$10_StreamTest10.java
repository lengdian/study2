package com.hxy.stream;

import java.util.Arrays;
import java.util.List;

//流的短路运算
public class $10_StreamTest10
{
    public static void main(String[] args)
    {
        List<String> list = Arrays.asList("hello2", "world", "hello world");

        //        list.stream().mapToInt(String::length).filter(item -> item == 5).findFirst().ifPresent(System
        //                .out::println);

        //不管中间生成了多少个新的stream，可以认为只有一个循环，循环里面使用了所有自定义的操作
        list.stream().mapToInt(item -> {
            int length = item.length();
            System.out.println(item);
            return length;
        }).filter(item -> item == 5).findFirst().ifPresent(System.out::println);

    }
}
