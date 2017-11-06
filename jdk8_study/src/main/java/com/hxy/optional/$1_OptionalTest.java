package com.hxy.optional;

import java.util.Optional;

//Optional类使用
public class $1_OptionalTest
{
    public static void main(String[] args)
    {
        Optional<String> optional = Optional.of("hello");
        //        Optional<String> optional = Optional.empty();
        //        Optional<String> optional = Optional.ofNullable("hello");


        //固有思维方式，不推荐的方式
        //        if (optional.isPresent())
        //        {
        //            System.out.println(optional.get());
        //        }

        //函数式风格:推荐的Optional使用方式
        optional.ifPresent(item -> System.out.println(item));
        System.out.println("----------------------");

        System.out.println(optional.orElse("world"));
        System.out.println("----------------------");

        System.out.println(optional.orElseGet(() -> "hihao"));
        System.out.println("----------------------");


    }
}
