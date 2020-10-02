package com.example.java;

import org.junit.Test;

import java.util.Comparator;
import java.util.Objects;
import java.util.TreeMap;

/**
 * @author Yi-27
 * @create 2020-10-02 19:34
 */
public class TreeMapTest {

    @Test
    public void test(){
        /*
            向TreeMap中添加key-value，要求key必须是由同一个类创建的对象
            因为要按照key进行排序：自然排序 和 定制排序
         */
        TreeMap map = new TreeMap();

        map.put(new User("Tom", 23), 98);
        map.put(new User("Jerry", 32), 77);
        map.put(new User("Jack", 20), 88);
        map.put(new User("Rose", 19), 90);

        System.out.println(map); // 自然排序
    }

    @Test
    public void test2(){
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User && o2 instanceof User){
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    // 这里我们不考虑年龄一样的问题，先来先到
                    return Integer.compare(u1.getAge(), u2.getAge());
                }else{
                    throw new RuntimeException("输入的类型不匹配");
                }
            }
        });

        map.put(new User("Tom", 23), 98);
        map.put(new User("Jerry", 32), 77);
        map.put(new User("Jack", 20), 88);
        map.put(new User("Rose", 19), 90);

        System.out.println(map); // 定制排序

    }
}

class User implements Comparable{
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("调用了equals");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age); // 不同于Object类的hashCode，Object类的随机算的
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof User){
            User user = (User) o;
//            return this.name.compareTo(user.name); // 按姓名从小到大排列
            int compare = this.name.compareTo(user.name);
            if(compare != 0){
                return compare;
            }else{
                return Integer.compare(this.age, user.age);
            }
        }else{
            throw new RuntimeException("输入的类型不匹配");
        }
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
}