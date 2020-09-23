package com.example.java;

/**
 * 多线程的创建，方式一：继承于Thread类
 *  1. 创建一个继承与Thread类的子类
 *  2. 重写Thread类的run()
 *  3. 创建Thread类的子类的对象
 *  4. 通过此对象调用start()
 *
 * @author Yi-27
 * @create 2020-09-23 10:04
 */
public class ThreadTest {

    public static void main(String[] args) {
        // 3. 创建Thread类的子类的对象
        MyThread t1 = new MyThread();
        // 4. 通过此对象调用start()
        t1.start(); // ① 启动当前线程  ② 调用当前线程的run()
//        t1.run(); // 这样就没有启用新的线程，而是直接调用run()

        // 多线程只能创建多个线程对象，不能同一线程对象start多次
        MyThread t2 = new MyThread();
        t2.start();


        System.out.println("hhhhh");
        for (int i=0; i<100; i++){
            if(i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + "-----" + i);
            }
        }
    }
}


// 1. 创建一个继承与Thread类的子类
class MyThread extends Thread{
    // 2. 重写Thread类的run()
    @Override
    public void run(){
        for (int i=0; i<100; i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}