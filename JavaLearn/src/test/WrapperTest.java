package test;

import org.junit.Test;

/**
 * 
 * @author Yi-27
 * @Time:2020年7月2日 下午4:21:30
 * @Description:
 *
 */
public class WrapperTest {
	
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
	
	
	// 包装类 ————> 基本数据类型：调用包装类的xxxValue()
	@Test
	public void test2() {
		Integer in1 = new Integer(24);
		
		int i1 = in1.intValue();
		System.out.println(i1);
		
		Boolean boolean1 = new Boolean(false);
		boolean b1 = boolean1.booleanValue();
		System.out.println(b1);
		
		Float float1 = new Float(20.3F);
		float f1 = float1.floatValue();
		System.out.println(f1);
	}

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
	}


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

	
	// String类型 ————> 基本数据类型、包装类：调用包装类的parseXxx()
	@Test
	public void test5() {
		String str1 = "123";
		// int num1 = (int)str1; 不行
		// Integer in1 = (Integer)str1; 也不行，不存在子父类的关系
		
		int num2 = Integer.parseInt(str1); // 如果是123a，带字母的，会抛出NumberFormat的异常
		System.out.println(num2);
		
		String str2 = "true1"; 
		boolean b1 = Boolean.parseBoolean(str2); // 不是不记大小写的 true，就是false
		System.out.println(b1);
	}
	
	
	// 常见面试题
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
	
}

class Order{
	
	boolean isMale; // 默认值:false
	Boolean isFemale; // 默认值:null，因为它已经是一个类了
}

