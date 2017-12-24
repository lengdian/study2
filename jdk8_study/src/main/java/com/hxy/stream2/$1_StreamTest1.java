package com.hxy.stream2;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class $1_StreamTest1
{
    public static void main(String[] args)
    {
        Student s1 = new Student("zhangsan", 80);
        Student s2 = new Student("lisi", 90);
        Student s3 = new Student("wangwu", 100);
        Student s4 = new Student("zhaoliu", 90);
        Student s5 = new Student("zhaoliu", 90);

        List<Student> students = Arrays.asList(s1, s2, s3, s4, s5);

        List<Student> students1 = students.stream().collect(toList());
        students1.forEach(System.out::println);
        System.out.println("-------------------------");

        System.out.println(students.stream().collect(counting()));
        System.out.println(students.stream().count());

        students.stream().collect(minBy(comparingInt(Student::getScore))).ifPresent(System.out::println);
        students.stream().collect(maxBy(comparingInt(Student::getScore))).ifPresent(System.out::println);
        System.out.println(students.stream().collect(averagingInt(Student::getScore)));
        System.out.println(students.stream().collect(summingInt(Student::getScore)));
        //获取摘要信息IntSummaryStatistics{count=4, sum=360, min=80, average=90.000000, max=100}
        IntSummaryStatistics summaryStatistics = students.stream().collect(summarizingInt(Student::getScore));
        System.out.println(summaryStatistics);
        System.out.println("-------------------------------");

        //拼接操作
        System.out.println(students.stream().map(Student::getName).collect(joining()));
        System.out.println(students.stream().map(Student::getName).collect(joining(", ")));
        System.out.println(students.stream().map(Student::getName).collect(joining(", ", "<begin>", "<end>")));
        System.out.println("-------------------------------");

        //多级分组
        Map<Integer, Map<String, List<Student>>> map = students.stream().collect(groupingBy(Student::getScore,
                groupingBy(Student::getName)));
        System.out.println(map);
        System.out.println("-------------------------------");

        //多级分区
        Map<Boolean, Map<Boolean, List<Student>>> map2 = students.stream().collect(partitioningBy(item -> item
                .getScore() > 80, partitioningBy(item2 -> item2.getScore() > 90)));
        System.out.println(map2);
        System.out.println("-------------------------------");

        //collector嵌套
        Map<Boolean, Long> map3 = students.stream().collect(partitioningBy(item -> item.getScore() > 80, counting()));
        System.out.println(map3);
        System.out.println("-------------------------------");




    }
}
