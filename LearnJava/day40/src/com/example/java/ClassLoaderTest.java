package com.example.java;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 了解类的加载器
 *
 * @author Yi-27
 * @create 2020-10-07 14:43
 */
public class ClassLoaderTest {

    @Test
    public void test(){
        // 对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader); // sun.misc.Launcher$AppClassLoader@18b4aac2 系统加载器
        // 调用系统类加载的getParent()：获取扩展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1); // sun.misc.Launcher$ExtClassLoader@23fc625e 扩展类加载器
        // 调用扩展类加载器的getParent()：无法获取引导类加载器
        // 引导类加载器主要负责加载java的核心类库，无法加载自定义类的
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2); // null 无法主动获取到引导类加载器

        ClassLoader classLoader3 = String.class.getClassLoader();
        System.out.println(classLoader3); // null
    }

    /*
    Properties：用来读取配置文件
     */
    @Test
    public void test2() throws IOException {

        Properties pros = new Properties();
        // 测试的文件默认在当前的module下
        // 读取配置文件的方式一：
//        FileInputStream fis = new FileInputStream("jdbc.properties");
//        pros.load(fis);

        // 读取配置文件的方式二：使用ClassLoader
        // 配置文件默认识别为，当前module的src下
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties"); // 这时默认是在src目录下
        pros.load(is);

        String name = pros.getProperty("name");
        int age = Integer.parseInt(pros.getProperty("age"));
        System.out.println(name + " : " + age);

        is.close();
    }
}
