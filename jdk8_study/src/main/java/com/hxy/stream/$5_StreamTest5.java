package com.hxy.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//流的使用:flatmap方法
public class $5_StreamTest5
{
    public static void main(String[] args)
    {
        List<String> list = Arrays.asList("hxy", "huang", "yi", "test");
        list.stream().map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("------------------");

        Stream<List<Integer>> stream = Stream.of(Arrays.asList(1, 2, 3), Arrays.asList(4, 5), Arrays.asList(6));
        //flatmap:将子项列表打平成一个stream
        stream.flatMap(theList -> theList.stream()).map(item -> item * item).forEach(System.out::println);


    }
}
