package com.example.java;

/**
 * @author Yi-27
 * @create 2020-09-23 17:31
 */
public class WindowTest4 {

    public static void main(String[] args) {

        Window4 t1 = new Window4();
        Window4 t2 = new Window4();
        Window4 t3 = new Window4();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window4 extends Thread{

    private static int ticket = 100;
    private static Object obj = new Object();

    @Override
    public void run(){

        while(true){
            if(show()){
                break;
            }
        }
    }

    // private synchronized boolean show(){ // 同步监视器：t1,t2,t3，这里锁会出问题，需要把方法改为静态的
    private static synchronized boolean show(){ // 同步监视器：Window4.class
        if (ticket > 0) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ": 卖票，票号为：" + ticket);
            ticket--;
        } else {
            return true;
        }
        return false;
    }
}




