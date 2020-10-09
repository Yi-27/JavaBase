package com.example.java;

import org.junit.Test;

import java.util.ArrayList;
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
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println); // 将每个元素都转成大写并打印

        // 练习1：获取名字长度大于三的名字
        List<Person> persons = Person.getPersons();
        Stream<String> nameStream = persons.stream().map(Person::getName); // 返回每个名字构成的stream
        nameStream.filter(name -> name.length() > 3).forEach(System.out::println);

        System.out.println("*************************************");

        // 练习2：
        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest2::fromStringToStream);
        streamStream.forEach(s ->{
            s.forEach(System.out::println);
        });

        System.out.println();

        // flatMap(Function f)：接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
        Stream<Character> characterStream = list.stream().flatMap(StreamAPITest2::fromStringToStream);
        // [[a,a],[b,b],[c,c],[d,d]] -> [a,a,b,b,c,c,d,d]
        characterStream.forEach(System.out::println);
        //
    }

    // 将字符串中的多个字符构成的集合转换为对应的Stream的实例
    public static Stream<Character> fromStringToStream(String str){
        ArrayList<Character> list = new ArrayList<>();
        for(Character c : str.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }


    @Test
    public void test3(){
        ArrayList list1 = new ArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        ArrayList list2 = new ArrayList();
        list2.add(4);
        list2.add(5);
        list2.add(6);

//        list1.add(list2); // [1, 2, 3, [4, 5, 6]]
        list1.addAll(list2); // [1, 2, 3, 4, 5, 6]
        System.out.println(list1);
    }

    @Test
    public void test4(){
        // sorted()：自然排序
        List<Integer> list = Arrays.asList(12, 43, 34, 76, 1, -20, 8);
        list.stream().sorted().forEach(System.out::println);

        List<Person> persons = Person.getPersons();
//        persons.stream().sorted().forEach(System.out::println); // 当Person没有实现Comparable接口时，会抛异常
        // 定制排序
        persons.stream().sorted((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge())).forEach(System.out::println);
    }


}
