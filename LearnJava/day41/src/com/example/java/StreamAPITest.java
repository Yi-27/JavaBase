package com.example.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 1. Stream关注的是对数据的运算，与CPU打交道
 *    集合关注的是数据的存储，与内存打交道
 *
 * 2. + Stream自己不会存储元素
 * + Stream不会改变源对象。相反，它们会返回一个持有结果的新的Stream
 * + Stream操作是延迟执行的。这意味着它们会等到需要结果的时候才执行
 *
 * 3。 + 创建Stream
 *     + 一个数据源（如：集合、数组），获取一个流
 *     + 中间操作
 *     + 一个中间操作链，对数据源的数据进行处理。（延迟执行）
 *     + 终止操作（终端操作）
 *     + 一旦执行终止操作，**就执行中间操作链**，并产生结果。
 *     + 之后，不会再被使用
 *
 * 测试Stream的实例化
 *
 *
 * @author Yi-27
 * @create 2020-10-08 21:19
 */
public class StreamAPITest {

    // 创建Stream方式一：通过集合
    @Test
    public void test(){
        List<Person> persons = Person.getPersons();

        // default Stream<E> stream() ：List接口的一个default方法，返回一个顺序流
        Stream<Person> stream = persons.stream();

        // default Stream<E> parallelStream()：返回一个并行流
        Stream<Person> parallelStream = persons.parallelStream();
    }

    // 创建Stream方式二：通过数组
    @Test
    public void test2(){
        int[] arr = {1,2,3,4,5,6};

        // 通过Arrays类的静态方法static <T> Stream<T> stream(T[] array)：返回一个流
        IntStream stream = Arrays.stream(arr);

        Person p1 = new Person("Tom", 21);
        Person p2 = new Person("Jack", 12);
        Person[] arr1 = {p1, p2};
        Stream<Person> stream1 = Arrays.stream(arr1);
    }

    // 创建Stream方式三：通过Stream的of()
    @Test
    public void test3(){

        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);
    }

    // 创建Stream方式四：创建无限流
    @Test
    public void test4(){

        // 迭代
        // public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        // 遍历前10个偶数
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);

        // 生成
        // public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}
