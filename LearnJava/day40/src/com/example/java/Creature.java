package com.example.java;

import java.io.Serializable;

/**
 * @author Yi-27
 * @create 2020-10-07 16:40
 */
public class Creature<T> implements Serializable {

    private char gender;
    public double weight;

    private void breath(){
        System.out.println("正在呼吸！");
    }

    public void eat(){
        System.out.println("正在吃东西！");
    }

}
