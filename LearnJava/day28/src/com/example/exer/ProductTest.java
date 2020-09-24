package com.example.exer;

/**
 * 生产者/消费者问题
 *
 * 分析：
 *  1.是否是多线程问题？是，生产者线程，消费者线程
 *  2.是否有共享数据？是，店员（或产品—）
 *  3.如何解决线程安全问题？同步机制，三种方法
 *  4.是否涉及到线程的通信？是
 *
 * @author Yi-27
 * @create 2020-09-24 13:27
 */
public class ProductTest {

    public static void main(String[] args) {

        Clerk clerk = new Clerk();
        Producer0 p1 = new Producer0(clerk);
        p1.setName("生产者");

        Customer0 c1 = new Customer0(clerk);
        Thread t1 = new Thread(c1);
        t1.setName("消费者1");

        Customer0 c2 = new Customer0(clerk);
        Thread t2 = new Thread(c1);
        t2.setName("消费者2");

        p1.start();
        t1.start();
        t2.start();

    }
}

class Clerk{

    private int productCount = 0;

    // 得到买进产品
    public synchronized void inProduct(){
        if(productCount < 20){
            productCount++;
            System.out.println(Thread.currentThread().getName() + " : 生产了第 " + productCount + " 个产品");

            // 可以唤醒消费者了
            notify();
        }else{
            // 等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 卖出产品
    public synchronized void outProduct(){
        if(productCount > 0){
            System.out.println(Thread.currentThread().getName() + " : 消费了第 " + productCount + " 个产品");
            productCount--;

            // 唤醒生产者
            notify();
        }else{
            // 等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}



// 生产者
class Producer0 extends Thread{

    private Clerk clerk;

    public Producer0(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + " : 开始生产产品！");

        while (true){

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.inProduct(); // 店员得到一个产品
        }
    }
}

// 消费者
class Customer0 implements Runnable{

    private Clerk clerk;

    public Customer0(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " : 开始消费产品！");

        while (true){

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.outProduct(); // 店员卖出一个产品
        }
    }
}