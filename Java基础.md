

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
            // 冒泡排序
            int[] a = new int[]{1,9,5,7,6,3,4,8,0,5,2,0,2};

          for(int i=0; i<a.length-1; i++) {
              for(int j=0; j<a.length-1-i; j++) {
                  if(a[j] > a[j+1]) {
                      // 交换值
                      int temp = a[j];
                      a[j] = a[j+1];
                      a[j+1] = temp;
                  }
              }
              List<Integer> iList = Arrays.stream(a)
                  .boxed()
                  .collect(Collectors.toList());
              System.out.println(iList);
          }
          List<Integer> iList = Arrays.stream(a)
              .boxed()
              .collect(Collectors.toList());
          System.out.println(iList);
          ```
          
        + ```
            [1, 5, 7, 6, 3, 4, 8, 0, 5, 2, 0, 2, 9]
            [1, 5, 6, 3, 4, 7, 0, 5, 2, 0, 2, 8, 9]
            [1, 5, 3, 4, 6, 0, 5, 2, 0, 2, 7, 8, 9]
            [1, 3, 4, 5, 0, 5, 2, 0, 2, 6, 7, 8, 9]
            [1, 3, 4, 0, 5, 2, 0, 2, 5, 6, 7, 8, 9]
            [1, 3, 0, 4, 2, 0, 2, 5, 5, 6, 7, 8, 9]
            [1, 0, 3, 2, 0, 2, 4, 5, 5, 6, 7, 8, 9]
            [0, 1, 2, 0, 2, 3, 4, 5, 5, 6, 7, 8, 9]
            [0, 1, 0, 2, 2, 3, 4, 5, 5, 6, 7, 8, 9]
            [0, 0, 1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 9]
            [0, 0, 1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 9]
            [0, 0, 1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 9]
            [0, 0, 1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 9]
            ```

        + 

    + 快速排序

        + 

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



## Arrays工具类

+ java.util.Arrays类
    + boolean equals(int[] a, int[] b)，判断两个数组是否相等
    + void fill(int[] a, int val)，将指定值填充到数组之中
    + void sort(int[] a)，对数组进行排序
    + int binarySearch(int[] a, int key)，对排序后的数组进行二分法检索指定的值



## 数组中的常见异常

+ 数组角标越界异常（就是不在数组length内）

    + **ArrayIndexOutOfBoundsExcetion**

+ 空指针异常

    + **NullPointerException**

    + 情况一

        + ```java
            int[] arr1 = new int[]{123};
            arr1 = null;
            arr1[0]; // 空指针异常
            ```

    + 情况二

        + ```java
            int[][] arr2 = new int[4][];
            arr2[0]; // null
            arr2[0][0]; // 空指针异常
            ```

    + 情况三

        + ```java
            String[] arr3 = new String[]{"AA", "BB", "CC"};
            arr3[0] = null;
            arr3[0]; // null
            arr3[0].toString(); // 空指针异常
            ```

        + 



# Day6		2020/6/10

## 面向对象

+ Java类及类的成员
    + 属性
    + 方法
    + 构造器
    + 代码块
    + 内部类
+ 面向对象三个特征
    + 封装性
    + 继承性
    + 多态性
+ 其它关键字
    + this
    + super
    + static
    + final
    + abstract
    + interface
    + package
    + import



## 对象的创建和使用：内存解析

![image-20200610172916326](C:\Users\Jarvis\AppData\Roaming\Typora\typora-user-images\image-20200610172916326.png)

**运行时数据区**

+ 方法区
    + 存储已被虚拟机加载的**类信息**、**常量**、**静态变量**、**即时编译器编译后的代码**等数据
+ 堆
    + 存放对象实例以及数组
+ 虚拟机栈（通常意义上指的栈）
    + 主要用于**存储局部变量**等，方法中的变量都是局部变量
        + **但类属性是存放在堆空间中的**
    + 基本数据类型
    + 对象引用（reference类型，是对象在堆内存放的首地址）
    + 方法执行完，自动释放
+ 本地方法栈
    + 通过Java调用本地C或C++的接口
+ 程序计数器

![image-20200610174706375](C:\Users\Jarvis\AppData\Roaming\Typora\typora-user-images\image-20200610174706375.png)



引用类型的变量，只能存储两类值

+ null
+ 地址值（含变量的类型）



## 类中成员变量和局部变量的异同点

**相同点：**

+ 定义的方式
+ 先声明，后使用
+ 都有其对应的作用域

**不同点：**

+ 在类中声明的位置不同
+ 权限修饰符不同
    + 声明属性时，指明权限
        + 常用的权限
            + private，私有
            + public，公共
            + protected，保护
            + 缺省
+ 默认初始化值
    + 属性：根据其类型，都有默认初始化值
        + 整形，0
        + 浮点型，0.0
        + 字符型，0或'\u0000'
        + 布尔型，false
        + 引用数据类型（类，数组，接口等），null
    + 局部变量：无默认初始化值
        + 一定要显示赋值
        + 形参在调用时才被赋值
    + 在内存中加载的位置不同
        + 属性，加载到堆空间中（非static）
        + 局部变量，加载到栈空间 



## 方法的声明

+ 权限修饰符

    + private
    + public
    + protected
    + 可省

+ 关键字（可省）

+ 返回值类型

    + 有返回值
        + 指定返回值类型
        + 用return关键字返回指定类型的变量或常量
    + 无返回值（void）
        + 通常不用return
        + 但是如果使用的话，只能`return;`，用于提前结束方法

+ 方法名

    + 属于标识符，遵循其规则和规范，见名知意

+ 形参列表

    + 不能默认值

+ 方法体

    + 内部不能再定义方法

    

## 方法的重载

形参的个数和类型不相同即可。

跟方法返回类型无关。



## 匿名对象的使用

直接 new Human();

使用时，直接 new Human().eat(); 

匿名对象只能调用一次

使用的情况

+ ![image-20200610192236702](C:\Users\Jarvis\AppData\Roaming\Typora\typora-user-images\image-20200610192236702.png)



# Day7 2020/6/20

## 方法的重载

+ 可变个数形参（Varargs,variable number of arguments）机制
    + 允许直接定义能和多个实参相匹配的形参
    + 格式：数据类型 ... 变量名，例如String ... strs
    + 其实就是个数组，但是如何有同样数据类型的重载方法，但是调用时只给一个参数时，优先调用单个参数的重载方法，而不是调用可变个数形参的方法
    + 而且，不能再这样重载String[] strs，这个同上面其实本质是一致的
    + 可以test.show("123", "456", "789");这样使用，也可以test.show({"123", "456", "789"});这样传一个数组
    + 在方法中，必须声明在末尾，同时只能声明一个



## 变量的赋值

基本类型变量赋值，就是栈空间中直接赋值。

+ 而当变量赋值给另一个变量时，就是重新赋值，比如int a = 10; int b = a;



引用类型变量赋值，就是栈空间中保存堆空间数据的地址值

+ 而当变量赋值给另一个变量时，只是两个栈空间的变量引用同一个堆空间的地址值而已。
+ 因此，改变其中一个变量具体的值，另一个变量也会相应改变



## 值传递机制

如果参数是基本数据类型，实参赋给形参的就是真实的具体值

而引用数据类型，传的是地址



## 输出数组

+ ```java
    int[] arr = new int[]{1,2,3};
    arr; // 地址值
    
    char[] arr1 = new char[]{'a', 'b', 'c'};
    arr1; // abc
    ```

+ 这是因为调用了System.out.println();中 println的重载方法



## 递归（recursion）方法

结合算法才更好理解。

+ 快排
+ 汉罗塔
+ 斐波那契数列

一个方法体内调用它自身。

方法递归包含了一种隐式循环，必须向已知方向递归，否则容易死循环。



## String的用法

虽然可以直接String str = "hello";但是它是引用数据类型，在栈空间存的还是地址。

但是这里，"hello"存在字符串常量池中，底层就是用char[]来存储的

当方法实参把字符串传给形参时，只是把常量池中的地址赋给形参了而已

当在方法中修改了形参的值，并不会影响到实参的值，而是在常量池中新建了新的值，把新的值的地址赋给形参



## 面向对象特征之：封装和隐藏

私有属性，就不能外部直接修改属性，只能通过set方法或构造方法来设置值

当我们需要给属性加以制约条件时，这个无法在属性声明时体现出来，只能通过方法进行限制条件的添加。同时将属性的权限设为私有

**封装性的体现**：

+ 将类的属性私有化，同时提供公共的方法来获取（getXXX）和设置（setXXX）此属性的值

+ 不对外暴露的私有的方法
+ 单例模式
+ 如果不希望类在包外被调用，可以将类设置为缺省

封装性的体现，需要权限修饰符来配合

+ private
+ 缺省
+ protected
+ public

4种权限都可以修饰类的内部结构：属性、方法、构造器、内部类

修饰类的话只能是public和缺省



封装性：Java提供了4中权限修饰符来修饰类及类的内部结构，体现类及类的的内部结构在被调用时的可见性的大小。



## 构造器

当显式定义了类的构造器后，系统将不再提供默认的无参构造器



## 属性赋值的先后顺序

+ 默认初始化
    + 不同数据类型值不同，比如int型的默认初始化值为0
+ 显式初始化
+ 构造器中赋值
+ 通过 对象.方法 或 对象.属性 的方式赋值



## JavaBean

JavaBean是一种Java语言写成的可重用组件。

**标准**：

+ 类是公共的
+ 有一个无参的公共的构造器
+ 有属性，且有对应的set/get方法



## this关键字

this可以修饰：属性、方法、构造器

类内也可以 this.方法 调用类中的方法

构造器中也可以用this.调用正在创建的类的对象和属性

**可以在重载的构造方法中，通过this()调用无参构造方法，也可以this(参数);调用有参的构造函数**

但只能有一个，构造方法中不能存在两个this();

类中还可以直接把 this 当作实参传递另一个对象的方法



## package关键字

为了更好实现项目中类的管理，提供包的概念

声明在源文件的首行，前面有空行也算首行

包名一般都小写

每 “.” 一次就代表一层文件目录

同一包下，不能命名同名的接口、类。不同包下可以



**JDK中主要的包介绍**：

![image-20200620230952469](C:\Users\Jarvis\AppData\Roaming\Typora\typora-user-images\image-20200620230952469.png)





# Day8 2020/6/21

## MVC设计模型

**视图模型层：**

+ view.utils，相关工具类
+ view.ui，自定义view

**数据模型层：**

+ model.bean/domain，数据对象封装
+ model.dao，数据库操作类
+ model.db，数据库

**控制器层：**

+ controller.activity，应用界面相关
+ controller.fragment，存放fragment
+ controller.adapter，显示列表的适配器

+ controller.service，服务相关的
+ controller.base，抽取的基类



## import关键字

导入指定包下的类、接口

声明在包的声明下面

可以通过XXX.*的方式，导入XXX包下的所有结构

如果使用的类是本包下的，可以省略import

同名包要在使用处写全包名，全类名的方式显示

子包的类也需要导入 

import static导入指定类或接口中的静态**结构**，不是具体的类或结构

+ import static java.lang.System.*;
+ 这样就可以直接 out.println();了
+ 这里的out是个静态变量

```java
String infoString = Arrays.toString(new int[]{1,2,3});
System.out.println(infoString);
// 快速打印数组
```



## 面向对象特征之继承性

好处：

+ 减少了代码的冗余，提高了代码的复用性
+ 便于功能的扩展
+ 为多态性的使用，提供了前提



**私有属性和方法也会被继承，但是不能直接在子类里通过 this.属性 来设置值，只能通过对应的set方法，同样get也是。**

**每个类会隐式继承Object类，**在java.lang包下



# Day9 2020/6/23

## 方法的重写

**override / overwrite**:

+ 重写父类的同名方法，方法名和形参列表要相同
+ 子类重写的方法的权限修饰符不小于父类被重写的方法的权限修饰符
    + 特殊情况：子类不能重写父类中声明为private权限的方法
+ 返回值类型
    + 父类是void，子类也必须是void
    + 子类重写的方法的返回值类型也可以是父类的返回值类型的子类
        + 比如，父类的返回值类型是Object，子类就可以是String，自定义的类等等
        + 但是返回值是基本数据类型，重写的方法的返回值类型也必须是基本数据类型
+ 抛出异常的类型
    + 子类重写的方法抛出的异常类型不大于父类被重写的方法抛出的异常类型



子父类同名方法都声明为static的，这不叫重写。

static方法是不能被重写的



## 关键字super

super可以用来调用：属性、方法、构造器



**在继承中，属性时不会覆盖的**

当子父类有同名属性时，可以通过 super.属性 显示调用父类的属性

同样，super.方法 可以调用父类的方法，在子类中同名也可以这样调用

当直接父类没有想调用的属性或方法时，会往上找间接父类

在子类构造器中可以通过 super(形参列表); 的方式调用父类的构造器，也必须放在首行

**在类的构造器中，this(形参列表); 或 super(形参列表); 只能二选一，不能同时出现**

子类默认会调用 super(空);



## 子类对象实例化的过程

从结果上看：

+ 子类继承父类，会获取父类中声明的属性和方法
+ 创建子类的对象，在堆空间中，就会加载所有父类中声明的属性

从过程上来看：

+ 无论怎么凋构造器，最终都会凋到Object()的构造器才截止
+ 所以在内存中才能看到父类中的结构，子类对象才可以进行调用

虽然创建子类对象时，调用了父类的构造器，但是自始至终只创建了一个对象，即为new 的子对象



## 多态性（Polymorphism）

理解多态性：可以理解为一个**事物的多种形态**

对象的多态性：**父类的引用指向子类的对象**（或子类的对象赋给父类的引用）

多态的使用：

+ 当调用子父类同名参数的方法时，实际执行的是子类重写父类的的方法（虚拟方法调用）

+ 有了对象的多态以后，在编译期，只能调用父类中声明的方法，但是在运行期，实际执行的是子类重写父类的方法
+ **编译，看左边；运行，看右边**

多态性的使用前提：

+ 类的继承关系
+ 方法的重写

比如说equals(Object o);就是应用到了多态

对象的多态性，只适用于方法，不适用于属性（编译和运行都看左边）

**多态性是运行时行为**，编译时是看不出来是不是多态的



+ 方法重载定义的细节
    + 重载是指允许存在多个同名方法，而这些方法的参数不同
    + 同时，重载是可以包括父类和子类的，即子类可以重载父类的同名不同参数的方法

+ 编译和运行的角度
    + 编译器根据方法不同的参数表，对同名方法的名称做修饰。这样对于编译器而言，这些同名方法就成了是不同的方法
    + 它们的调用地址在编译期就绑定了，即在方法调用前，编译器就已经确定了所要调用的方法，这称为“早绑定”或“静态绑定”
    + 对于多态，只有等到方法调用的那一刻，解释运行器才会确定所要调用的具体方法，这称为“晚绑定”或“动态绑定”
    + 因此，重写是多态，重载不是多态



**注：**

+ 在多态的时候，父类引用指向子类的对象时，不能调用子类特有的方法，因为在编译的时候找不到该方法
  

## instanceof关键字

Person p = new Man(); // Man继承了Person类

​	有了对象的多态性后，内存中实际上加载了子类的属性和方法，但是由于变量声明为父类类型，导致在编译时，只能调用用父类中声明的属性和方法。

​	子类特有的属性和方法不能调用。

​	那么如何调用子类特有的属性和方法？

+ Man m = (Man)p; // 强制类型转换，这样编译器就能识别了。即向下转型
    + 注：较高级的基本数据类型（double）转换成较低级的基本数据类型（int）时，要强制类型转换才行，但是反过来则会提升。
+ 子类赋给父类声明的变量，向上转型，多态。反之向下转型

+ **强制类型转换的时候有可能会出现异常**，编译不报错，但是运行时会报错
    + 为了避免这个问题，就要用到 instanceof 关键字



使用：

+ a instanceof A ，判断对象a是否是类型A的实例。是返回true，不是返回false
+ 为了避免在向下转型时出现ClassCastException的异常，在向下转型之前，先进行instanceof的判断
+ a instanceof A的直接父类或间接父类，都会返回true



​	若子类重写了父类方法，就意味着子类里定义的方法彻底覆盖了父类里的同名方法，系统将不可能把父类里的方法转移到子类中。

+ 这时只能通过super关键字来调用父类的同名方法



​	对于实例变量不存在这样的现象，即使子类里定义了与父类完全相同的实例变量，这个实例依然不可能覆盖父类中定义的实例变量。（比如属性）这是看声明变量的类型，声明的是父类的，就凋父类的属性，子类的就凋子类的。



# Day10 2020/6/28

子类向上转型成间接父类后，可以向下转型成其他间接父类和直接父类或本身

若子类**先向上转型**，再调用子父类同名方法，**优先调用子类重写的方法**，而不是子类重载的。

这时若**再强转成子类对象**，再调用该同名方法时，就会根据参数列表，若优先满足重载情况，则调用重载方法。比如重载方法时三个int，而重写的方法时一个Int一个int型的可变长度变量。



## Object类

+ 所有类的根父类
+ 未使用extends关键字，则默认Object类为直接父类
+ 通过 类.getClass().getSuperclass() 获取到当前的对象的类的父类
+ Object类中的方法具有通用性
    + clone()，可以复制调用该方法的对象
    + equals()，比较两个对象是否相等
    + finalize()，垃圾回收机制回收任何对象前都会调用该方法（对象本身凋），但是无需人为主动调用
    + toString()
    + hashCode()
    + wait()
    + notify()
    + notifyAll()
+ Object类只声明了空参构造器，并且所有类都会调用到这个空参构造器



# Day11 2020/6/29

int型和double型进行运算的时候，int型可有类型提升，提升为double

这里进行运算的时候并不局限于 + ， == 也是可以的，其他也是

**char a = 10; 不会报错**，应该a直接被类型提升为了 int



## == 运算符

若比较的是基本数据类型，则是比较两个变量保存的数据是否相等（类型可以不同）

若比较的是引用数据类型变量，则是比较两个对象的地址值是否相等，即两个引用是否指向同一个对象实体



## equals()方法的使用

+ 是方法，不是运算符
+ 只能用于引用数据类型
+ Object类中equals()的定义：
    + public boolean equals(Object obj) {
                return (this == obj);
            }
    + 这与 == 运算符是相同的，都还只是比较地址是否相同
+ 像String，Date，File、包装类等都**重写**了Object类中的equals()方法。会比较里面具体的实体内容
+ 自定义类，如果使用equals()，通常都要重写它
  
    



# Day12 2020/6/30

## 重写equals()

+ 先比较地址是否相同，相同就不需要往下比了

+ 再比较两个对象的实体内容是否相同

+ ```java
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true; // 地址相同说明是引用同一个对象，直接返回true
        }
        if(obj instanceof 类){ // 判断可是需要的类
            // 1. 强转成这个类
            // 2. 比较两个对象的实体内容是否相同
        
        }
    }
    // 这手写的
    ```

+ 可以通过自动生成，生成重写的equals()方法，自动生成的的代码比较的规则

    + 1. == 比较地址
        2. == 比较null
        3. 判断是否类是同类型
        4. 强转成被比较类对象
        5. 比较被比较类的所有属性



**重写原则**：

+ 对称性：x.equals(y) 和 y.equals(x) 的返回应一致
+ 自反性：x.equals(x) 必须返回true
+ 传递性：如果 x.equals(y)返回true，而且 y.equals(z)也返回true，那么z.equals(x)也应该返回true
+ 一致性：如果x.equals(y)返回是true，只要x,y值不变，多少次比较返回的都是true
+ 任何情况下，x.equals(null)，永远返回false; x.equals(和x不同类型的对象)永远返回false
+ 不能null.equals()，会报空指针异常
+ 并且**在重写时比较实体内容时，该用equals()还是要用**，以防出错
    + 同时如果被比较的类属性中有其他的类对象，这个其他类也要重写equals()，不然就是直接是 == 运算符比较了，就会容易出错



## == 和 equals的区别

+ == 既可以比较基本数据类型又可以比较引用数据类型。

    + 基本类型就是比较值
    + 引用类型就是比较内存地址
    + 使用 == 时，必须保证等号两边类型一致

+ equals()是属于java.lang.Object类里面的方法

    + 该方法没被重写，默认也是 ==
    + 被重写后，才会根据重写的内容进行比较，一般重写后都会比较对象的实体内容

    

## toString()

+ 当输出一个对象的引用时（直接打印对象），实际上就是调用当前对象的toString()方法

+ ```java
    public String toString() {
            return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
    // getClass().getName()，先获取类名
    // hashCode()，获取堆空间的存储位置，不过这个是虚拟的内存地址，因为有JVM
    // Integer.toHexString()，转换成16进制
    
    // learn.Test@15db9742
    ```

+ 像String、Date、File、包装类等都重写了Object类中的toString()方法，使得在调用对象的toString()时，返回“实体内容”信息

+ 自定义类也可以重写该方法，并自定义返回内容



## 包装类（Wrapper）的使用

+ 针对八种基本数据类型定义的相应引用类型——包装类（封装类）
+ 使得基本类型也有类的特征
+ byte —— Byte
+ short —— Short
+ int —— Integer
+ long —— Long
+ float —— Float
+ double —— Double
+ 上面几个类有一个共同的父类，Number类
+ boolean —— Boolean
+ char —— Character



## 基本类型、包装类与String类间的转换

![image-20200630224705986](C:\Users\Jarvis\AppData\Roaming\Typora\typora-user-images\image-20200630224705986.png)



### 基本数据类型 ——> 包装类

```java
	// 基本数据类型 ————> 包装类：调用包装类的构造器
	@Test
	public void test1() {
		int num1 = 10;
//		System.out.println(num1.toString());
		
		Integer in1 = new Integer(num1);
		System.out.println(in1.toString());
		
		Integer in2 = new Integer("123"); // 不能是 123abc
		System.out.println(in2.toString());
		
		Float f1 = new Float(12.3);
		Float f2 = new Float(12.3f);
		Float f3 = new Float("12.3");
		
		Boolean b1 = new Boolean(true);
		Boolean b2 = new Boolean("false"); // 这里源码是忽略大小写与true比较，不一样就是false
		Boolean b3 = new Boolean("true123");
		System.out.println(b3.toString());
		
	}
	
	
}

