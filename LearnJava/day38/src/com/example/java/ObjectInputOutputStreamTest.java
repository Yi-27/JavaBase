package com.example.java;

import org.junit.Test;

import java.io.*;

/**
 * 对象流的使用
 * 1.ObjectInputStream 和 ObjectOutputStream
 *
 * @author Yi-27
 * @create 2020-10-05 15:51
 */
public class ObjectInputOutputStreamTest {

    /*
    序列化过程：将内存中的java对象保存到磁盘中或通过网络传输出去
    使用ObjectOutputStream实现
     */
    @Test
    public void testObjectOutputStream(){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
            oos.writeObject(new String("这是序列字符串！"));
            oos.flush(); // 刷新操作

            oos.writeObject(new Person("哈哈哈", 23));
//            oos.flush(); // 不手动掉他们也会自动调

            oos.writeObject(new Person("嘿嘿嘿", 24, new Account(20.4)));
            oos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    反序列化的过程：将磁盘文件中的对象或者网络中传输来的对象还原为内存中的一个java对象
    使用ObjectInputStream
     */
    @Test
    public void testObjectInputStream(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));
            Object obj = ois.readObject();
            String str = (String) obj;
            System.out.println(str); // 这是序列字符串！

            Person p = (Person) ois.readObject();
            System.out.println(p); // Person{name='哈哈哈', age=23}

            Person p2 = (Person) ois.readObject();
            System.out.println(p2); // Person{name='嘿嘿嘿', age=24, acc=Account{balance=20.4}}

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}

/*
要想Person类支持序列化机制，
    1. 需要实现Serializable接口（这是个标识接口）
    2. 当前类提供一个全局常量：serualVersionUID
    3. 除了当前Person类需要实现Serializable接口之外，还必须保证其内部所有属性也必须是可序列号的
        （默认情况下，基本数据类型可序列化）

    ObjectOutputStream和ObjectInputStream不能序列化**static**和**transient**修饰的**成员变量**
 */
class Person implements Serializable{

    public static final long serialVersionUID = 475463534532L; // 序列版本号

    private static String name;
    private transient int age;
    private Account acc;

    public Person(String name, int age, Account acc) {
        this.name = name;
        this.age = age;
        this.acc = acc;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", acc=" + acc +
                '}';
    }

    public void setAge(int age) {
        this.age = age;
    }
}
class Account implements Serializable{

    public static final long serialVersionUID = 47546353532L; // 序列版本号
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public Account() {
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}