package day16;



/**
 * 
 * @author Yi-27
 * @Time:2020年8月3日 下午11:03:28
 * @Description:
 *
 *: 单例设计模式
 */
public class SingletonTest1 {

	public static void main(String[] args) {
		// 5.获取单例
		Bank bank1 = Bank.getInstance();
		Bank bank2 = Bank.getInstance(); // 这两个获取到的是同一个对象
			
	}
}

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