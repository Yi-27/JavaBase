package com.example.exer;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author Yi-27
 * @create 2020-10-03 21:58
 */
public class FileDemo {

    @Test
    public void test() throws IOException {
        File file = new File("F:\\Java基础学习和算法练习\\test\\hello.txt");
        // 创建一个与file同目录下的另外一个文件，文件名：haha.txt
        File destFile = new File(file.getParent(), "haha.txt");
        boolean newFile = destFile.createNewFile();
        if(newFile){
            System.out.println("创建成功！");
        }
    }
}
