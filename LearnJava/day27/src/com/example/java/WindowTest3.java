package com.example.java;

/**
 * 使用同步方法来实现Runnable接口的线程安全问题
 *  关于同步方法的总结：
 *      1. 同步方法仍然涉及到同步监视器，只是不需要显式的声明
 *      2. 非静态的同步方法，同步监视器是：this
 *          静态的同步方法，同步监视器是：当前类本身，即 类.class
 *
 * @author Yi-27
 * @create 2020-09-23 17:19
 */
public class WindowTest3 {

    public static void main(String[] args) {
        Window3 w = new Window3(); // 只创建一次

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}


class Window3 implements Runnable{

    private int ticket = 100; // 这里不用加static，也是100张票
    Object obj = new Object(); // 充当锁

    @Override
    public void run() {
        while(true){
            if(show()){
                break;
            }
        }
    }

    private synchronized boolean show(){ // 同步监视器：this
        if(ticket > 0){

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ": 卖票，票号为：" + ticket);
            ticket--;
        }else{
            return true;
        }
        return false;
    }
}


