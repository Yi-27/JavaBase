package com.example.exer;

import org.junit.Test;

/**
 * String算法题2
 *
 * 获取一个字符串在另一个字符串中出现的次数
 * 比如：获取"ab"在“abcsdhkabkjdlabklk”中出现的次数
 *
 * @author Yi-27
 * @create 2020-09-25 21:40
 */
public class StringDemo2 {

    public int getCount(String mainStr, String subStr){
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int count = 0;
        int index = 0;
        if(mainLength >= subLength){
            // 方式一： 找不到会返回-1
//            while((index = mainStr.indexOf(subStr)) != -1){
//                count++;
//                mainStr = mainStr.substring(index + subStr.length()); // 每次都要造一个字符串，效率不高
//            }

            // 方式二：indexOf()第二个参数是从哪个下标开始
            while((index = mainStr.indexOf(subStr, index)) != -1){
                count++;
                index += subLength; // 加上被搜索字符串的长度
            }

            return count;
        }else{
            return 0;
        }
    }

    @Test
    public void test0(){
        String mainStr = "abasdaabbadaabdsd";
        String subStr = "ab";
        int count = getCount(mainStr, subStr);
        System.out.println(count);
    }

}
