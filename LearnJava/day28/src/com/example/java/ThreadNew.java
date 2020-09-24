package com.example.java;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三：实现Callable接口。 --- JDK5.0 新增
 *
 * @author Yi-27
 * @create 2020-09-24 14:02
 */
public class ThreadNew {

    public static void main(String[] args) {
        // 3. 创建Callable接口实现类的镀锡
        NumThread numThread = new NumThread();
        // 4. 将此 Callable接口实现类的对象作为参数传递到FutureTask构造器中，创建FutureTask的对象
//        FutureTask futureTask = new FutureTask(numThread);
        FutureTask<Integer> futureTask = new FutureTask<Integer>(numThread);


        // 5. 将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()
        new Thread(futureTask).start();

        try {
            // 6. 获取Callable中call方法的返回值
            // get()返回值，即为FutureTask构造器参数Callable实现类重写的call()的返回值
//            Object sum = futureTask.get();
            Integer sum = futureTask.get();
            System.out.println("总和为：" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}

// 1. 创建一个实现Callable的实现类
class NumThread implements Callable<Integer>{

    // 2. 实现call方法，将此线程需要执行的操作声明在call()中
    @Override
//    public Object call() throws Exception {
    public Integer call() throws Exception {
        int sum = 0;
        for(int i=1; i<=100; i++){
            if(i % 2 == 0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum; // 这里int类型不是Object的子类，但是由于自动装箱的特性，因此会自动提升为Integer
    }
}