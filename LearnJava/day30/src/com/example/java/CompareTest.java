package com.example.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 *  Java中的对象比较问题
 *
 * @author Yi-27
 * @create 2020-09-27 14:41
 */
public class CompareTest {

    /*
        Comparable接口的使用     自然排序
        1. 像String及包装类等实现了Comparable接口，重写了compareTo(obj)方法给出了比较两个对象大小的方法
        2. 像String及包装类重写compareTo()方法后，进行从小到大的排列
        3，重写compareTo()的规则：
                如果当前对象this大于形参对象obj，则返回正整数
                               小于                  负整数
                               等于                   0
        4. 对于自定义类来说，如果需要排序，可以让自定义类实现Comparable接口，重写compareTo()方法
            在compareTo()方法中指明如何排序
     */
    @Test
    public void test(){
        String[] arr = new String[]{"AA", "BB", "CC", "GG", "JJ", "MM", "DD"};
        Arrays.sort(arr); // 排序
        System.out.println(Arrays.toString(arr));
    }


    @Test
    public void test2(){
        Goods[] arr = new Goods[4];
        arr[0] = new Goods("小米", 34);
        arr[1] = new Goods("华为", 64);
        arr[2] = new Goods("苹果", 74);
        arr[3] = new Goods("三星", 64);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    /*
        Comparator接口的使用    定制排序
        1. 背景
            当元素的类型没有实现java.lang.Comparable接口又不方便修改代码
            或者实现了java.lang.Comparable接口的排序规则不适合当前的操作
            那么就可以考虑使用Comparator
        2. 重写compare(Object o1, Object o2)方法，比较o1和o2的大小
                如果方法返回正整数，则表示 o1 大于 o2
                           负整数            小于
                           0                 等于
     */
    @Test
    public void test3(){
        String[] arr = new String[]{"AA", "BB", "CC", "GG", "JJ", "MM", "DD"};
        // 按照字符串从大到小顺序排列（默认是从小到大）
        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof String && o2 instanceof String){
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);
                }
//                return 0;
                throw new RuntimeException("输入的数据类型不一致");
            }
        });

        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test4(){
        Goods[] arr = new Goods[4];
        arr[0] = new Goods("小米", 34);
        arr[1] = new Goods("华为", 64);
        arr[2] = new Goods("苹果", 74);
        arr[3] = new Goods("三星", 64);
        Arrays.sort(arr, new Comparator<Goods>() {
            @Override
            public int compare(Goods o1, Goods o2) {
                // 指明商品比较大小的方式：先按照名称从低到高排, 再按照价格从高到低排序
                if(o1.getName().equals(o2.getName())){
                    return -Double.compare(o1.getPrice(), o2.getPrice());
                }else{
                    return o1.getName().compareTo(o2.getName());
                }
            }
        });
        System.out.println(Arrays.toString(arr));
    }
}

class Goods implements Comparable{

    private String name;
    private double price;

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Goods() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // 指明商品比较大小的方式：按照价格从低到高排序，再按照名称从高到低排
    @Override
    public int compareTo(Object o) { // 这里 o 是父类引用指向子类对象
        if(o instanceof Goods){
            Goods goods = (Goods)o; // 强转成goods（向下转型）
            // 方式一：
            if(this.price > goods.price){
                return 1;
            }else if(this.price < goods.price){
                return -1;
            }else{
//                return 0;
                return -this.name.compareTo(goods.name); // 调用字符串的compareTo
            }

            // 方式二：
//            return Double.compare(this.price, goods.price);
        }
        throw new RuntimeException("传入的数据类型不一致！");
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}