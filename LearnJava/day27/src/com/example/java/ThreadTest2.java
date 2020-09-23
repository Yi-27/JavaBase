package com.example.java;

/**
 * 创建多线程方式二：实现Runnable接口
 *  1. 创建一个实现了Runnable接口的类
 *  2. 实现类去实现Runnable中的抽象方法：run()
 *  3. 创建实现类的对象
 *  4. 将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 *  5. 通过Thread类的对象调用start()
 *
 *
 * @author Yi-27
 * @create 2020-09-23 12:43
 */
public class ThreadTest2 {

    public static void main(String[] args) {
        // 3. 创建实现类的对象
        MyThread2 mt = new MyThread2();
        // 4. 将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
        Thread t1 = new Thread(mt);
        // 5. 通过Thread类的对象调用start()
        t1.start(); // ① 启动线程 ② 调用当前线程的run()-->调用了Runnable类型的target的run()

        Thread t2 = new Thread(mt);
        t2.start();
    }


}

// 1. 创建一个实现了Runnable接口的类
class MyThread2 implements Runnable{

    // 2. 实现类去实现Runnable中的抽象方法：run()
    @Override
    public void run() {
        for(int i=0; i<100; i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }
    }
}