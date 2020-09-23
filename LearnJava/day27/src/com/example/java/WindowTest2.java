package com.example.java;

/**
 *例子：创建三个窗口卖票，总票数为100张，使用实现Runnable接口的方式
 *仍存在线程安全问题
 * 1. 问题： 卖票过程中，出现了重票、错票
 * 2. 问题出现的原因： 当某个线程操作车牌的过程中，尚未操作完成时，其他线程也操作了车票
 * 3. 如何解决：当一个线程a在操作共享ticket的时候，其他线程不能参与进来，
 *      直到线程a操作完成ticket时，其他线程才能开始操作ticket。
 *      即使线程a出现了阻塞，也不能改变
 * 4、在Java中，通过同步机制，来解决线程的安全问题
 * 方式一：同步代码块
 *      synchronized(同步监视器){
 *          // 需要被同步的代码
 *      }
 *      说明：① 操作共享数据的代码，即为需要被同步的代码。 --> 不能包含代码多了，也不能包含代码少了
 *            ② 共享数据：多个线程共同操作的变量，比如ticket
 *            ③ 同步监视器，俗称 锁。任何一个类的对象，都可以充当锁
 *                  要求：多个线程必须要共用同一把锁
 *                  在实现Runnable接口创建多线程的方式中，可以考虑使用this充当同步监视器
 * 方式二：同步方法
 *      如果操作共享数据的代码完整的声明在一个方法中，不妨将此方法声明为同步的
 *
 * 5. 同步的方式，解决了线程的安全问题。---好处
 *    操作同步代码时，只能有一个线程参与，其他线程等待。相当于是一个单线程的过程，效率低。---坏处
 *
 * @author Yi-27
 * @create 2020-09-23 12:55
 */
public class WindowTest2 {

    public static void main(String[] args) {
        Window2 w = new Window2(); // 只创建一次

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


class Window2 implements Runnable{

    private int ticket = 100; // 这里不用加static，也是100张票
    Object obj = new Object(); // 充当锁

    @Override
    public void run() {
        while(true){
//            synchronized (obj){
            synchronized (this){ // 可以用当前对象充当锁
                if(ticket > 0){

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ": 卖票，票号为：" + ticket);
                    ticket--;
                }else{
                    break;
                }
            }
        }
    }
}

