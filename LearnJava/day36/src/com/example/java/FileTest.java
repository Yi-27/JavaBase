package com.example.java;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * File类的使用
 * 1. File类的一个对象，代表一个文件或一个文件目录（俗称文件夹）
 * 2. File类声明在java.io包下
 * 3. File类中涉及到关于文件或文件目录的创建、删除、重命名、修改时间、文件大小等方法
 *    并未涉及到写入或读取文件内容的操作。如果需要读取或写入文件内容，必须使用I/O流来完成
 * 4. 后续File类的对象常会作为参数传递给流的构造器中，指明读取或写入的“目标”
 *
 * @author Yi-27
 * @create 2020-10-03 20:00
 */
public class FileTest {

    /*
    1.如何创建File类的实例
            File(String filePath)
            File(String parentPath, String childPath)
            File(File parentFile, String childPath)
    2.相对路径
            相较于某个路径下，指明的路径
      绝对路径
            包含盘符在内的文件或文件目录的路径
     */
    @Test
    public void test(){
        // 构造器1
        File file = new File("hello.txt"); // 相对于当前module
        File file2 = new File("F:\\Java基础学习和算法练习\\test.txt");

        System.out.println(file); // hello.txt
        System.out.println(file2); // F:\Java基础学习和算法练习\test.txt

        // 构造器2
        File file3 = new File("F:\\Java基础学习和算法练习", "JavaBase");
        System.out.println(file3); // F:\Java基础学习和算法练习\JavaBase

        // 构造器3
        File file4 = new File(file3, "test.txt");
        System.out.println(file4); // F:\Java基础学习和算法练习\JavaBase\test.txt

        // 以上并未考虑是否真实存在，而只是内存中的几个对象而已
    }

    /*
        File类的获取功能
     */
    @Test
    public void test2(){
        File file = new File("hello.txt");
        File file2 = new File("F:\\Java基础学习和算法练习\\JavaBase\\test.txt");
        // 获取绝对路径
        System.out.println(file.getAbsoluteFile()); // F:\Java基础学习和算法练习\JavaBase\LearnJava\day36\hello.txt
        //  // 获取路径
        System.out.println(file.getPath()); // hello.txt
        // 获取名称
        System.out.println(file.getName()); // hello.txt
        //  // 获取上层文件目录路径，若无返回null
        System.out.println(file.getParent()); // 这里返回null，创建文件后还是null，说明这个还是基于相对路径的
        // 获取文件长度（即，字节数）。不能获取目录的长度
        System.out.println(file.length()); // 0 因为文件不存在，创建文件后 10 字节
        // 获取最后一次的修改时间，毫秒数（时间戳）
        System.out.println(file.lastModified()); // 0 因为文件不存在，创建文件后 1601730081561

        System.out.println();

        System.out.println(file2.getAbsoluteFile()); // F:\Java基础学习和算法练习\JavaBase\test.txt
        System.out.println(file2.getPath()); // F:\Java基础学习和算法练习\JavaBase\test.txt
        System.out.println(file2.getName()); // test.txt
        System.out.println(file2.getParent()); // F:\Java基础学习和算法练习\JavaBase
        System.out.println(file2.length()); // 0
        System.out.println(file2.lastModified()); // 0
    }

    @Test
    public void test3(){
        File file = new File("F:\\Java基础学习和算法练习\\JavaBase");
        // 获取文件目录
        String[] list = file.list(); // 获取指定目录下所有文件或者文件目录的名称的数组
        System.out.println(Arrays.toString(list)); // [.git, .gitattributes, JavaLearn, Java基础.md, LearnJava, README.md]

        File[] files = file.listFiles(); // 获取指定目录下所有文件或者文件目录的File数组
        System.out.println(Arrays.toString(files)); // [F:\Java基础学习和算法练习\JavaBase\.git, F:\Java基础学习和算法练习\JavaBase\.gitattributes, F:\Java基础学习和算法练习\JavaBase\JavaLearn, F:\Java基础学习和算法练习\JavaBase\Java基础.md, F:\Java基础学习和算法练习\JavaBase\LearnJava, F:\Java基础学习和算法练习\JavaBase\README.md]
    }

    @Test
    public void test4(){
        // boolean renameTo(File dest)：把文件重命名，并移到指定的文件路径
        File file1 = new File("hello.txt");
        File file2 = new File("F:\\Java基础学习和算法练习\\test.txt");

        boolean b = file2.renameTo(file1);
        System.out.println(b); // 如果test.text文件存在，返回false；不存在则返回true
    }

    @Test
    public void test5(){
        File file1 = new File("hello.txt");
        File file2 = new File("F:\\Java基础学习和算法练习\\JavaBase");

        System.out.println(file1.isDirectory()); // 判断是否是文件目录
        System.out.println(file1.isFile()); // 判断是否是文件
        System.out.println(file1.exists()); // 判断是否存在
        System.out.println(file1.canRead()); // 判断是否可读
        System.out.println(file1.canWrite()); // 判断是否可写
        System.out.println(file1.isHidden()); // 判断是否隐藏

        System.out.println(file2.isDirectory()); // 判断是否是文件目录
        System.out.println(file2.isFile()); // 判断是否是文件
        System.out.println(file2.exists()); // 判断是否存在
        System.out.println(file2.canRead()); // 判断是否可读
        System.out.println(file2.canWrite()); // 判断是否可写
        System.out.println(file2.isHidden()); // 判断是否隐藏

        // 注意，当文件或路径不存在时，上面全返回false
    }

    @Test
    public void test6() throws IOException {
        /*
            创建和删除
         */
        File file1 = new File("hi.txt");
        if (!file1.exists()) {
            file1.createNewFile(); // 创建文件，会返回boolean值
            System.out.println("创建成功1");
        }else{
            file1.delete(); // 删除文件 会返回boolean值
            System.out.println("删除成功1"); // 注意，Java中的删除不走回收站
        }

        // 文件目录的创建
        File file2 = new File("F:\\Java基础学习和算法练习\\test");
        if (!file2.exists()) {
            file2.mkdir(); // 创建文件夹。如果文件目录存在就不创建了，如果文件目录上层目录不存在就不创建了
            System.out.println("创建成功2");
        }else{
            file2.delete(); // 删除文件夹 会返回boolean值
            System.out.println("删除成功2"); // 注意，Java中的删除不走回收站
        }

        File file3 = new File("F:\\Java基础学习和算法练习\\test2\\a");
        if (!file3.exists()) {
            file3.mkdirs(); // 当文件目录上层文件不存在，一并创建
            System.out.println("创建成功3");
        }else{
            file3.delete(); // 删除文件夹 会返回boolean值
            System.out.println("删除成功3"); // 注意，Java中的删除不走回收站
        }
    }
}
