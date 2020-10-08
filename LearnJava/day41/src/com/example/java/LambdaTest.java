package com.example.java;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda表达式的使用及举例
 *
 * 1. 举例：(o1, o2) -> Integer.compare(o1, o2);
 * 2. 格式：
 *          -> ：Lambda操作符 或 箭头操作符
 *          ->左边：Lambda形参列表 （其实就是接口中的抽象方法的形参列表）
 *          ->右边：Lambda体    （其实就是重写的抽象方法的方法体）
 *
 * 3. Lambda表达式的使用：（分为6中情况介绍）
 *
 *      总结：
 *      ->左边：Lambda形参列表的参数类型可以省略（类型推断），如果Lambda形参列表只有一个参数，其一对()也可以省略
 *      ->右边：Lambda体应该使用一对{}包裹，如果Lambda体只有一条执行语句（可能是return语句），可以省略这一对{}和return关键字
 *
 * 4. Lambda表达式的本质：作为接口（函数式）的实例
 *    Lambda表达式依赖于函数式接口
 *
 * 5. 如果一个接口中，只声明了一个抽象方法，则此接口就称为函数式接口
 *
 * @author Yi-27
 * @create 2020-10-08 14:18
 */
public class LambdaTest {

    @Test
    public void test(){

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("这是通过接口实现的run方法");
            }
        };

        r1.run();

        System.out.println("***********************************");

        Runnable r2 = () -> System.out.println("这是通过Lambda表达式实现的run方法");
        r2.run();
    }

    @Test
    public void test2(){

        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        int compare1 = com1.compare(3, 4);
        System.out.println(compare1);

        System.out.println("*******************************");

        // Lambda表达式的写法
        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1, o2);
        int compare2 = com2.compare(3, 4);
        System.out.println(compare2);

        System.out.println("*******************************");

        // 方法引用
        Comparator<Integer> com3 = Integer :: compare;
        int compare3 = com2.compare(3, 4);
        System.out.println(compare3);
    }


    // 语法格式一：无参，无返回值
    @Test
    public void test3(){

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("这是通过接口实现的run方法");
            }
        };

        Runnable r2 = () -> System.out.println("这是通过Lambda表达式实现的run方法");
        r2.run();
    }

    // 语法格式二：Lambda需要一个参数，但是没有返回值
    // 语法格式三：数据类型可以省略，因为可由编译器推断得出，称为“类型推断”
    // 语法格式四：Lambda若只需要一个参数时，参数的小括号可以省略
    @Test
    public void test4(){

        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        con.accept("通过方法调用");

        Consumer<String> con2 = (String s) -> {
            System.out.println(s);
        };

        con2.accept("通过Lambda表达式语法格式二调用");

        Consumer<String> con3 = (s) -> {
            System.out.println(s);
        };

        con3.accept("通过Lambda表达式语法格式三调用");

        Consumer<String> con4 = s -> {
            System.out.println(s);
        };

        con4.accept("通过Lambda表达式语法格式四调用");
    }


    // 语法格式五：Lambda需要两个或以上的参数，多条执行语句，并且可以有返回值
    @Test
    public void test5(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };

        System.out.println(com1.compare(12, 21));

        System.out.println("********************************");

        Comparator<Integer> com2 = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };

        System.out.println(com2.compare(12, 6));
    }


    // 语法格式六：当Lambda体只有一条语句时，return与大括号若有，都可以省略
    @Test
    public void test6(){
        Comparator<Integer> com1 = (o1, o2) -> {
            return o1.compareTo(o2);
        };

        System.out.println("********************************");

        Comparator<Integer> com2 = (o1, o2) -> o1.compareTo(o2);

        System.out.println(com2.compare(12, 21));
    }

}
