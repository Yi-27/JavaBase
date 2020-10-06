package com.example.java;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP例题3：从客户端发送文件给服务端，服务端保存到本地，并返回“发送成功”给客户端，并关闭相应的连接
 *
 * @author Yi-27
 * @create 2020-10-06 12:57
 */
public class TCPTest3 {

    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        BufferedInputStream bis = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
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

            // 关闭数据的输出，这样才能避免阻塞，才能接收下面接收反馈
            socket.shutdownOutput();

            // 等待并接收服务器端的反馈信息，并打印到控制台上
            is = socket.getInputStream(); // 创建输入流
            //用于接收字符，由于不知道长度是多大，所以这里用这个可以不限长度，更好
            baos = new ByteArrayOutputStream();
            byte[] buffer2 = new byte[20];
            while((len = is.read(buffer2)) != -1){ // 还要上班的len
                baos.write(buffer2, 0, len); // 写进baos中
            }
            System.out.println(baos.toString()); // 输出到控制台
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(baos != null){
                try {
                    baos.close();
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
        OutputStream os = null;
        try {
            // 创建服务器套接字
            ss = new ServerSocket(12345);
            // 接收传过来的套接字
            socket = ss.accept();
            // 创建输入流
            is = socket.getInputStream();
            // 创建写入本地文件的流 缓冲输出流(文件输出流（文件））
            bos = new BufferedOutputStream(new FileOutputStream("gakki5.png"));

            // 读写操作
            byte[] buffer = new byte[1024];
            int len;
            while((len = is.read(buffer)) != -1){ // 这个read是个阻塞式的方法
                bos.write(buffer, 0, len);
            }

            // 给客户端反馈
            os = socket.getOutputStream(); // 在socket上建立输出流
            os.write("你好，照片已收到！".getBytes());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
