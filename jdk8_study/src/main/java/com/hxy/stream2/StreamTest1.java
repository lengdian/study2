package com.hxy.stream2;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.*;

public class StreamTest1
{
    public static void main(String[] args)
    {
        Student s1 = new Student("zhangsan", 80);
        Student s2 = new Student("lisi", 90);
        Student s3 = new Student("wangwu", 100);
        Student s4 = new Student("zhaoliu", 80);

        List<Student> students = Arrays.asList(s1, s2, s3, s4);

        List<Student> students1 = students.stream().collect(toList());
        students1.forEach(System.out::println);
        System.out.println("-------------------------");

        System.out.println(students.stream().collect(counting()));
        System.out.println(students.stream().count());


    }
}
