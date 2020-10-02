package com.example.java;

import org.junit.Test;

import java.util.*;

/**
 * Collections：操作Collection、Map的工具类
 *
 * 面试题：Collection 和 Collections的区别
 *
 * @author Yi-27
 * @create 2020-10-02 20:08
 */
public class CollectionsTest {

    @Test
    public void test(){

        List<Integer> list = Arrays.asList(1, 3, 5, 0, 4, 2, -1);
        Integer set = list.set(0, 20); // 改变指定位置上的某值，并返回出来
        System.out.println(set); // 1
        System.out.println(list); // [20, 3, 5, 0, 4, 2, -1]

        // 反转
        Collections.reverse(list);
        System.out.println(list); // [-1, 2, 4, 0, 5, 3, 20]

        // 随机打乱
        Collections.shuffle(list);
        System.out.println(list); // [3, 20, 5, 0, 4, -1, 2]

        // 自然排序
        Collections.sort(list);
        System.out.println(list); // [-1, 0, 2, 3, 4, 5, 20]

        // 交换
        Collections.swap(list, 1, 2);
        System.out.println(list); // [-1, 2, 0, 3, 4, 5, 20]

        System.out.println(Collections.max(list)); // 20
        System.out.println(Collections.min(list)); // -1
        System.out.println(Collections.frequency(list, 2)); // 1

        // copy()
        // 错误写法
//        List dest = new ArrayList();
//        Collections.copy(dest, list); // java.lang.IndexOutOfBoundsException: Source does not fit in dest
//        System.out.println(dest); // copy时 会比较二者的数组中的size，而不是数组的长度

        // 巧妙的写法
        List dest = Arrays.asList(new Object[list.size()]);
        System.out.println(dest.size()); // list.size()
        System.out.println(dest); // [null, null, null, null, null, null, null]
        Collections.copy(dest, list); // 这样copy就对了
        System.out.println(dest); // [-1, 2, 0, 3, 4, 5, 20]
    }

    @Test
    public void test2(){
        /*
        Collections类中提供了多个synchronizedXxx()方法，
        该方法**可将指定集合包装成线程同步的集合**，
        从而可以解决多线程并发访问集合时的线程安全问题
         */
        // 返回的list1 即为线程安全的List.
        List list = Arrays.asList(1, 3, 5, 0, 4, 2, -1);
        List list1 = Collections.synchronizedList(list);

        Enumeration stringEnum = new StringTokenizer("a-b*c-d-e-g", "-");
        while (stringEnum.hasMoreElements()) {
            Object obj = stringEnum.nextElement();
            System.out.println(obj);
            /*
                a
                b*c
                d
                e
                g
             */
        }
    }
}
