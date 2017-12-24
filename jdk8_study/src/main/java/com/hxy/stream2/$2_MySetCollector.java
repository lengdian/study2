package com.hxy.stream2;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;
import static java.util.stream.Collector.Characteristics.UNORDERED;

//自定义收集器！
public class $2_MySetCollector<T> implements Collector<T, Set<T>, Set<T>>
{
    public static void main(String[] args)
    {
        List<String> list = Arrays.asList("hello", "world", "welcome", "hello");

        Set<String> set = list.stream().collect(new $2_MySetCollector<>());

        System.out.println(set);

    }

    @Override
    public Supplier<Set<T>> supplier()
    {
        System.out.println("supplier invoked!");

        return HashSet<T>::new;
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator()
    {
        System.out.println("accmulator invoked!");

        return Set<T>::add;
    }

    @Override
    public BinaryOperator<Set<T>> combiner()
    {
        System.out.println("combiner invoked!");
        return (set1, set2) -> {
            set1.addAll(set2);
            return set1;
        };
    }

    @Override
    public Function<Set<T>, Set<T>> finisher()
    {
//        System.out.println("finisher invoked!");
//        return Function.identity();

        //如果不需要最后的转换，可以直接抛出异常，确保不会被调用到
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<Characteristics> characteristics()
    {
        System.out.println("characteristics invoked!");
        return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH, UNORDERED));
    }
}
