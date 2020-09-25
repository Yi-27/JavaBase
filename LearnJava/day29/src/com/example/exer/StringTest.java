package com.example.exer;

/**
 * 一道面试题
 *
 * @author Yi-27
 * @create 2020-09-25 9:47
 */
public class StringTest {

    String str = new String("good");
    char[] ch = {'t', 'e', 's', 't'};

    public void change(String str, char ch[]){
        str = "test ok"; // 这时方法内的str的指向的地址就发生了变化
        ch[0] = 'b'; // 由于ch还是原来的ch，因此原本的ch也会被修改
    }

    public static void main(String[] args) {
        StringTest ex = new StringTest();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str); // good
        System.out.println(ex.ch); // best
    }

}
