package day13;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * @author Yi-27
 * @Time:2020年7月2日 下午11:47:10
 * @Description:
 * 	一些其他测试
 *
 */
public class OtherTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test1() {
		
		String s = "abc";
		s = null;
		System.out.println(s); // null 这里没报空指针，
		// 这是因为prinln()方法中 print()方法会判断是不是null
		// 是就直接打印 "null"，不是照常输出
		
		System.out.println("-------------");
		System.out.println(s.toString()); // NullPointedException
		
	}

}
