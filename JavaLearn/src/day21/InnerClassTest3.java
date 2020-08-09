package day21;

public class InnerClassTest3 {

	public void onCreate() {
		
		
		
	}
	
	
	
	
	/**
	 * 在局部内部类的方法中
	 * 如果调用局部内部类所在的方法中的局部变量时
	 * 要求此局部变量声明为final的
	 * 
	 * jdk7及之前版本，要求此局部变量显示声明为final的
	 * jdk8及之后版本，可以省略final的声明
	 */
	public void method() {
		// 局部变量
		int num = 10;
		
		class AA{
			
			public void show() {
//				num = 20; // 不能修改，要求必须是final型
				System.out.println(num);
			}
			
		}
	}
	
	
	
}