class Order{
	
	boolean isMale; // 默认值:false
	Boolean isFemale; // 默认值:null，因为它已经是一个类了
}

```



# Day13 2020/7/2

## 包装类 ——> 基本数据类型

```java
	// 包装类 ————> 基本数据类型：调用包装类的xxxValue()
	@Test
	public void test2() {
		Integer in1 = new Integer(24);
		
		int i1 = in1.intValue();
		System.out.println(i1);
        // 这样就可以加减乘除了，包装类是无法加减乘除的，所以要转成基本数据类型 
		
		Boolean boolean1 = new Boolean(false);
		boolean b1 = boolean1.booleanValue();
		System.out.println(b1);
		
		Float float1 = new Float(20.3F);
		float f1 = float1.floatValue();
		System.out.println(f1);
	}
```



## 自动装箱与自动拆箱

JDK5.0的新特性

```java
/**
	 * JDK 5.0 新特性：自动装箱与自动拆箱
	 */
	@Test
	public void test3() {
		int num1 = 10;
		
		// 基本数据类型  ——> 包装类的对象
		method(num1); // Object obj = num1;
		// 这里本来基本数据类型num1是无法作为类对象传递给method方法的
		
		// 自动装箱：基本数据类型  ——> 包装类的对象
		int num2 = 10;
		Integer in1 = num2; // 不需要再使用构造器了
		
		boolean b1 = true;
		Boolean b2 = b1; // 自动装箱
		
		
		// 自动开箱：包装类 ——> 基本数据类型
		System.out.println(in1.toString());
		int num3 = in1; // 自动拆箱
	}
	
	public void method(Object obj) {
		System.out.println(obj); 
        // println()中调用String.valueOf()，其实就是调用了对象的toString()
	}
```



## 基本数据类型、包装类 —— > String类型

```java
	// 基本数据类型、包装类 ————> String类型：调用String重载的valueOf(Xxx xxx)
	@Test
	public void test4() {
		int num1 = 10;
		// 方式1：连接运算
		String str1 = num1 + "";
		// 方式2：调用String的valueOf(Xxx xxx)
		float f1 = 12.3f;
		String str2 = String.valueOf(f1);
		System.out.println(str2);
		
		Double double1 = 20.4;
		String str3 = String.valueOf(double1);
		System.out.println(str3);	
	}
```



## String类型 ——> 基本数据类型

```java
// String类型 ————> 基本数据类型、包装类：调用包装类的parseXxx()
	@Test
	public void test5() {
		String str1 = "123";
		// int num1 = (int)str1; 不行
		// Integer in1 = (Integer)str1; 也不行，不存在子父类的关系
		
		int num2 = Integer.parseInt(str1); // 如果是123a，带字母的，会抛出NumberFormatException的异常
		System.out.println(num2);
		
		String str2 = "true1"; 
		boolean b1 = Boolean.parseBoolean(str2); // 不是不记大小写的 true，就是false
		System.out.println(b1);
	}
```



## 包装类常见面试题

```java
	@Test
	public void test6() {
		Object o1 = true ? new Integer(1) : new Double(2.0); // 三元运算符 ：编译时要求两边类型要一致，所以这里int提升到double
		System.out.println(o1); // 1.0
		
		Object o2;
		if(true) {
			o2 = new Integer(1); // 1
		}else {
			o2 = new Double(2.0);
		}
		
		System.out.println(o2);
	}
```



```java
	@Test
	public void test7() {
		Integer i = new Integer(1);
		Integer j = new Integer(1);
		System.out.println(i == j); // false 比较的是地址
		
		Integer m = 1;
		Integer n = 1;
		System.out.println(m == n); // true
		

		Integer x = 128;
		Integer y = 128;
		System.out.println(x == y); // false
		// 这是因为Integer类中有个私有静态内部类IntegerCache
		// 有个static final Integer cache[];属性，已经提前造好 -128~+127 的整数
		// 在使用自动装箱的方式时，给Integer赋值的范围在-128~127时，可以直接使用数组中的元素，就不用再去用了
		// 目的就是为了提高效率
		// 因此，这里Integer x = 128; 相当于new了个对象
	}
```



## 包装类的小练习

```java
/**
 * 
 * @author Yi-27
 * @Time:2020年7月2日 下午4:21:21
 * @Description:
 * 利用Vector代替数组处理，从键盘读取学生成绩（负数表示输入结束），找出最高分，并输出学生成绩等级
 * 数组一旦创建，长度固定不变， 但是 向量类java.util.Vector可以根据需要动态伸缩
 * 
 * Vector v = new Vector();
 * v.addElement(Object obj); // 向向量中添加元素
 * Object obj = v.elementAt(0); // 按下标取出元素
 * v.size(); // 计算向量的长度
 * 
 * 与最高分相差10分内 A等，20分内B等，30分内C等，其它D等
 * 
 */
public class ScoreTest {
	
	public static void main(String[] args) {
		// 1. 实例化Scanner，用于从键盘获取学生成绩
		Scanner scan = new Scanner(System.in); 
		
		// 2. 创建Vector对象，相当于数组
		Vector v = new Vector();
		
		int maxScore = 0;
		
		// 3. for(;;)给Vector中添加数据
		for(;;) {
			System.out.println("输入学生成绩（以负数代表输入结束）");
			int score = scan.nextInt();
			if(score < 0) {
				break;
			}
			if(score > 100) {
				System.out.println("输入的数据非法，请重新输入");
				continue;
			}
			// jdk5.0之前
//			Integer inScore = new Integer(score);
//			v.addElement(inScore); // 多态
			
			// jdk5.0之后
			v.addElement(score); // 自动装箱
			
			if(maxScore < score) {
				maxScore = score;
			}
		}
		// 4. 输入负数时，终止循环
		
		// 5. 获取学生成绩的最大值
		
		// 6. 遍历Vector得到每个学生的成绩，并与最大成绩比较，得到每个学生的等级
		char level;
		for(int i = 0; i < v.size(); i++) {
			Object obj = v.elementAt(i);
			
			// jdk5.0之前
//			Integer inScore = (Integer)obj;
//			int score = inScore.intValue();
			
			// jdk5.0之后
			int score = (int)obj; // 其实应该先拆成Integer再拆成int，但可以这样一步到位
			
			if(maxScore - score <= 10) {
				level = 'A';
			}else if(maxScore - score <= 20) {
				level = 'B';
			}else if(maxScore - score <= 30) {
				level = 'C';
			}else {
				level = 'D';
			}
			System.out.println("学生-" + i + " 成绩：" + score + " 等级：" + level);
			
		}
	}
	
}
```



## 其他要注意的点：

向上转型（多态）不需要用强转符，向下转型时一般需要强转符。

强转时可能会报ClassCastException异常，因此在此之前用instanceof判断一下，返回true再进行向下转型

在使用instanceof时，x所属的类与类A必须是子父类的关系，否则编译错误



数组也算是一个类



## 面试题：谈谈对多态性的理解

+ 实现代码的通用性
+ 举例：Object类中定义的equals()方法、JDBC使用java程序操作数据库
+ 抽象类、接口的使用肯定体现了多态性。（抽象类、接口不能实例化）
+ 多态是一个运行时行为



## 其他的测试

```java
	@Test
	public void test1() {
		
		String s = "abc";
		s = null;
		System.out.println(s); // null 这里没报空指针，
		// 这是因为prinln()方法中 print()方法会判断是不是null
		// 是就直接打印 "null"，不是照常输出
		
		System.out.println("-------------");
		System.out.println(s.toString()); // NullPointedException
		
	}
```



# Day14 2020/7/3

## static关键字

静态的意思

**用来修饰：属性、方法、代码块、内部类**

### 修饰属性：静态变量

+ 静态变量（类变量）
    + 多个变量共享同一个静态变量，当一个对象改变静态变量的值后，别的对象调用获取该静态变量的值已经是改变后的值了
+ 非静态变量（实例变量）
    + 每个对象修改非静态变量时不会影响其他对象的非静态变量
+ **静态变量随着类的加载而加载**，可以通过 类.静态变量 的方式进行调用
+ **静态变量的加载要早于对象的创建**
+ 由于类只会加载一次，则静态变量在内存中也只会存在一份，**存在方法区的静态域中**



# Day15 2020/7/4

## static关键字

静态属性举例：System.out; Math.PI



## 类变量和实例变量的内存解析

方法区：类的加载信息、静态域、常量池

![image-20200704233331574](C:\Users\Jarvis\AppData\Roaming\Typora\typora-user-images\image-20200704233331574.png)

类变量是加载到方法区的，而非堆空间



### static修饰方法：静态方法

+ 随着类的加载而加载，通过 类.静态方法 的方式进行调用

+ 类不能调用非静态方法，编译会不通过
+ 静态方法中，只能调用静态的方法或属性（因为无法使用this关键字）
    + 非静态方法都可以调用，



### static注意到

在静态方法内，不能使用this关键字、super关键字

+ 但是静态方法中调用静态属性和静态方法时，可以省略类名

非静态方法中调用类中其他方法，默认是省略了this关键字的



### 如何确定一个属性要声明为static?

+ 属性是可以被多个对象所共享的，不会随着对象的不同而不同的，可以考虑声明为static



### 如何确定一个方法要声明为static?

+ 操作静态属性的方法，通常声明为static
+ 工具类中的方法，习惯上声明为static，比如Math、Arrays、Collections







# Day16 2020/8/3

## 单例（Singleton）设计模式

对某个类**只能存在一个对象实例，**并且该类只提供一个取得其对象实例的方法。

首先需要**将类的构造器的访问权限设置为private**，这样，就不能用new操作符在类的外部产生类的对象，但是在类的内部可以

只能**调用该类的某个静态方法**以返回类内部创建的对象，静态方法只能访问类中的静态成员变量

所以，**指向**类内部产生的**该类对象的变量也必须定义为静态的**。



**饿汉式**：

```java
// 饿汉式
class Bank{
	
	// 1.私有化构造器
	private Bank() {
		// 外部无法调用
	}
	
	// 2.内部创建类的对象
	// 4.要求次对象也必须声明为静态的
	private static Bank instanceBank = new Bank();

    
	// 3.提供公共的静态方法，返回类的对象
	public static Bank getInstance() {
		return instanceBank;
	}

}

// 5.获取单例
Bank bank1 = Bank.getInstance();
Bank bank2 = Bank.getInstance(); // 这两个获取到的是同一个对象
	
```



**懒汉式**

```java
// 懒汉式
class Order{
	
	// 1.私有化类的构造器
	private Order() {
		
	}
	
	// 2.声明当前类对象，没有初始化
	// 4.此对象也必须声明为static
	private static Order instanceOrder = null;
	
	// 3.声明public、static的返回当前类的对象的方法
	public static Order getInstance() {
		if(instanceOrder == null) { // 如果不存在才会去创建新的对象
			instanceOrder = new Order(); // 这样也只会在第一次才创建这个对象
		}
		
		return instanceOrder;
	}
	
}

```



区别：

+ 懒汉式是什么时候用什么时候造，饿汉式是一开始就造好了。
+ **饿汉式是线程安全的。**



单例模式的优点：

+ 减少了系统性能的开销

+ 当一个对象的产生需要比较多的资源时，如读取配置、产生其他依赖对象时，则可以通过在应用启动时直接产生一个单例对象，然后永久驻留内存的方式来解决



单例模式的**应用场景：**

+ 网站的计数器
+ 应用程序的日志应用
+ 数据库连接池
+ 读取配置文件的类
+ Application也是单例的典型应用
+ Windows的Task manager(任务管理器)也是典型的单例模式，回收站也是



```java
// 还可以这样
class Bank{
	
	// 1.私有化构造器
	private Bank() {
		// 外部无法调用
	}
	
	// 2.内部创建类的对象
	// 3.这样final修饰，外部就不能修改内部结构只能调用了
	public static final Bank instanceBank = new Bank();
}

// 5.获取单例
Bank bank1 = Bank.instanceBank;
Bank bank2 = Bank.instanceBank; // 这两个获取到的是同一个对象

```





# Day17 2020/8/4

## 理解main()方法

+ main()方法是程序的入口
+ 必须是 main，其他单词不行
+ main()也是一个普通的静态方法
+ main()方法也可以作为与控制台交互的方式（之前用的Scanner
    + 只不过通过main()方法的args获取到的默认都是字符串类型的



## 代码块

类的成员之一

作用：

+ 用于初始化类、对象
+ 只能在前面加上static
+ 分类：静态代码块和非静态代码块



静态代码块：

+ 内部可以有输出语句
+ 随着类的加载而执行，且只执行一次
+ 对**类的属性**进行初始化，比如初始化类中静态的属性
+ **类中可定义多个静态代码块，并按声明的先后顺序执行**
+ 静态代码块的执行优先于费静态代码块，因为静态代码块是随着类的加载而执行的

+ 只能调用静态结构



非静态代码块：

+ 内部可以有输出语句
+ 随着对象的创建而执行，每创建一个就执行一次
+ 可以在创建对象时，对**对象的属性**等进行初始化
+ 非静态也可以定义多个
+ 可以调用静态结构和非静态结构





**类中属性可以赋值的位置：**

+ 默认初始化
+ 显式初始化
+ 构造器中初始化
+ 对象.属性 和 对象.方法的方式，进行复制
+ 在代码块中赋值



其中显示初始化和在在代码块中初始化的执行顺序要看在代码中的先后顺序



## final关键字

final可以用来修饰的结构：类、方法、变量



修饰类：

+ 不能被继承
+ 比如，String类、System类、StringBuffer类



修饰方法：

+ 表明方法不可以被重写
+ 比如，Object类中的getClass()



## native关键字

修饰方法时，这样的方法就没有方法体，表示接下来要调用底层的C/C++代码了





# Day18 2020/8/6

## final关键字

final可以用来修饰的结构：类、方法、变量



**修饰类：**

+ 不能被继承
+ 比如，String类、System类、StringBuffer类

**修饰方法：**

+ 表明方法不可以被重写
+ 比如，Object类中的getClass()

**修饰变量：**

+ 此时的变量就称为一个常量
+ 赋值的位置有：
    + 显示初始化
    + 代码块中初始化
    + 构造器中初始化

**修饰局部变量：**

+ 修饰形参时，表示此形参时一个常量，当调用此方法给常量形参赋值后，就只能在方法体内使用此形参，且不能修改

    

**static final 用来修饰属性：全局常量**

**static修饰的属性都加载到方法区的静态域中**



## 抽象类与抽象方法

### abstract关键字

abstract：抽象的

可以用来修饰的结构：类、方法

不能用来修饰：属性、构造器、代码块

**不能用来修饰私有方法、静态方法**

**修饰类：**

+ 不能实例化
+ 但有构造器，这是因为子类会用到
+ 开发中，抽象类不能实例化都会提供抽象类的子类，让子类对象实例化，来进行实际操作

**修饰方法：**

+ 抽象方法只有声明，没有方法体

+ 包含抽象方法的类，一定是抽象类

+ 若子类重写了父类中的所有的抽象方法后，此子类方可实例化

    + 不止直接父类的，间接父类的所有抽象方法都要重写

+ 若子类没有重写父类中的所有的抽象方法，则子类也是一个抽象类，需要用abstract修饰

    

**非匿名类匿名对象**：

类似`func(new subject());`

**抽象类的匿名子类对象：**

```java
		// 创建匿名子类的对象 （对象也可以有名或无名）
		// Employee抽象类是无法实例化的
		// 但是在后面加个大括号再重写抽象类的方法，就是该抽象类的匿名子类
		Employee employee = new Employee() {
			
			@Override
			public void work() {
				// TODO Auto-generated method stub
				
			}
		};
```



# Day19 2020/8/7

## 多态的应用：模板方法设计模式（TemplateMethod）

解决的问题：

+ 当功能内部一部分实现是确定的，一部分实现是不确定的。这时可以把不确定的部分暴露出去，让子类去实现
+ 换句话说，在软件开发中实现一个算法时，整体步骤很固定/通用，这些步骤在父类中写好。但是某些易变的部分可以抽象出来，供不同子类实现。这就是一种模板模式。
+ 比如，抽象类的应用。



## 接口（Interface）

通过接口达到多重继承的效果

一个类可以实现多个接口：打破了单继承的局限性

+ 类在书写时，先写继承，后写实现

`继承是一个“是不是”的关系，接口实现的则是“能不能”的关系`

+ 接口使用interface来定义
+ 接口和类是并列的两个结构
+ 接口的成员
    + JDK7及以前
        + 只能够定义**全局常量**和**抽象方法**
        + 全局常量：public static final
            + 其中public static final 可以省略不写
        + 抽象方法：public abstract
            + 其中public abstarct 也可以省略不写
    + JDK8及以后
        + 除了定义全局常量和抽象方法之外，还可以定义**静态方法**和**默认方法**
+ 接口中不能写构造器，意味着接口不可以实例化
+ 接口通过让类去实现（implements）的方式来使用
    + 如果实现类覆盖了接口中所有抽象方法，则此实现类就可以实例化
    + 如果实现类没有覆盖接口中所有的抽象方法，则此实现类仍为一个抽象类，需要定义为abstract class
+ **接口和接口之间时可以多继承的**

+ 接口的具体使用，体现多态性
    + USB usb = new Flash();  这里形参USB是接口，但是其实传来的是实际的子类实现对象
    + 编译看左边，运行看右边
+ 接口，实际上可以看作是一种规范

**继承父类叫重写方法，实现接口叫实现方法。**



# Day20 2020/8/8

## 接口应用：代理（Proxy）模式

代理设计就是为其他对象提供一种代理以控制对这个对象的访问。

```java
package day20;

/**
 * 
 * @author Yi-27
 * @Time:2020年8月8日 下午8:07:10
 * @Description:
 * 接口的应用：代理模式
 */
public class NetWorkTest {

	public static void main(String[] args) {
		Server server = new Server();
//		server.browse(); // 不自己调用
		ProxyServer proxyServer = new ProxyServer(server);
		
		proxyServer.browse(); // 通过代理类来调用方法
		
	}
}

interface NetWork{
	
	public void browse(); // 浏览器
	
}

// 被代理类
class Server implements NetWork{

	@Override
	public void browse() {
		// TODO Auto-generated method stub
		System.out.println("真是的服务器访问网络");
	}
	
}

// 代理类
class ProxyServer implements NetWork{

	private NetWork work;
	
	public ProxyServer(NetWork work) {
		this.work = work;
	}
	
	public void check() {
		System.out.println("联网前的检查工作");
	}
	
	@Override
	public void browse() {
		// TODO Auto-generated method stub
		check();
		work.browse();
	}
	
}
```

应用场景：

+ 安全代理：屏蔽对真实角色的直接访问
+ 远程代理：通过代理类处理远程方法调用（RMI）
+ 延迟加载：先加载轻量级的代理对象，真正需要再加载真实对象

分类：

+ 静态代理：静态定义代理类
+ 动态代理：动态生成代理类
    + JDK自带的动态代理，需要反射等知识



## 接口的应用：工厂模式

实现了**创建者与调用者的分离**，即将创建对象的具体过程屏蔽隔离起来，达到提高灵活性的目的。

+ 简单工厂模式：用来生产同一等级结构中的任意产品。（对于增加的新产品，需要修改已有代码）
    + 违反了开闭原则（对扩展开放，对修改封闭）
    + 工厂中直接创建需要产品的对象并返回出来，要想添加新产品，就要修改工厂的代码
        + 要在代码中判断需要生产什么产品，再生产出来返回出来

+ 工厂方法模式：用来生产同一等级结构中的固定产品。（支持增加任意产品）
    + 将工厂抽象成接口，定义具体产品的工厂类（实现了工厂接口）来生产产品
    + 但是工厂方法模式也并没有真正避免了代码的改动
        + Java的反射机制与配置文件的巧妙结合突破了限制（这在Spring中完美的体现了出来）
+ 抽象工厂模式：用来生产不同产品族的全部产品。（对于增加新的产品，无能为力，支持增加产品族）
    + 抽象工厂模式和工厂方法模式的区别就在于需要创建对象的复杂程度上
    + 抽象工厂模式满足条件：
        + 系统中有多个产品族，而系统一次只可能消费其中一族产品
        + 同属于同一个产品族的产品以其使用



当类继承的类和实现的接口有变量名相同的属性时

+ 可以通过 **super.属性** 调用父类的属性，通过 **接口名.属性** 来调用接口的属性

当类实现两个接口，两个接口有同名方法时

+ 类中重写这个方法，是同时对两个接口的该方法的实现



**Java8中关于接口的改进：**

+ 除了定义全局常量和抽象方法之外，还可以定义**静态方法**和**默认方法**
+ 接口中定义的静态方法只能通过接口来调用
+ 通过实现类的对象，可以调用接口中的默认方法
    + 如果实现类重写了接口中的默认方法，调用时，仍然调用的是重写以后的方法
+ 如果子类（或实现类）继承的父类和实现的接口中声明了同名同参数的方法
    + 那么子类在没有重写此方法的情况下，默认调用的是父类中的同名同参数的方法（类优先原则，仅对于方法）
+ 如果实现类实现了多个接口，多个接口中声明了同名同参数的**默认方法**
    + 那么在实现类没有重写此方法的情况下，会报错，接口冲突
    + 这时就要在实现类中重写此方法
        + 并不一定，有的是看implements后面接口的顺序，默认使用靠前的接口中同名同参的默认方法
+ 还可以通过 接口.super.默认方法名 来调用默认方法





## 内部类

当一个事物的内部，还有一个部分需要一个完整的结构进行描述，而这个内部的完整的结构又只为外部事物提供服务，那么整个内部的完整结构最好使用内部类



**分类：**

+ 成员内部类
    + 一方面，作为外部类的成员
        + 调用外部类的结构
        + 可以被static修饰
        + 可以被4中不同的权限修饰，因为是外部类的成员
    + 另一方面，作为一个类
        + 类内可以定义属性、方法、构造器、内部类
        + 可以被final修饰，表示此类不能被继承，不修饰则可以继承
        + 可以被abstract修饰，表示此类不能被实例化
+ 局部内部类（方法内，代码块内，构造器内）

```java
class Person{
	
