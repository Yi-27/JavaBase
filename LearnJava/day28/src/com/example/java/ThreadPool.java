package com.example.java;

import java.util.concurrent.*;

/**
 * 创建线程的方式四：线程池
 *
 * @author Yi-27
 * @create 2020-09-24 14:26
 */
public class ThreadPool {

    public static void main(String[] args) {

        // 1. 定义指定线程数量的线程池
        // 这里ExecutorService是一个接口，这样最终得到的是一个接口实现类的对象（多态）
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) executorService; // 其实就是 ThreadPoolExecutor 类的对象

        // 设置线程池的属性
//        service1.setCorePoolSize(15);
//        service1.setKeepAliveTime();

        // 2. 执行指定的线程的操作，需要提供实现Runnable接口或Callable接口实现类的对象
        executorService.execute(new NumberThread()); // 适合适用于Runnable
        executorService.execute(new NumberThread2()); // 适合适用于Runnable

        NumThread3 numThread3 = new NumThread3();
        executorService.submit(numThread3); // 适合适用于Callable

        FutureTask futureTask = new FutureTask(numThread3);

        try {
            Object sum = futureTask.get(); // !!! 这里会一直运行不知道为啥
            System.out.println("总和为：" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown(); // 关闭线程池
    }
}

class NumberThread implements Runnable{

    @Override
    public void run() {
        for(int i=0; i<=100; i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }
    }
}

class NumberThread2 implements Runnable{

    @Override
    public void run() {
        for(int i=0; i<=100; i++){
            if(i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }
    }
}

class NumThread3 implements Callable{

    @Override
    public Object call() throws Exception {

        int sum = 0;
        for(int i=1; i<=100; i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + " : " + i);
                sum += i;
            }
        }

        return sum;
    }
}