package com.example.java;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Yi-27
 * @create 2020-10-02 16:33
 */
public class LinkedHashMapTest {

    @Test
    public void test(){
        Map map = new HashMap(); // {345=BB, 123=AA, 12=CC} 不是按添加顺序来的
        map = new LinkedHashMap(); // {123=AA, 345=BB, 12=CC} 按添加顺序来的
        map.put(123, "AA");
        map.put(345, "BB");
        map.put(12, "CC");
        System.out.println(map);
    }

}