	// 静态成员内部类
	static class DD{
		
	}
    // 非静态成员内部类
    class EE{
        
    }
	
	public Person() {
		// 局部内部类
		class CC{
			
		}
	}
	
	public void method() {
		// 局部内部类
		class AA{
			
		}
	}
	
	{
		// 局部内部类
		class BB{
			
		}
	}
	
}
```

+ 如何实例化成员内部类的对象

+ 如何在成员内部类中区分调用外部类的结构
    + 内部类的属性直接 this.属性
    + 外部类的属性 外部类名.this.属性
+ 开发中局部内部类的使用 





# Day21 2020/8/9

## 局部内部类事宜的注意点

成员内部类和局部内部类，在编译后，都会生成字节码文件

格式：

+ 成员内部类：外部类$内部类名.class

+ 局部内部类：外部类$数字 内部类名.class



	 * 在局部内部类的方法中
	 * 如果调用局部内部类所在的方法中的局部变量时
	 * 要求此局部变量声明为final的
	 * 
	 * jdk7及之前版本，要求此局部变量显示声明为final的
	 * jdk8及之后版本，可以省略final的声明




## 异常处理

两大类：

+ Error：Java虚拟机无法解决的严重问题
    + 比如JVM内部错误、资源耗尽等问题
    + 比如，stackOverflowError和OOM
    + 一般不编写代码进行处理
+ Exception：其他因编程错误或偶然的外在因素导致的一致性问题
    + 空指针访问
    + 试图读取不存在的文件
    + 网络连接中断
    + 数组角标越界 
    + ...
    + 可以编写代码去处理



捕获错误最理想的是在**编译期间**，但有的错误只有在**运行时**才会发生。

比如：除数为0，数组下标越界等

+ 分类：
    + 编译时异常
        + 这时程序无法运行
    + 运行时异常
        + 程序能运行，但会报错



**异常体系机构：**

jang.lang.Throwable

+ java.lang.Error
+ jang.lang.Exception
    + 编译时异常（checked）
        + IOException
            + FileNotFoundException
        + ClassNotFoundException
    + 运行时异常（unchecked）
        + NullPointerException
        + ArrayIndexOutOfBoundsException
        + ClassCastException
        + NumberFormatException
        + InputMismatchException
        + ArithmaticException





# Day22 2020/8/10

## 异常处理

 **抓抛模型：**

+ 过程一：“抛”

    + 程序在正常执行的过程中，一旦出现异常，就会在异常代码处生成一个对应异常类的对象
    + 并将此对象抛出
    + 一旦抛出对象以后，其后的代码就不再执行

+ 过程二：“抓”

    + 可以理解为异常的处理方式

    + ①：try-catch-finally

        + ```java
            try{
                // 可能出现异常的代码
            }catch(异常类型1 变量名1){
                // 处理异常的方式1
            }catch(异常类型2 变量名2){
                // 处理异常的方式2
            }catch(异常类型3 变量名3){
                // 处理异常的方式3
            }
            ...
            finally{ // finally是可选的
                // 最后一定会执行的代码（哪怕是try或catch中return了）
            }
            ```

        + 使用try将可能出现异常代码包装起来，在执行过程中，一旦出现异常，就会生成一个对应异常类的对象，根据此对象类型，去catch中进行匹配

        + 一旦try中的异常对象匹配到某一个catch时，就进入catch中进行异常的处理

            + 一旦处理完成就跳出当前的try-catch结构（在没有写finally的情况下），继续执行后续的代码

        + catch中的异常类型如果没有子父类关系，则谁声明在上，谁声明在下无所谓。

            + 如果满足子父类关系，则要求子类一定声明在父类的上面。否则，报错  

        + 常用的异常对象处理方式：

            + ① String getMessage()
            + ② printStackTrace()
            + 出了try-catch就不能调用了

        + 体会：

            + 使用try-catch-finally处理编译时异常，是得程序在编译时就不再报错，但是运行时仍可能报错
            + 相当于我们使用try-catch-finally将一个编译时可能出现的异常，延迟到运行时出现

        + finally

        + ```java
            package day22;
            /**
             * 
             * @author Yi-27
             * @Time:2020年8月10日 下午11:45:40
             * @Description:
             * 
             */
            
            import org.junit.Test;
            
            public class FinallyTest {
            	
            	@Test
            	public void testMethod() {
            		int num = test();
            		System.out.println(num);
            	}
            	
            	public int test() {
            		try {
            			int[] arr = new int[10];
            			System.out.println(arr[10]);
            			return 1;
            		} catch (ArrayIndexOutOfBoundsException e) {
            			// TODO: handle exception
            			e.printStackTrace();
            			return 2;
            		}finally {
            			System.out.println("这一定会被执行"); // 肯定会执行
            			return 3; // 肯定会返回3
            		}
            	}
            	
            	
            	
            	
            
            	@Test
            	public void test1() {
            		try {
            			int a = 10;
            			int b = 0;
            			System.out.println(a / b);
            		}catch(ArithmeticException e) {
            			e.printStackTrace();
            			int[] arr = new int[10];
            			System.out.println(arr[10]);
            		}catch(Exception e) {
            			e.printStackTrace();
            		}finally { // finally是可选的
            			System.out.println("这一定会被执行"); // 即使catch中又出现了异常
            		}
            	}
            	
            	
            }
            
            ```

        + 像数据库连接，输入输出流，网络编程Socket等资源，JVM是不能自动的回收的，需要自己手动的进行资源的释放。此时的资源释放，就需要声明在finally中

        + try-catch-finally可以相互嵌套

    + ②：throws 
    
        + throws + 异常类型：写在方法的声明处。
    
            + 指明此方法在执行时，可能会抛出的异常类型
            + 一旦当方法体执行时，出行异常，仍会在异常代码处生成一个异常类的对象
            + 此对象满足throws后的异常类型时，就会被抛出
            + 异常代码后续的代码，就不再执行 
    
            



# Day23 2020/8/11

## 异常处理

**捕获异常：**

**try-catch-finally：**

+ 使用try-catch-finally处理编译时异常，是得程序在编译时就不再报错，但是运行时仍可能报错
    + 相当于我们使用try-catch-finally将一个编译时可能出现的异常，延迟到运行时出现

+ 开发中，由于运行时异常比较常见，所以通常不针对运行时异常编写try-catch-finally
    + 针对编译时异常，一定要考虑异常的处理 
+ try：执行可能产生异常的代码
+ catch：捕获异常
+ finally：无论是否发生异常，代码总被执行



**抛出异常：**

+ throw：
    + 异常的生成阶段：手动抛出异常对象



**声明异常：**

+ throws：
    + 异常的处理方式：声明方法可能要抛出的各种异常类



对比两种处理方式：

+ try-catch-finally：真正的将异常给处理掉了
+ throws的方式只是将异常抛给了方法的调用者，并没有真正的处理掉异常

开发中怎么选择：

+ 如果父类中被重写的方法没throws方式处理异常，则子类重写的方法也不能使用throws
    + 意味着若果子类重写的方法中有异常，必须使用try-catch-finally的方式处理
+ 执行的方法a中，先后又调用了另外的几个方法，这几个方法是递进关系执行的
    + 建议这几个方法使用throws的方式进行处理，而执行的方法a可以考虑使用try-catch-finally的方式进行处



**方法重写的规则之一：**

+ 子类重写的方法抛出的异常类型不大于父类被重写的方法抛出的异常类型



**如何自定义异常类：**

1. 继承于现有的异常结构：RuntimeException、Exception...
2. 提供全局常量：serialVersionUID
3. 提供重载的构造器 ：参数是类似String msg，并且super(msg)



# Day24 2020/9/4

## 重写方法异常抛出的规则

+ 子类重写的方法抛出的异常类型**不大于**父类被重写的方法抛出的异常



## 开发中如何选择使用try-catch-finally还是使用throws

+ 如果父类中被重写的方法没有throws方式处理异常，则子类重写的方法也不能使用throws，意味着如果子类重写的方法中有异常，必须使用try-catch-finally方式处理。

+ 执行的方法a中，先后又调用了另外的几个方法，这几个方法是递进关系执行的。建议几个方法使用throws的方式进行处理。而执行的方法a可以考虑使用try-catch-finally方式进行处理



关于异常的产生：

+ 系统自动生成异常对象
+ 手动的生产一个异常对象，并抛出（throw）



## 手动抛出异常

```java
// 手动抛出异常对象
//			throw new RuntimeException("您输入的数据非法！"); // 抛的是运行时异常
			throw new Exception("您输入的数据非法！"); // 这时就包括了编译时异常，需要进行处理
```



## 如何自定义异常类

+ 继承现有的异常结构：RuntimeException、Exception
+ 提供全局常量：serialVersionUID
+ 提供重载的构造器



# Day25 2020/9/5

project03一半





# Day26 2020/9/16

projec另一半的二分之一



# Day27 2020/9/23

projec最后的的二分之一



IDEA中顶层结构是Project，其次是Module



程序是为了完成特定任务、用某种语言编写的一组指令的集合。指一段静态的代码，静态对象。

进程是程序的一次执行过程，或是正在运行的一个程序，是一个动态的过程。。

+ 进程作为资源分配的单位，系统在运行时会为每个进程分配不同的内存区域

线程是进程的细化，是一个程序内部的一条执行路径

+ 一进程同一时间并行执行多个线程，即为支持多线程
+ 线程作为调度和执行的单位，**每个线程拥有独立的运行栈（虚拟机栈）和程序计数器（pc）**
+ 线程切换的开销小
+ 一个进程中的多个线程共享相同的内存单元/内存地址空间，它们从同一堆中分配对象，可以访问相同的变量和对象
+ 这使得线程间通信更加简便、高效，但多个线程操作共享的系统资源可能会带来安全隐患



![image-20200923094539552](C:\Users\Jarvis\AppData\Roaming\Typora\typora-user-images\image-20200923094539552.png)

方法区和堆是一个进程拥有一份，多个线程共享进程中的方法区和堆。



一个Java应用程序java.exe，至少有三个线程：main()主线程，gc()垃圾回收线程，异常处理线程。当发生异常，会影响主线程。





## 多线程

线程的创建有四种方式

线程的同步有三种方式



使用多线程的优点：

+ 提高应用程序的响应。对图形化界面更有意义，可增强用户体验
+ 提高计算机系统CPU的利用率
+ 改善程序结构，将既长又复杂的进程分为多个线程，独立运行，利于理解和修改

何时需要多线程

+ 程序需要同时执行两个或多个任务
+ 程序需要实现一些需要等待的任务时，如用户输入、文件读写、网络操作、搜索等
+ 需要一些后台运行的程序时



 不可以还让已经start()的线程再次start()



### 线程的常用方法

```
*  1. start(): 启动当前线程，调用当前线程的run()
*  2. run(): 通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
*  3. currentThread()： 静态方法，返回执行当前代码的线程
*  4. getName()： 获取当前线程的名字
*  5. setName()： 设置当前线程的名字
*  6. yield()： 释放当前CPU的执行权，但是可能下面又被分配到CPU的执行权
*  7. join()：在线程a中调用线程b的join()，此时线程a进入阻塞状态，直到线程b完全执行完之后，线程a结束阻塞状态
*  8. stop()： 已过时，当执行此方法时，强制结束当前线程
*  9. sleep(long millitime)： 线程睡眠，单位毫秒，在指定的毫秒时间内，当前线程是阻塞状态
*  10. isAlive()： 判断当前线程是否还存活
```



### 线程的调度

+ 时间片

+ 抢占式：高优先级的线程抢占CPU



### Java的调度方法

+ 同优先级线程组成先进先出队列（先到先服务），使用时间片策略
+ 对高优先级，使用优先调度的抢占策略



### 线程优先级等级

+ MAX_PRIORITY：10
+ MIN_PRIORITY：1
+ NORM_PRIORITY：5



#### 涉及的方法

+ getPriority()：返回线程优先值
+ setPriority(int newPriority)：改变线程的优先级



#### 说明

+ 线程创建时基础父线程的优先级
+ 低优先级只是获得调度的概率低，并非一定是高优先级线程之后才被调用



### 比较创建线程的两种方式：

+ 开发中优先选择实现Runnable接口的方式
    + 原因1：实现的方式没有类的单继承性的局限性
    + 原因2：实现的方式更适合来处理多个线程有共享数据的情况

+ ```
    联系：public class Thread implements Runnable
    ```

+ 相同点：两种方式都需要重写run()，将线程要执行的逻辑声明在run()中



### 线程的通信：

+ wait()
+ notify()
+ notifyAll()
+ 此三个方法定义在Object类中



### 线程的分类：

+ 守护线程
    + 用来服务用户线程的，通过在start()前调用thread.setDaemon(true)可以把一个用户线程变成一个守护线程
    + Java垃圾回收就是一个典型的守护线程
    + 若JVM中都是守护线程，当前JVM将退出
+ 用户线程
    + 比如main()线程



### 线程的声明周期：

+ NEW：当一个Thread类或其子类的对象被声明并创建时，新生的线程对象处于新建状态
+ RUNNABLE：处理新建状态的线程被start()后，将进入线程队列等待CPU时间片，此时它已经具备了运行的条件，只是没分配到CPU资源
+ BLOCKED：运行状态，当就绪的线程被调度并获得CPU资源时，就进入运行状态，run()方法定义了线程的操作和功能
+ WAITING：阻塞，join()触发，join()结束进入RUNNABLE状态
+ TIMED_WAITING：定时阻塞，sleep()方法触发，sleep()结束后进入RUNNABLE状态
+ TERMINATED：终止或死亡状态，线程完成了它的全部工作或者线程被提前强制性地中止或出现异常导致结束

![image-20200923135806550](C:\Users\Jarvis\AppData\Roaming\Typora\typora-user-images\image-20200923135806550.png)





## 线程的同步

```
例子：创建三个窗口卖票，总票数为100张，使用实现Runnable接口的方式
*仍存在线程安全问题
* 1. 问题： 卖票过程中，出现了重票、错票
* 2. 问题出现的原因： 当某个线程操作车牌的过程中，尚未操作完成时，其他线程也操作了车票
* 3. 如何解决：当一个线程a在操作共享ticket的时候，其他线程不能参与进来，
*      直到线程a操作完成ticket时，其他线程才能开始操作ticket。
*      即使线程a出现了阻塞，也不能改变
* 4、在Java中，通过同步机制，来解决线程的安全问题
* 方式一：同步代码块
*      synchronized(同步监视器){
*          // 需要被同步的代码
*      }
*      说明：① 操作共享数据的代码，即为需要被同步的代码。 --> 不能包含代码多了，也不能包含代码少了
*            ② 共享数据：多个线程共同操作的变量，比如ticket
*            ③ 同步监视器，俗称 锁。任何一个类的对象，都可以充当锁
*                  要求：多个线程必须要共用同一把锁
*                  在实现Runnable接口创建多线程的方式中，可以考虑使用this充当同步监视器
* 方式二：同步方法 
*	   在方法声明头部加上synchronized关键字即可
*      如果操作共享数据的代码完整的声明在一个方法中，不妨将此方法声明为同步的
*
* 5. 同步的方式，解决了线程的安全问题。---好处
*    操作同步代码时，只能有一个线程参与，其他线程等待。相当于是一个单线程的过程，效率低。---坏处
*
*	关于同步方法的总结：
 *      1. 同步方法仍然涉及到同步监视器，只是不需要显式的声明
 *      2. 非静态的同步方法，同步监视器是：this
 *          静态的同步方法，同步监视器是：当前类本身，即 类.class
```



## 线程的死锁问题

#### 死锁

+ 不同线程分别占用对方需要的同步资源不放弃，都在等待对方放弃自己需要的同步资源，就形成了线程的死锁
+ 出现死锁后，不会出现异常，不会出现提示，只是所有的线程都处于阻塞状态，无法继续

解决方法

+ 专门的算法、原则
+ 尽量减少同步资源的定义
+ 尽量避免嵌套同步





# Day28 2020/9/24

## 线程的同步

### Lock（锁）

+ JDK5.0后，Java提供了更强大的线程同步机制——通过显示定义同步锁对象来实现同步。同步锁使用Lock对象充当

+ java.util.concurrent.locks.Lock接口是控制多个线程对共享资源进行访问的工具。
+ 锁提供了对共享资源的独占资源的独占访问，每次只能有一个线程对Lock对象加锁，线程开始访问共享资源之前应先获得Lock对象
+ ReentrantLock类实现了Lock，它拥有与synchronized相同的并发性和内存语义，在实现线程安全的控制中，比较常用的是ReentrantLock，可以显示加锁、释放锁 



### synchronized与Lock的对比

+ Lock是显式锁（手动开启和关闭），synchronized是隐式锁，出了作用域就自动释放
+ Lock只有代码块锁，synchronized有代码块锁和方法锁
+ 使用Lock锁，JVM将花费较少的时间来调度线程，性能更好。并且具有更好的扩展性（提供更多的子类）



优先使用顺序：

Lock --> 同步代码块 （已经进入了方法体，分配了相应资源） --> 同步方法（在方法体之外）



### 线程的通信

```
* 线程通信的例子，使用两个线程打印1-100，线程1，线程2交替打印
*
* 涉及到的三个方法：
*  wait()：一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器
*  notify()：一旦执行此方法，就会唤醒被wait()的一个线程，如果有多个线程被wait，就唤醒优先级高的线程
*  notifyAll()：一旦执行此方法，就会唤醒所有被wait的线程
*
*  说明：
*      1.wait()和notify()和notifyAll()必须只能使用在同步代码块或同步方法中
*      2.同时三个方法的调用者必须是同步代码块或同步方法中的同步监视器
*      否则会出行IllegalMonitorStateException异常
*      3.三个方法定义在java.lang.Object类中
*
*  面试题：sleep() 和 wait() 的异同
*  1. 相同点：一旦执行方法，都可以使得当前的线程进入阻塞状态
*  2. 不同点：1）两个方法声明的位置不同：Thread类中声明sleep()，Object类中声明wait()
*            2）调用的要求不同，sleep()可以在任何需要的常见下调用，wait()必须使用在同步代码块或同步方法中
*            3）关于是否释放同步监视器：如果两个方法都使用在同步代码块或同步方法中，sleep()不会释放锁，wait()会释放锁
*            4）sleep()会自动唤醒，wait()需要手动唤醒
```



## JDK5.0新增线程创建方式

### 实现Callable接口

+ 比Runnable功能更强大
+ 相比run()方法，可以有返回值
+ 方法可以可以异常
+ 支持泛型的返回值
+ 需要借助FutureTask类，比如获取返回结果



Future接口

+ 可以对具体的Runnable、Callable任务的执行结果进行取消、查询是否完成、获取结果等
+ FutureTask是Future接口的唯一实现类
+ FutureTask同时实现了Runnable和Future接口，它既可以作为Runnable被线程执行，又可以作为Future得到Callable的返回值



#### 如何理解实现Callable接口的方式比实现Runnable接口创建多线程方式强大？

+ call()可以有返回值
+ call()可以抛出异常，被外面的操作捕获，获取异常的信息
+ Callable是支持泛型的



### 实现线程池

提前创建好多个线程，放入线程池中，使用时直接获取，使用完放回池中，可以避免频繁创建销毁、实现重复利用。类似公共交通工具。

好处

+ 提高响应速度（减少了创建新线程的世界）
+ 减低资源消耗（重复利用线程 池中线程，不需要每次都创建）
+ 便于线程管理
    + corePoolSize：核心池的大小
    + maximumPoolSize：最大线程数
    + keepAliveTime：线程没有任务时最多保持多长时间后终止



注：状态的切换都有相应的回调方法，需要写则可以去重写。



### 释放锁的操作

+ 当前线程的同步方法、同步代码块执行结束
+ 当前线程在同步代码块、同步方法中遇到break、return终止了该代码块、该方法的继续执行
+ 当前线程在同步代码块、同步方法中出现了未处理的Error或Exception，导致异常结束
+ 当前线程在同步代码块、同步方法中**执行了线程对象的wait()方法**，当前线程暂停，并**释放锁**



### 不会释放锁的操作

+ 线程执行同步代码块或同步方法时，程序调用Thread.sleep()、Thread.yield()方法暂停当前线程的执行

+ 线程执行同步代码块时，其他线程调用了该线程的suspend()方法将该线程挂起，该线程不会释放锁（同步监视器）。
    + **应尽量避免使用suspend()和resume()来控制线程**





## 字符串相关的类

**String为不可变的字符序列**

Java程序中所有字符串字面值（如“ABC”）都作为String类的实例实现

+ String是一个**final类**，代表不可变的字符序列

+ 字符串时常量，创建后就不能更改
+ String对象的字符内容是存储在一个字符数组value[]中的



```
String:字符串，""引起来
* 1.String声明为final的，不可被继承
* 2.String实现了Serializable接口：表示字符串时支持序列化的
*         实现了Comparable接口：表示String可以比较大小
* 3.String内部定义了final char[] ，value用于存储字符串数据
* 4.String：代表不可变的字符序列，简称：不可变性
*      体现：1）当对字符串重新赋值时，需要重写指定内存区域赋值，不能使用原有的value进行赋值
*           2）当对现有字符串进行连接操作时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值
*           3) 当调用String的replace()方法修改指定字符或字符串时，也同上
* 5.通过字面量的方式（区别于new）给一个字符串赋值，此时的字符串值声明在字符串常量池中
* 6.字符串常量池中是不会存储相同内容的字符串的
*
*面试题： String s = new String("abc"); 方式创建对象，在内存中创建了几个对象？
     *      两个：一个是堆空间中new结构，另一个是char[]对应的常量池中的数据"abc"
     *      当然如果已经有存在"abc“，就直接拿来用，而不需要再创建了
