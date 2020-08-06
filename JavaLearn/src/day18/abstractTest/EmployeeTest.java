package day18.abstractTest;

public class EmployeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Manager manager = new Manager("张三", 1001, 9000, 5000);
		// 多态
		// Employee manager = new Manager("张三", 1001, 9000, 5000);
		
		manager.work();
		
		CommonEmployee commonEmployee = new CommonEmployee();
		commonEmployee.work();
		
		
		// 创建匿名子类的对象
		// Employee抽象类是无法实例化的
		// 但是在后面加个大括号再重写抽象类的方法，就是该抽象类的匿名子类
		Employee employee = new Employee() {
			
			@Override
			public void work() {
				// TODO Auto-generated method stub
				
			}
		};
	}

}
