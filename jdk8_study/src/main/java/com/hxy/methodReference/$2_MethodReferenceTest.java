package com.hxy.methodReference;

import com.hxy.methodReference.bean.Student;

import java.util.Arrays;
import java.util.List;

public class $2_MethodReferenceTest
{
    public static void main(String[] args)
    {
        Student s1 = new Student("zhangsan", 20);
        Student s2 = new Student("lisi", 70);
        Student s3 = new Student("wangwu", 100);
        Student s4 = new Student("zhaoliu", 40);
        List<Student> studentList = Arrays.asList(s1, s2, s3, s4);

        studentList.sort((p1, p2) -> Student.compareStudentByScore(p1, p2));
        studentList.forEach(student -> System.out.println(student.getScore()));

        System.out.println("--------------------");

        studentList = Arrays.asList(s1, s2, s3, s4);
        //方式引用方式
        studentList.sort(Student::compareStudentByName);
        studentList.forEach(student -> System.out.println(student.getName()));

        System.out.println("--------------------");

    }
}
