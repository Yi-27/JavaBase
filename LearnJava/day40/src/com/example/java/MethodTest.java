package com.example.java;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 获得运行时类的方法结构
 *
 * @author Yi-27
 * @create 2020-10-07 19:20
 */
public class MethodTest {

    @Test
    public void test(){

        Class clazz = User.class;

        // getMethods()：获得当前运行时类及其父类所有声明为public权限的方法
        Method[] methods = clazz.getMethods();
        for(Method m : methods){
            System.out.println(m);
        }
        System.out.println();

        // getDeclaredMethods()：获取当前运行时类中声明的所有方法。（不包含父类中声明的方法）
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for(Method m : declaredMethods){
            System.out.println(m);
        }
    }

    /*
    方法具有哪些结构
    @Xxxx
    权限修饰符  返回值类型  方法名(参数类型1 形参名1,...) throws XxxException{}
     */
    @Test
    public void test2(){

        Class clazz = User.class;

        Method[] declaredMethods = clazz.getDeclaredMethods();
        for(Method m : declaredMethods){
//            System.out.println(m);
            // 1. 获取方法声明的注解
            Annotation[] annos = m.getAnnotations();
            System.out.print("注解: ");
            for(Annotation a : annos){
                System.out.print(a + "\n");
            }

            // 2. 权限修饰符
            System.out.print(" 权限修饰符：" + Modifier.toString(m.getModifiers()) + "\t");

            // 3. 返回值类型
            System.out.print(" 返回值类型：" + m.getReturnType().getName() + "\t");

            // 4. 方法名
            System.out.print(" 方法名：" + m.getName() + "\t");

            // 5. 形参列表
            System.out.print("(");
            Class[] parameterTypes = m.getParameterTypes(); // 形参类型
            if(!(parameterTypes == null && parameterTypes.length == 0)){
                for (int i = 0; i < parameterTypes.length; i++) {
                    if(i == parameterTypes.length - 1){
                        System.out.print(parameterTypes[i].getName() + " args_" + i); // 较早的jdk版本无法直接获得形参名，后来就可以了
                    }else{
                        System.out.print(parameterTypes[i].getName() + " args_" + i + ", "); // 这里没有写怎么获取形成名的代码
                    }
                }
            }
            System.out.print(")");

            // 5. 抛出的异常
            Class[] exceptionTypes = m.getExceptionTypes();
            if (exceptionTypes.length > 0){
                System.out.print(" throws ");
                for (int i = 0; i < exceptionTypes.length; i++) {
                    if(i == exceptionTypes.length -1){
                        System.out.print(exceptionTypes[i].getName());
                    }else{
                        System.out.print(exceptionTypes[i].getName() + ", ");
                    }
                }
            }

            System.out.println();
        }

    }
}
