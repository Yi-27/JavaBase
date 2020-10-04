package com.example.java;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 测试FileInputStream 和 FileOutputStream的使用
 *
 * 结论：
 *      1. 对于文本文件（.txt, .java, .c, .cpp），使用字符流处理
 *      2. 对于非文本文件（.jpg, .mp3, .mp4, .avi, .doc, .ppt,...），使用字节流处理
 * 另外：
 *      1. 当文本文件不需要在内存层面读出来，只是复制，那么使用 字符流/字节流 都可以
 *      2. 但非文本文件使用，只能使用字节流复制，不能使用字符流复制
 *
 * @author Yi-27
 * @create 2020-10-04 14:19
 */
public class FileInputOutputStreamTest {

    // 字节流 读入文本文件，可能出现乱码
    @Test
    public void testFileInputStream(){
        FileInputStream fis = null;
        try {
            // 1. 创建文件对象
            File file = new File("hello.txt");

            // 2 建流对象
            fis = new FileInputStream(file);

            // 3. 读数据 这里如果文件中有中文就会出现乱码
            byte[] buf = new byte[5]; // 因为这里一次只读5个字节，而UTF-8中中文占3个字节
            int len; // 记录每次读取的字节的个数
            while((len = fis.read(buf)) != -1){
                String str = new String(buf, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 关闭资源
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 实现对图片的赋值操作
    @Test
    public void testFileInputOutputStream(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            // 创建文件对象
            File srcFile = new File("gakki.png");
            File destFile = new File("gakki2.png");

            // 创建 输入流/输出流对象
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            // 复制过程 读写文件
            byte[] buf = new byte[5];
            int len;
            while((len = fis.read(buf)) != -1){
                fos.write(buf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭资源
                if(fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                // 关闭资源
                if(fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 指定路径下文件的赋值
    public void copyFile(String srcPath, String destPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            // 创建文件对象
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            // 创建 输入流/输出流对象
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            // 复制过程 读写文件
            byte[] buf = new byte[5];
            int len;
            while((len = fis.read(buf)) != -1){
                fos.write(buf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭资源
                if(fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                // 关闭资源
                if(fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testCopyFile(){
        long start = System.currentTimeMillis();
        copyFile("test.flv", "test3.flv");
        long end = System.currentTimeMillis();
        System.out.println("复制操作花费的时间为：" + (end -start));
        // 数组大小为 1024时为 375毫秒； 5时为 57411毫秒
    }

}
