package com.example.java;
import org.junit.Test;
/**
 * String的使用
 *
 *
 * @author Yi-27
 * @create 2020-09-24 20:27
 */
public class StringTest {

    /**
     * String:字符串，""引起来
     * 1.String声明为final的，不可被继承
     * 2.String实现了Serializable接口：表示字符串时支持序列化的
     *         实现了Comparable接口：表示String可以比较大小
     * 3.String内部定义了final char[] ，value用于存储字符串数据
     * 4.String：代表不可变的字符序列，简称：不可变性
     *      体现：1）当对字符串重新赋值时，需要重写指定内存区域赋值，不能使用原有的value进行赋值
     *           2）当对现有字符串进行连接操作时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值
     *           3) 当调用String的replace()方法修改指定字符或字符串时，也同上
     * 5.通过字面量的方式（区别于new）给一个字符串赋值，此时的字符串值声明在字符串常量池中
     * 6.字符串常量池中是不会存储相同内容的字符串的
     *
     * 面试题： String s = new String("abc"); 方式创建对象，在内存中创建了几个对象？
     *      两个：一个是堆空间中new结构，另一个是char[]对应的常量池中的数据"abc"
     *      当然如果已经有存在"abc“，就直接拿来用，而不需要再创建了
     *
     */
    @Test
    public void test1(){
        String s1 = "abc"; // 字面量
        String s2 = "abc";
//        s1 = "heallo";
        System.out.println(s1 == s2); // true
        System.out.println(s1); // hello
        System.out.println(s2);

        String s3 = "abc";
        s3 += "def";
        System.out.println(s3);

        String s4 = "abc";
        String s5 = s4.replace('a', 'm');
        System.out.println(s4); // abc
        System.out.println(s5); // mbc
    }

    @Test
    public void test2(){
        // String对象的创建
        // 方式一：通过字面量定义的方式
        String s0 = "hello"; // 此时s0和s1的数据声明在方法区中的字符串常量池中
        String s1 = "hello";

//        String s1 = new String();

//        String s2 = new String(String original);

//        String s3 = new String(char[] a);

//        String s4 = new String(char[] a, int startIndex, int count);

        // ...


        // 方式二：通过 new + 构造器的防护
        String str0 = new String("hello"); // 此时的str0和str1保存的地址值
        String str1 = new String("hello"); // 是数据在堆空间中开辟空间以后对应的地址值

        System.out.println(s0 == s1); // true
        System.out.println(s0 == str0); // false
        System.out.println(s0 == str1); // false
        System.out.println(str0 == str1); // false

        System.out.println("**************************");
        Person p1 = new Person("Tom", 12);
        Person p2 = new Person("Tom", 12);

        System.out.println(p1.name.equals(p2.name)); // true
        System.out.println(p1.name == p2.name); // true
        // 这时直接 == 也返回true，是因为 "Tom" 是通过字面量的方式创建的
        // 所以 在堆空间中 name属性的值即为常量池中的"Tom"的地址

        p1.name = "Jerry";
        System.out.println(p2.name); // Tom
        System.out.println(p1.name.equals(p2.name)); // false
        System.out.println(p1.name == p2.name); // false
    }

    @Test
    public void test3(){
        String s1 = "javaEE";
        String s2 = "hadoop";

        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";
        String s5 = s1 + "hadoop"; // 只要有变量名参与的字符串连接
        String s6 = "javaEE" + s2; // 就类似于 new String()
        String s7 = s1 + s2; // 都会现在堆空间新开辟一个空间




        System.out.println(s3 == s4); // true
        System.out.println(s3 == s5); // false
        System.out.println(s3 == s6); // false
        System.out.println(s3 == s7); // false
        System.out.println(s5 == s6); // false
        System.out.println(s5 == s7); // false
        System.out.println(s6 == s7); // false

        s1 += s2;
        System.out.println(s3 == s1); // false

    }


}

class Person{

    String name;
    int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Person(){}

}