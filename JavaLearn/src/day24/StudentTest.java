package day24;

public class StudentTest {

	public static void main(String[] args) {
		try {
			Student student = new Student();
			student.regist(-1001);
			System.out.println(student);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
}


class Student{
	
	private int id;
	public void regist(int id) throws Exception {
		if(id > 0) {
			this.id = id;
		}else {
//			System.out.println("您输入的数据非法！");
			// 手动抛出异常对象
//			throw new RuntimeException("您输入的数据非法！"); // 抛的是运行时异常
//			throw new Exception("您输入的数据非法！"); // 这时就包括了编译时异常，需要进行处理
			throw new MyException("不能输入负数！");
		}
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + "]";
	}
	
	
}