#  Day1		2020/6/5

+ Java仍然会存在内存泄漏和溢出的问题。

+ 文档注释，注释内容可以被JDK提供的工具javadoc所解析，被生成一套网页文件行形式对于该程序的说明文档。

    

## 八种基本数据类型

+ 数值型
    + 整数型（byte,short,int,long）1/2/4/8字节
        + 声明Long型变量，必须以"l"或"L"结尾
    + 浮点类型（float,double）
        + float，单精度，最多7位有效数字。
            + 声明时，必须以'f'或'F'结尾
            + 4字节，-3.403E38~3.403E38
            + 表示的范围比long还要大
        + double，双精度，8字节
            + 定义浮点型变量时，通常使用double。
+ 字符型（char）
    + 一字符，2字节
    + 声明时使用单引号，'a'
    + 转义字符算一个字符
    + 直接使用Unicode值来表示字符型常量，‘\u0043'，C
+ 布尔型（boolean）
+ 四种引用数据类型
    + 类（class）
    + 接口（interface）
    + 数据（[]）



# Day2		2020/6/6

七种基本数据类型变量间的运算，不包含boolean类型

## 自动类型提升

+ 范围小的和范围大做运算时，结果自动提升为容量大的数据类型。

+ ```java
    byte b1 = 2;
    int i1 = 129;
    
    byte b2 = b1 + i1; // 编译不通过
    int i2 = b1 + i1; 
    long l1 = b1 + i1;
    float f = b1 + i1; // 这些都可以编译通过
    
    short s1 = 213;
    double d2 = s1; // 直接这样赋值也行
    ```

+ ```java
    char c1 = 'a';
    int i3 = 10;
    int i4 = c1 + i3; // 编译通过
    
    short s2 = 10;
    char c2 = c1 + s2; // 编译不通过，至少也得是int型
    
    byte b2 = 10;
    char c3 = c1 + b2; // 编译也不行
    
    char c = ''; // 编译不通过
    
    short s3 = b2 + s2; // 也不行
    ```

+ 特别的，**当byte、short、char做运算时，结果为int型**

    + 甚至是byte + byte，short + short也一样
    + 只是因为很容易运算的时候就超过范围了

## 强制类型转换

+ 自动提升运算的逆运算

+ ```java
    double d1 = 12.6;
    int i1 = (int)d1; // 12 截断操作，可能会损失精度
    
    long l1 = 123;
    short s2 = (short)l1;
    
    int i2 = 128;
    byte b1 = (byte)i2; // -128 精度损失了 变为负的是二进制的问题
    ```

+ 数值类型编码情况

    + ```java
        long l = 123213; // 不加 l或L 也能编译过 这里会被当成int
        // 但是如果数特别大还是会编译失败
        ```

    + 对于整形常量，默认类型为int型

    + 浮点型常量，默认类型为double型

+ 字符串类型String

    + 引用数据类型
    + 可以和8种基本数据类型变量做运算，只能是连接运算 +
    + 运算结果仍是String类型
    + String 强转成其他基本类型是不能直接像 (int) 这样的，需要用到特定的方法，比如Integer.parseInt("123")

+ 练习

    + ```java
        char c = 'a'; // a97 A65
        int num = 10;
        String str = "hello";
        c + num + str; // 107hello
        c + str + num; // ahello10
        c + (num + str); // a10hello
        ```


## 进制

+ 二进制，**0b**或**0B**开头
    + 正数，原码、补码、反码都一样
    + 负数，原码除符号位外各个位取反得到反码，反码+1为补码
    + 计算机的底层都以补码的方式来存储数据
+ 八进制，**0**开头
+ 十六进制，**0x**或**0X**开头
+ 打印出来都是十进制表示
+ 十进制转二进制
    + 除 2 取 余的逆



# Day3		2020/6/7

+ %，取余运算，结果的符号与被模数的符号相同

+ 自增自减1，都不会改变本身变量的数据类型。比如，short型的变量++后仍是short型，byte型变量也是改变本身的数据类型

    + +=，这样的赋值运算符也不会改变本身

+ 支持连续赋值，a=b=10;，但不能int a=b=10;

+ 比较运算符，instanceof，检查是否是类的对象，比如"hello" instanceof String，返回true 


