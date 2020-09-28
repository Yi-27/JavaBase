package com.example.java;

import java.util.ArrayList;

/**
 *
 * 在编译时进行格式检查（JDK内置的三个基本注解
 * + @Override：限定重写父类方法，该注解只能用于方法
 * + @Deprecated：用于表示所修饰的元素（类，方法等）已过时，通常是因为所修饰的结构危险或存在更好的选择
 * + @SuppressWarnings：抑制编译器警告
 *
 * 跟踪代码依赖性，实现替代配置文件功能
 *
 *
 * @author Yi-27
 * @create 2020-09-28 21:09
 */
public class AnnotationTest {

    public static void main(String[] args) {

        @SuppressWarnings({"unused", "rawtypes"}) // rawtypes 抑制泛型警告 更多用在eclipse
        ArrayList list = new ArrayList();
    }

}

@MyAnnotation(value="hi")
class Person{

    @SuppressWarnings("unused") // 抑制警告
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public void walk(){
        System.out.println("走路");
    }

    public void eat(){
        System.out.println("吃饭");
    }
}

interface Info2{
    void show();
}


class Student extends Person implements Info2{

    @Override // 加了这个注解，会在编译时检查是否是重写的，不是的就会报错
    public void walk() {
        System.out.println("学生走路");
    }

    @Override
    public void show() {
        System.out.println("这是学生");
    }
}