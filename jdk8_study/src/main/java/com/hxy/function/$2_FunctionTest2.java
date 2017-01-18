package com.hxy.function;

import java.util.function.BiFunction;
import java.util.function.Function;

/*
Function接口的compose和andThen方法
 */
public class $2_FunctionTest2
{
    public static void main(String[] args)
    {
        $2_FunctionTest2 ft = new $2_FunctionTest2();

        System.out.println(ft.compute(2, value -> value * 3, value -> value * value));
        System.out.println(ft.compute2(2, value -> value * 3, value -> value * value));

        System.out.println(ft.compute3(1, 2, (v1, v2) -> v1 + v2));
        System.out.println(ft.compute3(1, 2, (v1, v2) -> v1 * v2));
    }

    //compose方法：f1 <- f2 <- value
    private int compute(int a, Function<Integer, Integer> f1, Function<Integer, Integer> f2)
    {
        //注意组合f1、f2函数之后会生成新的函数f_new
        Function<Integer, Integer> f_new = f1.compose(f2);
        return f_new.apply(a);
    }

    //andThen方法：f2 <- f1 <- value
    private int compute2(int a, Function<Integer, Integer> f1, Function<Integer, Integer> f2)
    {
        Function<Integer, Integer> f_new = f1.andThen(f2);
        return f_new.apply(a);
    }

    //BiFunction:接收两个参数，返回一个结果
    private int compute3(int a, int b, BiFunction<Integer, Integer, Integer> bif)
    {
        return bif.apply(a, b);
    }


}
