package com.example.java;

import org.junit.Test;

import java.io.*;

/**
 * 其他流的使用
 *      1. 标准的输入、输出流
 *      2. 打印流
 *      3. 数据流
 *
 *
 * @author Yi-27
 * @create 2020-10-04 21:57
 */
public class OtherStreamTest {
    /*
     1. 标准的输入、输出流
        1.1
        System.in：标准的输入流。默认从键盘输入
        System.out：标准的输出流，默认从控制台输出
        1.2
        System类的setIn(InputStream is) / setOut(PrintStream ps)方式重新指定输入和输出的流

        1.3 练习
        从键盘输入字符串，要求将读取到的整行字符串转成大写输出，然后继续进行输入操作
        直至当输入“e”或者“exit”时，退出程序
            方法一：使用Scanner实现，调用next()方法返回一个字符串
            方法二：使用System.in实现。System.in（字节流） --->  转换流（转换成字符流） --->  BufferedReader的readLine()
     */
    public static void main(String[] args) {
        BufferedReader br = null; // 转换流
        try {
            InputStreamReader isr = new InputStreamReader(System.in); // 用标准输入流
            br = new BufferedReader(isr);
            String data;
            while(true){
                System.out.println("请输入字符串");
                data = br.readLine();
                if("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)){
                    System.out.println("程序结束");
                    break;
                }
                String upperCase = data.toUpperCase(); // 转成大写的
                System.out.println(upperCase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /*
    打印流
     */
    @Test
    public void test2(){
        PrintStream ps = null;// 打印流，包装了文件字节流
        try {
            FileOutputStream fos = new FileOutputStream("text.txt");
            ps = new PrintStream(fos, true);
            if(ps != null){
                System.setOut(ps); // 将标准输出流（控制台输出）改成文件
            }
            for (int i = 0; i <=255 ; i++) { // 输出ASCII
                System.out.print((char) i); // 这时不会在控制台输出了，而是在写入到文件里了
                if(i % 50 == 0){ // 每50个数据一行
                    System.out.println(); // 换行
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ps != null){
                ps.close();
            }
        }
    }

    /*
    数据流
    DataInputStream 和 DataOutputStream
    作用：用于读取或写出基本数据类型的变量或字符串

    练习：将内存中的字符串、基本数据类型的变量写出到文件中
    注意：处理异常的话，仍然应该使用try-catch-finally.这里只是懒得写，才抛的
     */
    @Test
    public void test3() throws IOException {
        // 数据输出流 （文件输出流）
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));
        // 写
        dos.writeUTF("哈哈哈");
        dos.flush(); // 显式将缓冲区中的内容写进文件中
        dos.writeInt(23);
        dos.write(10);
        dos.writeBoolean(false);
        dos.flush();

        dos.close();
    }

    /*
        将文件中存储的基本数据类型变量和字符串读取到内存中，保存在变量中
        注意点：读取不同类型的数据的顺序要与当初写入文件时，保存的数据的顺序一致
     */
    @Test
    public void test4() throws IOException {
        // 输出输入流（文件输入流）
        DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));
        // 读（得按写的顺序读）
        String s = dis.readUTF();
        int i = dis.readInt();
        int read = dis.read();
        boolean b = dis.readBoolean();
        System.out.println(s + ", " + i + ", " + read + ", " + b);

        dis.close();
    }
}
