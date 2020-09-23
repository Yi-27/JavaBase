package com.example.exer;

/**
 * Thread多线程练习
 * @author Yi-27
 * @create 2020-09-23 10:22
 */
public class ThreadDemo {

    public static void main(String[] args) {

        // 创建Thread类的匿名子类
        new Thread(){
            @Override
            public void run(){
                for (int i=0; i<100; i++){
                    if(i % 2 == 0){ // 偶数
                        System.out.println(Thread.currentThread().getName() + " : " + i);
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run(){
                for (int i=0; i<100; i++){
                    if(i % 2 != 0){ // 奇数
                        System.out.println(Thread.currentThread().getName() + " : " + i);
                    }
                }
            }
        }.start();
    }
}
