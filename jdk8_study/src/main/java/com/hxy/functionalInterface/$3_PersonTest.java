package com.hxy.functionalInterface;

import com.hxy.functionalInterface.bean.Person;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

//BiFunction实例
public class $3_PersonTest
{
    public static void main(String[] args)
    {
        Person p1 = new Person("zhangsan", 20);
        Person p2 = new Person("lisi", 30);
        Person p3 = new Person("wangwu", 40);
        List<Person> personList = Arrays.asList(p1, p2, p3);

        $3_PersonTest test = new $3_PersonTest();
        List<Person> persons = test.getPersonByUsername("zhangsan", personList);
        persons.forEach(person -> System.out.println(person.getUsername()));

        persons = test.getPersonByAge(25, personList);
        persons.forEach(person -> System.out.println(person.getAge()));

        BiFunction<Integer, List<Person>, List<Person>> biFunction = (age1, persons1) -> persons1.stream().filter
                (person -> person.getAge() < age1).collect(Collectors.toList());
        persons = test.getPersonByAge2(25, personList, biFunction);
        persons.forEach(person -> System.out.println(person.getAge()));
    }

    private List<Person> getPersonByUsername(String username, List<Person> persons)
    {
        return persons.stream().filter(person -> person.getUsername().equals(username)).collect(Collectors.toList());
    }

    private List<Person> getPersonByAge(int age, List<Person> persons)
    {
        BiFunction<Integer, List<Person>, List<Person>> biFunction = (age1, persons1) -> persons1.stream().filter
                (person -> person.getAge() > age1).collect(Collectors.toList());

        return biFunction.apply(age, persons);

    }

    private List<Person> getPersonByAge2(int age, List<Person> persons, BiFunction<Integer, List<Person>,
            List<Person>> biFunction)
    {
        return biFunction.apply(age, persons);

    }
}
