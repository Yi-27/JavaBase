package day20;

import day20.Person.DD;
import day20.Person.EE;

/**
 * 
 * @author Yi-27
 * @Time:2020年8月8日 下午11:31:37
 * @Description:
 * 内部类：类A声明在类B中，类B称为外部类，类A就是内部类
 */
public class InnerClassTest {

	// 创建DD实例（静态的成员内部类）
	Person.DD dd = new Person.DD();
	// 创建EE实例（非静态的成员内部类）
	Person p = new Person(); // 不能像静态成员内部类那样创建
	Person.EE ee = p.new EE(); // 因为静态的内部结构是随着类的加载而加载的
//	ee.work(); // 为啥不对啊！！！
	
}

class Person{
	
	String name;
	int age;
	
	public void eat() {
		System.out.println("吃");
	}
	
	// 成员内部类
	static class DD{
		
	}
    // 非静态成员内部类
    class EE{
        
    	public EE() {
    		
    	}
    	
    	public void work() {
    		eat(); // 调用外部类的非静态方法
    		Person.this.eat(); // 这是写全
    	}
    }
	
	public Person() {
		// 局部内部类
		class CC{
			
		}
	}
	
	public void method() {
		// 局部内部类
		class AA{
			
		}
	}
	
	{
		// 局部内部类
		class BB{
			
		}
	}
	
}