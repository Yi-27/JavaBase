package com.example.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

/**
 * 集合元素的遍历操作，使用迭代器Iterator接口
 *
 * @author Yi-27
 * @create 2020-09-29 14:43
 */
public class IteratorTest {

    @Test
    public void test0(){

        Collection coll = new ArrayList();
        coll.add("AA");
        coll.add('c');
        coll.add(123); // 自动装箱
        coll.add(456.7890313);
        coll.add(false);
        coll.add(new Date());

        Iterator iterator = coll.iterator();

        // 方式一：
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next()); // 超出集合元素个数时，抛异常：NoSuchElementException

        // 方式二：不推荐
//        for (int i = 0; i < coll.size(); i++) {
//            System.out.println(iterator.next());
//        }

        // 方式三：推荐
        while(iterator.hasNext()){ // hasNext()判断还有下一个元素不
            System.out.println(iterator.next());
        }


        // 测试Interator中的remove()
        iterator = coll.iterator();
        while(iterator.hasNext()){ // hasNext()判断还有下一个元素不
            Object obj = iterator.next();
            if(obj.equals('c')){
                iterator.remove(); // 直接从原集合中移除掉该元素
            }
        }
        System.out.println(coll); // 'c'被移除了
    }

}
