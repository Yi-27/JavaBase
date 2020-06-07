# Day1		2020/6/5

+ Java仍然会存在内存泄漏和溢出的问题。
+ 文档注释，注释内容可以被JDK提供的工具javadoc所解析，被生成一套网页文件行形式对于该程序的说明文档。

+ 八种基本数据类型
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

+ 自动类型提升

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

+ 强制类型转换

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

+ 进制

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

+ 逻辑运算符

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

+ 从键盘获取输入值

    + ```java
        import java.util.Scanner;
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt(); // 从控制台获取输入的int数值
        ```

    + Scanner没有提供相关的方法来获取char型数据，只能获取一个字符串

    + 字符串的charAt(index)方法获取指定位置上的字符

+ 随机数

    + Math.random(); // [0.0, 1.0)

+ switch结构中的表达式，只能是byte、short、char、int、枚举类型、String类型

    + default的位置是灵活的，上中下都行
    + 能用if-else又能用switch-case的情况下，优先选switch-case，因为其执行效率稍高

+ system.currentTimeMillis(); // 获取19700101000000距离到现在的毫=秒数，long型

+ 嵌套循环，带标签的break和continue

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

    + 

 