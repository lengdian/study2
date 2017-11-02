package com.hxy.functionalInterface;

import com.hxy.functionalInterface.bean.Person;

import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

//Supplier接口
public class $7_PersonTest2
{
    public static void main(String[] args)
    {
        Supplier<Person> supplier=() -> new Person();
        System.out.println(supplier.get().getUsername());

        //构造方法引用形式
        Supplier<Person> supplier1=Person::new;
        System.out.println(supplier1.get().getUsername());



    }
}
