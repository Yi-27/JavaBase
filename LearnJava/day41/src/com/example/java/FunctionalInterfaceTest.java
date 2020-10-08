package com.example.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * java内置的4大核心函数式接口
 *
 * Consumer<T>消费型接口     void accept(T, t)
 * Supplier<T>供给型接口     T get()
 * Function<T, R>函数型接口  R apply(T t)
 * Predicate<T>判定型接口    boolean test(T t)
 *
 * @author Yi-27
 * @create 2020-10-08 15:22
 */
public class FunctionalInterfaceTest {

    @Test
    public void test(){

        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("这时价格：" + aDouble);
            }
        });

        System.out.println("******************");

        happyTime(400, money -> System.out.println("这时价格：" + money));

    }

    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }

    @Test
    public void test2(){

        List<String> list = Arrays.asList("北京", "南京", "天津", "东京", "西京", "普京");
        ArrayList<String> filterStrs = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(filterStrs);

        ArrayList<String> filterStrs2 = filterString(list, s -> s.contains("京"));
        System.out.println(filterStrs2);

    }

    // 根据给定的规则，过滤集合中字符串。此规则由Predicate的方法决定
    public ArrayList<String> filterString(List<String> list, Predicate<String> pre){

        ArrayList<String> filterList = new ArrayList<>();
        for(String s : list){
            if(pre.test(s)){
                filterList.add(s);
            }
        }
        return filterList;
    }

}
