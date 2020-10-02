package com.example.java;

import org.junit.Test;

import java.util.Stack;

/**
 * Stack栈的使用
 *
 * @author Yi-27
 * @create 2020-10-02 21:01
 */
public class StackClass {

    @Test
    public void test(){
        // 栈 继承了Vector类 因此是线程安全的
        Stack stack = new Stack();

        // 进栈 后进先出
        stack.push("ABC");
        stack.push(123);
        // 出栈
        System.out.println(stack.pop()); // 123
        System.out.println(stack.pop()); // ABC
        // System.out.println(stack.pop()); // 栈中没数据时，抛异常EmptyStackException

        stack.push("ABC");
        stack.push(123);
        System.out.println(stack); // [ABC, 123]
        System.out.println(stack.size()); // 2

        // 查找元素出现位置
        System.out.println(stack.search("ABC")); // 2

        // 清栈
        stack.clear();

        // 判断是否是空
        System.out.println(stack.isEmpty()); // true
    }

}