## 逻辑运算符

+ &，逻辑与，符号左右都会执行
+ &&，短路与，符号右边不执行了
+ |，逻辑或
+ ||，短路或
+ !，逻辑非
+ ^，逻辑异或

+ 位运算符

    + 优先级与字符串的连接符+相同

    + `<<`，左移，在一定范围内，每向左移一位，相当于 * 2

    + `>>`，右移，原最高位为1就补1，其他空缺位补0

    + `>>>`，无符号右移

    + &，与运算

    + |，或运算

    + ^，异或运算

        + ```java
            int a = 10,b=5;
            // 交换两个值
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
            // a = 5 b = 10
            ```

        + 

    + ~，取反运算，~6=-7

+ 运算符的优先级

    + 只有单目运算符、三元运算符和赋值运算符是从右向左运算的。


## 从键盘获取输入值

+ ```java
    import java.util.Scanner;
    Scanner scan = new Scanner(System.in);
    int num = scan.nextInt(); // 从控制台获取输入的int数值
    ```

+ Scanner没有提供相关的方法来获取char型数据，只能获取一个字符串

+ 字符串的charAt(index)方法获取指定位置上的字符

+ 有多种next()方法来获取输入

## 随机数

+ Math.random(); // [0.0, 1.0)
+ 公式：(int)(Math.random() * (b - a + 1) + a); [a,b)

+ switch结构中的表达式，只能是byte、short、char、int、枚举类型、String类型

    + default的位置是灵活的，上中下都行
    + 能用if-else又能用switch-case的情况下，优先选switch-case，因为其执行效率稍高

+ system.currentTimeMillis(); // 获取19700101000000距离到现在的毫=秒数，long型


## 嵌套循环，带标签的break和continue

+ ```java
    for(int i=1; i<=4; i++){
        for(int j=1l i<=10; j++)
            if(j%4 == 0){
                break; // 默认结束最近的一层循环
                continue; // 默认跳出最近的一层循环
            }
    }
    ```

+ ```java
    label:for(int i=1; i<=4; i++){
        for(int j=1l i<=10; j++)
            if(j%4 == 0){
                break label; // 结束指定标签的循环
                continue label; // 跳出指定标签的当次循环
            }
    }
    ```

    
    

# Day4		2020/6/8

## **数组**，属于引用数据类型的变量

+ 长度确定后就不能修改

+ 数组的声明和初始化

    + ```java
        int[] ids; // 声明
        // 静态初始化  数组的初始化和数组元素的赋值操作同时进行
        ids = new int[]{101,102,103,104};
        // 动态初始化  分开进行
        ids = new int[4];
        
        int[] arr = {1,2,3}; // 可以直接  类型推断
        // 但是不能ids = {1,2,3};
        ```

+ 数组元素的默认初始化值

    + 整形为 0
    + 浮点型为 0.0
    + char型为 0或‘\u0000’，而非'0'
    + boolean型为 false
    + String型为 null，不是"null"，引用类型都是null

+ 数组在内存中的解析（一维数组）

    + ```java
        int[] arr = new int[]{1,2,3};
        String[] arr1 = new String[4];
        arr1[1] = "刘德华";
        arr1[2] = "张学友";
        arr1 = new String[3];
        ```

    + 首先**栈空间**内，创建arr

    + 再在**堆空间**内，创建3个连续的int型空间作为arr数组的内存空间，并把首地址值（十六进制）给栈空间的arr

    + 通过栈空间的arr的值就能找到堆空间其对应的值了

    + 再把1,2,3赋值到每个内存空间中

    + String型数组一样，先在栈空间，创建arr1

    + 再在堆空间开辟一个4个空间，并把首地址值赋给arr1

    + 再根据arr1首地址赋值到具体的空间内

    + **再new了就又在堆空间内开辟新的空间**，把新的首地址赋值给arr1

    + 根据引用计数算法，判断堆空间的值是否还有栈空间的引用，没有的话，会在之后的某个不确定的时间，通过垃圾回收机制把空间给释放掉

    + ![image-20200608162538368](C:\Users\Jarvis\AppData\Roaming\Typora\typora-user-images\image-20200608162538368.png)

    + **注：**这里String类型其实并不是放在堆空间内的，而是放在**字符串常量池**内的。

