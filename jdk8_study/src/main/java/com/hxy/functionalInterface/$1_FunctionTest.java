package com.hxy.functionalInterface;

import java.util.function.Function;

//Function接口
public class $1_FunctionTest
{
    public static void main(String[] args)
    {
        $1_FunctionTest ft = new $1_FunctionTest();

        //传递行为
        System.out.println(ft.compute(1, value -> 2 * value));
        System.out.println(ft.compute(2, value -> {
            return 5 + value;
        }));
        System.out.println(ft.convert(1, value -> "helloworld_" + value));

        //传递值
        System.out.println(ft.compute_1(1));
        System.out.println(ft.compute_2(1));

    }

    private int compute(int a, Function<Integer, Integer> function)
    {
        return function.apply(a);
    }

    private String convert(int a, Function<Integer, String> function)
    {
        return function.apply(a);
    }

    private int compute_1(int a)
    {
        return 2 * a;
    }

    private int compute_2(int a)
    {
        return 5 + a;
    }
}
