package com.example.java;

import java.lang.reflect.Proxy;

/**
 * 动态代理的举例
 *
 * 动态代理要解决的问题？
 *      问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象
 *      问题二：当通过代理类的对象调用方法时，如何动态的去调用被代理类中的同名方法
 *
 * @author Yi-27
 * @create 2020-10-07 22:01
 */
public class ProxyTest {
}

class ProxyFactory{

    // 调用此方法，返回一个代理类的对象。    解决问题一
    public static Object getProxyInstance(Object obj){ // obj：被代理类的对象

        Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), )

    }

}

class MyInvocationHandler implements im

// 被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I am superman!";
    }

    @Override
    public void eat(String food) {
        System.out.println("喜欢吃 " + food);
    }
}

interface Human{

    String getBelief();
    void eat(String food);

}
