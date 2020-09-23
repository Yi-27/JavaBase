package com.example.java;

/**
 * 例子：创建三个窗口卖票，总票数为100张，使用继承Thread类的方式
 *
 * 存在线程安全问题
 *
 * 在继承Thread类来实现多线程的方式中，要慎用this充当同步监视器，但可以考虑用 类.class 来充当
 *
 *
 * @author Yi-27
 * @create 2020-09-23 12:34
 */
public class WindowTest {

    public static void main(String[] args) {

        Window t1 = new Window();
        Window t2 = new Window();
        Window t3 = new Window();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window extends Thread{

    private static int ticket = 100;
    private static Object obj = new Object();

    @Override
    public void run(){

        while(true){
            // synchronized (obj) { // 这里不能用this来充当锁
            synchronized (Window.class){ // 但是可以这样来充当锁，类也是对象，只会加载一次，是唯一的
                if (ticket > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(getName() + ": 卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}
