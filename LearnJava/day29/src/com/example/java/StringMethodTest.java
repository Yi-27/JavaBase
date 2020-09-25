package com.example.java;

import org.junit.Test;

/**
 * 字符串常用方法
 *
 * + int length()
 * + char charAt(int index)，返回某索引处的字符
 * + boolean isEmpty()，判断是否是空字符串
 * + String toLowerCase()，使用默认语言环境，将String中所有字符转换为小写
 * + String toUpperCase()，使用默认语言环境，将String中所有字符转换为大写
 * + String trim()，返回字符串的副本，忽略前导空白和尾部空白
 * + boolean equals(Object obj)，比较字符串的内容是否相同
 * + boolean equalsIgnoreCase(String anotherString)，与equals方法类似，忽略大小写
 * + String concat(String str)，将指定字符串连接到此字符串的尾部，等价于用“+”
 * + int compareTo(String anotherString)，比较两个字符串的大小
 * + String subString(int beginIndex)，返回一个新的字符串，它是此字符串的从beginIndex开始截取到最后一个子字符串
 * + String substring(int beginIndex, int endIndex)，返回一个新字符串，它是此字符串从beginIndex开始截取到endIndex(不包含)的一个子字符串
 *
 * + boolean endsWith(String suffix)，测试此字符串是否以指定的后缀结束
 * + boolean startsWith(String prefix)，测试此字符串是否以指定的前缀开始
 * + boolean startsWith(String prefix, int toffset)，测试此字符串从指定索引开始的子字符串是否以指定的前缀开始
 * + boolean contains(CharSequence s)，当且仅当此字符串包含指定的char值序列时，返回true
 * + int indexOf(String str)，返回指定字符串在此字符串中第一次出现处的索引
 * + int indexOf(String str, int fromIndex)，返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始
 * + int lastIndexOf(String str)，返回指定子字符串在此字符串中最右边出现处的索引
 * + int lastIndexOf(String str, int fromIndex)，返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索
 *     + 注indexOf和lastIndexOf方法如果未找到都是返回-1
 *
 * + String replace(char oldChar,char newChar)，返回一个新的字符串，它是通过用newChar替换此字符串中出现的所有oldchar得到的。
 * + String replace(CharSequence target,CharSequence replacement)，使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。
 * + String replaceAll(String regex,String replacement)，使用给定的replacement替换此字符串所有匹配给定的正则表达式的子字符串。
 * + string replaceFirst(String regex,String replacement)，使用给定的replacement替换此字符串匹配给定的正则表达式的第一个子字符串。
 * + boolean matches(String regex)，慧知此字符串是否匹配给定的正则表达式
 * + tringsplit(String regex)，根据给定正则表达式的匹配拆分此字符串。
 * + string split(String regex，int limit)，根据匹配给定的正则表达式来拆分此字符串，最多不超过limit个，如果超过了，剩下的全部都放到最后一个元素中
 *
 * @author Yi-27
 * @create 2020-09-25 10:23
 */
public class StringMethodTest {

    @Test
    public void test1(){
        String s1 = "helloWord";
        System.out.println(s1.length());
        System.out.println(s1.charAt(0));
        System.out.println(s1.isEmpty());

        String s2 = s1.toLowerCase(); // 小写
        String s3 = s1.toUpperCase(); // 大写
        System.out.println(s2);
        System.out.println(s3);

        String s4 = " he llo world ";
        System.out.println(s4.trim());

        System.out.println(s2.compareTo(s3)); // 涉及到字符串排序
        System.out.println(s2.compareToIgnoreCase(s3)); // 大于0左边大，小于0右边大
    }

    @Test
    public void test2(){
        String s1 = "helloworld";
        System.out.println(s1.endsWith("rld")); // true
        System.out.println(s1.startsWith("He")); // false
        System.out.println(s1.startsWith("ll", 2)); // true

        System.out.println(s1.contains("wo")); // true
        System.out.println(s1.indexOf("lo")); // 返回首次出现的索引
        System.out.println(s1.indexOf("lo", 5));
        System.out.println(s1.lastIndexOf("lo")); // 倒着找，返回正向的索引
        System.out.println(s1.lastIndexOf("lo", 5));
    }

    @Test
    public void test3(){
        String s1 = "ABCzzzDEzzzFC";
        String s2 = s1.replace("zzz", "ooo"); // replace是全替换
        System.out.println(s2);
        System.out.println(s1.replace('C', 'P'));
        System.out.println(s1.replaceFirst("zzz", "uuu"));

        String s3 = "12hello34world56"; // // replaceAll 是用于正则表达式的替换
        System.out.println(s3.replaceAll("\\d+", "-"));

        // matches即为判断字符串是否满足给定正则表达式
        boolean matches = s3.matches("\\d+"); // 判断s3是否请按不由数字组成，即有1-n个数字组成
        System.out.println(matches); // false

        // 切片
        String s4 = "hello|world|java";
        String[] strs = s4.split("\\|");
        for(int i=0; i<strs.length; i++){
            System.out.println(strs[i]);
        }
        String s5 = "hello,world,java";
        String[] strs2 = s5.split(",");
        for(int i=0; i<strs2.length; i++){
            System.out.println(strs2[i]);
        }

    }

}
