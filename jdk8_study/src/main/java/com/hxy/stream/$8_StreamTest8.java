package com.hxy.stream;

import java.util.stream.IntStream;

//流的使用
public class $8_StreamTest8
{
    public static void main(String[] args)
    {
        //正常程序
        IntStream.iterate(0, i -> (i + 1) % 2).limit(5).distinct().forEach(System.out::println);

        //注意该程序永远不会结束，因为iterate的无限流没有被截止
//        IntStream.iterate(0,i->(i+1)%2).distinct().limit(5).forEach(System.out::println);


    }
}
