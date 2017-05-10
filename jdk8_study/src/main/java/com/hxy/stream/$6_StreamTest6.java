package com.hxy.stream;

import java.util.stream.Stream;

//流的使用
public class $6_StreamTest6
{
    public static void main(String[] args)
    {
//        Stream<String> stream = Stream.generate(UUID.randomUUID()::toString);
//        stream.findFirst().ifPresent(System.out::println);

        //iterate方法需要与limit方法配合使用
        //mapToInt:避免自动拆装箱的性能损耗,同时生成的IntStream又可以提供便捷的方法
        //对比传统方式，代码更简洁，语义更清晰
//        System.out.println(Stream.iterate(1, item -> item + 2).limit(6).filter(item -> item > 2).mapToInt(item -> item * 2).skip(2).limit(2).sum());
//        IntSummaryStatistics summary = Stream.iterate(1, item -> item + 2).limit(6).filter(item -> item > 2).mapToInt(item -> item * 2).skip(2).limit(2).summaryStatistics();
//        System.out.println(summary.getSum());
//        System.out.println(summary.getMax());

        Stream<Integer> stream = Stream.iterate(1, item -> item + 2).limit(6);

        System.out.println(stream);
        System.out.println(stream.filter(item -> item > 2));
        //throw java.lang.IllegalStateException: stream has already been operated upon or closed
        //流一旦被使用或者关闭就不能再使用
        System.out.println(stream.distinct());


    }
}
