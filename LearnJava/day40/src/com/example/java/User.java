package com.example.java;

/**
 * @author Yi-27
 * @create 2020-10-07 16:41
 */
@MyAnnotation(value = "hi")
public class User extends Creature<String> implements Comparable<String>, MyInterface {

    private String name;
    int age;
    public int id;

    public User() {
    }

    @MyAnnotation(value = "abc")
    private User(String name) {
        this.name = name;
    }

    User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @MyAnnotation
    private String show(String nation){
        System.out.println("国籍是：" + nation);
        return nation;
    }

    public String display(String interests, int age) throws NullPointerException, ClassCastException{
        return interests + age;
    }


    @Override
    public void info() {
        System.out.println("这是info");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    private static void showDesc(){
        System.out.println("这是一个私有的静态方法！");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
