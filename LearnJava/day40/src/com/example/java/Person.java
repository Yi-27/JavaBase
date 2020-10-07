package com.example.java;

/**
 * @author Yi-27
 * @create 2020-10-06 15:33
 */
public class Person {

    private String name;
    public int age;

    private Person(String name){
        this.name = name;
    }

    private String showNation(String nation){
        System.out.println("我的国籍是：" + nation);
        return nation;
    }

    public void show(){
        System.out.println("你好。这是一个人");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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

    public void setAge(int age) {
        this.age = age;
    }

    public Person() {
//        System.out.println("为啥没执行");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
