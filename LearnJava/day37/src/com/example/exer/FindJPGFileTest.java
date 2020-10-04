package com.example.exer;

import org.junit.Test;

import java.io.File;
import java.io.FilenameFilter;

/**
 * File类练习题二：
 *      判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
 *
 * @author Yi-27
 * @create 2020-10-04 10:59
 */
public class FindJPGFileTest {

    @Test
    public void test(){
       File srcFile = new File("F:\\Java基础学习和算法练习\\test");
        String[] fileNames = srcFile.list(); // 获取指定目录下所有文件或者文件目录的名称的数组
        for(String fileName : fileNames){
            if(fileName.endsWith(".jpg")){
                System.out.println(fileName);
            }
        }
    }

    @Test
    public void test2(){
        File srcFile = new File("F:\\Java基础学习和算法练习\\test");

        File[] files = srcFile.listFiles();
        for(File file : files){
            if(file.getName().endsWith(".jpg")){
                System.out.println(file.getAbsolutePath()); // 输出绝对路径
            }
        }
    }

    @Test
    public void test3(){
        /*
            File类提供了两个文件过滤器方法
            public String[] list(FilenameFilter filter)
            public File[] listFiles(FileFilter filter)
         */
        File srcFile = new File("F:\\Java基础学习和算法练习\\test");

        File[] files = srcFile.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".jpg");
            }
        });

        for(File file : files){
            System.out.println(file.getAbsolutePath());
        }
    }


}
