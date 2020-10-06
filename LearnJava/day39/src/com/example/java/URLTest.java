package com.example.java;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL网络编程
 * 1.URL：统一资源定位符，对应着互联网的某一资源地址
 * 2.格式：
 *      http://localhost:8080/examples/gakki.png?username=Tom&age=18
 *      协议  主机名     端口号     资源地址            参数列表
 *
 * @author Yi-27
 * @create 2020-10-06 14:21
 */
public class URLTest {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:8080/examples/gakki.png?username=Tom&age=18");

            System.out.println(url.getProtocol()); // 获取该URL的协议名    http
            System.out.println(url.getHost()); // 获取该URL的主机名        localhost
            System.out.println(url.getPort()); // 获取该URL的端口号        8080
            System.out.println(url.getPath()); // 获取该URL的文件路径      /examples/gakki.png
            System.out.println(url.getFile()); // 获取该URL的文件名        /examples/gakki.png?username=Tom&age=18
            System.out.println(url.getQuery()); // 获取该URL的查询名       username=Tom&age=18




        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
