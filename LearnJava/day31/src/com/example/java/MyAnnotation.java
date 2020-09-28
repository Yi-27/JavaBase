package com.example.java;

/**
 * @author Yi-27
 * @create 2020-09-28 21:27
 */
public @interface MyAnnotation {

    String value() default "hello"; // 指定默认值

}
