package com.example.java;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

/**
 * @author Yi-27
 * @create 2020-10-07 20:52
 */
public class OtherTest {

    // 获取运行时父类
    @Test
    public void test(){

        Class clazz = User.class;

        Class superclass = clazz.getSuperclass();
        System.out.println(superclass); // class com.example.java.Creature
    }

    // 获取运行时带泛型的父类，及其泛型
    @Test
    public void test2(){

        Class clazz = User.class;

        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass); // com.example.java.Creature<java.lang.String>

        ParameterizedType paramType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = paramType.getActualTypeArguments();// 获取泛型类型
        System.out.println(Arrays.toString(actualTypeArguments)); // [class java.lang.String]
        System.out.println(actualTypeArguments[0].getTypeName()); // java.lang.String
        System.out.println(((Class) actualTypeArguments[0]).getName()); // java.lang.String
    }

    // 获取运行时类实现的接口
    @Test
    public void test3(){
        Class clazz = User.class;

        Class[] interfaces = clazz.getInterfaces();
        for(Class c : interfaces){
            System.out.println(c);
        }
        System.out.println();

        // 获取运行时类的父类所实现的接口
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for(Class c : interfaces1){
            System.out.println(c);
        }
    }


    // 获取运行时类所在的包
    @Test
    public void test4(){

        Class clazz = User.class;

        Package pack = clazz.getPackage();
        System.out.println(pack); // package com.example.java
    }

    // 获取运行时类声明的注解
    @Test
    public void test5(){

        Class clazz = User.class;

        Annotation[] annotations = clazz.getAnnotations();
        for(Annotation a : annotations){
            System.out.println(a); // @com.example.java.MyAnnotation(value=hi)
        }
    }

}