```



+ 常量与常量的拼接结果在常量池，且常量池中不会存在相同内容的常量
    + 注意只要加了final关键字，就变成常量了，还是会在常量池内进行拼接
    + 所谓相同内容，指的是使用String类的equals()比较，返回true
+ 只要其中有一个是变量，结果就在堆中
+ 如果拼接的结果调用intern()，返回值就在常量池中



# Day29 2020/9/25

## JVM中涉及到字符串的内存结构

### Heap堆

一个JVM实例只存在一个堆内存，堆内存的大小是可以调节的。

类加载器读取了类文件后，需要把类、方法、常变量放到堆内存中，保存所有引用类型的真实信息，以方便执行器执行



堆内存分为三部分：

+ 新生区：Young
+ 养老区：Old
+ 永久存储区：Perm



在JDK 1.6 中 字符串常量池在方法区中，方法区具体实现：**永久代**

在JDK 1.7中 字符串常量池在堆空间中

在JDK 1.8 中 字符串常量池在方法区中，方法区具体实现：**元空间**



## String常用方法

+ int length()
+ char charAt(int index)，返回某索引处的字符
+ boolean isEmpty()，判断是否是空字符串
+ String toLowerCase()，使用默认语言环境，将String中所有字符转换为小写
+ String toUpperCase()，使用默认语言环境，将String中所有字符转换为大写
+ String trim()，返回字符串的副本，忽略前导空白和尾部空白
+ boolean equals(Object obj)，比较字符串的内容是否相同
+ boolean equalsIgnoreCase(String anotherString)，与equals方法类似，忽略大小写
+ String concat(String str)，将指定字符串连接到此字符串的尾部，等价于用“+”
+ int compareTo(String anotherString)，比较两个字符串的大小
+ String subString(int beginIndex)，返回一个新的字符串，它是此字符串的从beginIndex开始截取到最后一个子字符串
+ String substring(int beginIndex, int endIndex)，返回一个新字符串，它是此字符串从beginIndex开始截取到endIndex(不包含)的一个子字符串
+ boolean endsWith(String suffix)，测试此字符串是否以指定的后缀结束
+ boolean startsWith(String prefix)，测试此字符串是否以指定的前缀开始
+ boolean startsWith(String prefix, int toffset)，测试此字符串从指定索引开始的子字符串是否以指定的前缀开始
+ boolean contains(CharSequence s)，当且仅当此字符串包含指定的char值序列时，返回true
+ int indexOf(String str)，返回指定字符串在此字符串中第一次出现处的索引
+ int indexOf(String str, int fromIndex)，返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始
+ int lastIndexOf(String str)，返回指定子字符串在此字符串中最右边出现处的索引
+ int lastIndexOf(String str, int fromIndex)，返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索
    + 注indexOf和lastIndexOf方法如果未找到都是返回-1
+ String replace(char oldChar,char newChar)，返回一个新的字符串，它是通过用newChar替换此字符串中出现的所有oldchar得到的。
+ String replace(CharSequence target,CharSequence replacement)，使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。
+ String replaceAll(String regex,String replacement)，使用给定的replacement替换此字符串所有匹配给定的正则表达式的子字符串。
+ string replaceFirst(String regex,String replacement)，使用给定的replacement替换此字符串匹配给定的正则表达式的第一个子字符串。
+ boolean matches(String regex)，慧知此字符串是否匹配给定的正则表达式
+ tringsplit(String regex)，根据给定正则表达式的匹配拆分此字符串。
+ string split(String regex，int limit)，根据匹配给定的正则表达式来拆分此字符串，最多不超过limit个，如果超过了，剩下的全部都放到最后一个元素中



### String与其他结构之间转换

```
* String 与 基本数据类型、包装类之间的转换
*      String --> 基本数据类型、包装类：调用包装类的静态方法，parseXxxx(Str)
*      基本数据类型、包装来 --> String：调用String重载的valueOf(xxx)
*
* String 与 char[] 之间的转换
*      String --> char[]： 调用String的toCharArray()
*      char[] --> String： 调用String的构造器
*
* String 与 byte[] 之间的转换
*      String --> byte[]：调用String的getBytes()
*      byte[] --> String：调用String的构造器
```



### String 常见算法题

+ 获取两个字符串中最大相同子串
    + 将短的哪个串进行长度一次递减的子串与较长的串比较
+ 对字符串中字符进行自然顺序排序
    + 字符串变成字符数组
    + 对数组排序，选择，冒泡，Arrays.sort()
    + 将排序后的数组变成字符串

+ 模拟trim方法，去除字符串两端的空格
+ 将一个字符串进行反转。将字符串中指定部分进行反转。
+ 获取一个字符串在另一个字符串中出现的次数





## StringBuffer和StringBuilder类

**可变的字符序列**



#### String、StringBuffer、StringBuilder三者的异同

+ String是不可变的字符序列，另两个事可变的
    + 底层是使用final char[]存储的
    + 会存在大量的字符串创建和回收，因此内存的消耗会较大
+ StringBuffer是线程安全的，但是效率低
    + 底层是使用char[]动态存储的
+ StringBuilder是JDK5.0新增的，线程不安全的，效率高
    + 底层是使用char[]动态存储的

效率：StringBuilder > StringBuffer > String



#### 源码分析

```
源码分析：
        String str = new String(); // char[] value = new char[0];
        String str1 = new String("abc); // char[] value = new char[]{'a', 'b', 'c'};


        StringBuffer sb1 = new StringBuffer(); // char[] value = new char[16]; 底层创建了一个长度是16的字符数组
        sb1.append('a'); // value[0] = 'a';
        sb1.append('b'); // value[1] = 'b';

        StringBuffer sb2 = new StringBuffer("abc"); // char[] value = new char["abc".length() + 16];

        // 问题1. sout(sb2.length()); 打印
        // 问题2. 扩容问题：如果要添加的数据顶层数组盛不下了，
             默认情况下，扩容为原来容量的 2倍+2 ，同时将原有数组中的元素复制到新的数组中
             特殊情况，默认扩容还不够的触发特殊情况

指导意义：建议使用StringBuffer(int capacity)或StringBuilder(int capacity)
```



### StringBuffer类的常用方法

+ append(xxx)：用于进行字符串拼接
+ delete(int start, int end)：删除指定位置的内容
+ replace(int start, int end, String str)：把[start, end)位置替换为str
+ insert(int offset, xxx)：在指定位置插入xxx
+ reverse()：把当前字符序列逆转

注：

+ StringBuilder类的方法与StringBuffer一样就是没同步而已

+ 当append和insert时，原有value数组长度不够，可扩容

+ 如上方法支持方法链操作

    + ```java
         @Override
            public synchronized StringBuffer append(int i) {
                toStringCache = null;
                super.append(i); // 拼接字符串
                return this; // 将原本的对象返回出去，因此可以继续 . 调用下一个方法
            }
        ```

        

## JDK 8 之前日期时间API

```
java.util.Date类
    |--- java.sql.Date类

1.两个构造器的使用
    >构造器1：Date()：创建一个对应当前时间的Date对象
    >构造器2：创建指定毫秒数的Date对象
2.两个方法的使用
    >toString()：显示当前的年、月、日、时、分、秒
    >getTime()：获取当前Date对象对应的毫秒数。（时间戳）
3.java.sql.Date 对应着数据库中的日期类型的变量
    >如何实例化
    >如何将java.util.Date对象转换为java.sql.Date对象
    
// 将java.util.Date对象转换为java.sql.Date对象
// 情况一：
Date date4 = new java.sql.Date(1601027147376L); // 子类赋给父类，多态
java.sql.Date date5 = (java.sql.Date) date4; // 再强转成sql.Date
// 情况二：
Date date6 = new Date(); // 这里new的就是父类对象，没办法再强转成子类的对象了
// java.sql.Date date7 = (java.sql.Date) date6; // 编译不报错，运行报错
java.sql.Date date7 = new java.sql.Date(date6.getTime()); // 二者共通的就是时间戳
```

 



# Day30 2020/9/27

## JDK 8 之前日期时间API

### java.text.simpleDateFormat类

```java
SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析、
1. 两个操作
1.1 格式化：日期 ---> 字符串
1.2 解析：格式化的逆过程：字符串 ---> 日期
// 实例化SimpleDateFormat
SimpleDateFormat sdf = new SimpleDateFormat();

// 格式化： 日期 ---> 字符串
Date date = new Date();
System.out.println(date);

String format = sdf.format(date); // 20-9-27 上午9:12 默认解析
System.out.println(format);

String str0 = "19-9-27 下午9:12";
Date parse1 = sdf.parse(str0); // 默认行为
System.out.println(parse1);

// 解析：格式化的逆过程：字符串 ---> 日期
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm:ss aaa");
// 指定方式格式化和解析：调用带参的构造器
// 格式化
SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
String format1 = sdf1.format(date);
System.out.println(format1); // 2020.09.27 09:22:09
// 解析：要求字符串要满足 自己定义的sdf 的格式。否则无法识别抛出异常
Date parse = sdf1.parse(format1);
System.out.println(parse);
```



### java.util.Calendar（日历）类

+ 主要用于完成日期字段之间操作的公共
+ 该类是个抽象类
+ 获取Calendar实例的方法
    + 调用Calendar.getInstance()方法
    + 调用它的子类GregorianCalendar的构造器
+ calendar是可变的
+ 年份是从1900年开始的

注意：

+ 获取月份时：一月是0，12月是11
+ 获取星期时，周日是1，周一是2，周六是7
+ 没办法直接格式化Calendar，需要转换成Date
+ 线程不安全，不能处理闰秒



## JDK 8 中新日期时间API

旧的Date类的构造器（指定年月日）并不是真的是输入的年月日，它会调用Calendar类来创建日期，并且有一定的偏移量，偏移了1900年

所以用Date类来创建指定年月日的日期时要减去1900年才能得到想要的年份

JDK8 吸收了Joda-Time的精华。

新时间日期API

+ java.time：包含值对象的基础包
+ java.time.chrono：提供对不同的日历系统的访问
+ java.time.format：格式化和解析时间和日期
+ java.time.temporal：包括底层框架和扩展特性
+ java.time.zone：包含时区支持的类



#### LocalTime LocalDate LocalDateTime的使用

```java
// now()：获取当前的日期，时间，日期+时间
LocalDate localDate = LocalDate.now();
LocalTime localTime = LocalTime.now();
LocalDateTime localDateTime = LocalDateTime.now();

System.out.println("localDate = " + localDate);
System.out.println("localTime = " + localTime);
System.out.println("localDateTime = " + localDateTime);

// of()：设置指定的 年月日时分秒，没有偏移量
LocalDateTime localDateTime1 = LocalDateTime.of(2020, 9, 26, 13, 24, 52);
System.out.println(localDateTime1);

// getXxx()：获取指定日期或时间
System.out.println(localDateTime.getDayOfMonth()); // 27
System.out.println(localDateTime.getDayOfWeek()); // SUNDAY
System.out.println(localDateTime.getDayOfYear()); // 271
System.out.println(localDateTime.getMonthValue()); // 9
System.out.println(localDateTime.getMonth()); // SEPTEMBER
System.out.println(localDateTime.getYear()); // 2020
System.out.println(localDateTime.getHour()); // 10
System.out.println(localDateTime.getMinute()); // 43
System.out.println(localDateTime.getSecond()); // 13

// withXxxx()：设置时间和日期
LocalDateTime localDateTime2 = localDateTime1.withDayOfMonth(28); // 返回新的对象，体现不可变性
System.out.println(localDateTime2);

// 加减操作
LocalDateTime localDateTime3 = localDateTime2.plusMonths(3);// 加上三个月
System.out.println(localDateTime3);
localDateTime3 = localDateTime3.plusMonths(-1);// 加上一个负的等于减去正的
System.out.println(localDateTime3);
LocalDateTime localDateTime4 = localDateTime3.minusWeeks(1);// 减去一个星期
System.out.println(localDateTime4);
```

java.time包是基于纳秒计算的

1 ns = 10^-9 s

1 秒 = 1000 毫秒 = 10^6 微秒 = 10^9 纳秒



### Instant（瞬时）类

+ 时间线上的一个瞬时点，可能用来几率应用程序中的实践时间戳

```java
/*
            Instant类使用
            类似于java.util.Date
         */
        // 实例化 now()：获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant); // 2020-09-27T03:05:15.606Z 差了8个小时 算的是本初子午线的时间

        // 添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime); // 2020-09-27T13:09:52.169+08:00

        // 获取自1970年1月1日0时0分0秒（UTC）到现在的毫秒数 --> Date.getTime()
        long milli = instant.toEpochMilli();
        System.out.println(milli);

        // 通过毫秒数来创建对象 ofEpochMilli()：通过给定的毫秒数，获取Instant实例 ---> Date(long milli)
        Instant instant1 = Instant.ofEpochMilli(1601183528121L);
        System.out.println(instant1);
```



### DateTimeFormatter格式化时间

```java
/*
    DateTimeFormatter：格式化或解析日期、时间
    类似于SimpleDateFormat
 */
// 方式一：预定义的标准格式：如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
// 格式化 日期 --> 字符串
LocalDateTime localDateTime = LocalDateTime.now();
System.out.println(localDateTime);
String format = formatter.format(localDateTime);
System.out.println(format);
// 解析：字符串 --> 日期
TemporalAccessor parse = formatter.parse(format);
System.out.println(parse);

// 方式二：本地化相关的格式：如：ofLocalizedDateTime(FormatStyle.LONG)
// 本地相关的格式：如ofLocalizedDateTime()
// FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT : 适用于 LocalDateTime
DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
// 格式化 Long: 2020年9月27日 下午01时31分13秒   SHORT:20-9-27 下午1:31    MEDIUM:2020-9-27 13:32:10
String format1 = formatter1.format(localDateTime);
System.out.println(format1);
// 解析
TemporalAccessor parse1 = formatter1.parse("2020年9月27日 下午01时31分13秒");
System.out.println(parse1); // 必须要与格式化时的格式一致，不然抛异常


// ofLocalizedDate()
// FormatStyle.FULL / FormatStyle.lONG / FormatStyle.MEDIUM / FirmatStyle.SHORT 适用于 LocalDate
// 2020年9月27日 星期日 / 2020年9月27日 / 2020-9-27 / 20-9-27
DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
// 格式化
String format2 = formatter2.format(LocalDate.now());
System.out.println(format2);


// 方式三（重点）：自定义的格式，如：ofPattern("yyyy-MM-dd hh:mm:ss E")
DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
// 格式化
String format3 = formatter3.format(LocalDateTime.now());
System.out.println(format3); // 2020-09-27 01:44:49
// 解析
TemporalAccessor parse2 = formatter3.parse("2020-09-27 05:05:05");
System.out.println(parse2);
// {SecondOfMinute=5, HourOfAmPm=5, NanoOfSecond=0, MicroOfSecond=0, MinuteOfHour=5, MilliOfSecond=0},ISO resolved to 2020-09-27
```



#### 使用LocalDateTime自带的parse来解析时间

```java
// 通过LocalDateTime自带的parse来解析时间
LocalDateTime now = LocalDateTime.now();
System.out.println(now);
LocalDateTime localDateTime = LocalDateTime.parse("2020-09-27T13:54:36.469"); // 不指定解析格式时用默认的
System.out.println(localDateTime);
System.out.println(LocalDateTime.parse("2020-09-27 05:05:05", DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
System.out.println(LocalDateTime.parse("2020-09-27 05:05:05", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))); // 用小写的h会抛异常
```



### 其他API

+ ZoneId：该类中包含了所有的失去信息，一个时区的ID
+ ZonedDateTime：一个在ISO-8601日历系失去的日期时间
    + 其中每个时区都对应着ID，地区ID都为“{区域}/{城市}”，如：Asia/Shanghai等
+ Clock：使用失去提供对当前即时/日期和时间的访问的时钟
+ 待续时间：Duration，用于计算两个时间间隔
+ 日期间隔：Period，用于计算两个日期间隔
+ TemporalAdjuster：时间矫正器，比如将日期调整到下一个工作日等
+ TemporalAdjusters：提供了大量静态方法，是对于TemporalAjuster的实现



## Java的比较器

对象之间的比较问题

+ 自然排序：java.lang.Comparable
+ 定制排序：java.util.Comparator



Java中的对象，一般只能进行 == 或 != 的比较，不能使用 > 或 <的

但是在开发中会涉及到这样的对象比较

这就需要这两个接口了 



#### Comparable接口的使用     自然排序

```
1. 像String及包装类等实现了Comparable接口，重写了compareTo(obj)方法给出了比较两个对象大小的方法
2. 像String及包装类重写compareTo()方法后，进行从小到大的排列
3，重写compareTo()的规则：
        如果当前对象this大于形参对象obj，则返回正整数
                       小于                  负整数
                       等于                   0
4. 对于自定义类来说，如果需要排序，可以让自定义类实现Comparable接口，重写compareTo()方法
    在compareTo()方法中指明如何排序
```

#### Comparator接口的使用    定制排序

```
1. 背景
    当元素的类型没有实现java.lang.Comparable接口又不方便修改代码
    或者实现了java.lang.Comparable接口的排序规则不适合当前的操作
    那么就可以考虑使用Comparator
2. 重写compare(Object o1, Object o2)方法，比较o1和o2的大小
        如果方法返回正整数，则表示 o1 大于 o2
                   负整数            小于
                   0                 等于
```

二者对比

+ Comparable接口的方式一旦一定，保证comparable接口实现类的对象在任何位置都可以比较大小
+ Comparator接口属于临时性的比较（应该也可以用实现类当作comparable那样的使用）



## System类

系统的很多属性和控制方法都在该类内部，位于java.lang包内

该类时private的，无法创建该类对象，内部方法和变量都是static的

+ System类内部包含in、out和err三个成员变量，分别代表标准输入流（键盘输入），标准输出流（显示器）和标准错误输出流（显示器）

+ 成员方法
    + native long currentTimeMills()
        + 返回当前计算机时间，时间戳，标准GMT时间
    + void exit(int status)
        + 退出程序，status的值为0代表正常退出，非0代表异常退出
        + 使用该方法可以在图形界面编程中实现程序的退出功能
    + void gc()
        + 请求系统进行垃圾回收
        + 系统是否会立刻进行回收，取决于系统中垃圾回收算法的实现以及系统执行时的情况
    + String getProperty(String key)
        + 获取系统中属性名为key的属性对应的值
        + 系统中常见的属性及作为如下：
            + java.version：java运行时环境版本
            + java.home：java安装目录
            + os.name：操作系统的名称
            + os.version：操作系统的版本
            + user.name：用户的账户名称
            + user.home：用户的主目录
            + user.dir：用户的当前工作目录
    + getProperties()
        + 一次性返回所有系统的属性



## Math类

java.lang.Math类提供了一系列静态方法用于科学计算，其方法的参数和返回值类型一般都是double型

+ abs，绝对值
+ sqrt，平方根
+ pow(double a, double b)，a的b次幂
+ exp，e为底指数
+ random，返回0.0到1.0的随机数
+ long round(double a)，double 型数据a转换为long型（四舍五入）
+ toDegrees(double angrad)，弧度 --> 角度
+ toRadians(double angdeg)，角度 --> 弧度



## BigInteger与BigDecimal类

##### BigInteger

+ Integer类作为int的包装类，能存储的最大整数型值为2^31-1，Long类也是有限的，最大为2^63-1
+ 如果要表示再大的整数，就无能为力了
+ java.math包的BigInteger可以表示**不可变的任意精度的整数**
    + 提供了Java的基本整数操作符的对应物，并提供java.lang.Math的所有相关方法
    + 另外，BigInteger还提供了：
        + 模运算
        + GCD计算
        + 质数测试
        + 素数生成
        + 位操作
        + 以及一些其他的操作
+ 构造器
    + BigInteger(String val)，根据字符串构建BigInteger对象



##### BigDecimal

+ 一般的Float类和Double类可以用来做科学计算或工程计算
+ 但在商业计算中，要求数字精度比较高，所以用到java.math.BigDecimal类

+ BigDecimal类支持不可变的、任意精度的有符号十进制定点数
+ 构造器
    + public BigDecimal(double val)
    + public BigDecimal(String val)
+ 常用方法
    + add()
    + subtract()
    + multiply()
    + divide()

+ 使用参数为float或double的BigDecimal创建对象会丢失精度
    +  使用BigDecimal(String val)的构造方法创建对象
        `new BigDecimal("1.745");`
        `new BigDecimal("0.745");`
    + 使用使用BigDecimal的valueOf(double val)方法创建对象
        `BigDecimal.valueOf(1.745);`
        `BigDecimal.valueOf(0.745);` 



# Day31 2020/9/28

## 枚举类

JDK5.0之前需要自定义枚举类



**当需要定义一组常量时，强烈建议使用枚举类**。前提是类的对象是有限个，确定的。

如果枚举类中只有一个对象，则可以作为单例模式的实现方式



### 如何定义枚举类

+ jdk5.0 之前，自定义枚举类
+ jdk5.0，使用enum关键字定义枚举类



枚举类默认继承与java.lang.Enum类，并且该类重写过toString()方法了，当然还可以再重写

**Enum类的主要方法**

+ values()方法：返回枚举类型的对象数组，该方法可以很方便地遍历所有的枚举值
+ valueOf(String str)：可以把一个字符串转为对应的枚举类对象。要求字符串必须是枚举类对象
+ toString()：返回当前枚举类对象常量的名称

```java
// Enum类的toString()
System.out.println(summer); // SUMMER 没有自己重写时，打印枚举的对象的变量名
System.out.println(Season2.class.getSuperclass()); // java.lang.Enum
// Enum类的values()
Season2[] values = Season2.values();
System.out.println(Arrays.toString(values));
// Enum类的valueOf(String objName)：返回枚举类中对象名是objName的对象
Season2 winter = Season2.valueOf("WINTER"); // 如果没有objName的枚举类对象，则抛异常：IllegalArgumentException
System.out.println(winter);
```



**使用enum关键字定义的枚举类实现接口的情况**

+ 实现接口，在enum类中实现抽象方法
+ 让枚举类的对象分别实现抽象方法



## 注解（Annotation）

jdk5.0的新增

+ Annotation其实就是代码里的**特殊标记**，可以在编译、类加载、运行时被读取，并执行相应的处理。

+ 通过使用注解，可以在不改变原有的逻辑下，在源文件中嵌入一些补充信息。

+ 代码分析工具、开发工具和部署工具可以通过这些补充信息进行验证或者进行部署

+ Annotation可以像修饰符一样被使用，可以用于修饰包、类、构造器、方法、成员变量、参数、局部变量的声明
    + 这些信息被保存在Annotation的“name=value"对中
+ 一定程度上可以说，框架 = 注解 + 反射 + 设计模式 



在编译时进行格式检查（JDK内置的三个基本注解

+ @Override：限定重写父类方法，该注解只能用于方法
+ @Deprecated：用于表示所修饰的元素（类，方法等）已过时，通常是因为所修饰的结构危险或存在更好的选择
+ @SuppressWarnings：抑制编译器警告



跟踪代码依赖性，实现替代配置文件功能



### 自定义注解

参考 @SuppressWarnings 来定义

+ 注解声明，使用@interface关键字

```
public @interface MyAnnotation {
}
```

+ 自定义注解自动继承了java.lang.annotation.Annotation接口
+ Annotation的成员变量在Annotation定义中以无参数方法的形式来说明
    + 其方法名和返回值定义了该成员的名字和类型，称之为配置参数
    + 类型只能是八种基本数据类型
        + String类型、Class类型、enum类型、Annotation类型以上所有类型的数组
+ 可以在定义Annotation的成员变量时为其指定初始值，指定成员变量的初始值可使用default关键字
+ 如果只有一个参数成员，建议使用参数名为value
+ 如果定义的注解含有配置参数，那么使用时必须指定参数值，除非它有默认值。
    + 格式是“参数名 = 参数值”
    + 如果只有一个参数成员，且名称为value，可以省略“value = ”

+ 没有成员定义的Annotation称为标记
+ 包含成员变量的Annotation称为元数据Annotation

注意：**自定义注解必须配上注解的信息处理流程才有意义**



**自定义注解过程：**

+ 注解声明为：@interface
+ 内部定义成员，通常使用value表示
+ 可以指定成员的默认值，使用default定义
+ 如果自定义注解没有成员，表明是表示的作用

如果注解有成员，在使用注解时，需要指明成名的值（有默认值则无需指定值）

自定义注解必须配上注解的信息处理流程（使用反射）才有意义



# Day32 2020/9/29

jdk提供了4种元注解

+ 用于修饰其他Annotation定义

+ jDK5.0提供了4个标准的meta-annotation类型
    + Retention
        + 只能用于修饰一个Annotation定义，用于指定该Annotation的声明周期
        + @Rentention包含一个RetentionPolicy类型的成员变量，使用@Rentention时必须为该value成员变量指定值
            + RetentionPolicy.SOURCE：在源文件中有效（即源文件保留），编译器直接丢弃这种策略的注释
            + RetentionPolicy.CLASS：在class文件中有效（即class保留），当运行Java程序时，JVM不会保留注解，这是默认值。当不标明这个注解时，注解的声明周期就是该状态
            + RetentionPolicy.RUNTIME：在运行时有效（即运行时保留），当运行Java程序时，JVM会保留注解，**程序可以通过反射获取该注解 
    + Target
        + 用于指定被修饰的Annotation能用于修饰哪些程序元素
    + Documented
        + 用于指定该元注解修饰的Annotation类将被javadoc工具提取成文档，默认情况下，Javadoc是不包括注解的
        + 定义为Documented的注解必须设置Retention值为RUNTIME
    + Inherited
        + 被它修饰的Annotation将具有继承性
        + 如果某个类使用了被@Inherited修饰的Annotation，则其子类将自动具有该注解
            + 子类继承父类类级别的注解
            + 实际应用中，使用较少
+ 元数据（数据库中）的理解：对现有数据进行修饰的数据
+ 元注解：对现有注解进行注解的注解
+ 定义注解通常指明两个元注解：Retention和Target

通过反射获取注解信息



### JDK8注解新特性

**可重复注解**

+ 在MyAnnotation上声明@Repeatable，成员值为 MyAnnotations.class
+ MyAnnotation的@Target和@Retention和MyAnnotations相同
    + 不同的话，直接编译出错
+ MyAnnotation要有@Inherited的话，MyAnnotations就必须也要加上
    + 不加的话，编译不出错但运行时会报错

**类型注解**

+ 在JDK1.8之后，关于元注解@Target的参数类型ElementType枚举值多了两个
    + TYPE_PARAMETER
    + TYPE_USE
+ 在Java8之前，注解只能是在声明的地方所使用，Java8开始，注解可以应用在任何地方
    + ElementType.TYPE_PARAMETER 表示该注解能写在类型变量的声明语句中
        + （如：类中，方法中泛型声明）
        + 但是方法上类的泛型、变量上类的泛型，还需要使用TYPE_USE才可以
    + ElementType.TYPE_USE 表示该注解能写在使用类型的任何语句中



## Java集合

Java集合就像一种容器，可以动态地把多个对象的引用放入容器中

**数组在内存存储方面的特点：**

+ 数组初始化以后，长度就确定了

+ 数组声明的类型，就决定了进行元素初始化时的类型
    + 当然如果定义成 Object[] arr，还是可以放入不同的子类对象的

**数组在存储数据方面的弊端：**

+ 数组初始化后，长度就不可变了，不便于扩展
+ 数组中提供的属性和方法少，不便于进行添加、删除、插入等操作，且效率不高，**同时无法直接获取存储元素的个数**
+ 数组存储的数据时**有序的，可以重复的** ---> 存储数据的特点单一
    + 无序的、不可重复的需求，不能满足



Java集合类可以用于存储数量不等的多个对象，还可用于保存具有映射关系的关联数组

集合中还是用到了数组



Java集合可分为Collection和Map两种体系

+ Collection接口：单列数据，定义了存取一组对象的方法的集合

    + List：元素有序、可重复的集合
    + Set：元素无序、不可重复的集合

+ Map接口：双列数据，保存具有映射关系“key-value对”的集合

    

![image-20200929123911905](C:\Users\Jarvis\AppData\Roaming\Typora\typora-user-images\image-20200929123911905.png)

![image-20200929123959514](C:\Users\Jarvis\AppData\Roaming\Typora\typora-user-images\image-20200929123959514.png)

### 集合框架

|----Collection接口：单列集合，用来存储一个一个的对象

​		|----List接口：存储有序、可重复的数据	---> ”动态“数组

​				|----ArrayList、LinkedList、Vector

​		|----Set接口：存储无序的、不可重复的数据	---> 高中讲的”集合 “

​				|----HashSet、LinkedHashSet、TreeSet

|----Map接口：双列集合，用来存储一堆（key - value）一堆的数据 	键值对

​		|----HashMap、LinkedHashMap、TreeMap、Hashtable、Properties



#### Collection接口中的方法

+ add(Object e)：将元素e添加到集合coll中

+ size()：获取添加的元素的个数

+ addAll(Collection coll2):将coll2集合中的元素添加到当前的集合中
+ clear()：情况集合元素
+ isEmpty()：判断当前集合是否为空
+ contains(Object obj)：判断当前集合中是否包含obj，会调用obj对象所在类的equals()
    + 因此向Collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals()
+ containsAll(Collection coll2)：判断形参coll2中的所有元素是否都存在于当前集合中
+ remove(Object obj)：从当前集合中移除obj元素
+ removeAll(Collection coll2)：差集：从当前集合中移除coll1中所有的元素
+ retainAll(Collection coll3)：交集:获取当前集合和coll3集合的交集，并返回给当前集合
+ equals(Object obj)：比较元素是否一一对应相等，按顺序比较
+ hashCode()：返回当前对象的哈希值
+ toArray()：集合 ---> 数组：toArray()
    + 数组 ---> 集合：Arrays.asList()
+ iterator()：返回Iterator接口的实例，用于遍历集合元素



注意：向Collection接口的实现类的对象中添加数据Obj时，要求Obj所在类要重写equals()，在contains和remove时都会调用equals()方法



### Iterator迭代器接口

#### 使用Iterator接口遍历集合元素

+ Iterator对象成为迭代器（设计模式的一种），主要用于遍历Collection集合中的元素
+ GOF给迭代器模式的定义为：**提供一种方法访问一个容器（container）对象中各个元素，而又不需暴露该对象的内部细节。迭代器模式，就是为容器而生**
+ Collection接口继承了java.lang.Iterable接口，该接口有一个iterator()方法
    + 因此所有实现了Collection接口的集合类都有一个iterator()方法，用以返回一个实现了Iterator接口的对象
+ Iterator仅用于遍历集合，Iterator本身并不提供承装对象的能力。
    + **如果需要创建Iterator对象，则必须有一个被迭代的集合**
+ **集合对象每次调用iterator()方法都得到一个全新的迭代器对象**，默认游标都在集合的第一个元素之前



内部的方法：hasNext() 和 next()

+ hasNext()
    + 判断是否还有下一个元素
+ next()
    + 指针下移
    + 将下移以后集合位置上的元素返回



default方法：remove()

+ 从集合中移除遍历到的iterator对应的元素
+ 此方法不同于集合直接调用remove()
    + 底层的实现不一样
+ 在没有调用next()前，一定不要调用remove()，不然就会抛异常IllegalStateException
+ 并且在下一次调用next()前，也不能重复调用remove()



jdk5.0新增了foreach循环，用于遍历集合、数组

```java
Collection coll = new ArrayList();
coll.add("AA");
coll.add('c');
coll.add(123); // 自动装箱
coll.add(456.7890313);
coll.add(false);
coll.add(new Date());

// for(集合元素的类型 局部变量 : 集合对象)
for(Object obj : coll){ // 其实内部凋的还是迭代器
    System.out.println(obj);
}

int[] arr = new int[]{1,2,3,4,5,6};
// for(数组元素的类型 局部变量 : 数组对象)
for(int i : arr){
    System.out.println(i);
}
```



**Enumeration接口是Iterator迭代器的“古老版本”**

```
Enumeration stringEnum = new StringTokenizer("a-b*c-d-e-g", "-");
while (stringEnum.hasMoreElements()) {
    Object obj = stringEnum.nextElement();
    System.out.println(obj);
    /*
        a
        b*c
        d
        e
        g
     */
}
```







## List接口

+ 通常使用List替代数组
+ List集合类中**元素有序**、**且可重复**，集合中的每个元素都有其对应的顺序索引
+ List容器中的元素都对应一个整数型的序号记载其在容器中的位置，可以根据序号存取容器中的元素
+ JDK API中List接口的实现类常用的有：ArrayList、LinkedList和Vector



```
* ArrayL：作为List接口的主要实现类
*      线程不安全的，效率高
*      底层使用Object[] elementData存储
* LinkedList：
*      对于频繁的 插入 和 删除 操作，使用此类效率比ArrayList高
*      底层使用双向链表存储（上一个元素地址 | 元素值 | 下一个元素地址）
* Vector：作为List接口的古老实现类 jdk 1.0
*      线程安全的，效率低
*      底层使用Object[] elementData存储
*
* 异同？
* 同： 三个类都实现了List接口，存储数据的特点相同，存储有序的、可重复的数据
* 不同：见上
```



#### 关键字transient

java 的transient关键字为我们提供了便利，你只需要实现Serilizable接口，将不需要序列化的属性前添加关键字transient，序列化对象的时候，这个属性就不会序列化到指定的目的地中。



### ArrayList底层源码分析

ArrayList在jdk7和jdk8中不同

**jdk7情况下**

+ ArrayList list = new ArrayList();

+ 底层创建了长度是10的Object[] 数组elementData
+ 默认情况下扩容时，是扩容为当前容量的1.5倍。（这类似于StringBuilder
    + 当扩容1.5倍后还是小于所需容量，则直接扩容为所需容量
    + 当扩容到整型最大值时，就取整型的最大值

+ 将数组中的元素通过Arrays.copyOf()复制进新数组中
+ **建议开发中使用带参的构造器**：ArrayList list = new ArrayList(int capacity);
    + 这样能节省频繁扩容时所消耗的资源

**jdk8中的变化**：

+ ArrayList list = new ArrayList();
+ 底层Object[] elementData**初始化为{}**，**并没有创建长度为10的数组**
+ 第一次调用add()时，底层才创建了长度为10的数组，并将数据添加进elementData[0]内
+ 后续的添加和扩容与jdk7无异



jdk7的ArrayList的对象的创建类似于单例的饿汉式，而jdk8中的ArrayList的对象的创建类似于单例的懒汉式，延迟了数组的创建，节省内存



### LinkedList底层源码分析

+ LinkedList list = new LinkedList();

+ 内部声明了Node类型的first和last属性，默认值为null

+ list.add(123)； 将123封装到Node中，创建了Node对象

    + ```
        private static class Node<E> {
                E item;
                Node<E> next;
                Node<E> prev;
        
                Node(Node<E> prev, E element, Node<E> next) {
                    this.item = element;
                    this.next = next;
                    this.prev = prev;
                }
        }
        ```

    + 双向链表，灵活



### Vector底层源码分析

+ 初始化也是10长度的数组
+ 扩容默认扩容二倍
+ 线程安全的（但也不一定用，有Collections工具类中同步的方法更好用）



### List常用方法调用

除了实现Collection接口的方法外，List接口还有一些自己的方法

+ void add(int index, Object ele）：在index位置插入ele元素
+ boolean addAll(int index,Collection eles)：从index位置开始将eles中所有元素插入进去
+ Object get(int index)：获取指定index位置的元素
+ int indexOf(Object obj)：返回obj在集合中首次出现的位置，如果不存在就返回-1
+ int lastIndexOf(Object obj)：返回obj在当前集合中末次出现的位置，如果不存在返回-1
+ Object remove(int index)：移除指定index位置的元素，并返回此元素
+ Object set(int index, Object ele)：设置指定index位置的元素为ele
+ List subList(int fromIndex, int toIndex)：返回fromIndex到toIndex位置的左闭右开区间
+ size()：长度



**循环遍历List**

+ Iterator迭代器方式
+ forEach
+ 普通的循环



# Day33 2020/9/30

## Set接口

+ Set接口是Collection接口的子接口，**但是没有提供额外的方法**，使用的都是Collection中声明过的方法

+ Set集合不允许包含相同的元素，重复添加会操作失败
+ Set判断两个对象是否相同不是使用 == 运算符，而是根据equals()方法



```
*	   HashSet：作为Set接口的主要实现类
*          线程不安全
*          可以存储null值
*      LinkedHashSet：作为HashSet的子类，遍历其内部数据时，可以按照添加的顺序遍历
*      TreeSet：可以按照添加对象的指定属性，进行排序
```

Set：存储无序的、不可重复的数据

### 以HashSet为例说明

+ 无序性：
    + 不等于随机性
    + 存储的数据在底层数组中并非按照数组索引的顺序添加，而是根据数据的哈希值来决定的

+ 不可重复性
    + 保证添加的元素按照equals()判断时，不能返回true,即相同元素只能添加一个



**添加元素的过程**

+ 向HashSet中添加元素a，首先调用元素a所在类的hashCode()方法，计算元素a的哈希值
+ 此哈希值接着通过某种算法计算出在HashSet底层数组中的存放位置（即为索引位置）
+ 判断数组此位置上是否已经有元素
    + 没有其他元素b，则元素a添加成功    ---> 情况1
    + 有其他元素b（或以链表形式存在的多个元素），则比较元素a与元素b的hash值
        + 如果hash值不相同，则元素a添加成功    ---> 情况2
        + 如果hash值相同，进而需要调用元素a所在类的equals()方法
            + equals()返回true，元素a添加失败
            + equals()返回false，元素a添加成功    ---> 情况3



对于添加成功的情况2和情况3而言：元素与已经存在指定索引位置上数据以链表的方式存储
        jdk 7 ：元素a放到数组中，指向原来的元素
        jdk 8 ：原来的元素在数组汇总，指向元素a



#### hashCode()的重写

为何自动重写equals()和hashCode()时，**hashCode()方法中有31这个数字**？

+ 选择系数的时候要选择尽量大的系数，因为如果计算出来的hash地址越大，所谓的“冲突”就越少（冲突指的是计算得到的哈希值相同），查找起来效率也会提高。（减少冲突）
+ 并且31只占用5bits，相乘造成数据溢出的概率较小
+ 31可以由 i*31 == (i << 5) -1 来表示，现在很多虚拟机里面都有做相关优化（提高算法效率）
+ 31是一个素数，素数的作用就是如果用一个数字来乘以这个素数，那么最终出来的结果只能被素数本身和被乘数还有1来整除（也是在减少冲突）



注意：**向Set中添加的数据，其所在类一定要重写hashCode()和equals()，并且尽可能保持一致性。**

#### 重写hasCode()方法的基本原则

+ 在程序运行时，同一个对象多次调用hashCode()方法应该返回相同的值
+ 当两个对象的equals()方法比较返回true时，这两个对象的hashCode()方法的返回值也应相等
+ 对象中用作equals()方法比较的Field，都应该用来计算hashCode值



### LinkedHashSet的使用

+ LinkedHashSet作为HashSet的子类，在添加数据的同时，每个数据还维护两个引用
+ 记录此数据前一个数据和后一个数据
+ 优点：**对于频繁的遍历操作**，LinkedHashSet效率高于HashSet



### TreeSet使用

TreeSet和TreeMap采用**红黑树**的存储结构

特点：有序，查询速度比List快



```
向TreeSet中添加的数据，要求是相同类
两种排序方式：自然排序（实现compareTo()接口） 和 定制排序（Comparator）

自然排序中，比较两个对象是否相同的标准为：compareTo()返回0，不再是equals()
定制排序中，比较两个对象是否相同的标准为：compare()返回0，不再是equals()
```



# Day34 2020/10/1

## Map接口

```
* Map的实现类的结构：
* |----Map：双列数据，存储key-value对的数据
*      |----HashMap：作为Map的主要实现类。线程不安全，效率高；存储null的key和value
*          |----LinkedHashMap：保证在遍历map元素时，可以按照添加的顺序实现遍历
*                  原因：在原有的HashMap底层结构基础上，添加了一对指针，指向前一个和后一个元素
*                  对于频繁的遍历操作，此类指向效率高于HashMap
*      |----TreeMap：可以按照添加的key-value对进行排序，实现排序遍历；此时考虑key的自然排序和定制排序，而不是value
*                    底层使用红黑树
*      |----Hashtable：作为古老的实现类；线程安全，效率低；不能存储null的key和value
*          |----Properties：常用来处理配置文件。key和value都是String类型
*
*  HashMap的底层：数组 + 链表 （jdk7及之前）
*                 数组 + 链表 + 红黑树 （jdk8）
```

 **Map结构的理解：**

+ key是无序的、不可重复的，使用Set存储所有的key
    +  key所在类要重写equals()和hashCode()（以HashMap为例，TreeMap不是这样的）
+ value是无序的、可重复的，使用Collection存储所有的value
    + value所在类要重写equals()
+ Map并不是两两放进去，放的是一个Entry对象，而key和value是作为Entry的属性的
    *      一个键值对：key-value构成一个Entry对象
*      Map中的entry：无序的、不可重复的，使用Set存储所有的entry



**HashMap的底层实现原理**。以jdk7为例说明

+ HashMap map = new HashMap();
+ 在实例化以后，底层创建了长度是16的一维数组Entry[] table;
+ ...可能执行过多次put...
+ map.put(key1, value1);
+ 首先，调用key1所在类的hashCode()计算key1哈希值，此哈希值经过某种算法计算后得到在Entry数组中存放位置
    + 如果此位置上的数据为空，此时key1-value1添加成功   ---> 情况1
    + 如果此位置上的数据不为空，（意味着此位置上存在一个或多个数据（以链表形式存在）），比较key1和已经存在的一个或多个数据的哈希值：
        + 如果key1的哈希值与已经存在的数据的哈希值都不相同，此时key1-value1添加成功    ---> 情况2
        + 如果key1的哈希值与已经存在的某个数据(key2-value2)的哈希值相同，继续比较：调用key1所在类的equals()方法，比较：
            + 如果equals()返回false：此时key1-value1添加成功     ---> 情况3
            + 如果equals()返回true：使用value1替换value2，



```
补充：关于情况2和情况3：key1-value1和原来的数据以链表的方式存储（还是七上八下）
```

在不断的添加过程中，会涉及到扩容问题，默认的扩容方式：**扩容为原来容量的2倍，并将原有的数据复制过来**

+ 当 超出临界值 且 要存放的位置非空 时，才会扩容
+ 并且在扩容后，要重写计算所有元素存放的位置，原本是相同哈希值以链表存在同一个位置上时，可能扩容后就分开了
+ 



**jdk8 相较于 jdk7底层实现方面的不同：**

+ new HashMap()：底层没有创建一个长度为16的数组
+ jdk8 底层的数组是：Node[]，而非Entry[]（其实都差不多）
+ 首次调用put()方法时，底层创建长度为16的数组
+ jdk7底层结构只有：数组+链表。jdk8中底层结构：数组+链表+红黑树
    + 当数组的某一个索引位置上的元素以链表形式存在的数据个数 > 8 且当前数组的长度 > 64时
    + 此时此索引位置上的所有数据改为使用红黑树存储。（查询效率高）



**底层源码常用常数**

+ DEFAULT_INITAL_CAPACITY：HashMap的默认容量，16
+ DEFAULT_LOAD_FACTOR：HashMap的默认加载（填充）因子：0.75
    + 用于控制链表数量，即要兼顾到数组利用率又要让链表尽可能的少一点
+ threshold：扩容的临界值 = 容量 * 填充因子：16 * 0.75 => 12
+ TREEIFY_THRESHOLD:



面试题：

谈谈对HashMap中put/get方法的认识？再谈谈扩容机制？默认大小是多少？什么是负载因子（或填充比）？什么是吞吐临界值（或阈值、threshold）？

+ 默认大小是16
+ 临界值是到多少就扩容，而不是超了才扩容

当new HashMap(15)； 想显示的在底层创建15的数组，其实还是创建16的数组，



# Day35 2020/10/2

jdk7中HashMap同一位置如何以链表来存数据的？

+ 先将原本位置上的旧元素取出来

+ 然后new Entry<>()将新元素的哈希值、键、值、和旧元素传进去

    + ```java
        static class Entry<K, V> implements Map.Entry<K, V>{
            final K key;
            V value;
            Entry<K, V> next; // 链表的指针，指向下一个元素
            int hash;
            
            Entry(int h, K k, V v, Entry<K, V> n){
            	value = v;
                key = k;
                hash = h;
                next = n; // 将旧的元素放到这里
        	}
        }
        
        ```

jdk8中的HashMap的变化

+ 不用Entry，改用Node了

+ ```java
    static class Node<K,V> implements Map.Entry<K,V> {
            final int hash;
            final K key;
            V value;
            Node<K,V> next;
    
            Node(int hash, K key, V value, Node<K,V> next) {
                this.hash = hash;
                this.key = key;
                this.value = value;
                this.next = next;
            }
        // ...
    }
    ```

+ putVal源码解析（添加数据的过程）

    + ```java
        final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                       boolean evict) {
            Node<K,V>[] tab;
            Node<K,V> p;
            int n, i; // n为tab长度，i表示存放数据在tab上的索引位置
            // Node<K,V>[] table; 就是存数据的地方
            // 如果是首次调用tab = table 是 null 因为还没开始存数据，这样的话就给tab开辟空间
            // 如果不是首次添加这个逻辑就不用考虑了
            if ((tab = table) == null || (n = tab.length) == 0)
                n = (tab = resize()).length;
            // 计算当前要在tab上存放的位置，将该位置上的数据赋值给p，没数据时，等于null
            if ((p = tab[i = (n - 1) & hash]) == null)
                tab[i] = newNode(hash, key, value, null);// 该位置没数据直接存
            else {
                // 当要存放的位置已有数据时，就以链表的形式存储数据了
                Node<K,V> e; K k; // 中间变量，接收 数据 和 key
                // 先判断该位置上的数据与要添加进去的数据的哈希值是否一样
                // 当哈希值一样时，再判断 两者的地址是否一样 或者 内容是否一样
                // 地址一样内容肯定就一样，所以这里用的 || 
                // 这里只是该位置第一个数据的比较，要时不相等就要比较后续的链表中的数据（前提时该位置有其他数据）
                if (p.hash == hash &&
                    ((k = p.key) == key || (key != null && key.equals(k))))
                    e = p; // 中间变量暂存一下该位置的原数据
                else if (p instanceof TreeNode)
                    // 当数据不一样时，红黑树的情况
                    e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
                else {
                    // 尾插法
                    for (int binCount = 0; ; ++binCount) {
                        if ((e = p.next) == null) {
                            // p的next为null，说明当前位置就一个元素
                            // 那么就直接添加进去（由于上边比过新旧元素不一样）
                            p.next = newNode(hash, key, value, null);
                            if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                                // TREEIFY_THRESHOLD = 8
                                // 当链表上的数据超过8时就要考虑是否变成红黑树
                                treeifyBin(tab, hash);
                            break;
                        }
                        // p.next不为null时，同上面p一样，要判断哈希值/地址/内容
                        if (e.hash == hash &&
                            ((k = e.key) == key || (key != null && key.equals(k))))
                            break; // 如果存在哈希值相同且 地址或内容相同时，就break，终止循环
                        p = e; // 准备改进该位置的下一个数据
                        // 即p.next位置有数据又不一样，就接着比较p.next.next
                        // 由于在最上面已经让中间变量e接收了p.next
                        // 这里只需要让p = e，那么下一循环时就e就是p.next.next了
                    }
                }
                // 只有当当前位置就p一个数据时，e才会等于 null
                // 能进到下面，说明不需要新增数据，但可能是修改同一位置上的值，并把旧的值返回出去
                // 当新旧值一样时，也会执行这段代码，新值替换旧值，并返回旧值
                if (e != null) { // existing mapping for key
                    V oldValue = e.value; // 将旧的值取出来
                    if (!onlyIfAbsent || oldValue == null)
                        e.value = value;
                    afterNodeAccess(e); // 元素替换？
                    return oldValue; // 返回出去
                }
            }
            ++modCount;
            if (++size > threshold)
                // 判断新增数据后，可有大于临界值，大于了就要判断要不要扩容
                resize();
            afterNodeInsertion(evict);
            return null;
        }
        ```

+ resize()源码分析 用于扩容

    + ```java
        final Node<K,V>[] resize() {
            // 首次进来oldTab也是null
            Node<K,V>[] oldTab = table; // 记录一下旧的table
            int oldCap = (oldTab == null) ? 0 : oldTab.length;
            int oldThr = threshold; // 临界值
            int newCap, newThr = 0; // 新容量和新临界值先赋值为0
            if (oldCap > 0) {
                if (oldCap >= MAXIMUM_CAPACITY) {
                    threshold = Integer.MAX_VALUE;
                    return oldTab;
                }
                else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                         oldCap >= DEFAULT_INITIAL_CAPACITY)
                    newThr = oldThr << 1; // double threshold
            }
            else if (oldThr > 0) // initial capacity was placed in threshold
                newCap = oldThr;
            else {               // zero initial threshold signifies using defaults
                // 当首次开辟空间时，oldTab为 null，oldCap为0，就进到这里
                newCap = DEFAULT_INITIAL_CAPACITY; // 16
                newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY); // 0.75*16 = 12
            }
            if (newThr == 0) {
                float ft = (float)newCap * loadFactor;
                newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                          (int)ft : Integer.MAX_VALUE);
            }
            threshold = newThr; // 首次进来，临界值这样被赋值为12
            @SuppressWarnings({"rawtypes","unchecked"})
                Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap]; // 这里就通过newCap创建新容量大小的新的tab
            table = newTab; // 将存储数据的table指向新的扩容后的newTab
            if (oldTab != null) { 
                // 当旧tab不为null时扩容后旧需要将旧数据复制到新空间里，才会进到这里
                for (int j = 0; j < oldCap; ++j) {
                    Node<K,V> e;
                    if ((e = oldTab[j]) != null) {
                        oldTab[j] = null;
                        if (e.next == null)
                            newTab[e.hash & (newCap - 1)] = e;
                        else if (e instanceof TreeNode)
                            ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                        else { // preserve order
                            Node<K,V> loHead = null, loTail = null;
                            Node<K,V> hiHead = null, hiTail = null;
                            Node<K,V> next;
                            do {
                                next = e.next;
                                if ((e.hash & oldCap) == 0) {
                                    if (loTail == null)
                                        loHead = e;
                                    else
                                        loTail.next = e;
                                    loTail = e;
                                }
                                else {
                                    if (hiTail == null)
                                        hiHead = e;
                                    else
                                        hiTail.next = e;
                                    hiTail = e;
                                }
                            } while ((e = next) != null);
                            if (loTail != null) {
                                loTail.next = null;
                                newTab[j] = loHead;
                            }
                            if (hiTail != null) {
                                hiTail.next = null;
                                newTab[j + oldCap] = hiHead;
                            }
                        }
                    }
                }
            }
            return newTab; // 将新的tab返回
        }
        ```

+ afterNodeAccess()源码分析

    + ```java
        void afterNodeAccess(Node<K,V> e) { // move node to last
            LinkedHashMap.Entry<K,V> last;
            if (accessOrder && (last = tail) != e) {
                LinkedHashMap.Entry<K,V> p =
                    (LinkedHashMap.Entry<K,V>)e, b = p.before, a = p.after;
                p.after = null;
                if (b == null)
                    head = a;
                else
                    b.after = a;
                if (a != null)
                    a.before = b;
                else
                    last = b;
                if (last == null)
                    head = p;
                else {
                    p.before = last;
                    last.after = p;
                }
                tail = p;
                ++modCount;
            }
        }
        ```

+ treeifyBin()源码分析，判断是否要使用红黑树来存储

    + ```java
        final void treeifyBin(Node<K,V>[] tab, int hash) {
            int n, index; Node<K,V> e;
            // MIN_TREEIFY_CAPACITY = 64
            // 判断当前的tab的长度与64比较一下，小于就扩容，大于就改用红黑树存储
            if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
                resize();
            else if ((e = tab[index = (n - 1) & hash]) != null) {
                TreeNode<K,V> hd = null, tl = null;
                do {
                    TreeNode<K,V> p = replacementTreeNode(e, null);
                    if (tl == null)
                        hd = p;
                    else {
                        p.prev = tl;
                        tl.next = p;
                    }
                    tl = p;
                } while ((e = e.next) != null);
                if ((tab[index] = hd) != null)
                    hd.treeify(tab);
            }
        }
        ```



#### LinkedHashMap底层实现

+ 父类是HashMap，大部分方法还是用的父类的

+ 重写了newNode()

    + ```java
        Node<K,V> newNode(int hash, K key, V value, Node<K,V> e) {
            LinkedHashMap.Entry<K,V> p =
                new LinkedHashMap.Entry<K,V>(hash, key, value, e); // 创建新元素对象
            linkNodeLast(p); // 将新元素添加到链表末尾
            return p;
        }
        ```

    + LinkedHashMap.Entry

        + ```java
            static class Entry<K,V> extends HashMap.Node<K,V> { // 继承了HashMap的Node
                // 除了Node中的几个属性外，多加了before和after
                Entry<K,V> before, after; // Entry上一个元素和下一个元素。用于明确添加元素的先后顺序
                Entry(int hash, K key, V value, Node<K,V> next) {
                    super(hash, key, value, next); // 调用Node的构造器
                }
            }
            ```

    + linkNodeLast()

        + ```java
            // link at the end of list 链接到列表末尾
            private void linkNodeLast(LinkedHashMap.Entry<K,V> p) {
                // LinkedHashMap.Entry<K,V> tail; 双链表的尾部
                LinkedHashMap.Entry<K,V> last = tail; // 记录尾元素
                tail = p; // 将尾元素换成新添加元素
                if (last == null)
                    head = p; // 当没有尾元素时首元素就是新添加元素
                else {
                    p.before = last; // 新添加元素的上一个元素是 旧尾元素
                    last.after = p; // 旧尾元素的下一个元素是 新添加元素 这就链接在一起了
                }
            }
            ```



在原本的HashSet()中，构造器直接创建了HashMap()的对象

+ 当向HashSet中add元素时，就相当于向HashMap中put元素了
    + 而这个 元素值 就作为HashMap中的 key了，value时一个常量PRESENT = new Object()，这样也是防止真的这样调用去访问值时抛空指针异常而已



### Map的常用方法

见代码。



### TreeMap使用

向TreeMap中添加key-value，要求key必须是由同一个类创建的对象

因为要按照key进行排序：自然排序 和 定制排序

具体使用与HashSet一样



### Properties使用

+ Properties类是Hashtable的子类，该对象用于处理属性文件
+ 由于属性文件里的key、value都是字符串类型，所以**Properties里的key和value都是字符串类型**
+ 存取数据时，建议使用setProperty(String key, String value)方法和getProperty(String key)方法



## Collections工具类

+ Collections是一个操作Set、List和Map等集合的工具类

+ Collections中提供了**一系列静态的方法**对集合元素进行排序、查询和修改等操作，还提供了**对集合对象设置不可变**、**对集合对象实现同步控制**等方法

+ 排序操作：（均为static方法）

    + reverse(List)：反转List中的元素的顺序

    + shuffle(List)：对List集合元素进行随机排序

    + sort(List)：根据元素的自然排序对指定List集合元素按升序排序

    + sort(List, Comparator)：根据指定的Comparator产生的顺序对List集合元素进行排序

    + swap(List, int, int)：将指定List集合中的i处元素和j处元素进行交换

    + int frequnency(Collection, Object)：返回指定集合中指定元素的出行次数

    + void copy(List dest, List src)：将src中的内容复制到dest中

        + ```java
            // 错误写法
            List dest = new ArrayList();
            Collections.copy(dest, list);  // 抛异常
            // java.lang.IndexOutOfBoundsException: Source does not fit in dest
            System.out.println(dest); // copy时 会比较二者的数组中的size，而不是数组的长度
            
            // 巧妙的写法
            List dest = Arrays.asList(new Object[list.size()]);
            System.out.println(dest.size()); // list.size()
            Collections.copy(dest, list); // 这样copy就对了
            System.out.println(dest); // [-1, 2, 0, 3, 4, 5, 20]
            ```

    + boolean replaceAll(List list, Object oldVal, Object newVal)：使用新值替换List对应元素的值

+ Collections类中提供了多个synchronizedXxx()方法，该方法**可将指定集合包装成线程同步的集合**，从而可以解决多线程并发访问集合时的线程安全问题
    + 因此，并不会直接用Ventor或Hashtable，而是直接将ArrayList或HashMap放入Collections对应的synchronizedXxx()方法中，来实现线程同步
    + 底层似乎就是将对应的方法用同步代码块包裹了一下





## 数据结构

![image-20201002205129180](C:\Users\Jarvis\AppData\Roaming\Typora\typora-user-images\image-20201002205129180.png)

![image-20201002205851562](C:\Users\Jarvis\AppData\Roaming\Typora\typora-user-images\image-20201002205851562.png)

![image-20201002210032044](C:\Users\Jarvis\AppData\Roaming\Typora\typora-user-images\image-20201002210032044.png)

![image-20201002211120443](C:\Users\Jarvis\AppData\Roaming\Typora\typora-user-images\image-20201002211120443.png)

![image-20201002211216444](C:\Users\Jarvis\AppData\Roaming\Typora\typora-user-images\image-20201002211216444.png)

![image-20201002211416627](C:\Users\Jarvis\AppData\Roaming\Typora\typora-user-images\image-20201002211416627.png)





# Day36 2020/10/3

## 泛型（Generic）

+ 所谓的泛型，就是允许在定义类、接口时通过一个标识表示类中某个属性的类型或者是某个方法的返回值及参数类型。
    + 这个类型在使用时（例如，继承或实现这个接口，用这个类型声明变量、创建对象时）确定（即传入实际的类型参数，也称为类型实参）。

+ JDK1.5以后，Java引入了“参数化类型（Parameteried type）”概念，允许在创建集合时指定集合元素的类型，正如：`List<String>`，这表明该List只能保存字符串类型的对象
+ JDK1.5改写了集合框架中的全部接口和类，为这些接口、类增加了泛型支持，从而可以在声明集合变量、创建集合对象时传入类型实参。



使用泛型时

+ 集合接口或集合类在jdk5.0时都修改为带泛型的结构
+ 在实例化集合类时，可以指明具体的泛型类型
+ 指明完以后，在集合类或接口中凡是定义类或接口时，内部结构（比如：方法、构造器、属性等）使用到类的泛型的位置，都指定为实例化的泛型类型
    + 比如：add(E e) ---> 实例化以后 add(Integer e)
+ 注意：泛型的类型必须是类，不能是基本数据类型，用到的话需要用包装类
+ 如果实例化时，没有这么泛型的类型，默认类型为java.lang.Object类型



### 自定义泛型结构

泛型类、泛型接口、泛型方法

+ 如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为Object类型
+ 要求：如果定义了类是带泛型的，建议在实例化时要指明类的泛型
+ 后边尖括号内的类型可省，但是确定使用泛型时，前面的不可以省

```java
class SubOrder extends Order<Integer>{
    // 这里指明基础时用什么类型，因此在实例化时就不需要再指明了
}

