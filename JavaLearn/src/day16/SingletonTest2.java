package day16;

// 单例模式的懒汉式实现
public class SingletonTest2 {

	public static void main(String[] args) {
		
		Order order1 = Order.getInstance();
		Order order2 = Order.getInstance(); // 这两个对象仍是同一个
		
		
	}
	
}


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
