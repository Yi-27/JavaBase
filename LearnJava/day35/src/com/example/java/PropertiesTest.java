package com.example.java;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Yi-27
 * @create 2020-10-02 19:52
 */
public class PropertiesTest {

    public static void main(String[] args) throws IOException {
        Properties pros = new Properties();
        FileInputStream fis = new FileInputStream("jdbc.properties"); // 文件输入流
        pros.load(fis); // 加载流对应的文件

        String name = pros.getProperty("name");
        String password = pros.getProperty("password");
        System.out.println(name + " : " + password);
        Object o = pros.setProperty("name", "zxc"); // 将旧的值返回出来
        System.out.println(o); // Jiyou
        System.out.println(pros); // {password=abc123, name=zxc}

        fis.close();
    }

}
