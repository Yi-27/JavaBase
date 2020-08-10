package day22;

import org.junit.Test;

/**
 * 
 * @author Yi-27
 * @Time:2020年8月10日 下午9:55:14
 * @Description:
 * 异常的处理：抓抛模型
 */
public class ExceptionTest2 {

	@Test
	public void test1() {
		String string = "123";
		string = "abc";
		try {
			int num = Integer.parseInt(string);
			
			System.out.println("这行代码不执行");
		}catch(NumberFormatException e) {
			System.out.println("出行数值转换异常");
			System.out.println(e.getMessage()); // 查看异常信息
			e.printStackTrace(); // 这样也可以查看异常信息 
		}catch (NullPointerException e) {
			System.out.println("出行空指针异常 ");
		}
		
		System.out.println("这行代码继续执行");
	}
 	
}
