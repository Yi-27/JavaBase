package com.example.java;

import org.junit.Test;

import java.util.Optional;

/**
 * Optional类的使用
 *
 *
 * @author Yi-27
 * @create 2020-10-09 13:28
 */
public class OptionalTest {

    @Test
    public void test(){

        // Optional.of(T t)：创建一个Optional实例，t必须非空
        Girl girl = new Girl();
        Optional<Girl> girl1 = Optional.of(girl); // 这样没问题
        girl = null;
        Optional<Girl> girl2 = Optional.of(girl); // 这样就抛异常，空指针异常

        // Optional.empty()：创建一个空的Optional实例


        // Optional.ofNullable(T t)：t 可以为null

    }

    @Test
    public void test2(){

        Girl girl = new Girl();
        // Optional.ofNullable(T t)：t 可以为null
        Optional<Girl> girl1 = Optional.ofNullable(girl);
        System.out.println(girl1); // Optional[Girl{name='null'}]
        girl = null;
        Optional<Girl> girl2 = Optional.ofNullable(girl);
        System.out.println(girl2); // Optional.empty

        // t.orElse(T t1)：如果当前的Optional内部封装的t是非空的则返回内部的t
        // 如果内部的t是空的，则返回orElse()中的参数t1
        Girl girl3 = girl2.orElse(new Girl("哈哈哈")); // 如果调用OrElse的Optional为null就返回参数中的对象
        System.out.println(girl3); // Girl{name='哈哈哈'}
    }

    public String getGirlName(Boy boy){
        return boy.getGirl().getName(); // 可能存在两处空指针异常，boy是空，getGirl()是空
    }

    @Test
    public void test3(){
        Boy boy = new Boy();
        String girlName = getGirlName(boy);
        System.out.println(girlName); // 空指针异常，因为没有赋予girl对象
    }

    // 优化，避免空指针
    public String getGirlName2(Boy boy){
        if(boy != null){
            Girl girl = boy.getGirl();
            if(girl != null){
                return girl.getName();
            }
        }

        return null;
    }

    @Test
    public void test4(){
        Boy boy = new Boy();
        String girlName = getGirlName2(boy);
        System.out.println(girlName); // 空指针异常，因为没有赋予girl对象
    }

    // 使用Optional类来优化，避免空指针
    public String getGirlName3(Boy boy){
        Optional<Boy> boyOptional = Optional.ofNullable(boy);
        // 此时的boy1一定非空
        Boy boy1 = boyOptional.orElse(new Boy(new Girl("呀呀呀")));

        Girl girl = boy1.getGirl();
        // 这里再封装是防止，boy不是非空，但boy内的girl是空的情况
        Optional<Girl> girlOptional = Optional.ofNullable(girl);
        // 此时girl1一定非空
        Girl girl1 = girlOptional.orElse(new Girl("嘿嘿嘿"));
        return girl1.getName();
    }

    @Test
    public void test5(){
        Boy boy = new Boy();
//        boy = null;
        String girlName = getGirlName3(boy);
        System.out.println(girlName); // 空指针异常，因为没有赋予girl对象
    }
}

class Boy{

    private Girl girl;

    @Override
    public String toString() {
        return "Boy{" +
                "girl=" + girl +
                '}';
    }

    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }

    public Boy() {
    }

    public Boy(Girl girl) {
        this.girl = girl;
    }
}


class Girl{
    private String name;

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Girl() {
    }

    public Girl(String name) {
        this.name = name;
    }
}