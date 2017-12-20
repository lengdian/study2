package com.hxy.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class $1_MyComparatorTest
{
    public static void main(String[] args)
    {
        List<String> list = Arrays.asList("nihao", "hello", "world", "welcome");

        //        Collections.sort(list);

        //一层Comparator,能根据上下文直接推断出类型
        //        Collections.sort(list, (item1, item2) -> item1.length() - item2.length());

        //        Collections.sort(list, Comparator.comparingInt(String::length).reversed());
        //        list.sort(Comparator.comparingInt(String::length));

        //两层Comparator，Comparator.comparingInt((String item) -> item.length())不能根据上下文直接推断出类型，离上下文太远
        //需要显示指定String类型，编译器无法进行类型推断
        //        Collections.sort(list, Comparator.comparingInt((String item) -> item.length()).reversed());

        //        Collections.sort(list, Comparator.comparingInt((Object item) -> 1).reversed());

        //多级比较
        //thenComparing:如果前一级比较结果相等，才使用thenComparing提供的比较器进行比较！！！
        //        Collections.sort(list, Comparator.comparingInt(String::length).thenComparing(String
        // .CASE_INSENSITIVE_ORDER));

        //        Collections.sort(list, Comparator.comparingInt(String::length).thenComparing(Comparator.comparing
        //                (String::toLowerCase, Comparator.reverseOrder())));

        //        Collections.sort(list, Comparator.comparingInt(String::length).reversed().thenComparing(Comparator
        // .comparing
        //                (String::toLowerCase, Comparator.reverseOrder())));

        Collections.sort(list, Comparator.comparingInt(String::length).reversed().thenComparing(Comparator.comparing
                (String::toLowerCase, Comparator.reverseOrder())).thenComparing(Comparator.reverseOrder()));

        System.out.println(list);

    }
}
