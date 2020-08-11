package day23;

// 自定义异常类
// 1. 继承异常类
public class EcDef extends Exception {

	// 2. 定义异常的独立的版本号
	static final long serialVersionUID = -33875169931222998L;
	
	// 3. 提供重载的构造器
	public EcDef() {
		
	}
	
	public EcDef(String msg) {
		super(msg);
	}
}
