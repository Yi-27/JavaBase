package com.example.exer;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 图片加密解密测试
 *
 * @author Yi-27
 * @create 2020-10-04 17:04
 */
public class PicTest {

    // 图片的加密
    @Test
    public void test(){
        FileInputStream fis = null; // 可以省略new File，FileInputStream重载构造器有能帮忙创建的
        FileOutputStream fos = null;

        try {
//        FileInputStream fis = new FileInputStream(new File("gakki.png"));
            fis = new FileInputStream("gakki.png");
            fos = new FileOutputStream("gakki4.png");

            byte[] buffer = new byte[20];
            int len;
            while((len = fis.read(buffer)) != -1){
                // 对字节数据进行加密
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte)(buffer[i] ^ 5); // ^ 异或运算
                }
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 图片的解密
    @Test
    public void test2(){
        FileInputStream fis = null; // 可以省略new File，FileInputStream重载构造器有能帮忙创建的
        FileOutputStream fos = null;

        try {
//        FileInputStream fis = new FileInputStream(new File("gakki.png"));
            fis = new FileInputStream("gakki4.png");
            fos = new FileOutputStream("gakki5.png");

            byte[] buffer = new byte[20];
            int len;
            while((len = fis.read(buffer)) != -1){
                // 对字节数据进行加密
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte)(buffer[i] ^ 5); // ^ 异或运算
                }
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
