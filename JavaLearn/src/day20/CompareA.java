package day20;

// 除了定义全局常量和抽象方法之外，还可以定义**静态方法**和**默认方法**
public interface CompareA {
	
	// 静态方法
	public static void method1() {
		System.out.println("静态方法");
	}
	
	// 默认方法
	public default void method2() {
		System.out.println("默认方法1");
	}
	
	default void method3() { // 不加public默认就是public
		System.out.println("默认方法2");
	}
}
