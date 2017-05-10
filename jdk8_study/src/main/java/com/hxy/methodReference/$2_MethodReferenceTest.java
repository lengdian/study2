package com.hxy.methodReference;

import com.hxy.methodReference.bean.Student;
import com.hxy.methodReference.bean.StudentComparator;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class $2_MethodReferenceTest
{
    String getString(Supplier<String> supplier)
    {
        return supplier.get() + "test";
    }

    String getString2(String str,Function<String,String> function)
    {
        return function.apply(str);
    }

    public static void main(String[] args)
    {
        Student s1 = new Student("zhangsan", 20);
        Student s2 = new Student("lisi", 70);
        Student s3 = new Student("wangwu", 100);
        Student s4 = new Student("zhaoliu", 40);
        List<Student> studentList = Arrays.asList(s1, s2, s3, s4);

        System.out.println("---------lambda表达式方式-----------");
        studentList.sort((p1, p2) -> Student.compareStudentByScore(p1, p2));
        studentList.forEach(student -> System.out.println(student.getScore()));

        System.out.println("---------方式引用方式-> 类名::静态方法名-----------");
        studentList = Arrays.asList(s1, s2, s3, s4);
        studentList.sort(Student::compareStudentByName);
        studentList.forEach(student -> System.out.println(student.getName()));

        System.out.println("---------方法引用方式-> 引用名（对象名）::实例方法名-----------");
        studentList = Arrays.asList(s1, s2, s3, s4);
        StudentComparator st = new StudentComparator();
        studentList.sort(st::compareStudentByName);
        studentList.forEach(student -> System.out.println(student.getName()));

        System.out.println("---------方法引用方式-> 类名::实例方法名-----------");
        studentList = Arrays.asList(s1, s2, s3, s4);
        //等价于：（s1,s2）-> s1.compareByScore(s2)
        //用第一个参数去作为实例去调用给出的方法，剩下的参数作为实参传递给该方法
        studentList.sort(Student::compareByScore);
        studentList.forEach(student -> System.out.println(student.getScore()));

        System.out.println("---------方法引用方式->(构造方法引用) 类名::new-----------");
        $2_MethodReferenceTest mrt = new $2_MethodReferenceTest();
        System.out.println(mrt.getString(String::new));
        System.out.println(mrt.getString2("hxy",String::new));

    }
}
