package com.example.java;

import java.util.Arrays;

/**
 * 枚举类的使用
 *  1. 类的对象只有有限个，称此类为枚举类
 *  2. 当需要定义一组常量时，强烈建议使用枚举类
 *  3. 如果枚举类中只有一个对象，则可以作为单例模式的方式实现 
 *
 * @author Yi-27
 * @create 2020-09-28 9:30
 */
public class EnumTest {

    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);

        Season2 summer = Season2.SUMMER;
        // Enum类的toString()
        System.out.println(summer); // SUMMER 没有自己重写时，打印枚举的对象的变量名
        System.out.println(Season2.class.getSuperclass()); // java.lang.Enum
        // Enum类的values()
        Season2[] values = Season2.values();
        System.out.println(Arrays.toString(values));
        // Enum类的valueOf(String objName)：返回枚举类中对象名是objName的对象
        Season2 winter = Season2.valueOf("WINTER"); // 如果没有objName的枚举类对象，则抛异常：IllegalArgumentException
        System.out.println(winter);
        winter.show();
    }

}

// 自定义枚举类
class Season{

    // 1. 声明Season对象的属性:private final修饰
    private final String seasonName;
    private final String seasonDesc;

    // 2. 私有化类的构造器，并给对象属性赋值
    private Season(String seasonName, String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    // 3.提供当前枚举类的多个对象
    public static final Season SPRING = new Season("春天", "春暖花开");
    public static final Season SUMMER = new Season("夏天", "夏日炎炎");
    public static final Season AUTUMN = new Season("秋天", "秋高气爽");
    public static final Season WINTER = new Season("冬天", "冰天雪地");

    // 4.获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}


// 使用enum关键字定义关键字
// 枚举类默认继承与java.lang.Enum类，并且该类重写过toString()方法了，当然还可以再重写
enum Season2 implements Info{
    // public static final Season2    = new Season2 可省
    // 1. 提供当前枚举类的对象，多个对象之间用“,”隔开，末尾对象“;”结束
    SPRING("春天", "春暖花开"){
        @Override
        public void show() {
            System.out.println("春天在哪里？");
        }
    }, // 有属性才要加括号写上属性值
    SUMMER("夏天", "夏日炎炎") {
        @Override
        public void show() {
            System.out.println("夏天啊");
        }
    },
    AUTUMN("秋天", "秋高气爽") {
        @Override
        public void show() {
            System.out.println("秋天好啊");
        }
    },
    WINTER("冬天", "冰天雪地") {
        @Override
        public void show() {
            System.out.println("这是冬天啊");
        }
    };

    // 2. 声明Season2对象的属性:private final修饰
    private final String seasonName;
    private final String seasonDesc;

    // 3. 私有化类的构造器，并给对象属性赋值
    Season2(String seasonName, String seasonDesc){ // 默认是private的
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    // 4.获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

//    @Override
//    public void show() {
//        System.out.println("这是一个季节！");
//    }
}

interface Info{
    void show();
}