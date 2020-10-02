package com.example.java;

import org.junit.Test;

import java.util.*;

/**
 * Set接口的框架结构
 *
 * 父接口 Collection
 * 实现类
 *      HashSet：作为Set接口的主要实现类
 *          线程不安全
 *          可以存储null值
 *      LinkedHashSet：作为HashSet的子类，遍历其内部数据时，可以按照添加的顺序遍历
 *      TreeSet：可以按照添加对象的指定属性，进行排序
 *
 * @author Yi-27
 * @create 2020-09-30 9:49
 */
public class SetTest {

    /*
        Set：存储无序的、不可重复的数据
        以HashSet为例说明
            1. 无序性：
                不等于随机性
                存储的数据在底层数组中并非按照数组索引的顺序添加，而是根据数据的哈希值来决定的
            2. 不可重复性
                保证添加的元素按照equals()判断时，不能返回true,即相同元素只能添加一个

            添加元素的过程
                向HashSet中添加元素a，首先调用元素a所在类的hashCode()方法，计算元素a的哈希值
                此哈希值接着通过某种算法计算出在HashSet底层数组中的存放位置（即为索引位置）
                判断数组此位置上是否已经有元素
                    没有其他元素b，则元素a添加成功    ---> 情况1
                    有其他元素b（或以链表形式存在的多个元素），则比较元素a与元素b的hash值
                        如果hash值不相同，则元素a添加成功    ---> 情况2
                        如果hash值相同，进而需要调用元素a所在类的equals()方法
                            equals()返回true，元素a添加失败
                            equals()返回false，元素a添加成功    ---> 情况3

            对于添加成功的情况2和情况3而言：元素与已经存在指定索引位置上数据以链表的方式存储
                jdk 7 ：元素a放到数组中，指向原来的元素
                jdk 8 ：原来的元素在数组汇总，指向元素a
     */
    @Test
    public void test(){
        /*
            HashSet()的使用
         */
        Set set = new HashSet(); // 底层也先是用数组存的
        set.add(456);
        set.add(123.678);
        set.add("AA");
        set.add('c');
        set.add(new Date());
        set.add(new User("Tom",12)); // 未重写equals 两个都被添加进去了
        set.add(new User("Tom",12)); // 重写后，仍旧都被添加进去了

        // [AA, c, User{name='Tom', age=12}, User{name='Tom', age=12}, 456, Wed Sep 30 10:25:01 GMT+08:00 2020, 123.678]
        // [AA, Wed Sep 30 10:34:40 GMT+08:00 2020, c, User{name='Tom', age=12}, User{name='Tom', age=12}, 456, 123.678]
        // 光重写equals()不够，还需要重写hashCode()，才能保证不可重复性
        // [AA, c, Wed Sep 30 10:36:45 GMT+08:00 2020, 456, User{name='Tom', age=12}, 123.678]
        System.out.println(set); // 可以看到与添加的顺序不一样，这就是无序性
    }

    @Test
    public void test2(){
        /*
            LinkedHashSet的使用
            LinkedHashSet作为HashSet的子类，在添加数据的同时，每个数据还维护两个引用
            记录此数据前一个数据和后一个数据
            优点：对于频繁的遍历操作，LinkedHashSet效率高于HashSet
         */
        LinkedHashSet set = new LinkedHashSet(); // 添加的时候还是无序的
        set.add(456);
        set.add(123.678);
        set.add("AA");
        set.add('c');
        set.add(new Date());
        set.add(new User("Tom",12));
        set.add(new User("Tom",12));

        System.out.println(set);
    }


