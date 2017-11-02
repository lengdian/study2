package com.hxy.functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

//Predicate接口：与或非操作对应 and or negate方法
public class $5_PredicateTest2
{
    public static void main(String[] args)
    {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        $5_PredicateTest2 pt = new $5_PredicateTest2();

        Predicate<Integer> condition1 = value -> value > 5;
        pt.conditionFilter(list,condition1);
        System.out.println("-----------");

        Predicate<Integer> condition2 = value -> value <= 3;
        pt.conditionFilter(list,condition2);
        System.out.println("-----------");

        Predicate<Integer> condition3 = value -> true;
        pt.conditionFilter(list,condition3);
        System.out.println("-----------");

        pt.conditionFilter2(list,condition1,condition2);
    }

    //函数式强调一种更高层次的抽象，具体实现在真正使用时给出
    private void conditionFilter(List<Integer> list, Predicate<Integer> predicate)
    {
        for (Integer integer : list)
        {
            if (predicate.test(integer))
                System.out.print(" "+integer);

        }
        System.out.println();
    }

    private void conditionFilter2(List<Integer> list, Predicate<Integer> p1, Predicate<Integer> p2)
    {
        for (Integer integer : list)
        {
            if (p1.and(p2).negate().test(integer))
                System.out.print(" "+integer);

        }
        System.out.println();
    }

}
