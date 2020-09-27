package com.example.java;

import org.junit.Test;

/**
 * @author Yi-27
 * @create 2020-09-26 21:52
 */
public class IDEADebug {

    @Test
    public void testStringBuffer(){
        String str = null;
        StringBuilder sb = new StringBuilder();

        sb.append(str); //
        System.out.println(sb.length()); // 4
        System.out.println(sb); // "null"
        System.out.println(sb.toString()); // "null"

        StringBuilder sb1 = new StringBuilder(str);
        System.out.println(sb1); // 抛异常 空指针
    }

}
