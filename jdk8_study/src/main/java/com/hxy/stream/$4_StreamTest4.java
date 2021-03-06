package com.hxy.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static sun.plugin.javascript.navig.JSType.Link;

//流的使用：collect方法
public class $4_StreamTest4
{
    public static void main(String[] args)
    {
//        Stream<String> stream = Stream.of("hxy", "huang", "yi");
//        String[] stringArray=stream.toArray(String[]::new);
//        Arrays.asList(stringArray).forEach(System.out::println);

        Stream<String> stream = Stream.of("hxy", "huang", "yi");
//        List<String> list=stream.collect(Collectors.toList());
        //最后一个参数，合并多个list的操作，应该是因为并行流操作，使得有多个list需要合并成一个list返回？？？
//        List<String> list = stream.collect(() -> new ArrayList<String>(), (theList, item) -> theList.add(item), (theList1, theList2) -> theList1.addAll(theList2));
        List<String> list = stream.collect(LinkedList<String>::new, LinkedList<String>::add, LinkedList<String>::addAll);
        list.forEach(System.out::println);

        Stream<String> stream2 = Stream.of("hxy2", "huang2", "yi2");
        //更加灵活的collect
        Set<String> set=stream2.collect(Collectors.toCollection(HashSet<String>::new));
        set.forEach(System.out::println);

        Stream<String> stream3 = Stream.of("h", "x", "y");
        String str=stream3.collect(Collectors.joining()).toString();
        System.out.println(str);


    }
}
