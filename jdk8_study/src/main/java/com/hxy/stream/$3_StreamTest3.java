package com.hxy.stream;

import java.util.Arrays;
import java.util.List;

//流的使用
public class $3_StreamTest3
{
    public static void main(String[] args)
    {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(list.stream().map(i->2*i).reduce(0,Integer::sum));

    }
}
