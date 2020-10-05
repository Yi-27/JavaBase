package com.example.java;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile的使用
 *  1. RandomAccessFile直接继承于java.lang.Object类，实现了DataInput和 DataOutput接口
 *  2. RandomAccessFile既可以作为一个输入流又可以作为一个输出流
 *
 *  3. 如果RandomAccessFile作为输出流时，写出到文件如果不存在，则在执行过程中自动创建
 *     如果写出到的文件存在，则会对原有文件内容进行覆盖（默认情况，从头覆盖，能覆盖多少覆盖多少）
 *
 * @author Yi-27
 * @create 2020-10-05 17:04
 */
public class RandomAccessFileTest {

    @Test
    public void test(){

        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            // 随机存取文件流（文件）
            raf1 = new RandomAccessFile(new File("gakki.png"), "r");
            raf2 = new RandomAccessFile(new File("gakki2.png"), "rw");

            // 读、写文件
            byte[] buffer = new byte[1024];
            int len;
            while ((len = raf1.read(buffer)) != -1){
                raf2.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            if(raf1 != null){
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(raf2 != null){
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("hello.txt", "rw");
        raf1.write("xyz".getBytes()); // 覆盖了原文件中的前三个字符
        raf1.close();
    }

    @Test
    public void test3() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("hello.txt", "rw");

        raf1.seek(3); // 将指针调到角标为3的位置
        raf1.write("uuu".getBytes()); // 这样只是覆盖了外来位置上的字符，而不是插入

        raf1.close();
    }

    @Test
    public void test4() throws IOException {
        File file = new File("hello.txt");
        RandomAccessFile raf1 = new RandomAccessFile(file, "rw");

        raf1.seek(file.length()); // 将指针调到文件末尾，这样就是一种追加的操作
        raf1.write("000".getBytes());

        raf1.close();
    }

    /*
    使用RandomAccessFile实现数据的插入效果
     */
    @Test
    public void test5() throws IOException {
        File file = new File("hello.txt");
        RandomAccessFile raf1 = new RandomAccessFile(file, "rw");

        raf1.seek(3); // 将指针调到角标为3的位置

        // 保存指针3后面的所有数据到StringBuilder
        StringBuilder builder = new StringBuilder((int) file.length()); // 创建个字符串长度定义为文件被内容的长度
        byte[] buffer = new byte[20];
        int len;
        while((len = raf1.read(buffer)) != -1){
            builder.append(new String(buffer, 0, len));
        }

        raf1.seek(3); // 将指针再掉回来
        raf1.write("TTT".getBytes()); // 将要插入的数据写进去

        raf1.write(builder.toString().getBytes()); // 再写入取出来的字符串，完成插入

        raf1.close();
    }
}
