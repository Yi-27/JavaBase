package com.example.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * jdk5.0新增了foreach循环，用于遍历集合、数组
 *
 * @author Yi-27
 * @create 2020-09-29 17:59
 */
public class ForEachTest {

    @Test
    public void test(){

        Collection coll = new ArrayList();

        coll.add("AA");
        coll.add('c');
        coll.add(123); // 自动装箱
        coll.add(456.7890313);
        coll.add(false);
        coll.add(new Date());

        // for(集合元素的类型 局部变量 : 集合对象)
        for(Object obj : coll){ // 其实内部凋的还是迭代器
            System.out.println(obj);
        }

    }

    @Test
    public void test2(){

        int[] arr = new int[]{1,2,3,4,5,6};
        // for(数组元素的类型 局部变量 : 数组对象)
        for(int i : arr){
            System.out.println(i);
        }

    }

    @Test
    public void test3(){

        String[] arr = new String[]{"MM", "MM", "MM"};

        // 方式一：普通for循环
        for (int i = 0; i < arr.length; i++) {
            arr[i] = "GG";
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        // 方式二：增强for循环
        for(String s : arr){
            s = "TT";
        }
        for(String s : arr){
            System.out.println(s);
        }

    }

}
