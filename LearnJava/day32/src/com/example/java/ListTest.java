package com.example.java;

import org.junit.Test;

import java.util.*;

/**
 * ArrayL：作为List接口的主要实现类
 *      线程不安全的，效率高
 *      底层使用Object[] elementData存储
 * LinkedList：
 *      对于频繁的 插入 和 删除 操作，使用此类效率比ArrayList高
 *      底层使用双向链表存储（上一个元素地址 | 元素值 | 下一个元素地址）
 * Vector：作为List接口的古老实现类 jdk 1.0
 *      线程安全的，效率低
 *      底层使用Object[] elementData存储
 *
 * 异同？
 * 同： 三个类都实现了List接口，存储数据的特点相同，存储有序的、可重复的数据
 * 不同：见上
 *
 * **循环遍历List**
 *
 * + Iterator迭代器方式
 * + forEach
 * + 普通的循环
 *
 *
 * @author Yi-27
 * @create 2020-09-29 18:24
 */
public class ListTest {

    @Test
    public void test(){
        Collection a = new ArrayList();
        a.add("abc");
        a.add('d'); // java.lang.Character 自动装箱
        Iterator iterator = a.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().getClass());
        }
    }

    @Test
    public void test2(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456.879);
        list.add("AA");
        list.add(new Date());
        list.add(123);
        System.out.println(list);

        // void add(int index, Object ele）：在index位置插入ele元素
        list.add(1, "bb");
        System.out.println(list);

        // boolean addAll(int index,Collection eles)：从index位置开始将eles中所有元素插入进去
        List list1 = Arrays.asList(1, 2, 3);
        list.addAll(list1);
        System.out.println(list);
        list.add(list1); // 整体添加
        System.out.println(list);

        // Object get(int index)：获取指定index位置的元素
        System.out.println(list.get(0));


        // int indexOf(Object obj)：返回obj在集合中首次出现的位置，如果不存在就返回-1
        int index = list.indexOf(123);
        System.out.println(index);

        // int lastIndexOf(Object obj)：返回obj在当前集合中末次出现的位置，如果不存在返回-1
        System.out.println(list.lastIndexOf(123));

        // Object remove(int index)：移除指定index位置的元素，并返回此元素
        Object remove = list.remove(0);
        System.out.println(remove);
        System.out.println(list); // 后边元素往前移了
        boolean bb = list.remove("bb"); // 按具体的值来移除元素
        System.out.println(bb); // 同样该方法会调用equals()
        System.out.println(list); // 如果remove(2)是想删除具体的值是2的话不能这样，需要

        // Object set(int index, Object ele)：设置指定index位置的元素为ele
        list.set(1, "DD");
        System.out.println(list);

        // List subList(int fromIndex, int toIndex)：返回fromIndex到toIndex位置的左闭右开区间
        List subList = list.subList(2, 4);
        System.out.println(subList);
        System.out.println(list);

    }

}
