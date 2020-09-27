package com.example.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * jdk 8 之前的日期时间额度API测试
 *
 * @author Yi-27
 * @create 2020-09-27 9:07
 */
public class SimpleDateFormatTest {

    /*
        SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析、
        1. 两个操作
        1.1 格式化：日期 ---> 字符串
        1.2 解析：格式化的逆过程：字符串 ---> 日期

        SimpleDateFormat的实例化
     */
    @Test
    public void test0() throws ParseException {
        // 实例化SimpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat();

        // 格式化： 日期 ---> 字符串
        Date date = new Date();
        System.out.println(date);

        String format = sdf.format(date); // 20-9-27 上午9:12 默认解析
        System.out.println(format);

        String str0 = "19-9-27 下午9:12";
        Date parse1 = sdf.parse(str0); // 默认行为
        System.out.println(parse1);

        // 解析：格式化的逆过程：字符串 ---> 日期
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm:ss aaa");
        // 指定方式格式化和解析：调用带参的构造器
        // 格式化
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        String format1 = sdf1.format(date);
        System.out.println(format1); // 2020.09.27 09:22:09
        // 解析：要求字符串要满足 自己定义的sdf 的格式。否则无法识别抛出异常
        Date parse = sdf1.parse(format1);
        System.out.println(parse);
    }

    @Test
    public void test2() throws ParseException {
        /*
            练习：将字符串"2020-09-08"转换为java.sql.Date
         */
        String str = "2019-09-08";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf.parse(str);
        System.out.println(parse);
        java.sql.Date date = new java.sql.Date(parse.getTime());
        System.out.println(date);
    }

    @Test
    public void test3(){
        /*
            练习二：三天打鱼两天晒网 从1990-01-01开始
            2020-09-08 是打鱼还是晒网
            总天数 % 5 == 1,2,3 ： 打鱼
            总天数 % 5 == 4,0 ： 晒网
            总天数的计算？
            方式一：时间戳相减 (date1.getTime() - date2.getTime()) / (1000 * 60 * 60 * 24) + 1
         */
        Date date1 = new Date(1990-1900, 1, 1); // 减去1900的偏移量
        Date date2 = new Date(2020-1900, 9, 27);
        double days = (date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24);
        System.out.println("days = " + days);
        if(days % 5 == 1 || days % 5 == 2 || days % 5 == 3){
            System.out.println("打鱼");
        }else if(days % 5 == 4 || days % 5 == 0){
            System.out.println("晒网");
        }
    }

}
