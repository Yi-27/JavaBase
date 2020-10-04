package com.example.java;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之一：缓冲流的使用
 *
 * 1。 缓冲流
 *      BufferedInputStream
 *      BufferOutputStream
 *      BufferedReader
 *      BufferedWroter
 *
 * 2、 作用：提高流的读取、写入的速度
 *     原因：内部提供了一个缓冲区
 *
 * 3， 处理流，就是“套接”在已有流的基础上
 *
 * @author Yi-27
 * @create 2020-10-04 16:00
 */
public class BufferedTest {

    /*
        实现非文本文件的赋值
     */
    @Test
    public void testBufferedStream(){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            // 1. 创建文件对象
            File srcFile = new File("gakki.png");
            File destFile = new File("gakki3.png");

            // 2. 创建流对象
            // 2.1 创建 节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            // 2.2 创建 缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            // 3. 复制的细节：读取、写入
            byte[] buffer = new byte[10];
            int len;
            while((len = bis.read(buffer)) != -1){
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 4. 关闭资源
                // 要求：先关闭外层的流，再关闭内层的流
                if(bos != null)
                    bos.close();
                // 说明：关闭外层的流的同时，内层流也会自动的进行关闭。因此，内层流的关闭代码，可以省略
//        fos.close();
//        fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    // 4. 关闭资源
                    // 要求：先关闭外层的流，再关闭内层的流
                    if(bis != null)
                        bis.close();
                    // 说明：关闭外层的流的同时，内层流也会自动的进行关闭。因此，内层流的关闭代码，可以省略
//        fos.close();
//        fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    // 实现文件复制的方法
    public void copyFileWithBuffered(String srcPath, String destPath){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            // 1. 创建文件对象
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            // 2. 创建流对象
            // 2.1 创建 节点流(文件流）
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            // 2.2 创建 缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            // 3. 复制的细节：读取、写入
            byte[] buffer = new byte[1024];
            int len;
            while((len = bis.read(buffer)) != -1){
                bos.write(buffer, 0, len);

//                bos.flush(); // 刷新缓冲区，即显式的将缓冲区内的数据写入磁盘中
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 4. 关闭资源
                // 要求：先关闭外层的流，再关闭内层的流
                if(bos != null)
                    bos.close();
                // 说明：关闭外层的流的同时，内层流也会自动的进行关闭。因此，内层流的关闭代码，可以省略
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    // 4. 关闭资源
                    // 要求：先关闭外层的流，再关闭内层的流
                    if(bis != null)
                        bis.close();
                    // 说明：关闭外层的流的同时，内层流也会自动的进行关闭。因此，内层流的关闭代码，可以省略
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testCopyFileWithBuffered(){
        long start = System.currentTimeMillis();
        copyFileWithBuffered("test.flv", "test3.flv");
        long end = System.currentTimeMillis();
        System.out.println("复制操作花费的时间为：" + (end -start));
        // 不使用缓冲流时，数组大小为 1024时为 375毫秒； 5时为 57411毫秒
        // 使用缓冲流时，数组大小为 1024时为 116毫秒； 5时为 707毫秒
    }

    /*
        使用BufferedReader和BufferedWriter实现文本文件的赋值
     */
    @Test
    public void testBufferedReaderBufferedWriter(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            // 缓冲流（文件流（文件）））
            br = new BufferedReader(new FileReader(new File("src\\com\\example\\java\\FileInputOutputStreamTest.java")));
            bw = new BufferedWriter(new FileWriter(new File("testJava.txt")));

            // 读写操作
            // 方式一：使用char[] 数组
//            char[] cbuf = new char[1024]; // 字符流
//            int len;
//            while ((len = br.read(cbuf)) != -1){
//                bw.write(cbuf, 0, len);
//            }

            // 方式二：使用String
            String data;
            while((data = br.readLine()) != null){
                // 方法一：
//                bw.write(data + "\n"); // data中不包含换行符
                // 方法二：
                bw.write(data);
                bw.newLine(); // 换行
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if(bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
