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

    public static int compareStudentByScore(Student s1, Student s2)
    {
        return s1.getScore() - s2.getScore();
    }

    public static int compareStudentByName(Student s1, Student s2)
    {
        return s1.getName().compareTo(s2.getName());
    }
}