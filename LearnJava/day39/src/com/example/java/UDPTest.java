package com.example.java;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP 协议的网络编程
 *
 *
 *
 * @author Yi-27
 * @create 2020-10-06 13:47
 */
public class UDPTest {

    // 发送端
    @Test
    public void sender(){
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();

            String str = "这是UDP方式发送的数据包";
            byte[] data = str.getBytes();
            InetAddress inet = InetAddress.getLocalHost(); // 发送的IP，这里发送到本地
            DatagramPacket packet = new DatagramPacket(data, 0, data.length, inet, 12345);

            // 通过套接字发送数据包
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(socket != null){
                socket.close();
            }
        }
    }

    // 接收端
    @Test
    public void receiver(){
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(12345);

            byte[] buffer = new byte[100];
            DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);

            socket.receive(packet);

            System.out.println(new String(packet.getData(), 0, packet.getLength()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(socket != null){
                socket.close();
            }
        }
    }


}
