package com.example.exer;

import java.io.File;

/**
 * File类联系题三. 遍历指定目录所有文件名称，包括子文件目录中的文件
 *      拓展1：并计算指定目录占用空间的大小 file.length()
 *      扩展2：删除指定文件目录及其下的所有文件
 *
 *
 * @author Yi-27
 * @create 2020-10-04 11:13
 */
public class ListFilesTest {

    public static void main(String[] args) {
        // 递归：文件目录
        // 打印出指定目录所有文件名称，包括子文件目录中的文件

        // 1. 创建目录对象
        File dir = new File("F:\\Java基础学习和算法练习\\test");

        // 2. 打印目录的子文件
        printSubFile(dir);
    }

    public static void printSubFile(File dir){
        // 打印目录的子文件
        File[] subfiles = dir.listFiles();

        for(File f : subfiles){
            if(f.isDirectory()){ // 文件目录
                printSubFile(f);
            }else{ // 文件
                System.out.println(f.getAbsolutePath());
            }
        }
    }

    // 拓展1：求指定目录所在空间的大小
    public static long getDirectorySize(File file){
        // file是文件直接返回file.length()
        // file是目录，把它的下一级的所有大小加起来就是它的总大小
        long size = 0;
        if(file.isFile()){
            size += file.length();
        }else{
            File[] files = file.listFiles(); // 获取file的下一级
            // 累加下一级目录的所有文件的大小
            for(File f : files){
                size += getDirectorySize(f);
            }
        }

        return size;
    }

    // 拓展2：删除指定的目录
    public static void deleteDirectory(File file){
        // 如果file是文件，直接delete
        // 如果file是目录，先把它的下一级删掉，然后删自己
        if(file.isDirectory()){
            File[] files = file.listFiles();
            // 循环删除file的下一级
            for(File f : files){ // f代表file的每一个下级
                deleteDirectory(f);
            }
        }
        // 删除自己
        file.delete();
    }
}
