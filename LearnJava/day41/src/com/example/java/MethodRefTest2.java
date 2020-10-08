package com.example.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 构造器引用和数组引用
 *
 * 构造器引用
 *      和方法引用类似，函数式接口的抽象方法的形参列表和构造器的形参列表一致。
 *      抽象方法的返回值类型即为构造器所属的类的类型
 *
 * 数组引用
 *      可以将数组看做是一个特殊的类，则写法与构造器引用一致
 *
 * @author Yi-27
 * @create 2020-10-08 16:18
 */
public class MethodRefTest2 {

    // 构造器引用
    // Suppiler中的T get()
    @Test
    public void test(){

        Supplier<Person> sup = new Supplier<Person>() {
            @Override
            public Person get() {
                return new Person();
            }
        };
        System.out.println(sup.get());
        System.out.println("***************************");

        Supplier<Person> sup1 = () -> new Person();
        System.out.println(sup1.get());

        System.out.println("***************************");

        Supplier<Person> sup2 = Person::new; // 构造器引用
        System.out.println(sup2.get());
    }

    // Function中的R apple(T t)
    @Test
    public void test2(){
        Function<String, Person> func1 = name -> new Person(name);
        Person person = func1.apply("哈哈哈");
        System.out.println(person); // Person{name='哈哈哈', age=0}
        System.out.println("*****************");

        Function<String, Person> func2 = Person::new;
        Person person1 = func2.apply("哈哈哈2");
        System.out.println(person1); // Person{name='哈哈哈2', age=0}
    }

    // BiFunction中的R apply(T t, U u)
    @Test
    public void test3(){
        BiFunction<String, Integer, Person> func1 = (name, age) -> new Person(name, age);
        System.out.println(func1.apply("哈哈哈", 21)); // Person{name='哈哈哈', age=21}

        System.out.println("**************");

        BiFunction<String, Integer, Person> func2 = Person::new;
        System.out.println(func2.apply("哈哈哈2", 22)); // Person{name='哈哈哈2', age=22}
    }

    // 数组引用
    // Function中的R apply(T t)
    @Test
    public void test4(){
        Function<Integer, String[]> func1 = length -> new String[length];
        String[] arr1 = func1.apply(5);
        System.out.println(Arrays.toString(arr1));

        System.out.println("****************************");

        Function<Integer, String[]> func2 = String[]::new;
        String[] arr2 = func2.apply(10);
        System.out.println(Arrays.toString(arr2));
    }


}
