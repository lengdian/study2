package com.hxy.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//stream分组操作，类似于sql语句的group by操作
//分区：partition，在这里可以认为是分组的一种特殊形式，分区只会根据给出的条件分成满足条件(true)和不满足条件(false)两组
public class $13_StreamTest13
{
    public static void main(String[] args)
    {
        Student s1 = new Student("zhangsan", 100, 20);
        Student s2 = new Student("lisi", 90, 20);
        Student s3 = new Student("wangwu", 90, 30);
        Student s4 = new Student("zhangsan", 80, 40);

        List<Student> studentList = Arrays.asList(s1, s2, s3, s4);

        //分组
        Map<String, List<Student>> map = studentList.stream().collect(Collectors.groupingBy(Student::getName));
        System.out.println(map);

        //分组并且计数
        Map<String, Long> map2 = studentList.stream().collect(Collectors.groupingBy(Student::getName, Collectors
                .counting()));
        System.out.println(map2);

        //分组并且求平均值
        Map<String, Double> map3 = studentList.stream().collect(Collectors.groupingBy(Student::getName, Collectors
                .averagingDouble(Student::getScore)));
        System.out.println(map3);

        //分区,key是boolean类型，只有两组
        Map<Boolean, List<Student>> map4 = studentList.stream().collect(Collectors.partitioningBy(student -> student
                .getScore() >= 90));
        System.out.println(map4);

    }
}
