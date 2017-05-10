package com.hxy.stream;

import java.util.stream.IntStream;

//流的使用
public class $2_StreamTest2
{
    public static void main(String[] args)
    {
        IntStream.of(new int[]{1,2,3}).forEach(System.out::println);
        System.out.println("--------------");

        IntStream.range(3,8).forEach(System.out::println);
        System.out.println("--------------");

        IntStream.rangeClosed(3,8).forEach(System.out::println);
        System.out.println("--------------");
    }
}
