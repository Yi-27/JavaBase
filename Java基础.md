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