class SubOrder1<T> extends Order<T>{
    // 保留泛型，这是实例化就需要指明类型了
}
```

#### 泛型类

+ 泛型类可能有多个参数，此时应将多个参数一起放在尖括号内。比如<E1, E2, E3>

+ 泛型类的构造器如下

    + 正确：public GenericClass(){}
    + 错误：public GenericClass<E>(){}

+ 实例化后，操作原来泛型位置的结构必须与指定的泛型类型一致

+ 泛型不同的引用不能相互赋值

    + 尽管在编译时ArrayList<String>和ArrayList<Integer>是两种类型，但是，在运行时只有一个ArrayList被加载到JVM中

+ 泛型如果不指定，将被擦除，泛型对应的类型均按照Object处理，但不等价于Object

    + 经验：泛型要使用一路都是。要不用，一路都不要用

+ 如果泛型类是一个接口或者抽象类，则不可窗口泛型类的对象

+ jdk1.7，泛型的简化操作：ArrayList<String> first = new ArrayList<>();

+ 泛型的指定中不能使用基本数据类型，可以使用包装类替换

+ 在类/接口上声明的泛型，在本类或本接口中即代表某种类型，可以作为非静态属性的类型、非静态方法的参数类型、非静态方法的返回值类型。

    + **但是在静态方法中不能使用类的泛型**

+ 异常类不能是泛型的

+ 不能使用 new E[]。但是可以：E[] elements = (E[]) new Object[capacity];

    + 参考：ArrayList源码中声明：Object[] elementData，而非泛型参数类型数组

+ 父类有泛型，子类可以选择保留泛型，也可以选择指定泛型类型

    + 子类不保留父类的泛型：按需实现

        + 没有类型	擦除
        + 具体类型

    + 子类保留父类的泛型：泛型子类

        + 全部保留
        + 部分保留

    + **子类除了指定或保留父类的泛型，还可以增加自己的泛型**

    + ```java
        class Father<T1, T2>{
        }
        // 子类不保留父类的泛型 但子类可以自己添加自己的泛型
        // 1. 没有类型，擦除
        class Son extends Father{
            // 等价于 class Son extends Father<Object, Object>{}
        }
        // 2. 具体类型
        class Son2<A, B> extends Father<Integer, String>{
        }
        
        // 子类保留父类的泛型 子类可以声明自己的泛型
        // 1. 全部保留
        class Son3<T1, T2> extends Father<T1, T2>{
        }
        
        // 2. 部分保留
        class Son4<T2> extends Father<Integer, T2>{
        }
        ```



#### 泛型方法

```java
// 泛型方法：在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系
// 换句话说，泛型方法所属的类是不是泛型类型都没有关系
public <E> List<E> copyFromArrayToList(E[] arr){
    // 必须要指明<E>才行，这是为了让编译器知道E不是类名
    // 字母可以用别的，不过如果类也用了泛型，要注意区分开
    ArrayList<E> list = new ArrayList<>();
    for (E e : arr){
        list.add(e);
    }
    return list;
}
```

```java
Integer[] arr = new Integer[]{1,2,3,4};
// 泛型方法的调用
List<Integer> list = order.copyFromArrayToList(arr);
System.out.println(list);
```

另外，**泛型方法可以声明为静态方法**

原因：泛型参数是在调用方法时确定的，并非在实例化类时确定的





#### 什么时候会用到泛型类或泛型方法？

DAO：data(base) access object 数据访问对象



### 泛型在继承方面的体现

+ 类A是类B的父类，G<A> 和 G<B> 二者不具备子父类关系，二者是并列的
    + 但，A<G> 是 B<G>的父类



### 通配符的使用

通配符：?

类A 是 类B 的父类，G<A> 和 G<B> 二者不具备子父类关系，二者共同的父类是：G<?>



#### 有限制的通配符

+ <?>：允许所有泛型的引用调用
+ 通配符指定上限
    + 上限extends：使用时指定的类型必须是继承某个类，或者实现某个接口，即<=
+ 通配符指定下限
    + 下限super：使用时指定的类型不能小于操作的类，即>=
+ 举例
    + <? extends Number> (无穷小, Number]
        + 只允许泛型为Number及Number子类的引用调用
    + <? super Number>   [Number, 无穷大)
        + 只允许泛型为Number及Number父类的引用调用
    + <? extends Comparable>
        + 只允许泛型为实现Comparable接口的实现类的引用调用





## I/O流

### File类的使用

+ java.io.File类：文件和文件目录路径的抽象表示形式，与平台无关
+ File能新建、删除、重命名文件和目录，但File不能访问文件内容本身。
    + 如果需要访问文件内容本身，则需要使用输入/输出流
+ 想要在Java程序中表示一个真实存在的文件或目录，那么必须有一个File对象
    + 但是Java程序中的一个File对象，可能没有一个真实存在的文件或目录
+ File对象可以作为参数传递给流的构造器



#### 路径分隔符

+ 路径中的每级目录之间用一个**路径分隔符**隔开
+ 路径分隔符和系统有关
    + windows和DOS系统默认使用“\”来表示
    + UNIX和URL使用“/”来表示
+ Java程序支持跨平台运行，因此路径分隔符要慎用
+ 为了解决这个隐患，File类提供了一个常量
    + public static fial String separator：根据操作系统，动态的提供分隔符
    + 使用时，File.separator，即可



```
1.如何创建File类的实例
        File(String filePath)
        File(String parentPath, String childPath)
        File(File parentFile, String childPath)
