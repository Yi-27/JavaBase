package day24;

/**
 * 
 * @author Yi-27
 * @Time:2020年9月4日 下午10:50:18
 * @Description:
 * 
 */
public class MyException extends Exception{

	// 全局常量，与类共存加载，唯一标识该类
	static final long serialVersionUID = -338751699312428L;
	
	public MyException() {
		
	}
	
	public MyException(String msg) {
		super(msg);
	}
	
}
