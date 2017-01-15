package com.hxy.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class $5_StringComparator
{
    public static void main(String[] args)
    {
        List<String> names = Arrays.asList("zhangsan", "lisi", "wangwu", "zhaoliu");
        System.out.println(names);

//        Collections.sort(names, new Comparator<String>()
//        {
//            @Override
//            public int compare(String o1, String o2)
//            {
//                return o2.compareTo(o1);
//            }
//        });
//        System.out.println(names);

        //expression lambda: o2.compareTo(o1)
        //statsment lambda:{return o2.compareTo(o1);}
        Collections.sort(names, (o1, o2) -> o2.compareTo(o1));
        System.out.println(names);
    }
}
