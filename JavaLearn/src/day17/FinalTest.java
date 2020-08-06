package day17;

public class FinalTest {
	final int width = 10;
	final int LEFT;
	final int RIGHT;

	
	{
		LEFT = 1; // 代码块中初始化
	}
	
	public FinalTest() {
		RIGHT = 2;
	}
	
	public FinalTest(int r) {
		RIGHT = r; // 多个构造器要考虑是否都给初始化
	}
	
	public void doWidth() {
//		width = 20; // 不能再赋值了
	}
}

final class FinalA{
	
}

//class B extends FinalA{
//	
//}