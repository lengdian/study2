package com.hxy.methodReference.bean;

public class Student
{
    private String name;
    private int score;

    public Student(String name, int score)
    {
        this.name = name;
        this.score = score;
    }

    public String getName()
    {
        return name;
    }

    public int getScore()
    {
        return score;
    }

    //设计错误的方式
    public static int compareStudentByScore(Student s1, Student s2)
    {
        return s1.getScore() - s2.getScore();
    }

    public static int compareStudentByName(Student s1, Student s2)
    {
        return s1.getName().compareToIgnoreCase(s2.getName());
    }

    //设计正确的方式
    public int compareByScore(Student student)
    {
        return this.getScore() - student.getScore();
    }

    public int compareByName(Student student)
    {
        return this.getName().compareToIgnoreCase(student.getName());
    }
}
