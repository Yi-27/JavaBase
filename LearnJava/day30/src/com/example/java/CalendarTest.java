package com.example.java;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Yi-27
 * @create 2020-09-27 9:50
 */
public class CalendarTest {
    /*
        Calendar日历类的使用
     */
    @Test
    public void test0(){
        // 1. 实例化
        // 方式一：创建其子类的（GregorianCalendar）的对象
        // 方式二：调用其静态方法getInstance()
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass());
        // 2. 常用方法
        // get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);// 获取常用的数据：年月日，第几天等待
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        // set()
        calendar.set(Calendar.DAY_OF_MONTH, 25); // 直接修改calendar
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        // add()
        calendar.add(Calendar.DAY_OF_MONTH, 3); // 在原有基础上累加
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        calendar.add(Calendar.DAY_OF_MONTH, -2); // 加上负的就是减
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        // getTime()：日历类 ---> Date
        Date date = calendar.getTime();
        System.out.println(date);

        // setTime()：Date ---> 日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));


    }

}
