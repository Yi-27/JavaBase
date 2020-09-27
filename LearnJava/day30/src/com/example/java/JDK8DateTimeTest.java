package com.example.java;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * JDK 8 中日期时间API的测试
 *
 * @author Yi-27
 * @create 2020-09-27 10:22
 */
public class JDK8DateTimeTest {

    @Test
    public void test0(){
        /*
            LocalTime LocalDate LocalDateTime
         */
        // now()：获取当前的日期，时间，日期+时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println("localDate = " + localDate);
        System.out.println("localTime = " + localTime);
        System.out.println("localDateTime = " + localDateTime);

        // of()：设置指定的 年月日时分秒，没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 9, 26, 13, 24, 52);
        System.out.println(localDateTime1);

        // getXxx()：获取指定日期或时间
        System.out.println(localDateTime.getDayOfMonth()); // 27
        System.out.println(localDateTime.getDayOfWeek()); // SUNDAY
        System.out.println(localDateTime.getDayOfYear()); // 271
        System.out.println(localDateTime.getMonthValue()); // 9
        System.out.println(localDateTime.getMonth()); // SEPTEMBER
        System.out.println(localDateTime.getYear()); // 2020
        System.out.println(localDateTime.getHour()); // 10
        System.out.println(localDateTime.getMinute()); // 43
        System.out.println(localDateTime.getSecond()); // 13

        // withXxxx()：设置时间和日期
        LocalDateTime localDateTime2 = localDateTime1.withDayOfMonth(28); // 返回新的对象，体现不可变性
        System.out.println(localDateTime2);

        // 加减操作
        LocalDateTime localDateTime3 = localDateTime2.plusMonths(3);// 加上三个月
        System.out.println(localDateTime3);
        localDateTime3 = localDateTime3.plusMonths(-1);// 加上一个负的等于减去正的
        System.out.println(localDateTime3);
        LocalDateTime localDateTime4 = localDateTime3.minusWeeks(1);// 减去一个星期
        System.out.println(localDateTime4);
    }

    @Test
    public void test2(){
        /*
            Instant类使用
            类似于java.util.Date
         */
        // 实例化 now()：获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant); // 2020-09-27T03:05:15.606Z 差了8个小时 算的是本初子午线的时间

        // 添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime); // 2020-09-27T13:09:52.169+08:00

        // 获取自1970年1月1日0时0分0秒（UTC）到现在的毫秒数 --> Date.getTime()
        long milli = instant.toEpochMilli();
        System.out.println(milli);

        // 通过毫秒数来创建对象 ofEpochMilli()：通过给定的毫秒数，获取Instant实例 ---> Date(long milli)
        Instant instant1 = Instant.ofEpochMilli(1601183528121L);
        System.out.println(instant1);
    }

    @Test
    public void test3(){
        /*
            DateTimeFormatter：格式化或解析日期、时间
            类似于SimpleDateFormat
         */
        // 方式一：预定义的标准格式：如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        // 格式化 日期 --> 字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        String format = formatter.format(localDateTime);
        System.out.println(format);
        // 解析：字符串 --> 日期
        TemporalAccessor parse = formatter.parse(format);
        System.out.println(parse);

        // 方式二：本地化相关的格式：如：ofLocalizedDateTime(FormatStyle.LONG)
        // 本地相关的格式：如ofLocalizedDateTime()
        // FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT : 适用于 LocalDateTime
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        // 格式化 Long: 2020年9月27日 下午01时31分13秒   SHORT:20-9-27 下午1:31    MEDIUM:2020-9-27 13:32:10
        String format1 = formatter1.format(localDateTime);
        System.out.println(format1);
        // 解析
        TemporalAccessor parse1 = formatter1.parse("2020年9月27日 下午01时31分13秒");
        System.out.println(parse1); // 必须要与格式化时的格式一致，不然抛异常


        // ofLocalizedDate()
        // FormatStyle.FULL / FormatStyle.lONG / FormatStyle.MEDIUM / FirmatStyle.SHORT 适用于 LocalDate
        // 2020年9月27日 星期日 / 2020年9月27日 / 2020-9-27 / 20-9-27
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        // 格式化
        String format2 = formatter2.format(LocalDate.now());
        System.out.println(format2);


        // 方式三（重点）：自定义的格式，如：ofPattern("yyyy-MM-dd hh:mm:ss E")
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 格式化
        String format3 = formatter3.format(LocalDateTime.now());
        System.out.println(format3); // 2020-09-27 01:44:49
        // 解析
        TemporalAccessor parse2 = formatter3.parse("2020-09-27 05:05:05");
        System.out.println(parse2);
        // {SecondOfMinute=5, HourOfAmPm=5, NanoOfSecond=0, MicroOfSecond=0, MinuteOfHour=5, MilliOfSecond=0},ISO resolved to 2020-09-27
    }

    @Test
    public void test4(){
        // 通过LocalDateTime自带的parse来解析时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDateTime localDateTime = LocalDateTime.parse("2020-09-27T13:54:36.469"); // 不指定解析格式时用默认的
        System.out.println(localDateTime);
        System.out.println(LocalDateTime.parse("2020-09-27 05:05:05", DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
        System.out.println(LocalDateTime.parse("2020-09-27 05:05:05", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))); // 用小写的h会抛异常
    }

}
