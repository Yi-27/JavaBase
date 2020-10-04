package com.example.java;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之二：转换流的使用
 *  1. 转换流：属于字符流
 *      InputStreamReader：将一个字节的输入流转换为字符的输入流
 *      OutputStreamWrite：将一个字符的输出流转换为字节的输出流
 *  2. 提供 字节流与字符流之间的转换
 *
 *  3. 解码：字节、字节数组    --->    字符数组、字符串
 *     编码：字符数组、字符串  --->    字节、字节数组
 *
 *  4. 字符集（编码集）
 *
 * @author Yi-27
 * @create 2020-10-04 20:22
 */
public class InputStreamReaderTest {

    @Test
    public void test(){

        InputStreamReader isr = null; // 自定义字符集
        try {
            FileInputStream fis = new FileInputStream("hello.txt");
//        InputStreamReader isr = new InputStreamReader(fis); // 使用系统默认的字符集（目前是UTF-8
            // 参数2指明了字符集 具体使用哪个字符集，取决于要读取的文件在保存时使用的字符集
            isr = new InputStreamReader(fis, "UTF-8");

            // 字节流 转 字符流
            char[] cbuf = new char[20];
            int len;
            while((len = isr.read(cbuf)) != -1){
                String str = new String(cbuf, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(isr != null){
                try {
                    isr.close();  // 内部会帮忙把fis关闭掉
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
        综合使用InputStreamReader 和 OutputStreamWriter
     */
    @Test
    public void test2(){
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            // 文件
            File srcFile = new File("hello3.txt");
            File destFile = new File("hello4.txt");

            // 节点流 字节流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);

            // 转换流
            isr = new InputStreamReader(fis, "UTF-8");
            osw = new OutputStreamWriter(fos, "gbk");

            // 读写过程
            char[] cbuf = new char[20];
            int len;
            while((len = isr.read(cbuf)) != -1){
                osw.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 资源关闭
            if(osw != null){
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(isr != null){
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }




    }
}
