package com.example.java;

import org.junit.Test;

import java.util.*;

/**
 * Map中常用方法的测试
 *
 * @author Yi-27
 * @create 2020-10-02 17:08
 */
public class MapMethodTest {

    @Test
    public void test(){
        Map map = new HashMap();
        // 添加
        map.put("AA", 123);
        map.put('c', 123);
        map.put(456, 123);
        map.put("BB", 123);
        // 修改
        map.put("AA", 456);
        System.out.println(map); // {AA=456, BB=123, c=123, 456=123}

        System.out.println(map.put("AA", 456)); // 返回了456
        System.out.println(map.put("AA", 789)); // 返回了456
        System.out.println(map.put("CC", 789)); // 返回了null
        System.out.println(map); // {AA=789, BB=123, CC=789, c=123, 456=123}

        Map map1 = new HashMap();
        map1.put("AA", 987);
        map1.put("CC", 789);
        map1.put("DD", 789);
        map.putAll(map1); // AA 的值更新了，新增了DD的值
        System.out.println(map); // {AA=987, BB=123, CC=789, DD=789, c=123, 456=123}

        // remove(Object key)
        Object value = map.remove("CC"); // 移除并返回出来
        System.out.println(value); // 789
        System.out.println(map);
        System.out.println(map.remove("abcd")); // null

        // clear()
        map1.clear(); // 不是简单的map = null; 清具体的内容
        System.out.println(map1); // {}
        System.out.println(map1.size()); // 0

        // isEmpty()
        System.out.println(map1.isEmpty()); // true

        map.put(null, "321");
        // get(Object key)
        System.out.println(map.get(null)); // 321
        System.out.println(map.get(456)); // 123

        // conatainsKey(Object key)
        boolean isExist = map.containsKey("BB"); // 一样会判断哈希值/地址/equals判断内容
        System.out.println(isExist); // true

        isExist = map.containsValue(789); // 有一个值为789就回返回true
        System.out.println(isExist); // true

        // boolean equals(Object obj)：判断当前map和参数对象obj是否相等
    }

    @Test
    public void test2(){
        /*
        元视图操作的方法
         */
        Map map = new HashMap();
        // 添加
        map.put("AA", 123);
        map.put('c', 456);
        map.put(456, 789);
        map.put("BB", 0);

        // 遍历所有的key值
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next()); // AA BB c 456
        }

        // 遍历所有的value集：values()
        Collection values = map.values(); // 与keySet()出来的顺序是一样的
        for(Object obj : values){
            System.out.println(obj);
        }

        // 遍历所有的key-value
        // entrySet():
        Set set1 = map.entrySet();
        Iterator iterator1 = set1.iterator();
        while (iterator1.hasNext()) {
            Object obj = iterator1.next();
            // entrySet得到的集合中的数据都是Entry型的
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "---->" + entry.getValue());
        }

        for(Object obj : map.entrySet()){
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "---->" + entry.getValue());
        }
    }


}
