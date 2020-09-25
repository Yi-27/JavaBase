package com.example.java;

import org.junit.Test;

import java.util.Date;

/**
 * JDK 8 之前日期和时间的API测试
 *
 *
 * @author Yi-27
 * @create 2020-09-25 17:32
 */
public class DateTimeTest {

    // 1. System类中的currentTimeMillsis()
    @Test
    public void test1(){
        // 返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差
        long timestamp = System.currentTimeMillis(); // 称为时间戳
        System.out.println(timestamp);
    }

    /*
        java.util.Date类
            |--- java.sql.Date类

        1.两个构造器的使用
            >构造器1：Date()：创建一个对应当前时间的Date对象
            >构造器2：创建指定毫秒数的Date对象
        2.两个方法的使用
            >toString()：显示当前的年、月、日、时、分、秒
            >getTime()：获取当前Date对象对应的毫秒数。（时间戳）
        3.java.sql.Date 对应着数据库中的日期类型的变量
            >如何实例化
            >如何将java.util.Date对象转换为java.sql.Date对象
     */
    @Test
    public void test2(){
        // 构造器1：Date()：创建一个对应当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1.toInstant()); // 2020-09-25T09:45:47.376Z
        System.out.println(date1.toString()); // Fri Sep 25 17:45:47 GMT+08:00 2020
        System.out.println(date1.getTime()); // 1601027147376

        // 构造器2：创建指定毫秒数的Date对象
        Date date2 = new Date(1601027147376L);
        System.out.println(date2.toString());

        // 创建java.sql.Date对象
        java.sql.Date date3 = new java.sql.Date(1601027147376L);
        System.out.println(date3); // 2020-09-25
        System.out.println(date3.toString()); // 2020-09-25
        System.out.println(date3.toLocalDate()); // 2020-09-25


        // 将java.util.Date对象转换为java.sql.Date对象
        // 情况一：
        Date date4 = new java.sql.Date(1601027147376L); // 子类赋给父类，多态
        java.sql.Date date5 = (java.sql.Date) date4; // 再强转成sql.Date
        // 情况二：
        Date date6 = new Date(); // 这里new的就是父类对象，没办法再强转成子类的对象了
        // java.sql.Date date7 = (java.sql.Date) date6; // 编译不报错，运行报错
        java.sql.Date date7 = new java.sql.Date(date6.getTime()); // 二者共通的就是时间戳

    }
}
