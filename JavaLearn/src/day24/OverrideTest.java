package day24;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 
 * @author Yi-27
 * @Time:2020年9月4日 下午10:16:46
 * @Description:
 * 方法重写规则：
 *  子类的重写的方法抛出的异常不大于父类被重写的方法抛出的异常类型
 */
public class OverrideTest {
	
	public static void main(String[] args) {
		OverrideTest test = new OverrideTest();
		test.display(new SubClass()); // 多态 调用的是子类重写后的method
	}
	
	
	public void display(SuperClass s) {
		try {
			s.method();
		} catch (IOException e) { // 这时如果子类的异常时大于父类的，这里由于明面上是处理父类的异常，就无法处理子类的异常了
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

class SuperClass{
	
	public void method() throws IOException{
		
	}
}

class SubClass extends SuperClass{
	// 不大于父类异常
	public void method() throws IOException, FileNotFoundException{
		
	}
}