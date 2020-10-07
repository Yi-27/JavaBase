package com.example.java;

import org.junit.Test;

import java.util.Random;

/**
 * 通过反射创建对应的运行时类的对象
 *
 * @author Yi-27
 * @create 2020-10-07 15:39
 */
public class NewInstanceTest {

    @Test
    public void test() throws IllegalAccessException, InstantiationException {

        Class<Person> clazz = Person.class;
        /*
        newInstance()：调用此方法，创建对应的运行时类的对象。内部调用了运行时类的空参构造器

        要想此方法正常的创建运行时类的对象，要求：
            1. 运行时类必须提供空参的构造器
            2. 空参的构造器的访问权限得够。通常，设置为public

        在javabean中要求提供一个public的空参构造器。原因：
            1. 便于通过反射，创建运行时类的对象
            2. 便于子类继承此运行时类时，默认调用super()时，保证父类有此构造器
         */
        Person obj = clazz.newInstance();
        System.out.println(obj);
    }

    // 体现反射的动态性
    @Test
    public void test2(){
        int num = new Random().nextInt(3); // 0,1,2
        String classPath = "";
        switch (num){
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
//                classPath = "java.sql.Date"; // java.sql.Date类没有空参构造器，故这里会抛异常
                classPath = "java.lang.Object";
                break;
            case 2:
                classPath = "com.example.java.Person";
                break;
        }
        try {
            Object obj = getInstance(classPath);
            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Object getInstance(String classPath) throws Exception{
        Class clazz = Class.forName(classPath);
        return clazz.newInstance();
    }
}
