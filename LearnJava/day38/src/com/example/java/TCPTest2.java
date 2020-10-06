package com.example.java;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 例题2：客户端发送文件给服务端，服务端将文件保存在本地
 *
 * @author Yi-27
 * @create 2020-10-05 21:47
 */
public class TCPTest2 {

    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        BufferedInputStream bis = null;
        try {
            // 创建套接字
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 12345);
            // 套接字中的输出流
            os = socket.getOutputStream();

            // 读取本地文件的 缓冲流（文件流（文件））
            bis = new BufferedInputStream(new FileInputStream("gakki.png"));

            // 读写操作
            byte[] buffer = new byte[1024];
            int len;
            while((len = bis.read(buffer)) != -1){
                os.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void server(){
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        BufferedOutputStream bos = null;
        try {
            // 创建服务器套接字
            ss = new ServerSocket(12345);
            // 接收传过来的套接字
            socket = ss.accept();
            // 创建输入流
            is = socket.getInputStream();
            // 创建写入本地文件的流 缓冲输出流(文件输出流（文件））
            bos = new BufferedOutputStream(new FileOutputStream("gakki3.png"));

            // 读写操作
            byte[] buffer = new byte[1024];
            int len;
            while((len = is.read(buffer)) != -1){
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(ss != null){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
