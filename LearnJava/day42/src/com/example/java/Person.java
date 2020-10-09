package com.example.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Yi-27
 * @create 2020-10-06 15:33
 */
public class Person {

    private String name;
    public int age;

//    private Person(String name){
//        this.name = name;
//    }
    public Person(String name){
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
        System.out.println("执行空参构造器");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static List<Person> getPersons(){
        List<Person> list = new ArrayList<>();
        list.add(new Person("Tom", 33));
        list.add(new Person("Jack", 21));
        list.add(new Person("Rose", 17));
        list.add(new Person("Kei", 27));
        list.add(new Person("Marin", 18));
        return list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
