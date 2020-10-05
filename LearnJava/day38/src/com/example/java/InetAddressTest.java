package com.example.java;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 一、网络编程中两个主要问题：
 *      + 如何准确地定位网络上一台或多台主机：定位主机上的特定的应用
 *      + 找到主机后如何可靠高效地进行数据传输
 *
 * 二、网络编程中的两个要素
 *      1.对应问题一：IP和端口号
 *      2.对应问题二：提供网络通信协议：TCP/IP参考模型（应用层、传输层、网络层、物理层、数据链路层
 *
 * 三、通信要素一：IP和端口号
 *      1. IP：唯一的标识Internet上的计算机（通信实体）
 *      2. 在Java中使用InetAddress类代笔IP
 *      3. IP分类：IPv4 和 IPv6 ； 万维网 和 局域网
 *      4. 域名： www.baidu.com
 *      5. 本地回路地址：127.0.0.1 对应着：localhost
 *      6. 如何实例化InetAddress：两个方法：getByName(String host)、getLocalHost()
 *              两个常用方法：getHostName() / getHostAddress()
 *
 * @author Yi-27
 * @create 2020-10-05 20:17
 */
public class InetAddressTest {

    public static void main(String[] args) {

        try {
            // File file = new File("hello.txt")
            InetAddress inet1 = InetAddress.getByName("192.168.1.222");
            System.out.println(inet1); // /192.168.1.222

            InetAddress inet2 = InetAddress.getByName("www.atguigu.com");
            System.out.println(inet2); // www.atguigu.com/58.215.145.131

            InetAddress inet3 = InetAddress.getByName("127.0.0.1");
            System.out.println(inet3); // /127.0.0.1

            // 获得本机的IP地址（局域网内的）
            InetAddress inet4 = InetAddress.getLocalHost();
            System.out.println(inet4); // LAPTOP-GCA2NLN7/192.168.222.1


            // getHostName()
            System.out.println(inet2.getHostName()); // www.atguigu.com
            // getHostAddress()
            System.out.println(inet2.getHostAddress()); // 58.215.145.106
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
