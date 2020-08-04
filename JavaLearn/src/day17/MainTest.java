package day17;

import java.awt.print.Printable;

import day15.StaticTest;

/**
 * 
 * @author Yi-27
 * @Time:2020年8月4日 下午9:45:09
 * @Description:
 * main()方法的使用说明
 * 1.程序的入口
 * 2.一个普通的静态方法
 * 3.类中非public 类也可以有同名同类型的main方法，但是它并不是入口
 * 
 */
public class MainTest {

	public static void main(String[] args) {
		System.out.println("111");
		Main.main(new String[100]); // 静态凋静态
		System.out.println("000");
	}
}

class Main {
	
	// 这只是个普通的静态方法
	public static void main(String[] args) {
		for(int i=0; i<args.length; i++) {
			args[i] = "args_" + i;
			System.out.println(args[i]);
		}
	}
	
}