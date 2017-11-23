package com.hxy.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//流的使用：中间操作与终止操作
public class $7_StreamTest7
{
    public static void main(String[] args)
    {
        List<String> list = Arrays.asList("huang", "hxy", "yi");
        Stream<String> stream = list.stream();

        System.out.println(stream);
        stream.map(item -> {
            String result = item.substring(0, 1).toUpperCase() + item.substring(1);
            System.out.println("test");
            return result;
        }).forEach(System.out::println);

    }
}
