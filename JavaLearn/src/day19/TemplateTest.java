package day19;

public class TemplateTest {
	public static void main(String[] args) {
		
		SubTemplate t = new SubTemplate();
		t.spendTime();
	}
}

abstract class Template{
	
	// 计算某段代码或非的时间
	public void spendTime() {
		long start = System.currentTimeMillis(); // 获取当前时间
		code(); // 不确定的部分
		long end = System.currentTimeMillis();
		
		System.out.println("代码花费的时间为：" + (end - start));
	}
	
	public abstract void code();

}


class SubTemplate extends Template{

	@Override
	public void code() {
		// TODO Auto-generated method stub
		for(int i=2; i<=1000; i++) {
			boolean isFlag = true;
			for(int j=2; j<=Math.sqrt(i); j++) { // sqrt开方
				if(i % 2 == 0) {
					isFlag = false;
					break;
				}
			}
			if(isFlag) {
				System.out.println(i);
			}
		}
	}
	
}