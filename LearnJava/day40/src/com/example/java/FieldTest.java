package com.example.java;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 获取当前运行时类的属性结构
 *
 * @author Yi-27
 * @create 2020-10-07 16:53
 */
public class FieldTest {

    // 获取属性结构
    @Test
    public void test(){

        Class clazz = User.class;

        // getFields()：获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] fields = clazz.getFields();
        for(Field field : fields){
            System.out.println(field);
            /*
            public int com.example.java.User.id
            public double com.example.java.Creature.weight
             */
        }
        System.out.println(); // 换行

        // getDeclaredField()：获取当前运行时类中声明的所有属性；（不包含父类中声明的属性）
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field f : declaredFields){
            System.out.println(f);
        /*
        private java.lang.String com.example.java.User.name
        int com.example.java.User.age
        public int com.example.java.User.id
         */
        }
    }

    // 权限修饰符 数据类型 变量名
    @Test
    public void test2(){
        Class clazz = User.class;

        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field f : declaredFields) {
//            System.out.println(f);
            // 1. 权限修饰符
            int modifier = f.getModifiers();
            System.out.print(Modifier.toString(modifier) + "\t"); // 打印具体的类型

            // 2. 数据类型
            Class type = f.getType();
            System.out.print(type.getName() + "\t");
            // 3. 变量名
            String fName = f.getName();
            System.out.println(fName);

            System.out.println();
        }
    }


}
