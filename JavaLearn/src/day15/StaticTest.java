package day15;

/**
 * @author Yi-27
 * @Time:2020年7月4日 下午11:54:56
 * @Description:
 *
 */
public class StaticTest {

	static int a = 10;
	int b = 20;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void info() {
		System.out.println("这是非静态方法");
		System.out.println(a); // 调用静态属性，省略了 类名
		System.out.println(b); // 调用非静态属性，省略了this
		show(); // 调用静态方法，也省略了类名
	}
	
	public static void show() {
		System.out.println("这是静态方法");
		System.out.println(a); // 可以调用静态属性和静态方法
//		System.out.println(b);
//		info(); // 不能调用非静态的
	}
	
	
}
