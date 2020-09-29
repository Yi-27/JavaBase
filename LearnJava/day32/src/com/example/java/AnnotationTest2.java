package com.example.java;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * jDK5.0提供了4个标准的meta-annotation类型
 *
 * + Retention
 *      只有声明为RUNTIME声明周期的注解，才能通过反射获取
 * + Target
 *      用于指定被修饰的Annotation能用于修饰哪些程序元素
 * + Documented
 * + Inherited
 *
 * @author Yi-27
 * @create 2020-09-29 9:10
 */
@MyAnnotation2("hello ")
public class AnnotationTest2 {

    @Test
    public void test0(){
        // 通过反射获取到注解
        Class clazz = Student.class;
        Annotation[] annotations = clazz.getAnnotations();
        System.out.println(Arrays.toString(annotations)); // [@com.example.java.MyAnnotation2(value=hi)]
    }

}

@MyAnnotation2(value="hi") // 重复这样写就等于下面那一行那样写
@MyAnnotation2(value="hello") // 可以重复这样写的前提就是 @Repeatable(MyAnnotations.class) 加了这个注解
//@MyAnnotations({@MyAnnotation2(value="hi"), @MyAnnotation2(value="hello")}) // jdk8之前的重复注解写法
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

class Generic<@MyAnnotation2("类上泛型注解") T>{

    public List<@MyAnnotation2("方法上泛型注解") String> info(){
        return null;
    }

    public void show() throws RuntimeException{
        ArrayList<@MyAnnotation2("变量前泛型注解") String> list = new ArrayList<>();
    }
}