2.相对路径
        相较于某个路径下，指明的路径
  绝对路径
        包含盘符在内的文件或文件目录的路径
```



#### File类的获取功能

```java
File file = new File("hello.txt");
File file2 = new File("F:\\Java基础学习和算法练习\\JavaBase\\test.txt");
// 获取绝对路径
System.out.println(file.getAbsoluteFile()); // F:\Java基础学习和算法练习\JavaBase\LearnJava\day36\hello.txt
//  // 获取路径
System.out.println(file.getPath()); // hello.txt
// 获取名称
System.out.println(file.getName()); // hello.txt
//  // 获取上层文件目录路径，若无返回null
System.out.println(file.getParent()); // 这里返回null，创建文件后还是null，说明这个还是基于相对路径的
// 获取文件长度（即，字节数）。不能获取目录的长度
System.out.println(file.length()); // 0 因为文件不存在，创建文件后 10 字节
// 获取最后一次的修改时间，毫秒数（时间戳）
System.out.println(file.lastModified()); // 0 因为文件不存在，创建文件后 1601730081561

System.out.println();

System.out.println(file2.getAbsoluteFile()); // F:\Java基础学习和算法练习\JavaBase\test.txt
System.out.println(file2.getPath()); // F:\Java基础学习和算法练习\JavaBase\test.txt
System.out.println(file2.getName()); // test.txt
System.out.println(file2.getParent()); // F:\Java基础学习和算法练习\JavaBase
System.out.println(file2.length()); // 0
System.out.println(file2.lastModified()); // 0
```

```java
File file = new File("F:\\Java基础学习和算法练习\\JavaBase");
// 获取文件目录
String[] list = file.list(); // 获取指定目录下所有文件或者文件目录的名称的数组
System.out.println(Arrays.toString(list)); // [.git, .gitattributes, JavaLearn, Java基础.md, LearnJava, README.md]

