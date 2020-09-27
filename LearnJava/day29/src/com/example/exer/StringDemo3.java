package com.example.exer;

import org.junit.Test;

import java.util.Arrays;

/**
 * String面试题3
 *
 * @author Yi-27
 * @create 2020-09-26 20:54
 */
public class StringDemo3 {

    /*
        获取两个字符串中最大相同子串
        str = "abajdhjahjdhwabcd"; str2 = "abcd"
        提示：将短的哪个串进行长度一次递减的子串与较长的串比较
     */
    public String getMaxSameString(String str1, String str2){
        if(str1 != null && str2 != null){
            // 不考虑存在多个最大相同子串
            String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
            String minStr = (str1.length() < str2.length()) ? str1 : str2; // 这里不等于，是为了在两字符串长度相同时可以让max 和 min字符串分别是两个字符串

            int length = minStr.length();

            for(int i=0; i<length; i++){

                for(int x=0, y=length-i; y<=length; x++,y++){
                    String subStr = minStr.substring(x, y);
                    if(maxStr.contains(subStr)){
                        return subStr;
                    }
                }
            }
        }

        return null;
    }

    public String[] getManyMaxSameString(String str1, String str2){
        if(str1 != null && str2 != null){
            StringBuilder sb = new StringBuilder();
            // 不考虑存在多个最大相同子串
            String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
            String minStr = (str1.length() < str2.length()) ? str1 : str2; // 这里不等于，是为了在两字符串长度相同时可以让max 和 min字符串分别是两个字符串

            int length = minStr.length();

            for(int i=0; i<length; i++){

                for(int x=0, y=length-i; y<=length; x++,y++){
                    String subStr = minStr.substring(x, y);
                    if(maxStr.contains(subStr)){
                        sb.append(subStr).append(",");
                    }
                }
//                System.out.println(sb.toString());
                if(sb.length() != 0){
                    break; // 这里如果不等于0，那么就说明第一轮已经有最大相同子串了，就不用接着往下判断了
                }
            }
            // 先将最后结尾的 逗号 替换成空字符串，再以字符串分隔开字符串得到字符串数组
            return sb.toString().replaceAll(",$", "").split(",");
        }

        return null;
    }


    @Test
    public void test0(){
        String str1 = "abchellodefyoujiyouaili";
        String str2 = "cdefhellodyoujiyaili";
        System.out.println(Arrays.toString(getManyMaxSameString(str1, str2)));
        System.out.println(Arrays.toString("123,321".split(",")));


    }

}
