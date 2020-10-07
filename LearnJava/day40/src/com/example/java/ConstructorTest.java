package com.example.java;

import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * 获取构造器
 *
 * @author Yi-27
 * @create 2020-10-07 19:58
 */
public class ConstructorTest {

    @Test
    public void test(){

        Class clazz = User.class;

        // 获取当前运行时类中声明为public的构造器
        Constructor[] constructors = clazz.getConstructors();
        for(Constructor c : constructors){
            System.out.println(c);
        }
        System.out.println();

        // 获取当前运行时类中所有声明的构造器
        // 这里也可以通过相应的方法来获取类型、形参列表，形参名
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for(Constructor c : declaredConstructors){
            System.out.println(c);
        }
    }

}
