package day19;

public class InterfaceTest {

}

// 
interface Flyable{
	
	// 全局常量
	public static final int MAX_SPEED = 7900; // 第一宇宙速度
	int MIN_SPEED = 1; // public static final  可以省略
	
	// 抽象方法
	public abstract void fly();
	
	void stop(); // 省略了public abstarct
	
}

class Plane implements Flyable{

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("飞机飞");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("飞机停止");
	}
	
}

interface Attackable{
	void attack();
}

class Bullet extends Object implements Flyable, Attackable{
	// 继承多个接口
	
	
	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}
	
}

interface AA{
	void method1();
}

interface BB{
	void method2();
}

interface CC extends AA, BB{
	// 继承到了两个方法
}