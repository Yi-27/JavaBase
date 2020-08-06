package day18.abstractTest;

// 抽象类 雇员类
public abstract class Employee {
	
	private String name;
	private int id;
	private double salary;
	
	public Employee() {
		super();
	}

	public Employee(String name, int id, double salary) {
		super();
		this.name = name;
		this.id = id;
		this.salary = salary;
	}
	
	public abstract void work(); // 抽象方法
	
}
