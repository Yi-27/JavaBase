package com.example.java;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 涉及到String类与其他结构之间的转换
 *
 * String 与 基本数据类型、包装类之间的转换
 *      String --> 基本数据类型、包装类：调用包装类的静态方法，parseXxxx(Str)
 *      基本数据类型、包装来 --> String：调用String重载的valueOf(xxx)
 *
 * String 与 char[] 之间的转换
 *      String --> char[]： 调用String的toCharArray()
 *      char[] --> String： 调用String的构造器
 *
 * String 与 byte[] 之间的转换
 *      String --> byte[]：调用String的getBytes()
 *      byte[] --> String：调用String的构造器
 *
 * @author Yi-27
 * @create 2020-09-25 13:13
 */
public class StringTest {

    @Test
    public void test1(){
        /*
         * String 与 基本数据类型、包装类之间的转换
         *      String --> 基本数据类型、包装类：调用包装类的静态方法，parseXxxx(Str)
         *      基本数据类型、包装来 --> String：调用String重载的valueOf(xxx)
         */
        String str1 = "123";
        int num = Integer.parseInt(str1);
        String str2 = String.valueOf(num); // "123"
        String str3 = num + "";
    }

    @Test
    public void test2(){
        /*
         * String 与 char[] 之间的转换
         *      String --> char[]： 调用String的toCharArray()
         *      char[] --> String： 调用String的构造器
         */
        String str1 = "abc123";
        char[] charArray = str1.toCharArray(); // 转成字符数组
        for(int i=0; i<charArray.length; i++){
            System.out.println(charArray[i]);
        }

        char[] arr = new char[]{'h', 'e', 'l', 'l', 'o'};
        String str2 = new String(arr); // 直接调用相应的构造函数即可
        System.out.println(str2);
    }

    @Test
    public void test3() throws UnsupportedEncodingException {
        /*
         * String 与 byte[] 之间的转换
         *      String --> byte[]：调用String的getBytes()
         *      byte[] --> String：调用String的构造器
         *
         * 编码：字符串 --> 字节 （看得懂 --> 看不懂的二进制数据）
         * 解码：字节 --> 字符串 （看不懂的二进制数据 --> 看得懂）
         */
        String s1 = "abc123中国";
        byte[] bytes = s1.getBytes(); // 使用默认（UTF-8，我们定义过的）的字符集，进行转换，都是字符的ASCII码
        // [97, 98, 99, 49, 50, 51, -28, -72, -83, -27, -101, -67]
        // 这里中文字符就是占三个字节（UTF-8编码情况下)
        System.out.println(Arrays.toString(bytes));

        byte[] gbks = s1.getBytes("gbk"); // 使用指定的字符集，gbk编码的中文字符只占两字节
        System.out.println(Arrays.toString(gbks)); // 无论是gbk还是UTF-8对于字母和数字编码都和ASCII编码一样


        String s2 = new String(bytes); // 使用默认的字符集，进行解码
        System.out.println(s2);

        String s3 = new String(gbks, "gbk"); // 指定解码的字符集
        System.out.println(s3); // 当出现乱码时，就可能时编码和解码的字符集不同
    }

}
