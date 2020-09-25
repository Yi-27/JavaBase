package com.example.java;

import org.junit.Test;

/**
 * 关于StringBuffer和StringBuilder的使用
 *
 *
 * @author Yi-27
 * @create 2020-09-25 14:10
 */
public class StringBufferBuilderTest {

    @Test
    public void test1(){
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0, 'm'); // 改变其中一个字符
        System.out.println(sb1);


        StringBuffer sb2 = new StringBuffer();
        System.out.println(sb2.length());

        System.out.println(3 >> 1);
        System.out.println(3 << 1);
    }

    /*
        源码分析：
        String str = new String(); // char[] value = new char[0];
        String str1 = new String("abc); // char[] value = new char[]{'a', 'b', 'c'};


        StringBuffer sb1 = new StringBuffer(); // char[] value = new char[16]; 底层创建了一个长度是16的字符数组
        sb1.append('a'); // value[0] = 'a';
        sb1.append('b'); // value[1] = 'b';

        StringBuffer sb2 = new StringBuffer("abc"); // char[] value = new char["abc".length() + 16];

        // 问题1. sout(sb2.length()); 打印
        // 问题2. 扩容问题：如果要添加的数据顶层数组盛不下了，
                  默认情况下，扩容为原来容量的 2倍+2 ，同时将原有数组中的元素复制到新的数组中
                  特殊情况，默认扩容还不够的触发特殊情况

                  指导意义：建议使用StringBuffer(int capacity)或StringBuilder(int capacity)
     */


    @Test
    public void test2(){
        StringBuffer s1 = new StringBuffer("abc");
        s1.append(1); // append支持方法链，它在拼接完字符串后将对象返回出去了
        s1.append("1"); // 提供了各种类型的append()
        System.out.println(s1);
        s1.delete(2, 4); // 虽然delete是带返回值的，但是原位置也被修改了
        System.out.println(s1);
        s1.replace(1, 2, "0"); // 如果替换导致字符串超过16了，会触发扩容
        System.out.println(s1);
        s1.insert(2, false); // false插入进去就变成五个字符了
        System.out.println(s1 + " " +  s1.length());
        System.out.println(s1.reverse());
    }
}
