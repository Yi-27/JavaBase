package com.example.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 测试Stream的中间操作
 *
 * @author Yi-27
 * @create 2020-10-08 21:45
 */
public class StreamAPITest2 {

    // 1-筛选与切片
    @Test
    public void test(){

        List<Person> persons = Person.getPersons();
        // filter(Predocate p)：接收Lambda，从流中排除某些元素
        Stream<Person> stream = persons.stream();
        // 练习：年龄大于20的
        stream.filter(p -> p.getAge() > 20).forEach(System.out::println);

        System.out.println();

        // limit(n)：截断流，使其元素不超过给定数量
        persons.stream().limit(3).forEach(System.out::println); // persons.stream()放在前面因为上面已经终止了

        System.out.println();

        // skip(n)：跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流。与limit(n)互补
        persons.stream().skip(3).forEach(System.out::println);

        System.out.println();

        // distinct()：筛选，通过流所生成元素的hashCode()和equals()去除重复元素
        persons.add(new Person("哈哈哈", 50));
        persons.add(new Person("哈哈哈", 50));
        persons.add(new Person("哈哈哈", 50));
        persons.add(new Person("哈哈哈", 50));
        persons.stream().distinct().forEach(System.out::println); // 需要类重写equals()方法和hashcode()方法
    }

    // 2-映射
    @Test
    public void test2(){

        // map(Function f)：接收一个函数作为参数，将元素转换成其他形式或提取信息，该函数会被应用到每个元素上，并将其映射成一个新的元素
        Arrays.asList("aa", "bb", "cc", "dd");
    }




}
