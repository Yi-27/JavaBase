package com.example.java;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 *
 *
 * @author Yi-27
 * @create 2020-10-06 15:33
 */
public class ReflectionTest {

    // 反射之前，对于Person类的操作
    @Test
    public void test(){
        // 1. 创建Person类的对象
        Person p1 = new Person("Tom", 20);
        // 2. 通过对象，调用其内部的属性、方法
        p1.age = 10;
        System.out.println(p1.toString());

        p1.show();

        // 在Person类外部，不可以通过Person类的对象调用其内部私有结构
        // 比如：name、showNation()以及私有的构造器
    }

    // 反射之后，对于Person的操作
    @Test
    public void test2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class clazz = Person.class; // 获取Person类 类对象
        // 1. 通过反射创建Person类的对象
        Constructor constructor = clazz.getConstructor(String.class, int.class); // 找构造器
        Object obj = constructor.newInstance("Tom", 12);// 根据构造器创建对象
        Person p = (Person) obj; // 强转回Person类
        System.out.println(p.toString()); // Person{name='Tom', age=12}

        // 2. 通过反射，调用对象指定的属性、方法
        // 调用属性
        Field age = clazz.getDeclaredField("age");
        age.set(p, 10);
        System.out.println(p.toString()); // Person{name='Tom', age=10}

        // 调用方法
        Method show = clazz.getDeclaredMethod("show"); // 参数中还可以填入形参需要什么
        show.invoke(p); // 参数中还可以填入形参需要的结构  相当于上面p1.show()

        // 通过反射，可以调用Person类的私有结构的。比如：私有的构造器、方法、属性
        // 调用私有的构造器
        Constructor cons1 = clazz.getDeclaredConstructor(String.class); // 获得私有构造器
        cons1.setAccessible(true);
        Person p1 = (Person) cons1.newInstance("Jerry"); // 创建对象
        System.out.println(p1); // Person{name='Jerry', age=0}

        // 调用私有的属性
        Field name = clazz.getDeclaredField("name"); // 获取私有属性
        name.setAccessible(true);
        name.set(p1, "哈哈哈");
        System.out.println(p1); // Person{name='哈哈哈', age=0}

        //  调用私有的方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class); // 获取私有方法
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1, "中国");// 相当于 p1.showNation("中国")
        System.out.println(nation); // 中国
    }

    /*
    疑问：通过直接new的方式或反射的方式都可以调用公共的结构，开发中用哪个？
        建议：直接new的方式
        什么时候会用：反射的方式。
        反射的特征：动态性
    疑问：反射机制与面向对象中的封装性是不是矛盾的？如何看待两个技术？
        不矛盾。
        通俗地讲，封装性就是一种规范，告诉你什么应该凋什么不应该凋，就是建议怎么调用的事
                而反射则是，能不能调用的事
     */

    // 获取Class的实例的方式
    @Test
    public void test3() throws ClassNotFoundException {
        // 方式一：调用运行时类的属性：.class
        Class<Person> clazz1 = Person.class; // 可以加上泛型，效果一样，加上的话后面就不用强转了
        System.out.println(clazz1); // class com.example.java.Person

        // 方式二：通过运行时类的对象，调用getClass()
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2); // class com.example.java.Person

        // 方式三：调用Class的静态方法：forName(String classPath)   （用方式三居多）
        Class clazz3 = Class.forName("com.example.java.Person");
//        clazz3 = Class.forName("java.lang.String");
        System.out.println(clazz3); // class com.example.java.Person

        // 加载到内存中的  运行时类  会缓存一定的时间，在此时间内，可以通过不同的方式来获取此运行时类
        System.out.println(clazz1 == clazz2); // true
        System.out.println(clazz1 == clazz3); // true
        System.out.println(clazz2 == clazz3); // true


        // 前三种方式需要掌握
        // 方式四：使用类的加载器：ClassLoader （了解）
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("com.example.java.Person");
        System.out.println(clazz4);
        System.out.println(clazz1 == clazz4); // true
    }

    @Test
    public void ClassLoadingTest(){
        System.out.println(A.m); // 100
    }
}

class A{
    static {
        m = 300;
    }
    // 静态代码块和显示赋值就是个谁先谁后的关系
    static int m = 100;
}
/*
1. 类的加载，将类A加载到内存中
2. 链接结束后 m=0
3. 初始化后，m的值由<clinit>()方法执行决定
    这个A的类构造器<clinit>()方法由类变量的赋值和静态代码块中的语句按照顺序合并产生
    类似于
        <clinit>(){
            m = 300;
            m = 100;
        }
 */