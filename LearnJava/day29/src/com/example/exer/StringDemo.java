package com.example.exer;

import org.junit.Test;

/**
 * String算法题1
 *          将一个字符串进行反转，将字符串中指定部分进行反转
 *
 * @author Yi-27
 * @create 2020-09-25 20:57
 */
public class StringDemo {

    // 方式一： 转换为char[]，再反转
    public String reverse(String str, int startIndex, int endIndex){
        if(str != null){
            char[] arr = str.toCharArray();
            for(int i=startIndex, j=endIndex; i<j; i++,j--){
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

            return new String(arr);
        }

        return null;
    }

    // 方式二：String的拼接操作
    public String reverse2(String str, int startIndex, int endIndex){
        if(str != null){
            // 第1部分
            String reverseStr = str.substring(0, startIndex);
            // 第2部分
            for(int i=endIndex; i>=startIndex; i--){
                reverseStr += str.charAt(i);
            }
            // 第3部分
            reverseStr += str.substring(endIndex+1); // 一个参数时就是从参数index开始往后到最后

            return reverseStr;
        }

        return null;
    }

    // 方式三：使用StringBuffer/StringBuilder替换String
    public String reverse3(String str, int startIndex, int endIndex){
        if(str != null){
            StringBuilder builder = new StringBuilder(str.length());

            // 第1部分
            builder.append(str.substring(0, startIndex));
            // 第2部分
            for(int i=endIndex; i>=startIndex; i--){
                builder.append(str.charAt(i));
            }
            // 第3部分
            builder.append(str.substring(endIndex+1));

            return builder.toString();
        }

        return null;
    }

    // 方式四：使用StringBuffer/StringBuilder替换String
    public String reverse4(String str, int startIndex, int endIndex){
        if(str != null){
            StringBuilder builder = new StringBuilder(str.length());

            // 第1部分
            builder.append(str.substring(0, startIndex));
            // 第2部分
            StringBuilder builder1 = new StringBuilder(str.substring(startIndex, endIndex+1));
            builder.append(builder1.reverse()); // 直接使用StringBuilder的反转方法
            // 第3部分
            builder.append(str.substring(endIndex+1));

            return builder.toString();
        }

        return null;
    }


    @Test
    public void test0(){
        String s = "123abc321";
        System.out.println(reverse4(s, 3, 5));
    }
}