File[] files = file.listFiles(); // 获取指定目录下所有文件或者文件目录的File数组
System.out.println(Arrays.toString(files)); // [F:\Java基础学习和算法练习\JavaBase\.git, F:\Java基础学习和算法练习\JavaBase\.gitattributes, F:\Java基础学习和算法练习\JavaBase\JavaLearn, F:\Java基础学习和算法练习\JavaBase\Java基础.md, F:\Java基础学习和算法练习\JavaBase\LearnJava, F:\Java基础学习和算法练习\JavaBase\README.md]
```

**renameTo(File dest)**

```java
// boolean renameTo(File dest)：把文件重命名，并移到指定的文件路径
File file1 = new File("hello.txt");
File file2 = new File("F:\\Java基础学习和算法练习\\test.txt");

boolean b = file2.renameTo(file1);
System.out.println(b); // 如果test.text文件存在，返回false；不存在则返回true
```



#### File类的判断功能

```java
File file1 = new File("hello.txt");
File file2 = new File("F:\\Java基础学习和算法练习\\JavaBase");

System.out.println(file1.isDirectory()); // 判断是否是文件目录
System.out.println(file1.isFile()); // 判断是否是文件
System.out.println(file1.exists()); // 判断是否存在
System.out.println(file1.canRead()); // 判断是否可读
System.out.println(file1.canWrite()); // 判断是否可写
System.out.println(file1.isHidden()); // 判断是否隐藏

System.out.println(file2.isDirectory()); // 判断是否是文件目录
System.out.println(file2.isFile()); // 判断是否是文件
System.out.println(file2.exists()); // 判断是否存在
System.out.println(file2.canRead()); // 判断是否可读
System.out.println(file2.canWrite()); // 判断是否可写
System.out.println(file2.isHidden()); // 判断是否隐藏

// 注意，当文件或路径不存在时，上面全返回false
```

#### File类的创建和删除功能

```java
File file1 = new File("hi.txt");
if (!file1.exists()) {
    file1.createNewFile(); // 创建文件，会返回boolean值
    System.out.println("创建成功1");
}else{
    file1.delete(); // 删除文件 会返回boolean值
    System.out.println("删除成功1"); // 注意，Java中的删除不走回收站
}

// 文件目录的创建
File file2 = new File("F:\\Java基础学习和算法练习\\test");
if (!file2.exists()) {
    file2.mkdir(); // 创建文件夹。如果文件目录存在就不创建了，如果文件目录上层目录不存在就不创建了
    System.out.println("创建成功2");
}else{
    file2.delete(); // 删除文件夹 会返回boolean值
    System.out.println("删除成功2"); // 注意，Java中的删除不走回收站
}

