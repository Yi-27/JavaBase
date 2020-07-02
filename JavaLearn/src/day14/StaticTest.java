package day14;

/**
 * 
 * @author Yi-27
 * @Time:2020年7月3日 上午12:12:12
 * @Description:
 *	static关键字的学习
 */
public class StaticTest {

	public static void main(String[] args) {
		
		Human.nation = "啊中国"; // 静态变量的加载是早于对象的创建的
		
		Human h1 = new Human();
		h1.name = "张三";
		h1.age = 23;
		h1.nation = "中国";
		
		Human h2 = new Human();
		h2.name = "李四";
		h2.age = 32;
		h1.nation = "中国啊";
		
		System.out.println(h1.nation);
	
	}
}

class Human{
	
	String name;
	int age;
	static String nation; // static修饰属性，静态变量
	
}