package com.example.java;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 方法引用
 *
 * @author Yi-27
 * @create 2020-10-08 15:50
 */
public class MethodRefTest {

    // 情况一：对象::实例方法
    // Consumer中的void accept(T t)
    // PrintStream中的void println(T t)
    @Test
    public void test(){
        Consumer<String> con1 = str -> System.out.println(str);
        con1.accept("这时函数式接口+Lambda表达式使用");

        System.out.println("*************************");

        PrintStream ps = System.out; // 用标准输出作打印流
        Consumer<String> con2 = ps::println;
        con2.accept("这是方法引用的使用");
    }

    // 情况二：类::静态方法
    // Comparator中的int compare(T t1, T t2)
    // Integer中的int compare(T t1, T t2)
    @Test
    public void test2(){
        Comparator<Integer> com1 = (t1, t2) -> Integer.compare(t1, t2);
        System.out.println(com1.compare(12, 21));

        System.out.println("*****************************");

        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(12, 21));

        Comparator<Integer> com3 = Integer::compareTo; // 情况三
        System.out.println(com3.compare(12, 21));
    }

    // Function中的R apply(T t)
    // Math 中的Long round(Double d)
    @Test
    public void test3(){
        Function<Double, Long> func1 = d -> Math.round(d);
        System.out.println(func1.apply(12.3));
        System.out.println("***************");

        Function<Double, Long> func2 = Math::round;
        System.out.println(func2.apply(12.6));
    }


    // 情况三：类::实例方法（有难度）
    // Comparator中的int compare(T t1, T t2)
    // String 中的int t1.compareTo(t2)
    @Test
    public void test4(){
        Comparator<String> com1 = (s1, s2) -> s1.compareTo(s2);
        System.out.println(com1.compare("abc", "abd"));

        System.out.println("*************");

        Comparator<String> com2 = String::compareTo;
        System.out.println(com2.compare("abd", "abm"));
    }

    // BiPredicate中的boolean test(T t1, T t2);
    // String中的boolean t1.equals(t2)
    @Test
    public void test5(){
        BiPredicate<String, String> pre1 = (s1, s2) -> s1.equalsIgnoreCase(s2);
        System.out.println(pre1.test("ABC", "abc"));

        System.out.println("****************");

        BiPredicate<String, String> pre2 = String::equalsIgnoreCase;
        System.out.println(pre2.test("DEF", "deb"));

    }

}
