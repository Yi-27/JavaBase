package day22;
/**
 * 
 * @author Yi-27
 * @Time:2020年8月10日 下午11:45:40
 * @Description:
 * 
 */

import org.junit.Test;

public class FinallyTest {
	
	@Test
	public void testMethod() {
		int num = test();
		System.out.println(num);
	}
	
	public int test() {
		try {
			int[] arr = new int[10];
			System.out.println(arr[10]);
			return 1;
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			e.printStackTrace();
			return 2;
		}finally {
			System.out.println("这一定会被执行"); // 肯定会执行
			return 3; // 肯定会返回3
		}
	}
	
	
	
	

	@Test
	public void test1() {
		try {
			int a = 10;
			int b = 0;
			System.out.println(a / b);
		}catch(ArithmeticException e) {
			e.printStackTrace();
			int[] arr = new int[10];
			System.out.println(arr[10]);
		}catch(Exception e) {
			e.printStackTrace();
		}finally { // finally是可选的
			System.out.println("这一定会被执行"); // 即使catch中又出现了异常
		}
	}
	
	
}
