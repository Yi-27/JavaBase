package com.example.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理的举例
 *
 * 动态代理要解决的问题？
 *      问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象
 *      问题二：当通过代理类的对象调用方法a时，如何动态的去调用被代理类中的同名方法a
 *
 * @author Yi-27
 * @create 2020-10-07 22:01
 */
public class ProxyTest {

    public static void main(String[] args) {

        // 创建被代理类对象
        SuperMan superMan = new SuperMan();

        // 创建代理类对象
        // proxyInstance：代理类的对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);// 内部动态创建代理类对象

        // 当通过代理类对象调用方法时，会自动的调用被代理类中同名的方法
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("四川麻辣烫");

        System.out.println("*********************************");

        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory proxyClothFactory = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);
        proxyClothFactory.produceCloth();

    }
}

class HumanUtil{

    public void method1(){
        System.out.println("=============通用方法1=============");
    }

    public void method2(){
        System.out.println("=============通用方法2=============");
    }
}



class ProxyFactory{

    // 调用此方法，返回一个代理类的对象。    解决问题一
    public static Object getProxyInstance(Object obj){ // obj：被代理类的对象

        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj); // 将handler 绑定 被代理类对象

        // 当通过代理类去调用方法时，会自动通过handler来调用被代理类中的方法
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);

    }

}

class MyInvocationHandler implements InvocationHandler {

    private Object obj; // 需要使用被代理类的对象进行赋值

    public void bind(Object obj){
        this.obj = obj;
    }

    // 当我们通过代理类的对象，调用方法a时，就会自动的调用如下的方法：invoke()
    // 将被代理类要执行的方法a的功能声明在invoke()中
    // 为了解决问题二
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        HumanUtil util = new HumanUtil();
        util.method1();

        // method：即为代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
        // obj：被代理类的对象
        Object retValue = method.invoke(obj, args);

        util.method2();

        // 上述的方法的返回值就作为当前类中的invoke()的返回值
        return retValue;
    }
}

// 被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        System.out.println("调用了belief方法");
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
