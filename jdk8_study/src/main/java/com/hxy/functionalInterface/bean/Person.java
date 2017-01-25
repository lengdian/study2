package com.hxy.functionalInterface.bean;

public class Person
{
    private String username = "hxy";

    private int age = 26;

    public Person(String username, int age)
    {
        this.username = username;
        this.age = age;
    }

    public Person()
    {
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
}
