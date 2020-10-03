package com.example.java;

import org.junit.Test;

import java.util.*;

/**
 * 泛型的使用
 * 1.jdk5.0新增的特性
 *
 *
 * @author Yi-27
 * @create 2020-10-03 13:32
 */
public class GenericTest {

    // 集合中没有使用泛型之前的情况
    @Test
    public void test(){
        // 没有泛型时
        ArrayList list = new ArrayList();
        list.add(78);
        list.add(80);
        list.add(90);

        // 问题一：类型不安全
//        list.add("Tom");

        for(Object score : list){
            // 问题二：强转时，可能出现ClassCastException
            int stuScore = (Integer) score;
            System.out.println(stuScore);
        }

        list.forEach(System.out::println);
    }

    // 在集合中没有使用泛型的情况
    @Test
    public void test2(){
        // 泛型在使用时是一个类型而不是基本数据类型，需要用包装类
        ArrayList<Integer> list = new ArrayList<>();

        list.add(123);
        list.add(321);
        list.add(1234);

        // 编译时，就会进行类型检查，保证数据的安全
//        list.add("Tom");、
        // 方式一
        for(Integer socre : list){
            // 避免强制转换操作
            System.out.println(socre);
        }
        // 方式二：
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer score = iterator.next();
            System.out.println(score);
            iterator.remove(); // 这里不能用增强for循环来删，只能用迭代器来删
        }
        System.out.println(list);
    }

    // 在集合中使用泛型的情况：以HashMap为例
    @Test
    public void test3(){
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("Tom", 87);
        map.put("Jerry", 87);
        map.put("Jack", 67);

        // 泛型的嵌套
        // 这里Entry是定义在Map内部的，所以要用.
        Set<Map.Entry<String, Integer>> entry = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            System.out.println(next.getKey() + "--->" + next.getValue());
        }
    }

    @Test
    public void test4(){
        // 使用自定义泛型类
        // 如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为Object类型
        // 要求：如果定义了类是带泛型的，建议在实例化时要指明类的泛型
        Order order = new Order();
        order.setOrderT(123);
        order.setOrderT("ABC");

        // 建议：实例化时指明类的泛型 后边尖括号内的类型可省
        Order<String> order1 = new Order<>("orderAA", 1001,"order:AA");
        order1.setOrderT("AA:hello");

        // 继承时指明了类型，实例化就不需要了
        SubOrder subOrder = new SubOrder();
        subOrder.setOrderT(12345);

        // 光指明后面的没用，还是需要指明
//        SubOrder1 subOrder1 = new SubOrder1<Double>();
//        subOrder1.setOrderT("ABC");
        SubOrder1<Double> subOrder1 = new SubOrder1<>();
        subOrder1.setOrderT(123.456);
    }

    @Test
    public void test5(){

        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = null;
        // 泛型不同的引用不能相互赋值
//        list1 = list2; // 直接编译就过不了
    }

    @Test
    public void test6(){
        Order<String> order = new Order<>();
        Integer[] arr = new Integer[]{1,2,3,4};
        // 泛型方法的调用
        List<Integer> list = order.copyFromArrayToList(arr);
        System.out.println(list);
    }

    @Test
    public void test7(){
        List<Object> list1 = null;
        List<String> list2 = null;

        // ? 是 通配符
        List<?> list = null;

        // 这样转换没问题
        list = list1;
        list = list2;

        //
        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");
        list = list3;
        // 添加 ： 对于List<?>就不能向其内部添加数据了
//        list.add("DD");
        list.add(null); // 唯一可以加 null

        // 获取（读取）：运行读
        Object o = list.get(0);
        System.out.println(o);
    }
    // 实现通用调用
    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next(); // 用Object接收
            System.out.println(next);
        }
    }

    @Test
    public void test8(){
        // ? 要小于等于Father类，即 是Father类 或 其子类（直接或间接）
        List<? extends Father> list1 = null;
        // ? 要大于等于Father类， 即 是Father类 或 其父类（直接或间接）
        List<? super Father> list2 = null;

        List<Son> list3 = null;
        List<Father> list4 = null;
        List<Object> list5 = null;

        list1 = list3;
        list1 = list4;
//        list1 = list5; // Object 不行

//        list2 = list3; // Son 不行
        list2 = list4;
        list2 = list5;

        // 读取数据
        list1 = list4;
//        Son s = list1.get(0); // 由于list1 存储的数据时 小于等于Father类的
        Father f = list1.get(0); // 因此接收list1中数据时就要 大于等于
        Object o = list1.get(0); // 才能保证不会出现 son类 接收 Father类的情况

        list2 = list4;
//        Son s2 = list2.get(0); // 由于list2是 大于等于 Father类的
//        Father f2 = list2.get(0); // 即可能是 Father 类 或 其直接父类和间接父类
        Object o2 = list2.get(0); // 因此这里只能用最大的 Object类来接收


        // 写入数据
//        list1.add(new Son()); // 编译不通过，因为list1可能是比Son还小的子类
//        list1.add(new Father());
//        list1.add(new Object()); // 都不行

        list2.add(new Father());
        list2.add(new Son());
//        list2.add(new Object()); // list2可能是比Object小的类
    }
}

// 自定义泛型类
class Order<T>{
    // 这里的T并不是指这个类是什么类型，它只是个参数
    String orderName;
    int orderId;

    // 类的内部结构就可以使用类的泛型
    T orderT;

    public Order() {
        // 编译不通过
//        T[] arr = new T[10];
        T[] arr = (T[]) new Object[10]; // 这样可以

    }

    public Order(String orderName, int orderId, T orderT) {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    // 如下的两个方法都不是泛型方法
    public T getOrderT(){
        return orderT;
    }

    public void setOrderT(T orderT){
        this.orderT = orderT;
    }

    // 泛型方法：在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系
    // 换句话说，泛型方法所属的类是不是泛型类型都没有关系
    public <E> List<E> copyFromArrayToList(E[] arr){
        // 必须要指明<E>才行
        ArrayList<E> list = new ArrayList<>();
        for (E e : arr){
            list.add(e);
        }
        return list;
    }


    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}

class SubOrder extends Order<Integer>{
    // 这里指明基础时用什么类型，因此在实例化时就不需要再指明了
}

class SubOrder1<T> extends Order<T>{
    // 保留泛型，这是实例化就需要指明类型了
}

class Father<T1, T2>{
}
// 子类不保留父类的泛型 但子类可以自己添加自己的泛型
// 1. 没有类型，擦除
class Son extends Father{
    // 等价于 class Son extends Father<Object, Object>{}
}
// 2. 具体类型
class Son2<A, B> extends Father<Integer, String>{
}

// 子类保留父类的泛型 子类可以声明自己的泛型
// 1. 全部保留
class Son3<T1, T2> extends Father<T1, T2>{
}

// 2. 部分保留
class Son4<T2> extends Father<Integer, T2>{
}