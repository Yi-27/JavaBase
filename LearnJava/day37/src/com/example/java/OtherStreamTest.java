package com.example.java;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 其他流的使用
 *      1. 标准的输入、输出流
 *      2. 打印流
 *      3. 数据流
 *
 *
 * @author Yi-27
 * @create 2020-10-04 21:57
 */
public class OtherStreamTest {
    /*
     1. 标准的输入、输出流
        1.1
        System.in：标准的输入流。默认从键盘输入
        System.out：标准的输出流，默认从控制台输出
        1.2
        System类的setIn(InputStream is) / setOut(PrintStream ps)方式重新指定输入和输出的流

        1.3 练习
        从键盘输入字符串，要求将读取到的整行字符串转成大写输出，然后继续进行输入操作
        直至当输入“e”或者“exit”时，退出程序
            方法一：使用Scanner实现，调用next()方法返回一个字符串
            方法二：使用System.in实现。System.in（字节流） --->  转换流（转换成字符流） --->  BufferedReader的readLine()
     */
    @Test
    public void test(){

        InputStreamReader isr = new InputStreamReader(System.in); // 用标准输入流
        BufferedReader br = new BufferedReader(isr); // 转换流
        String data;
        while(true){
//            String data = br.readLine();
        }

    }


}
