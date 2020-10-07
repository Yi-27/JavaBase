package com.example.java;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 调用运行时类中指定的结构；属性、方法、构造器
 *
 * @author Yi-27
 * @create 2020-10-07 21:12
 */
public class RunReflectionTest {

    /*
       一般不这样用
     */
    @Test
    public void test() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
       Class clazz = User.class;

       // 创建运行时类的对象
        User u = (User) clazz.newInstance();

        // 获取指定的属性:只能获取public权限的属性
        Field id = clazz.getField("id");

        // 设置当前属性的值
        // set()：参数1：指明设置 哪个对象 的属性    参数2：将此 属性值 设置为多少
        id.set(u, 1001);

        // 获取当前属性值
        // get()：参数1：获取哪个对象的当前属性值
        int uId = (int) id.get(u);
        System.out.println(uId);
    }

    // 如何操作允许时类中的指定属性 --（需要掌握）
    @Test
    public void test2() throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class clazz = User.class;

        // 创建运行时类的对象
        User u = (User) clazz.newInstance();

        // 1. getDeclaredField(String filedName): 获取运行时类中指定变量名的属性
        Field name = clazz.getDeclaredField("name");

        // 2. 保证当前属性是可访问的
        name.setAccessible(true);
        // 3. 获取、设置指定对象的此属性值
        name.set(u, "哈哈哈");
        System.out.println(name.get(u));
    }


    // 如何操作允许时类中的指定方法 --（需要掌握）
    @Test
    public void testMethod() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class clazz = User.class;

        // 创建运行时类的对象
        User u = (User) clazz.newInstance();

        // 1. 获取指定的某个方法
        // getDeclaredMethod():参数1：指明获取的方法名称    参数2L指明获取的方法的形参列表（形参的类型）
        Method show = clazz.getDeclaredMethod("show", String.class);

        // 2. 保证当前方法是可访问的
        show.setAccessible(true);

        // 3. 调用方法
        // invoke()：参数1：方法的调用对象     参数2：给方法形参赋值的实参
        // invoke()：返回值即为对应类中调用的方法的返回值
        Object retValue = show.invoke(u, "CHN");// 类似于 String nation = u.show("CHN");
        System.out.println(retValue); // CHN

        System.out.println();

        // 调用静态方法 private static void showDesc()
        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
//        Object retValue2 = showDesc.invoke(u); // 无返回值就是null
//        Object retValue2 = showDesc.invoke(User.class); // 因为是静态方法所以这样也行，对于静态属性也是同样的道理
        Object retValue2 = showDesc.invoke(null); // 这样也行。只有非静态的才需要具体知道是哪个对象调用的
        System.out.println(retValue2); // null
    }

    // 如何操作允许时类中的指定构造器 --（需要掌握）
    @Test
    public void testConstuctor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class clazz = User.class;

        // private User(String name)
        // 1. 获取指定的构造器
        // getDeclaredConstructor()：参数：指明构造器的参数列表
        Constructor constructor = clazz.getDeclaredConstructor(String.class);

        // 2. 保证此构造器是可访问的
        constructor.setAccessible(true);

        // 3. 调用此构造器创建运行时类的对象
        User u = (User) constructor.newInstance("Tom");
        System.out.println(u); // User{name='Tom', age=0, id=0}

    }
}
