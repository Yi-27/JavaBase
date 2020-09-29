package com.example.java;

import org.junit.Test;

import java.util.*;

/**
 * 集合框架的使用
 *
 * 1. 集合、数组都是对多个数据进行存储操作的结构，简称Java容器
 *      说明：此时的存储，主要指的是内存层面的存储，不涉及到持久化的存储（.txt,.jpg,.avi，数据库中的存储）
 * 2. 数组初始化后长度就固定了
 * 3. 数组提供的方法有限且不便，调用时容易出现角标异常和空指针异常，且效率不高
 * 4. 数组没有现存的属性和方法获取实际元素的个数
 * 5. 数组存储数据的特点：有序、可重复，对于无需、不可重复的需求不能满足
 *
 * @author Yi-27
 * @create 2020-09-29 10:53
 */
public class CollectionTest {

    @Test
    public void test1(){

        Collection coll = new ArrayList();

        // add(Object e)：将元素e添加到集合coll中
        coll.add("AA");
        coll.add('c');
        coll.add(123); // 自动装箱
        coll.add(456.7890313);
        coll.add(false);
        coll.add(new Date());

        // size()：获取添加的元素的个数
        System.out.println(coll.size()); // 6

        // addAll(Collection coll2):将coll2集合中的元素添加到当前的集合中
        Collection coll2 = new ArrayList();
        coll2.add(456);
        coll2.add("cc");
        coll.addAll(coll2);

        System.out.println(coll.size()); // 8
        System.out.println(coll); // [AA, c, 123, 456.7890313, false, Tue Sep 29 12:56:11 GMT+08:00 2020, 456, cc]

        // clear()：情况集合元素
        coll2.clear();

        // isEmpty()：判断当前集合是否为空
        System.out.println(coll2.isEmpty()); // true


        // contains(Object obj)：判断当前集合中是否包含obj，会调用obj对象所在类的equals()
        System.out.println(coll.contains("AA")); // true
        System.out.println(coll.contains(false)); // true

        coll.add(new String("Tom"));
        System.out.println(coll.contains(new String("Tom"))); // true 这里的判断是判断的内容，而不是地址
        System.out.println(coll.contains("Tom")); // true

        coll.add(new Person2("Tom", 12));
//        System.out.println(coll.contains(new Person2("Tom", 12))); // false 这里由于没有重写equals方法，所以还是 == 比较的地址值
        System.out.println(coll.contains(new Person2("Tom", 12))); // true 重写后，就是比较内容，就没错了
        // 由于ArrayList是有序的，因此contains在比较的时候，是将contains()括号内的值， .equals()
        // 然后按顺序将ArrayList中的元素放在equals()的参数中进行比较，直到比对成功就终止

        // containsAll(Collection coll2)：判断形参coll2中的所有元素是否都存在于当前集合中
        coll2 = Arrays.asList(123, 456);
        System.out.println(coll.containsAll(coll2)); // true


        // remove(Object obj)：从当前集合中移除obj元素
        System.out.println(coll.remove(false)); // true
        System.out.println(coll);
        System.out.println(coll.remove(true)); // false
        System.out.println(coll.remove(new Person2("Tom", 12))); // true 还会调用equals

        // removeAll(Collection coll2)：差集：从当前集合中移除coll1中所有的元素
        System.out.println(coll.removeAll(coll2)); // true
        System.out.println(coll);


        // retainAll(Collection coll3)：交集:获取当前集合和coll3集合的交集，并返回给当前集合
        Collection coll3 = Arrays.asList("AA", "BB");
        System.out.println(coll.retainAll(coll3)); // true 顺便修改了coll
        System.out.println(coll); // [AA]

        // equals(Object obj)：比较元素是否一一对应相等，按顺序比较
        System.out.println(coll2.equals(coll3)); // false

        // hashCode()：返回当前对象的哈希值
        System.out.println(coll.hashCode());

        // toArray()：集合 ---> 数组：toArray()
        Object[] objects = coll.toArray();
        System.out.println(Arrays.toString(objects));

        // 数组 ---> 集合：Arrays.asList()
        List<String> strings = Arrays.asList("abc", "def");
        List<String> strings1 = Arrays.asList(new String[]{"ABC", "DEF"});
        System.out.println(strings);
        System.out.println(strings1);

        // 使用该方法创建集合要注意
        List<int[]> ints = Arrays.asList(new int[]{123, 456}); // 会把整体当作成一个元素
        List<Integer> integers1 = Arrays.asList(new Integer[]{123, 456});// 会把整体当作成一个元素
        List<Integer> integers = Arrays.asList(123, 456);
        System.out.println(ints); // [[I@1376c05c]
        System.out.println(integers); // [123, 456]
        System.out.println(integers1); // [123, 456]


        // iterator()：返回Iterator接口的实例，用于遍历集合元素

    }
}
class Person2{

    String name;
    int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person2() {
    }

    @Override // 重写equals
    public boolean equals(Object o) {
        System.out.println("重写了equals方法");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person2 person2 = (Person2) o;
        return age == person2.age &&
                Objects.equals(name, person2.name);
    }

}