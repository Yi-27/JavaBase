package com.example.java;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Map的实现类的结构：
 * |----Map：双列数据，存储key-value对的数据
 *      |----HashMap：作为Map的主要实现类。线程不安全，效率高；存储null的key和value
 *          |----LinkedHashMap：保证在遍历map元素时，可以按照添加的顺序实现遍历
 *                  原因：在原有的HashMap底层结构基础上，添加了一对指针，指向前一个和后一个元素
 *                  对于频繁的遍历操作，此类指向效率高于HashMap
 *      |----TreeMap：可以按照添加的key-value对进行排序，实现排序遍历；此时考虑key的自然排序和定制排序，而不是value
 *                    底层使用红黑树
 *      |----Hashtable：作为古老的实现类；线程安全，效率低；不能存储null的key和value
 *          |----Properties：常用来处理配置文件。key和value都是String类型
 *
 *  HashMap的底层：数组 + 链表 （jdk7及之前）
 *                 数组 + 链表 + 红黑树 （jdk8）
 *
 * 面试题：
 *      HashMap的底层实现原理？
 *      HashMap 和 Hashtable的异同？
 *      CurrentHashMap（实现了分段锁） 与 Hashtable的异同？
 *
 * Map结构的理解：
 *      key是无序的、不可重复的，使用Set存储所有的key；--> key所在类要重写equals()和hashCode()（以HashMap为例，TreeMap不是这样的）
 *      value是无序的、可重复的，使用Collection存储所有的value； -->value所在类要重写equals()
 * Map并不是两两放进去，放的是一个Entry对象，而key和value是作为Entry的属性的
 *      一个键值对：key-value构成一个Entry对象
 * Entry类似于Set，无序且不可重复
 * Map中的entry：无序的、不可重复的，使用Set存储所有的entry
 *
 *
 *
 * @author Yi-27
 * @create 2020-10-01 8:49
 */
public class MapTest {

    @Test
    public void test(){
        Map map = new HashMap();
        map.put(null, 123);
        System.out.println(map); // {null=123}

        Map map1 = new Hashtable();
        map1.put(null, 123); // 直接抛异常 java.lang.NullPointerException
        System.out.println(map1);
    }

    @Test
    public void test2(){
        /*
         HashMap的底层实现原理。以jdk7为例说明
            HashMap map = new HashMap();
            在实例化以后，底层创建了长度是16的一维数组Entry[] table;
            ...可能执行过多次put...
            map.put(key1, value1);
            首先，调用key1所在类的hashCode()计算key1哈希值，此哈希值经过某种算法计算后得到在Entry数组中存放位置
                如果此位置上的数据为空，此时key1-value1添加成功   ---> 情况1
                如果此位置上的数据不为空，（意味着此位置上存在一个或多个数据（以链表形式存在）），比较key1和已经存在的一个或多个数据的哈希值：
                        如果key1的哈希值与已经存在的数据的哈希值都不相同，此时key1-value1添加成功    ---> 情况2
                        如果key1的哈希值与已经存在的某个数据(key2-value2)的哈希值相同，继续比较：调用key1所在类的equals()方法，比较：
                                如果equals()返回false：此时key1-value1添加成功     ---> 情况3
                                如果equals()返回true：使用value1替换value2，

             补充：关于情况2和情况3：key1-value1和原来的数据以链表的方式存储（还是七上八下）

             在不断的添加过程中，会涉及到扩容问题，默认的扩容方式：扩容为原来容量的2倍，并将原有的数据复制过来

             jdk8 相较于 jdk7底层实现方面的不同：
                1. new HashMap()：底层没有创建一个长度为16的数组
                2. jdk8 底层的数组是：Node[]，而非Entry[]
                3. 首次调用put()方法时，底层创建长度为16的数组
                4. jdk7底层结构只有：数组+链表。jdk8中底层结构：数组+链表+红黑树
                   当数组的某一个索引位置上的元素以链表形式存在的数据个数 > 8 且当前数组的长度 > 64时，
                   此时此索引位置上的所有数据改为使用红黑树存储。（查询效率高）

         */
    }

}
