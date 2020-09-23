package com.example.java;

/**
 * 使用同步机制将单例模式中的懒汉式改写为线程安全的
 *
 * @author Yi-27
 * @create 2020-09-23 17:54
 */
public class BankTest {
}


class Bank{

    private Bank(){}

    private static Bank instance = null;

    public static synchronized Bank getInstance(){ // 可能有多个线程同时来调用这个方法
        // 解决方法一：直接加上synchronized关键字即可

        // 解决方法二：里面的代码包上synchronized代码块
        //      方式一：效率稍差
//        synchronized(Bank.class){
//            if(instance == null){
//                instance = new Bank();
//            }
//            return instance;
//        }

        //      方式二：效率稍高
        if(instance == null){
            synchronized (Bank.class){
                if(instance == null){
                    instance = new Bank();
                }
            }
        }
        return instance;
    }

}