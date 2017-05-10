package com.hxy.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//流的创建
public class $1_StreamTest1
{
    public static void main(String[] args)
    {
        Stream stream1= Stream.of("hxy","huang");

        String[] myArray=new String[]{"hxy","huang"};
        Stream stream2=Stream.of(myArray);

        Stream stream3= Arrays.stream(myArray);

        List<String> list=Arrays.asList(myArray);
        Stream stream4=list.stream();
    }
}
