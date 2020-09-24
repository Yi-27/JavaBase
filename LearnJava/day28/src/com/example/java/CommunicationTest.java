package com.example.java;

/**
 * 线程通信的例子，使用两个线程打印1-100，线程1，线程2交替打印
 *
 * 涉及到的三个方法：
 *  wait()：一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器
 *  notify()：一旦执行此方法，就会唤醒被wait()的一个线程，如果有多个线程被wait，就唤醒优先级高的线程
 *  notifyAll()：一旦执行此方法，就会唤醒所有被wait的线程
 *
 *  说明：
 *      1.wait()和notify()和notifyAll()必须只能使用在同步代码块或同步方法中
 *      2.同时三个方法的调用者必须是同步代码块或同步方法中的同步监视器
 *      否则会出行IllegalMonitorStateException异常
 *      3.三个方法定义在java.lang.Object类中
 *
 *  面试题：sleep() 和 wait() 的异同
 *  1. 相同点：一旦执行方法，都可以使得当前的线程进入阻塞状态
 *  2. 不同点：1）两个方法声明的位置不同：Thread类中声明sleep()，Object类中声明wait()
 *            2）调用的要求不同，sleep()可以在任何需要的常见下调用，wait()必须使用在同步代码块或同步方法中
 *            3）关于是否释放同步监视器：如果两个方法都使用在同步代码块或同步方法中，sleep()不会释放锁，wait()会释放锁
 *            4）sleep()会自动唤醒，wait()需要手动唤醒
 * @author Yi-27
 * @create 2020-09-24 11:03
 */
public class CommunicationTest {

    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }


}

class Number implements Runnable{

    private int number = 1;

    @Override
    public void run() {
        while(true){
            synchronized (this) {

                // 唤醒线程
                notify(); // 这里还省略了 this.
                // 这里的情况是线程1阻塞后线程2获得CPU执行权，那么线程2调用notify()就会唤醒线程1，
                // 那么此时线程1就处于就绪的状态，等待CPU分配资源

                if(number <= 100){

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + " : " + number);
                    number++;

                    try {
                        // 使得调用wait()的线程进入阻塞状态
                        wait(); // 同时也会释放锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    break;
                }
            }
        }
    }
}