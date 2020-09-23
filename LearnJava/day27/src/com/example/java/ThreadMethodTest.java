package com.example.java;

/**
 * 测试Thread中的常用方法：
 *  1. start(): 启动当前线程，调用当前线程的run()
 *  2. run(): 通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
 *  3. currentThread()： 静态方法，返回执行当前代码的线程
 *  4. getName()： 获取当前线程的名字
 *  5. setName()： 设置当前线程的名字
 *  6. yield()： 释放当前CPU的执行权，但是可能下面又被分配到CPU的执行权
 *  7. join()：在线程a中调用线程b的join()，此时线程a进入阻塞状态，直到线程b完全执行完之后，线程a结束阻塞状态
 *  8. stop()： 已过时，当执行此方法时，强制结束当前线程
 *  9. sleep(long millitime)： 线程睡眠，单位毫秒，在指定的毫秒时间内，当前线程是阻塞状态
 *  10. isAlive()： 判断当前线程是否还存活
 *
 *
 * @author Yi-27
 * @create 2020-09-23 10:27
 */
public class ThreadMethodTest {
    public static void main(String[] args) {

        HelloThread h1 = new HelloThread("构造器命名线程-");

        // 设置线程名
//        h1.setName("h1线程");
        // 设置分线程的优先级
        h1.setPriority(Thread.MAX_PRIORITY);

        h1.start();

        Thread.currentThread().setName("主线程-"); // 也可以在运行线程的时候改
        for (int i=0; i<100; i++){
            if(i % 2 != 0){ // 奇数
                System.out.println(Thread.currentThread().getName() + "==" + Thread.currentThread().getPriority() +  " : " + i);
            }

            if(i == 30){
                try {
                    h1.join(); // 阻塞当前线程，执行h1线程
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(h1.isAlive());
    }
}


class HelloThread extends Thread{

    public HelloThread(String name){
        super(name);
    }

    @Override
    public void run(){
        for (int i=0; i<100; i++){
            if(i % 2 == 0){ // 偶数
                try { // 这里不能throw出去是因为父类的run()没有抛异常，子类不能大于父类
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "==" + Thread.currentThread().getPriority() + " : " + i);
            }

            if(i % 20 == 0){
                this.yield(); // 释放当前CPU的占用
            }
        }
    }

}