    @Test
    public void test3(){
        /*
            向TreeSet中添加的数据，要求是相同类
            两种排序方式：自然排序（实现compareTo()接口） 和 定制排序（Comparator）

            自然排序中，比较两个对象是否相同的标准为：compareTo()返回0，不再是equals()
            定制排序中，比较两个对象是否相同的标准为：compare()返回0，不再是equals()

            TreeSet和TreeMap采用**红黑树**的存储结构
            特点：有序，查询速度比List快
         */
        TreeSet set = new TreeSet();

        // 失败 不能添加不同类的对象
//        set.add(123);
//        set.add(456);
//        set.add("aA");
//        set.add(new Date());

        // Integer型
//        set.add(34);
//        set.add(-34);
//        set.add(43);
//        set.add(11);
//        System.out.println(set); // [-34, 11, 34, 43]

        set.add(new User("Tom", 12));
        set.add(new User("Jerry", 15));
        set.add(new User("Jim", 10));
        set.add(new User("Mike", 19)); // 由于compareTo()方法只比较了name，因此重复姓名的不会被添加进去
        set.add(new User("Mike", 20)); // 因此需要写明二级比较
        // java.lang.ClassCastException: com.example.java.User cannot be cast to java.lang.Comparable
        // 需要实现Comparable接口
        System.out.println(set);
        // 重写后，重写时按姓名从小到大比较，重复姓名就从小到大比较年龄
        // [User{name='Jerry', age=15}, User{name='Jim', age=10}, User{name='Mike', age=19}, User{name='Tom', age=12}]
        // [User{name='Jerry', age=15}, User{name='Jim', age=10}, User{name='Mike', age=19}, User{name='Mike', age=20}, User{name='Tom', age=12}]
    }

    @Test
    public void test4(){
        Comparator com = new Comparator(){

            // 按照年龄从大到小排列
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
        };

        TreeSet set = new TreeSet(com); // 不加参数按自然排序来，加参数按参数的定制排序来
        set.add(new User("Tom", 12));
        set.add(new User("Jerry", 15));
        set.add(new User("Jim", 10));
        set.add(new User("Mike", 19));
        set.add(new User("Mike", 20));
        System.out.println(set);
        // [User{name='Jim', age=10}, User{name='Tom', age=12}, User{name='Jerry', age=15}, User{name='Mike', age=19}, User{name='Mike', age=20}]
    }

    @Test
    public void test5(){
        /*
            在List内去除重复数字值，要求尽量简单
         */
        Collection list = Arrays.asList(1234,1,2,50,4,4,5,5,7,789,8,8,921,9,0,0);
        HashSet set = new HashSet(); // 用set来去重
        set.addAll(list); // 这样居然是按顺序存的
        System.out.println(set);  // [0, 1, 1234, 2, 50, 4, 5, 789, 7, 8, 921, 9]
        System.out.println(new ArrayList(set)); // 再转回List
    }

    @Test
    public void test6(){
        /*

         */
        HashSet set = new HashSet();
        User u1 = new User("AA", 101);
        User u2 = new User("BB", 101);

        set.add(u1);
        set.add(u2);
        System.out.println(set); // [User{name='AA', age=101}, User{name='BB', age=101}]

        u1.setName("CC");
        set.remove(u1); // 由于改了对象的值，对应的哈希值就有极大的可能性改变，那么在数组中的位置就可能找到的不是改之前的位置，因此就删不掉，还有可能删掉其他的了
        System.out.println(set); // [User{name='CC', age=101}, User{name='BB', age=101}]

        set.add(new User("CC", 101)); // 新加的这个与改动的那个具体哈希值不同
        // [User{name='CC', age=101}, User{name='BB', age=101}, User{name='CC', age=101}]
        System.out.println(set);


        set.add(new User("AA", 101));
        // [User{name='CC', age=101}, User{name='BB', age=101}, User{name='CC', age=101}, User{name='AA', age=101}]
        // 这里是由于先比较哈希值，结果哈希值与第一个改成CC的User相同
        // 接着再通过equals()比较二者具体的值，发现不同，就添加进去了

        System.out.println(set);
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
//            return this.name.compareTo(user.name); // 按姓名排列
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