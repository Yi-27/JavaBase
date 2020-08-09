package day21;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

import org.junit.Test;

public class ExceptionTest {

	// 运行时异常
	// NullPointerException
	@Test
	public void test1() {
		int[] arr = null;
		System.out.println(arr[1]); // 空指针异常
	}
	
	// ClassCastException
	@Test
	public void test2() {
		Object object = new Date();
		String str = (String)object; // 类型转换异常
	}
	
	// NumberFormatException
	@Test
	public void test3() {
		String string = "123";
		string = "abc";
		int num = Integer.parseInt(string); // 数值格式异常
	}
	
	// InputMisatchException
	@Test
	public void test4() {
		Scanner scanner = new Scanner(System.in);
		int score = scanner.nextInt(); // 当输入 abc 时 报输入格式不匹配异常
		System.out.println(score);
	}
	
	// 编译时异常 直接编译不通过，就运行不了
}