## 多维数组

+ 从数组底层的运行机制来看，其实没有多维数组

+ 二维数组的声明和初始化

    + ```java
        // 静态初始化
        int[][] arr1 = new int[][]{{1,2,3},{4,5},{6,7,8}}; // int[] arr[] 或 int arr[][] 都可以
        // 动态初始化
        String[][] arr2 = new String[3][2];
        String[][] arr3 = new String[3][];
        
        arr1; // 地址 [[I@6d06d69c  [[表示两维数组 I表示int型
        arr1[0]; // 地址 [I@15db9742
        arr1[0][0]; // 0 
        
        arr2[0]; // 地址 [Ljava.lang.String;@7852e922
        arr2[0][0]; // null
        
        arr3[0]; // null
        arr3[0][0]; // 空指针异常
        
        
        // 可以直接 int[][] arr = {{1,2,3},{4,5},{6,7,8}};
        
        arr1.length; // 3
        arr1[1].length; // 2
        
        ```

    + ![image-20200608163935139](C:\Users\Jarvis\AppData\Roaming\Typora\typora-user-images\image-20200608163935139.png)

        + 二维数组的内存解析
            + ![image-20200608172054918](C:\Users\Jarvis\AppData\Roaming\Typora\typora-user-images\image-20200608172054918.png)
    
+ 数组中，arr2 = arr1; 只是把arr1的地址赋值给arr2，动arr2的值，就是动arr1的值。

    + 有一定前提，arr2和arr1的类型要匹配，匹配后，两个都指向堆空间的唯一的一个数组实体
    + 比如，arr2是二维数组的地址，arr1是一维数组的地址，就不能这样赋值了
    + **arr2 = arr1;不能称作数组的复制**

## **内存的简化结构**

+ 内存规划在JVM中
+ 栈，stack
    + 局部变量，放在方法中的变量都是局部变量
+ 堆，heap
    + new 出来的结构，对象，数组
+ 方法区
    + 常量池
    + 静态域
    + 类加载的一些信息

## **数据结构与算法**

+ 数据与数据之间的逻辑关系：集合、一对一、一对多、多对多
+ 数据的存储结构
    + 线性表（一对一）：顺序表（比如，数组）、链表、栈（先进后出）、队列（先进先出）
    + 树形结构（一对多）：二叉树
    + 图形结构（多对多）：无向图、有向图 

+ 基础算法：
  
    + 排序算法
    + 搜索算法
    
+ 数组中涉及的常见算法

    + 赋值型
        + 创建一个长度为6的int型数组，要求数组的值都在1-30内，且是随机赋值。同时要求各元素的值各不相同
        + 回形数
    + 数值型
        + 求最大值、最小值、平均值、总和
    + 复制
        + new 新的堆空间后，再for循环复制进去
    + 反转
        + 中间变量，首尾交换
        + new新数组后倒着复制进去，然后旧数组指向新数组



# Day5		2020/6/9

## 数组查找算法

+ 线性查找，就是循环一个一个的找

+ 二分查找

    + 比较快

    + 前提要先有序

    + ```java
        int[] arr = new int[]{1,2,3,4,5,6};
        int dest = 2;
        int head = 0; // 初始的首索引
        int end = arr.length - 1; // 初始的末索引
        boolean isFlag = true;
        
        while(head <= end){
            int middle = (head + end) / 2;
            if(dest == arr[middle]){
                System.out.println("找到了指定的元素，位置为：" + middle);
                isFlag = false; // 说明找到了
                break;
            }else if(arr[middle] > dest){
                end = middle -1;
            }else{
                head = middle + 1;
            }
        }
        
        if (ifFlag == false){
            System.out.println("未找到！")
        }
        
        ```

## 排序算法

+ 选择排序

    + 直接选择排序
    + 堆排序

+ 交换排序

    + 冒泡排序

        + ```java
            
            ```

        + 

    + 快速排序

+ 插入排序

    + 直接插入排序
    + 折半插入排序
    + Shell排序

+ 归并排序

+ 桶式排序

+ 基数排序

    

## 算法的五大特征

+ 输入
+ 输出
+ 有穷性
+ 确定性
+ 可行性

