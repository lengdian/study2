package com.hxy.lambda;

@FunctionalInterface
interface MyInterface
{
    void test();

    //注解报错
    //    void test2();

    //重写java.lang.Object中的方法不会让接口中的抽象方法数量增加
    @Override
    String toString();
}

class Test2
{
    private void test(MyInterface mi)
    {
        System.out.println(1);
        mi.test();
        System.out.println(2);
    }

    public static void main(String[] args)
    {
        Test2 test2 = new Test2();
        //传统匿名内部类方式
        //        test2.test(new MyInterface()
        //        {
        //            @Override
        //            public void test()
        //            {
        //                System.out.println("my test.");
        //            }
        //        });
        //lambda表达式方式
        test2.test(() -> System.out.println("my test."));

        System.out.println("-----------------------------");

        //实现FunctionalInterface注解的的接口的实例可以用lambda表达式生成
        MyInterface mi = () -> System.out.println("hello");
        System.out.println(mi.getClass());
    }
}
