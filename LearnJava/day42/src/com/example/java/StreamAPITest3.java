package com.example.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 测试Stream的终止操作
 *
 *
 * @author Yi-27
 * @create 2020-10-09 10:44
 */
public class StreamAPITest3 {

    // 1- 匹配与查找
    @Test
    public void test(){

        List<Person> persons = Person.getPersons();

        System.out.println(persons.stream()); // java.util.stream.ReferencePipeline$Head@7960847b

        // allMatch(Predicate p)：检查是否匹配所有元素
        // 练习：是否所有的person的年龄都大于18
        boolean allMatch = persons.stream().allMatch(p -> p.getAge() > 18);
        System.out.println(allMatch); // false

        // anyMatch(Predicate p)：检查是否至少匹配一个元素
        boolean anyMatch = persons.stream().anyMatch(p -> p.getAge() > 18);
        System.out.println(anyMatch); // true

        // noneMatch(Predicate p)：检查是否没有匹配所有元素
        boolean noneMatch = persons.stream().noneMatch(p -> p.getName().startsWith("Z"));
        System.out.println(noneMatch); // true

        // findFirst()：返回第一个元素
        Optional<Person> first = persons.stream().findFirst();
        System.out.println(first); // Optional[Person{name='Tom', age=33}]
        // 先排序再返回第一个元素
        Optional<Person> firstAfterSorted = persons.stream().sorted((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge())).findFirst();
        System.out.println(firstAfterSorted); // Optional[Person{name='Rose', age=17}]

        // findAny()：返回当前流中的任意元素
        Optional<Person> any = persons.stream().findAny();
        System.out.println(any);
        Optional<Person> any2 = persons.parallelStream().findAny(); // 并行流
        System.out.println(any2);
    }

    @Test
    public void test2(){
        List<Person> persons = Person.getPersons();

        // count():返回流中元素总数
        long count = persons.stream().filter(p -> p.getAge() > 20).count();
        System.out.println(count);

        // max(Comparator c)：返回流中最大值
        Stream<Integer> ageStream = persons.stream().map(p -> p.getAge());
        Optional<Integer> max = ageStream.max(Integer::compare);
        System.out.println(max); // Optional[33]

        // min(Comparator c)：返回流中最小值
        Optional<Person> min = persons.stream().min((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));
        System.out.println(min); // Optional[Person{name='Rose', age=17}]

        // forEach(Consumer c)：内部迭代
        persons.stream().forEach(System.out::println);
        // 使用集合的遍历操作
        persons.forEach(System.out::println);

        // 而我们外部自己用迭代器，就属于外部迭代
    }

    // 2-规约
    @Test
    public void test3(){
        // reduce(T iden, BinaryOperator b):可以将流中元素反复结合起来，得到一个值，返回T
        // 练习1：计算1-10的自然数的和
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = list.stream().reduce(0, Integer::sum);
        // 第一个参数为初始值，第二个是方法
        // 相当于 n = 0,n = a + b,n = n + c...
        System.out.println(sum);

        // reduce(BinaryOperator b)：可以将流中元素反复结合起来，得到一个值，返回Optional<T>
        // 练习2：计算所有person的年龄总合
        List<Person> persons = Person.getPersons();
        Stream<Integer> ageStream = persons.stream().map(Person::getAge);
//        Optional<Integer> sumAge = ageStream.reduce(Integer::sum);
        Optional<Integer> sumAge = ageStream.reduce((a1, a2) -> a1 + a2);
        System.out.println(sumAge); // Optional[116]
    }

    // 3-收集
    @Test
    public void test4(){

        // collect(Collector c) 将流转换为其他形式。接收一个Collector接口的实现，用于给Stream中元素做汇总的方法
        List<Person> persons = Person.getPersons();
        List<Person> collect = persons.stream().filter(p -> p.getAge() > 20).collect(Collectors.toList());
        System.out.println(collect); // [Person{name='Tom', age=33}, Person{name='Jack', age=21}, Person{name='Kei', age=27}]

        Set<Person> collect1 = persons.stream().filter(p -> p.getAge() > 20).collect(Collectors.toSet());
        collect1.forEach(System.out::print);

    }

}


