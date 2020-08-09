package day20;

public class InnerClassTest2 {

	// 开发中很少见
	public void method() {
		// 局部内部类
		class AA{
			
		}
	}
	
	
	// 开发中较常见
	// 返回一个实现了Comparable接口的类的对象
	public Comparable getComparable() {
		
		// 创建了一个实现了Comparable接口的类：局部内部类
		// 方式一：
		class MyComparable implements Comparable{

			@Override
			public int compareTo(Object o) {
				// TODO Auto-generated method stub
				return 0;
			}
			
		}
		
		return new MyComparable();
	}
	
	public Comparable getComparable2() {
		
		// 方式二：匿名实现类的匿名对象
		return new Comparable() {

			@Override
			public int compareTo(Object o) {
				// TODO Auto-generated method stub
				return 0;
			}
			
		};
		
		
	}
}
