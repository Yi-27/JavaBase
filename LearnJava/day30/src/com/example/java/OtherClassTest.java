package com.example.java;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 其他常见类的使用
 *
 * @author Yi-27
 * @create 2020-09-27 15:59
 */
public class OtherClassTest {

    @Test
    public void SystemTest(){
        /*
        + java.version：java运行时环境版本
        + java.home：java安装目录
        + os.name：操作系统的名称
        + os.version：操作系统的版本
        + user.name：用户的账户名称
        + user.home：用户的主目录
        + user.dir：用户的当前工作目录
         */
        System.out.println("System.getProperties() = " + System.getProperties());
        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));
    }

    @Test
    public void BigNumTest(){
        BigInteger bi = new BigInteger("23465456431346846131654522113131113131321321236");
        BigDecimal bd = new BigDecimal("12345.351");
        BigDecimal bd2 = new BigDecimal("11");
        System.out.println(bi); // ROUND_HALF_UP 表示四舍五入
        System.out.println(bd.divide(bd2, BigDecimal.ROUND_HALF_UP)); // 默认保留3位小数
        System.out.println(bd.divide(bd2, 15, BigDecimal.ROUND_HALF_UP)); // 保留15位小数
    }
}
