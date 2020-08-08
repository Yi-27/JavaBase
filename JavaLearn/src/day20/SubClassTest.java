package day20;

public class SubClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubClass s = new SubClass();
//		s.method1(); 
		// 接口中定义的静态方法只能通过接口来调用
		CompareA.method1();
		
		// 默认方法可以通过对象来调用
		s.method2();
		s.method3();
	}

}

class SubClass extends SuperClass implements CompareB, CompareA{
	
	public void method2() {
		// 重写了method2方法
		System.out.println("重写method2方法");
		method3(); // 那个接口靠前，用哪个接口的默认方法
		CompareA.super.method3(); // 这样也可以调用接口中的默认方法
	}
	
}

class SuperClass{
	
	public void method3() {
		System.out.println("superClass method3");
	}
	
}

interface CompareB{
	
	 default void method3() {
		 System.out.println("compareB method3");
	 }
	
}