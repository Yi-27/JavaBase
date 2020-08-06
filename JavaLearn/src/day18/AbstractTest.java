package day18;

public class AbstractTest {

	public static void main(String[] args) {
		// 抽象类不能实例化
//		Person p1 = new Person();
//		p1.eat();
		
	}
	
	
}

abstract class Person{
	String name;
	int age;
	
	public Person() {
		
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// 抽象方法
	public abstract void look();
	
	public void eat() {
		System.out.println("吃饭");
	}
	
	public void walk() {
		System.out.println("走路");
	}
}


class Student extends Person{
	
	public Student(String name, int age) {
		super(name, age);
	}

	// 一定要重写所有的抽象方法，包括父类的父类的
	@Override
	public void look() {
		// TODO Auto-generated method stub
		
	}
	
	
}