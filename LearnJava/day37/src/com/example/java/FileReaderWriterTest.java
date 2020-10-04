package com.example.java;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 一、**流的分类**
 *
 * + 按操作**数据单位**不同分为：**字节流（8 bit）**，**字符流（16 bit）**
 * + 按数据流的**流向**不同分为：**输入流**、**输出流**
 * + 按流的**角色**的不同分为：**节点流**、**处理流**
 *
 * 二、流的体系结构
 * 抽象基类
 *      字节流             节点流（或文件流）                                  缓冲流（处理流的一种）
 *      InputStream        FileInputStream  （read(byte[] buffer)）             BufferedInputStream （read(byte[] buffer)）
 *      OutputStream       FileOutputStream （write(byte[] buffer, 0, len)）    BufferOutputStream （write(byte[] buffer, 0, len)） / flush()刷新缓存区
 *      字符流
 *      Reader             FileReader （read(char[] cbuf)）                   BufferedReader （read(char[] cbuf) / readLine()）
 *      Writer             FileWriter （write(char[] cbuf, 0, len)）          BufferedWroter （write(char[] cbuf, 0, len)） / flush()刷新缓存区
 *
 * @author Yi-27
 * @create 2020-10-04 12:41
 */
public class FileReaderWriterTest {

    public static void main(String[] args) {
        File file = new File("hello.txt"); // 相较于当前工程
        System.out.println(file.getAbsolutePath()); // F:\Java基础学习和算法练习\JavaBase\LearnJava\hello.txt

        File file2 = new File("day37\\hello.txt");
        System.out.println(file2.getAbsolutePath()); // F:\Java基础学习和算法练习\JavaBase\LearnJava\day37\hello.txt
    }


    /*
        将day38下的hello.txt文件内容读入程序中，并输出到控制台
        说明点：
            1. read()的理解：返回读入的一个字符，如果达到文件末尾，返回-1
            2. 异常的处理，为了保证流资源一定可以执行关闭操作，需要使用try-catch-finally处理
            3. 读入的文件一定要存在，否则就会报 FileNotFoundException
     */
    @Test
    public void testFileReader(){
        FileReader fr = null;
        try {
            // 1. 实例化File对象，指明要操作的文件
            File file = new File("hello1.txt"); // 相较于当前Module
            System.out.println(file.getAbsolutePath()); // F:\Java基础学习和算法练习\JavaBase\LearnJava\day37\hello.txt

            // 2. 提供具体的流（节点流 字符流）
            fr = new FileReader(file);

            // 3. 数据的读入
            // read()：返回读取的一个字符，如果达到文件末尾，返回-1

            // 方式一：
//        int data = fr.read();
//        while (data != -1){
//            System.out.println((char)data);
//            data = fr.read();
//        }

            // 方式二：语法上针对方式一的修改
            int data;
            while ((data = fr.read()) != -1) {
                System.out.println((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 流的关闭操作
            try {
                if (fr != null)
                    fr.close(); // 没有创建对象就不需要close
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    // 对read()操作升级：使用read的重载方法
    @Test
    public void testFileReader2(){
        FileReader fr = null;
        try {
            // 1. File类的实例化
            File file = new File("hello.txt");

            // 2. FileReader流的实例化
            fr = new FileReader(file);

            // 3. 读入的操作
            // read(char[] cbuf)：返回每次读入cbuf数组中的字符的个数，如果达到文件末尾，返回-1
            char[] cbuf = new char[5];  // 每次读取字符的个数
            int len;
            while ((len = fr.read(cbuf)) != -1) {
//                System.out.println(Arrays.toString(cbuf));
                /*
                [h, e, l, l, o]
                [w, o, r, l, d]
                [1, 2, 3, l, d]
                 */
                // 因此要想正确的读出读取的数据，应该
//                for (int i = 0; i < len; i++) {
//                    System.out.print(cbuf[i]);
//                } // helloworld123

//                String str = new String(cbuf); // 这样也不行
//                System.out.println(str);
                /*
                hello
                world
                123ld
                 */

                String str = new String(cbuf, 0, len); // 这样就可以，只截取需要的
                System.out.print(str); // helloworld123
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 资源的关闭
            try {
                if(fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    从内存中写出数据到硬盘的文件里
    说明：
        1. 输出操作：对于的File可以不存在
        2. File对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建此文件
           File对应的硬盘中的文件如果存在：
                    如果流使用的构造器是：FileWriter(file, false) / FileWriter(file)：对原有文件覆盖
                    如果流使用的构造器是：FileWriter(file, true)：不会覆盖原有文件，而是追加内容
     */
    @Test
    public void testFileWriter(){
        FileWriter fw = null; // append字段表示是否在原有文件上追加，不追加就是覆盖
        try {
            // 1. 提供File类的对象，指明写出到的文件
            File file = new File("hello1.txt");

            // 2. 提供FileWriter的对象，用于数据的写出
            fw = new FileWriter(file, false);

            // 3. 写出的操作
            fw.write("I have a dream!\n"); // 按字符写入
            fw.write("You neet to have a dream!".toCharArray()); // 一次写入一个字符数组
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 流资源的关闭
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /*
        不能使用字符流来处理图片、视频等字节数据
     */
    @Test
    public void testFileReaderAndWriter(){
        FileReader fr = null;
        FileWriter fw = null;
        try {
            // 1. 创建File类对象，指明读入和写出的文件
            File srcFile = new File("hello.txt");
            File destFile = new File("hello2.txt");

            // 2.创建输入流和输出流的对象
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);

            // 3. 数据的读入和写出操作
            char[] cbuf = new char[5];
            int len; // 记录每次读入到cbuf数组中的字符的个数
            while((len = fr.read(cbuf)) != -1){
                // 每次写出len个字符
                fw.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 关闭流资源
            // 方式一：
            try {
                if(fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // 方式二：
            try {
                if(fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    if(fr != null)
                        fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
