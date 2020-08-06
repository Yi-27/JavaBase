package day18.abstractTest;

public class Manager extends Employee{
	
	private double bonus; // 奖金
	
	
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(String name, int id, double salary, double bonus) {
		super(name, id, salary);
		// TODO Auto-generated constructor stub
		this.bonus = bonus;
	}

	public Manager(double bonus) {
		super();
		this.bonus = bonus;
	}


	
	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("管理者重写work抽象方法");
	}
}
