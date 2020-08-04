package day17;



/**
 * 
 * @author Yi-27
 * @Time:2020年8月4日 下午10:17:42
 * @Description:
 * 类的成员，代码块（或初始化块）
 */
public class BlockTest {

	public static void main(String[] args) {
		String desc = Person.desc;
		
		Person p1 = new Person(); // 非静态代码块会被执行
		Person p2 = new Person(); // 非静态代码块又执行了一次
	}
}


class Person{
	// 属性
	String name;
	int age;
	static String desc="这是一个描述";
	
	// 构造器
	public Person() {
		
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	// 非静态代码块
	{
		System.out.println("这是非静态代码块！");
	}
	
	// 静态代码块
	static {
		System.out.println("这是静态代码块");
	}
	
	
	
	// 方法
	public void eat() {
		System.out.println("吃饭");
	}
	
	// 静态方法
	public static void Info() {
		System.out.println("这是一个静态方法");
	}
	
	

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	
	
}