File file3 = new File("F:\\Java基础学习和算法练习\\test2\\a");
if (!file3.exists()) {
    file3.mkdirs(); // 当文件目录上层文件不存在，一并创建
    System.out.println("创建成功3");
}else{
    file3.delete(); // 删除文件夹 会返回boolean值
    System.out.println("删除成功3"); // 注意，Java中的删除不走回收站
}
```



# Day37 2020/10/4

## IO流原理及流的分类

+ I/O是Input/Output的缩写，I/O技术是非常实用的技术，**用于处理设备之间的数据传输**，如读/写文件，网络通讯等。
+ java程序中，对于数据输入/输出操作以“流（stream）”的方式进行

+ java.io包下提供了各种“流”类和接口，用以获取不同种类的数据，并通过标准的方法输入或输出数据



**JavaIO原理**

+ 输入input：读取外部数据（磁盘、光盘等存储设备的数据）到程序（内存）中
+ 输出output：将程序（内存）数据输出到磁盘、光盘等存储设备中



**流的分类**

+ 按操作**数据单位**不同分为：**字节流（8 bit）**，**字符流（16 bit）**
+ 按数据流的**流向**不同分为：**输入流**、**输出流**
+ 按流的**角色**的不同分为：**节点流**、**处理流**

| 抽象基类   | 字节流       | 字符流 |
| ---------- | ------------ | ------ |
| **输入流** | InputStream  | Reader |
| **输出流** | OutputStream | Writer |

+ Java的IO流共涉及40多个类，实际上非常规划，都是从这4个抽象基类派生的
+ 由这4个类派生出来的子类名称都是以其父类名作为子类名后缀

![image-20201004123958237](C:\Users\Jarvis\AppData\Roaming\Typora\typora-user-images\image-20201004123958237.png) 



#### 

#### FileReader和FileWriter的使用

```
1. read()的理解：返回读入的一个字符，如果达到文件末尾，返回-1
2. 异常的处理，为了保证流资源一定可以执行关闭操作，需要使用try-catch-finally处理
3. 读入的文件一定要存在，否则就会报 FileNotFoundException
```

```java
		FileReader fr = null;
        try {
            // 1. File类的实例化
            File file = new File("hello.txt");

            // 2. FileReader流的实例化
            fr = new FileReader(file);

            // 3. 读入的操作
            // read(char[] cbuf)：返回每次读入cbuf数组中的字符的个数，如果达到文件末尾，返回-1
            char[] cbuf = new char[5];  // 每次读取字符的个数
            int len;
            while ((len = fr.read(cbuf)) != -1) {
//                System.out.println(Arrays.toString(cbuf));
                /*
                [h, e, l, l, o]
                [w, o, r, l, d]
                [1, 2, 3, l, d]
                 */
                // 因此要想正确的读出读取的数据，应该
//                for (int i = 0; i < len; i++) {
//                    System.out.print(cbuf[i]);
//                } // helloworld123

//                String str = new String(cbuf); // 这样也不行
//                System.out.println(str);
                /*
                hello
                world
                123ld
                 */

                String str = new String(cbuf, 0, len); // 这样就可以，只截取需要的
                System.out.print(str); // helloworld123
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 资源的关闭
            try {
                if(fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
```

```
从内存中写出数据到硬盘的文件里
说明：
    1. 输出操作：对于的File可以不存在
    2. File对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建此文件
       File对应的硬盘中的文件如果存在：
                如果流使用的构造器是：FileWriter(file, false) / FileWriter(file)：对原有文件覆盖
                如果流使用的构造器是：FileWriter(file, true)：不会覆盖原有文件，而是追加内容
```



#### FileInputStream 和 FileOutputStream的使用

```
* 结论：
*      1. 对于文本文件（.txt, .java, .c, .cpp），使用字符流处理
*      2. 对于非文本文件（.jpg, .mp3, .mp4, .avi, .doc, .ppt,...），使用字节流处理
* 另外：
*      1. 当文本文件不需要在内存层面读出来，只是复制，那么使用 字符流/字节流 都可以
*      2. 但非文本文件使用，只能使用字节流复制，不能使用字符流复制

```





#### 处理流之一：缓冲流的使用

```
* 1。 缓冲流
*      BufferedInputStream
*      BufferOutputStream
*      BufferedReader
*      BufferedWroter
*
* 2、 作用：提高流的读取、写入的速度
*     原因：内部提供了一个缓冲区
*
* 3， 处理流，就是“套接”在已有流的基础上
* 4. 关闭资源
*	  要求：先关闭外层的流，再关闭内层的流
*	  说明：关闭外层的流的同时，内层流也会自动的进行关闭。因此，内层流的关闭代码，可以省略
```



#### 处理流之二：转换流的使用

+ 转换流提供了在字节流和字符流直接的转换
+ Java API提供了两个转换流
    + InputStreamReader：将InputStream转换为Reader
    + OutputStreamWriter：将Writer转换为OutputStream
+ 字节流中的数据都是字符时，转成字符流操作更高效
+ 很多时候使用转换流来处理文件乱码问题，实现编码和解码的功能



简单的说，就是

+ 将输入的 字节流 转换为 字符流
    + 就是输入时将， byte 转换成 char 
+ 将输出的 字符流 转换为 字节流
    + 就是输出时将，char 转换成 byte



#### **字符集**

+ ASCII：美国标准信息交换码
    + 用一个字节的7位可以表示
+ ISO8859-1：拉丁码表。欧洲码表
    + 用一个字节的8位表示
+ GB2312：中国的中文编码表。
    + **最多**两个字节编码所有字符
+ GBK：中国的中文编码表升级，融合了更多的中文文字符号。
    + **最多**两个字节编码
+ Unicode：国际标准码，融合了目前人类使用的所有字符。
    + 为每个字符分配唯一的字符码。
    + 所有的文字**都用**两个字节来表示
    + Unicode不完美
        + 英文字母只用一个字节表示就够了
        + 如何区分Unicode和ASCII
        + 用类似与GBK等双字节编码方式来表示一个字符，用最高位1或0表示两个字节和一个字节，就会少了很多值无法用于表示字符。不够表示所有字符
+ UTF-8：变长的编码方式
    + 可用1-4个字节来表示一个字符
        + 修正后的UTF-8编码中还可能需要6个字节
    + 每次8个位传输数据
    + 中文在UTF-8中占3个字节



**字符编码**

+ ANSI编码，通常指的是平台的默认编码，例如英文操作系统中是ISO-8859-1，中文系统是GBK
+ Unicode字符集只是定义了字符的集合和唯一编号
+ Unicode编码，则是对UTF-8、UCS-2/UTF-16等具体编码方案的统称而已，并不是具体的编码方案





## 标准输入流、输出流

+ System.in和System.out分别代表了系统标准的输入和输出设备
+ 默认输入设备是：键盘，输出设备是：显示器
+ System.in的类型是InputStream
+ System.out的类型是PrintStream，其实OutputStream的子类，FilterOutputStream的子类
+ 重定向：通过System类的setIn，setOut方法对默认设备进行改变
    + public static void setIn(InputStream in)
    + public static void setOut(PrintStream out)



# Day38 2020/10/5

## 打印流

+ 实现将**基本数据类型**的数据格式转化为**字符串**输出
+ 打印流：**PrintStream（字节输出流）**和**PrintWriter（字符输出流）**
    + 提供了一系列重载的print()和println()方法，用于多种数据类型的输出
    + PrintStream和PrintWriter的输出不会抛出IOException异常
    + PrintStream和PrintWriter有自动flush功能
    + PrintStream打印的所有字符都使用平台的默认字符编码转换为字节
        + 在需要写入字符而不是写入字节的情况下，应该使用PrintWriter类
    + System.out返回的是PrintStream的实例



## 数据流

+ 为了方便地操作Java语音的基本数据类型和String的数据，可以使用数据流
+ 数据流有两个类：（用于读取和写出基本数据类型、String类的数据）
    + DataInputStream和DataOutputStream
    + 分别“套接”在InputStream和OutputStream子类的流上
+ DataInputStream中的方法
    + boolean readBoolean()
    + byte readByte()
    + char readChar()
    + float readFloat()
    + double readDouble()
    + short readShort()
    + long readLong()
    + int readInt()
    + String readUTF()
    + void readFully(byte[] b)
+ DataOutputStream中的方法
    + 将上述的方法的read改为相应的write即可。

+ 注意点：读取不同类型的数据的顺序要与当初写入文件时，保存的数据的顺序一致
    + 读（得按写的顺序读）



## 对象流

+ ObjectInputStream和ObjectOutputStream
+ 用于存储和读取**基本数据类型**数据或**对象**的处理流。
    + 它的强大之处就是可以把Java中的对象写入到数据源中，也能把对象从数据源中还原回来
+ **序列化**：用ObjectOutputStream类**保存**基本类型数据或对象的机制
+ **反序列化**：用ObjectInputStream类**读取**基本类型数据或对象的机制

+ ObjectOutputStream和ObjectInputStream不能序列化**static**和**transient**修饰的**成员变量**



### 对象的序列化机制

+ 对象的序列化机制允许**把内存中的Java对象转换成平台无关的二进制流**，从而允许**把这种二进制流持久化地保存在磁盘上**，或**通过网络将这种二进制流传输到另一个网络节点**。
    + 当其他程序获取了这种二进制流，就可以恢复成原来的Java对象
+ 序列化的好处在于可将任何实现了Serializable接口的对象转换为**字节数据**，使其在保存和传输时可被还原
+ 序列化是RMI（Remote Method Invoke - 远程方法调用）过程的参数和返回值都必须实现的机制，而RMI是JavaEE的基础，因此序列化机制是JavaEE平台的基础
+ 如果需要让某个对象支持序列化机制，则必须让对象所属的类及其属性是可序列化的，为了让某个类是可序列化的，该类必须实现如下两个接口之一。否则，会抛出**NotSerializableException**异常
    + **Serializable**
    + Externalizable
+ 凡是实现Serializable接口的类都有一个标识序列化版本标识符的静态变量
    + private static final long serialVersionUID;
    + serialVersionUID用来表明类的不同版本间的兼容性。简言之，其目的是**以序列化对象进行版本控制，有关各版本反序列化时是否兼容**
    + 如果类没有显式定义这个静态变量，它的值是Java运行时环境根据类的内部细节自动生成的，若类的实例变量做了修改，serialVersionUID可能发生变化。故建议，显式声明
+ 简单来说，Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的，
    + 在进行反序列化时，**JVM会把传来的字节流**中的serialVersionUID 与**本地相应**实体类的serialVersionUID进行比较
        + 如果相同就认为是一致的，可以进行反序列化
        + 否则就会出现序列化版本不一致的异常（InvalidCastException）



```
要想Person类支持序列化机制，
    1. 需要实现Serializable接口（这是个标识接口）
    2. 当前类提供一个全局常量：serualVersionUID
    3. 除了当前Person类需要实现Serializable接口之外，还必须保证其内部所有属性也必须是可序列号的
        （默认情况下，基本数据类型可序列化）
```





## 随机存取文件流

### RandomAccessFile类

+ RandomAccessFile声明在java.io包下，但直接继承于java.lang.Object类
    + 并且它实现了DataInput、DataOutput这两个接口，也就意味着这个类既可以读也可以写
+ RandomAccessFile类支持“随机访问”的方式，**程序可以直接跳到文件的任意地方来读、写文件**
    + 支持只访问文件的部分内容
    + 可以向已存在的文件后追加内容
+ RandomAccessFile对象包含一个记录指针，用以标示当前读写处的位置
    + RandomAccessFile类对象可以自由移动记录指针
        + long getFilePointer()：获取文件记录指针的当前位置
        + void seek(long pos)：将文件记录指针定位到pos位置

+ 构造器
    + public RandomAccessFile(File file, String mode)
    + public RandomAccessFile(String name, String mode)
+ 创建RandomAccessFile类实例需要指定一个mode参数，该参数指定RandomAccessFile的访问模式
    + r：以只读方式打开
    + rw：打开以便读取和写入
    + rwd：打开以便读取和写入；同步文件内容的更新
    + rws：打开以便读取和写入；同步文件内容和元数据的更新
+ 如果模式为只读r。则不会创建文件，而是会去读取一个已经存在的文件
    + 如果读取的文件不存在，则会出行异常
+ 如果模式为rw读写。
    + 如果文件不存在则会去创建文件
    + 如果存在则不会创建



可以用RandomAccessFile类，来实现一个**多线程断点下载**的功能

+ **下载前**会建立**两个临时文件**
    + 一个是与被下载文件大小相同的空文件
    + 另一个是记录文件指针的位置文件
+ 每次暂停的时候，都会保存上一次的指针，然后断点下载的时候，会继续从上一次的地方下载，从而实现断点下载或上传的功能



## NIO.2中Path、Paths、Files类的使用

## Java NIO概述

+ Java NIO（New IO，Non-Blocking IO）是java1.4引入的一套新的IO API，可以替代标准的Java IO API。
+ NIO与原来的IO有同样的作用和目的，但是使用的方式完全不同
    + NIO支持**面向缓冲区**的（IO是**面向流**的）、基于通道的IO操作
    + NIO将以更加高效的方式进行文件的读写操作
+ Java API中提高了两套NIO
    + 一套是**针对标准输入输出NIO**
    + 另一套是**网络编程NIO**
        + java.nio.channels.Channel
            + FileChannel：处理本地文件
            + SocketChannel：TCP网络编程的客户端的Channel
            + ServerSocketChannel：TCP网络编程的服务器端的Channel
            + DatagramChannel：UDP网络编程中发送端和接收端的Channel



### NIO.2

+ 随着JDK7的发布，Java对NIO进行了极大的扩展，增强了对文件处理和文件系统特性的支持，以至于称他为NIO.2
+ 因为NIO提供的一些功能，NIO已经成为文件处理中越来越重要的部分



### Path、Paths和Files核心API

+ 早期的Java只提供了一个File类来访问文件系统，但File类的功能比较有限，所提供的方法性能也不高

    + 而且，大多数方法在出错时仅返回失败，并不会提供异常信息（比如说renameTo()方法，错误是返回false，而不是抛异常）

+ NIO.2为了弥补这种不足，引入了Path接口，代表一个平台无关的平台路径，描述了目录结构中文件的位置

    + Path可以看成是File类的升级版本，**实际引用的资源也可以不存在**

+ 在以前IO操作是这样写的

    + ```java
        import java.io.File;
        File file = new File("index.html");
        ```

+ 在Java7中，可以这样写

    + ```java
        import java.nio.file.Path;
        import java.nio.file.Paths;
        Path path = Paths.get("index.html");
        ```

+ 同时，NIO.2在java.nio.file包下还提供了Files、Paths工具类

    + Files包含了大量静态的工具方法来操作文件
    + Paths则包含了两个返回Path的静态工厂方法

+ Paths类提供的静态get()方法用来获取Path对象

    + static Path get(String first, String ... more)：用于将多个字符串串联成路径
    + static Path get(URI uri)：返回指定uri对应的Path路径

![image-20201006145733030](C:\Users\Jarvis\AppData\Roaming\Typora\typora-user-images\image-20201006145733030.png)

![image-20201006145817850](C:\Users\Jarvis\AppData\Roaming\Typora\typora-user-images\image-20201006145817850.png)

![image-20201006145901345](C:\Users\Jarvis\AppData\Roaming\Typora\typora-user-images\image-20201006145901345.png)



## 网络编程

+ Java提供的网络类库，可以实现无痛的网络连接，联网的底层细节被隐藏在Java的本机安装系统里，由JVM进行控制。并且Java实现了一个跨平台的网络库，程序员面对的是一个统一的网络编程环境



网络编程中有两个主要的问题：

+ 如何准确地定位网络上一台或多台主机：定位主机上的特定的应用
+ 找到主机后如何可靠高效地进行数据传输



#### 如何实现网络中的主机互相通信

+ 通信双方地址
    + IP
    + 端口号
        + 不同进程有不同的端口号
        + 被规定为一个16位的整数 0~65535
        + 端口分类
            + 公认端口：0~1023。被预定义的服务通信占用
                + 如：HTTP占用端口80，FTP占用端口21，Telnet占用端口23
            + 注册端口：1024~49151。分配给用户进程或应用程序。
                + 如：Tomcat占用端口8080，MySQL占用端口3306，Oracle占用端口1521等
                    + 这些服务的端口大多都可以自己修改
            + 动态/私有端口：49152~65535
    + 端口号和IP地址的组合得出一个网络套接字：Socket
+ 一定的规则（即：网络通信协议，有两套参考模型）
    + OSI参考模型：模型过于理想化，未能在因特网上进行广泛推广
    + TCP/IP参考模型（或TCP/IP协议）：事实上的国际标准



#### TCP和UDP协议

传输层协议中有两个非常重要的协议

+ 传输控制协议TCP
+ 用户数据报协议UDP

TCP/IP包含两个主要协议：传输控制协议（TCP）和网络互联协议（IP）

+ IP（Internet Protocol）协议是网络层的主要协议，支持网间互连的数据通信
+ TCP/IP协议模型从更实用的角度出发，形成了高高效的四层体系结构，即物理链路层、IP层、传输层和应用层



**TCP协议**：

+ 使用TCP协议前，须先建立TCP连接，形成传输数据通道
+ 传输前，采用“”**三次握手**“方式，点对点通信，是**可靠的**
+ TCP协议进行通信的两个应用进程：客户端、服务端
+ 在连接中可进行大数据量的传输
+ 传输完毕，要释放已建立的连接，效率低



**UDP协议：**

+ 将数据、源、目的封装成数据包，不需要建立连接
+ 每个数据报的大小限制在**64K内**
+ 发送不管对方是否准备好，接收方收到也不确认，故是**不可靠的**
+ 可以广播发送
+ 发送数据结束时无需释放资源，开销小，速度快



# Day39 2020/10/6

## UDP网络通信

+ 类DatagramSocket和DatagramPacket实现了基于UDP协议网络程序
+ UDP数据报通过数据报套接字DatagramSocket发送和接收，系统不保证UDP数据报一定能够安全送到目的地，也不能确定什么时候可以抵达
+ DatagramPacket对象封装了UDP数据报，在数据报中包含了发送端的IP地址和端口号以及接收端的IP地址和端口号
+ UDP协议中每个数据报都给出了完整的地址信息，因此无须建立发送方和接收方的连接



## URL编程

+ URL（Uniform Resource Locator）：统一资源定位符，它表示Internet上**某一资源**的地址
+ 它是一个具体的URI，即URL可以用来标识一个资源，而且还指明了如何locate（定位）这个资源
+ 通过URL可以访问Internet上各种网络资源，比如最常见的www，ftp站点。
    + 浏览器通过解析给定的URL可以在网络上查找相应的文件或其他资源
+ URL的基本结构由5部分组成
    + <传输协议>://<主机名>:<端口号>/<文件名>#片段名?参数列表
    + 例如：http://localhost:8080/examples/gakki.png?username=Tom&age=18
    + #片段名：即锚点
    + 参数列表格式：参数名=参数值&参数名=参数值



## Java反射（Reflection）机制

+ Reflection（反射）是被视为**动态语言**的关键，反射机制允许程序在执行期借助于Reflection API**取得任何类的内部信息**，并**能直接操作任意对象的内部属性及方法**

+ 加载完类之后，在**堆内存的方法区**中就产生了一个**Class类型的对象**（**一个类只有一个Class对象**），这个对象就包含了完整的类的结构信息
    + 可以通过这个对象看到类的结构
    + 这个对象就像一面镜子，透过这个镜子看到类的结构，所以形象的称之为：**反射**

+ 正常方式：
    + 引入需要的“包类”名称
    + 通过new实例化
    + 取得实例化对象
+ 反射方式：
    + 实例化对象
    + getClass()方法
    + 得到完整的“包类”名称



#### 动态语言 vs 静态语言

+ 动态语言
    + 是一类在运行时可以改变其结构的语言：例如新的函数、对象、甚至代码可以被引进，已有的函数可以被删除或是其他结构上的变化
    + 通俗点就是**在运行时代码可以根据某些条件改变自身结构**
    + 主要动态语言：Object-C、C#、JavaScript、PHP、Python、Erlang
+ 静态语言
    + 与动态语言相对应的，**运行时结构不可变的语音就是静态语言**。如Java、C、C++



Java不是动态语言，但Java可以称之为“**准动态语言**”。

+ Java具有一定的动态性，**可以利用反射机制、字节码操作获得类似动态语言的特性**
+ Java的动态性让编程的时候更加灵活



### Java反射机制提供的功能

+ 在运行时判断任意一个对象所属的类
+ 在运行时构造任意一个类的对象
+ 在运行时判断任意一个类所具有的成员变量和方法
+ 在运行时获取泛型信息
+ 在运行时调用任意一个对象的成员变量和方法
+ 在运行时处理注解
+ 生成动态代理



### 反射相关的主要API

+ **java.lang.Class**：代表一个类
+ java.lang.reflect.Method：代表类的方法
+ java.lang.reflect.Field：代表类的成员变量
+ java.lang.reflect.Constructor：代表类的构造器
+ ......

```
疑问：通过直接new的方式或反射的方式都可以调用公共的结构，开发中用哪个？
    建议：直接new的方式
    什么时候会用：反射的方式。
    反射的特征：动态性
疑问：反射机制与面向对象中的封装性是不是矛盾的？如何看待两个技术？
    不矛盾。
    通俗地讲，封装性就是一种规范，告诉你什么应该凋什么不应该凋，就是建议怎么调用的事
            而反射则是，能不能调用的事
```

#### Class类的理解

+ 类的加载过程：
    + 程序经过javac.exe命令后，会生成一个或多个字节码文件（.class结尾）（这一行不是类加载的过程）
    + 接着使用java.exe命令对某个字节码文件进行解释运行（应该是包含main方法的那个字节码文件）
    + 相当于将某个字节码文件加载到内存中
    + 此过程就称为类的加载。**加载到内存中的类，就称为运行时类。**
        + 此运行时类，就作为Class的一个实例
        + 换句话说，**Class的实例就对应着一个运行时类**

+ 加载到内存中的  运行时类  会缓存一定的时间，在此时间内，可以通过不同的方式来获取此运行时类



```
        // 获取Class的实例的方式
        // 方式一：调用运行时类的属性：.class
        Class<Person> clazz1 = Person.class; // 可以加上泛型，效果一样，加上的话后面就不用强转了
        System.out.println(clazz1); // class com.example.java.Person

        // 方式二：通过运行时类的对象，调用getClass()
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2); // class com.example.java.Person

        // 方式三：调用Class的静态方法：forName(String classPath)   （用方式三居多）
        Class clazz3 = Class.forName("com.example.java.Person");
//        clazz3 = Class.forName("java.lang.String");
        System.out.println(clazz3); // class com.example.java.Person

        // 加载到内存中的  运行时类  会缓存一定的时间，在此时间内，可以通过不同的方式来获取此运行时类
        System.out.println(clazz1 == clazz2); // true
        System.out.println(clazz1 == clazz3); // true
        System.out.println(clazz2 == clazz3); // true


        // 前三种方式需要掌握
        // 方式四：使用类的加载器：ClassLoader （了解）
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("com.example.java.Person");
        System.out.println(clazz4);
        System.out.println(clazz1 == clazz4); // true
```



#### 哪些类型可以有Class对象

+ class：外部类，成员（成员内部类，静态内部类），局部内部类，匿名内部类

    + 包括Class本身

+ interface：接口

+ []：数组

    + ```java
        int[] a = new int[10];
        int[] b = new int[100];
        Class ca = a.getClass();
        Class cb = b.getClass();
        System.out.println(ca == cb);
        ```

    + 只要数组的元素类型与纬度一样，就是同一个Class

+ enum：枚举

+ annotation：注解@interface

+ primitive type：基本数据类型

+ void

    



#### 类的加载过程

当程序主动使用某个类时，如果该类还未被加载到内存中，则系统会通过如下三步来对该类进行初始化

+ 类的加载（Load）

    + 将类的class文件读入内存，并将这些**静态数据转换成方法区的运行时数据结构**，
    + 然后生成一个代表这个类的java.lang.Class对象，作为方法区中类数据的访问入口（即引用地址）
    + 所有需要访问和使用类数据只能通过这个Class对象
    + 此过程由类加载器完成

+ 类的链接（Link）

    + 将类的二进制数据合并到JVM的运行状态之中的过程
    + 验证：确保加载的类信息符合JVM规范，例如：以cafe开头，没有安全方面的问题
    + 准备：正式为类变量（static）分配内存并**设置类变量默认初始值（比如int为0，引用型的为null）**的阶段，这些内存都将在方法区中进行分配
    + 解析：虚拟机常量池内的符号引用（常量名）替换为直接引用（地址）的过程

+ 类的初始化（Initialize）

    + 执行**类构造器<clinit>()**方法的过程。**类构造器<clinit>()方法是由编译期自动收集类中所有类变量的赋值动作和静态代码块中的语句合并产生的**。（类构造是构造类信息的，不是构造该类对象的构造器）
    + 当初始化一个类的时候，如果发现其父类还没有进行初始化，**则需要先触发其父类的初始化**

    + 虚拟机会保证一个类的<clinit>()方法在多线程环境中被正确加锁和同步



```
    @Test
    public void ClassLoadingTest(){
        System.out.println(A.m); // 100
    }
}

class A{
    static {
        m = 300;
    }
    // 静态代码块和显示赋值就是个谁先谁后的关系
    static int m = 100;
}
/*
1. 类的加载，将类A加载到内存中
2. 链接结束后 m=0
3. 初始化后，m的值由<clinit>()方法执行决定
    这个A的类构造器<clinit>()方法由类变量的赋值和静态代码块中的语句按照顺序合并产生
    类似于
        <clinit>(){
            m = 300;
            m = 100;
        }
 */
```



源程序(\*.java文件 )-->Java编译器-->字节码(\*.class文件)-->类装载器 --> 字节码校验器 -->解释器 --> 操作系统平台



#### 类加载器的作用

+ 类加载的作用：将class文件字节码内存加载到内存中，并**将这些静态数据转换成方法区的运行时数据结构**，然后在**堆**中生成一个代表这个类的java.lang.Class对象，**作为方法区中类数据的访问入口**
+ 类缓存：标准的JavaSE类加载器可以按要求查找类，但一旦某个类被加载到类加载器中，它将维持加载（缓存）一段时间。不过JVM垃圾回收机制可以回收这些Class对象。



# Day40 2020/10/7

## ClassLoader

类加载器作用是用来把类（class）装载进内存的，JVM规范定义了如下类型的类的加载器

+ **引导类加载器**：用C++编写的，是JVM自带的类加载器，**负责Java平台核心库**，用来装载核心类库，该加载器无法直接获取
+ **扩展类加载器**：负责jre/lib/ext目录下的jar包或-D java.ext.dirs指定目录下的jar包装入工作库
+ **系统类加载器**：负责java -classpath 或 -D java.class.path所指的目录下的类与jar包装入工作，是最常用的加载器

```java
// 对于自定义类，使用系统类加载器进行加载
ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
System.out.println(classLoader); // sun.misc.Launcher$AppClassLoader@18b4aac2 系统加载器
// 调用系统类加载的getParent()：获取扩展类加载器
ClassLoader classLoader1 = classLoader.getParent();
System.out.println(classLoader1); // sun.misc.Launcher$ExtClassLoader@23fc625e 扩展类加载器
// 调用扩展类加载器的getParent()：无法获取引导类加载器
// 引导类加载器主要负责加载java的核心类库，无法加载自定义类的
ClassLoader classLoader2 = classLoader1.getParent();
System.out.println(classLoader2); // null 无法主动获取到引导类加载器

ClassLoader classLoader3 = String.class.getClassLoader();
System.out.println(classLoader3); // null
```

```java
 /*
    Properties：用来读取配置文件
     */
    @Test
    public void test2() throws IOException {

        Properties pros = new Properties();
        // 测试的文件默认在当前的module下
        // 读取配置文件的方式一：
//        FileInputStream fis = new FileInputStream("jdbc.properties");
//        pros.load(fis);

        // 读取配置文件的方式二：使用ClassLoader
        // 配置文件默认识别为，当前module的src下
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties"); // 这时默认是在src目录下
        pros.load(is);

        String name = pros.getProperty("name");
        int age = Integer.parseInt(pros.getProperty("age"));
        System.out.println(name + " : " + age);

        is.close();
    }
```



### 创建运行时类的对象

```
/*
newInstance()：调用此方法，创建对应的运行时类的对象。内部调用了运行时类的空参构造器

要想此方法正常的创建运行时类的对象，要求：
    1. 运行时类必须提供空参的构造器
    2. 空参的构造器的访问权限得够。通常，设置为public

在javabean中要求提供一个public的空参构造器。原因：
    1. 便于通过反射，创建运行时类的对象
    2. 便于子类继承此运行时类时，默认调用super()时，保证父类有此构造器
 */
```

```java
// 体现反射的动态性
    @Test
    public void test2(){
        int num = new Random().nextInt(3); // 0,1,2
        String classPath = "";
        switch (num){
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
//                classPath = "java.sql.Date"; // java.sql.Date类没有空参构造器，故这里会抛异常
                classPath = "java.lang.Object";
                break;
            case 2:
                classPath = "com.example.java.Person";
                break;
        }
        try {
            Object obj = getInstance(classPath);
            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Object getInstance(String classPath) throws Exception{
        Class clazz = Class.forName(classPath);
        return clazz.newInstance();
    }
```



### 获取运行时类中的指定结构

见代码。



### 调用运行时类的指定结构

见代码。





# Day41 2020/10/8

## 动态代理（反射的应用）

+ 代理设计模式的原理
    + 使用一个代理将对象包装起来，然后用该代理对象取代原始对象。
    + 任何对原始对象的调用都要通过代理
    + 代理对象决定是否以及何时将方法调用转到原始对象上
+ 静态代理，特征是**代理类和目标对象的类都是在编译期间确定下来**，不利于程序的扩展
    + 同时，**每一个代理类只能为一个接口服务**，这样一来程序开发中必然产生过多的代理
    + **最好可以通过一个代理类完成全部的代理功能**

+ 动态代理是指客户通过代理类来调用其他对象的方法，并且使在程序运行时根据需要动态创建目标类的代理对象
    + 动态代理使用场合
        + 调试
        + 远程方法调用
+ 动态代理相比于静态代理的优点
    + 抽象角色中（接口）声明的所有方法都被转义到调用处理器一个集中的方法中处理
    + 这样，可以更加灵活和统一的处理众多的方法





### 动态代理与AOP（Aspect Orient Programming）

+ AOP代理的方法
    + 动态代理增加的通用方法1
    + 回调目标对象的方法
    + 动态代理增加的通用方法2





## Java8的其他新特性

+ 速度快
+ 代码更少（增加了新的语法：Lambda表达式）
+ 强大的Stream API
+ 便于并行
+ 最大化减少空指针异常：Optional
+ Nashorm引擎，允许在JVM上允许JS应用



#### 并行流与串行流

+ 并行流是把一个内容分成多个数据块，并用不同的线程分别处理每个数据块的流。
    + 相比较串行的流，**并行的流可以很大程度上提高程序的执行效率**
+ Stream API可以声明性地通过parallel()与sequential()在并行流与顺序流之间进行切换





## Lambda表达式

Lambda是一个匿名函数，可以理解为一段可以传递的代码（将代码像数据一样进行传递）。使用它可以写出更简洁、更灵活的代码。

但在Java中**Lambda表达式是对象，而不是函数**，且必须依附于函数式接口

```
 * Lambda表达式的使用及举例
 *
 * 1. 举例：(o1, o2) -> Integer.compare(o1, o2);
 * 2. 格式：
 *          -> ：Lambda操作符 或 箭头操作符
 *          ->左边：Lambda形参列表 （其实就是接口中的抽象方法的形参列表）
 *          ->右边：Lambda体    （其实就是重写的抽象方法的方法体）
 *
 * 3. Lambda表达式的使用：（分为6中情况介绍）
 *
 *      总结：
 *      ->左边：Lambda形参列表的参数类型可以省略（类型推断），如果Lambda形参列表只有一个参数，其一对()也可以省略
 *      ->右边：Lambda体应该使用一对{}包裹，如果Lambda体只有一条执行语句（可能是return语句），可以省略这一对{}和return关键字
 *
 * 4. Lambda表达式的本质：作为接口（函数式）的实例
 *    Lambda表达式依赖于函数式接口
 * 
 * 5. 如果一个接口中，只声明了一个抽象方法，则此接口就称为函数式接口
```



## 函数式接口

如果一个接口中，只声明了一个抽象方法，则此接口就称为函数式接口

比如，Runnable接口、Comparator接口

并且在此类接口上面还有一个注解，FunctionalInterface

不加此注解也是函数式接口，只不过加上后就可以验证它是不是了



+ 只包含一个抽象方法的接口，称之为函数式接口
+ 可以通过Lambda表达式来创建该接口的对象
    + 若Lambda表达式抛出一个受检异常（即：非运行时异常），那么该异常需要在目标接口的抽象方法上进行声明）
+ 可以在接口上使用@FunctionalInterface注解，这样做可以检查它是否是一个函数式接口。
    + 同时javadoc也会包含一条声明，说明这个接口是一个函数式接口
+ 在java.util.function包下定义了Java 8的丰富的函数式接口



为何需要函数式接口？

+ 需要Java不但可以支持OOP还要支持OOF（面向函数编程）
+ Lambda表达式就是一个函数式接口的实例
+ 所有以前用匿名实现类表示的现在都可以用Lambda表达式来写



### Java内置四大核心函数式接口

| 函数式接口               | 参数类型 | 返回类型 | 用途                                                         |
| ------------------------ | -------- | -------- | ------------------------------------------------------------ |
| Consumer\<T\>消费型接口  | T        | void     | 对类型为T的对象应用操作，包含方法：void accept(T, t)         |
| Supplier\<T\>供给型接口  | 无       | T        | 返回类型为T的对象，包含方法：T get()                         |
| Function<T, R>函数型接口 | T        | R        | 对类型为T的对象应用操作，并返回结果，结果是R类型的对象。包含方法：R apply(T t) |
| Predicate\<T\>判定型接口 | T        | boolean  | 确定类型为T的对象是否满足某约束，并返回boolean值。包含方法：boolean test(T t) |



## 方法引用和构造器引用和数组引用

### 方法引用（Method References）

+ 当要转递给Lambda体的操作，**已经有实现的方法了**，可以使用方法引用
+ 方法引用可以看做事Lambda表达式深层次的表达
    + 换句话说，方法引用就是Lambda表达式，也就是函数式接口的一个实例
    + 通过方法的名字来执行一个方法，可以认为事Lambda表达式的一个语法糖
+ 要求：**实现接口的抽象方法的参数列表和返回值类型，必须与方法引用的方法的参数列表和返回值类型保持一致！（针对于情况1和情况2）**

+ 格式：使用操作符“::”将类（或对象）与方法名分隔开来
+ 如下三种主要使用情况：
    + 对象::实例方法名（情况1）
    + 类::静态方法名（情况2）
    + 类::实例方法名（情况3）



```
* 构造器引用
*      和方法引用类似，函数式接口的抽象方法的形参列表和构造器的形参列表一致。
*      抽象方法的返回值类型即为构造器所属的类的类型
*
* 数组引用
*      可以将数组看做是一个特殊的类，则写法与构造器引用一致
```



## 强大的Stream API

+ Java8中两个最为重要的改变，第一个是**Lambda表达式**；另一个就是**StreamAPI**
+ Stream API（java.util.stream）把真正的函数式编程风格引入到java中。
    + 这是目前为止对Java类库最好的补充
    + 因为StreamAPI可以极大提供Java程序员的生产力，让程序员写出高效率、干净、简洁的代码
+ Stream是Java8中处理集合的关键抽象概念，它可以指定我们希望对集合进行的操作，可以执行非常复杂的查找、过滤和映射数据等操作
    + 使用StreamAPI对集合数据进行操作，就类似于使用SQL执行的数据库查询
    + 也可以使用StreamAPI来并行执行操作
    + 简言之，StreamAPI提供了一种高效且易于使用的处理数据的方式



#### 为什么要使用StreamAPI

+ 实际开发中，项目中多数数据源都来自于Mysql。Oracle等。
    + 但现在数据源可以更多了，有MongoDB,Redis等
    + 这些NoSql的数据就需要Java层面去处理
+ Stream和Collection集合的区别：
    + Collection是一种静态的内存数据结构，而Stream是有关计算的
    + 前者是主要面向内存，存储在内存中的
    + 后者主要是面向CPU，通过CPU实现计算的



#### 什么是Stream

是数据渠道，用于操作数据源（集合、数组等）所生成的元素序列

注意：

+ Stream自己不会存储元素
+ Stream不会改变源对象。相反，它们会返回一个持有结果的新的Stream
+ Stream操作是延迟执行的。这意味着它们会等到需要结果的时候才执行



#### Stream的操作三个步骤

+ 创建Stream
    + 一个数据源（如：集合、数组），获取一个流

        + ```
            // 创建Stream方式一：通过集合
            // default Stream<E> stream() ：List接口的一个default方法，返回一个顺序流
            // default Stream<E> parallelStream()：返回一个并行流
            
            // 创建Stream方式二：通过数组
            // 通过Arrays类的静态方法static <T> Stream<T> stream(T[] array)：返回一个流
            
            // 创建Stream方式三：通过Stream的of()
            Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);
            
            // 创建Stream方式四：创建无限流
            // 迭代
            // public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
            // 遍历前10个偶数
            Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);
            
            // 生成
            // public static<T> Stream<T> generate(Supplier<T> s)
            Stream.generate(Math::random).limit(10).forEach(System.out::println);
            ```

+ 中间操作

    + 一个中间操作**链**，对数据源的数据进行处理。（延迟执行）

    + 多个中间操作可以连接起来形成一个流水线，除非流水线上触发终止操作，否则中间操作不会执行任何的处理

    + 而在终止操作时一次性全部处理，称为“**惰性求值**”。

        + 筛选与切片

            + | 方法                | 描述                                                         |
                | ------------------- | ------------------------------------------------------------ |
                | filter(Predicate p) | 接收Lambda，从流中排除某些元素                               |
                | distinct()          | 筛选，通过流所生成元素的hashCode()和equals()去除重复元素     |
                | limit(long maxSize) | 截断流，使其元素不超过给定数量                               |
                | skip(long n)        | 跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流。与limit(n)互补 |

            

+ 终止操作（终端操作）

    + 一旦执行终止操作，**就执行中间操作链**，并产生结果。
    + 之后，**不会再被使用**



