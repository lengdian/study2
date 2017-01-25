package com.hxy.functionalInterface;

import java.util.function.Supplier;

//Supplier接口：不接收参数，返回一个结果
public class $6_SupplierTest
{
    public static void main(String[] args)
    {
        Supplier<String> supplier = () -> "hi";
        System.out.println(supplier.get());
    }

}
