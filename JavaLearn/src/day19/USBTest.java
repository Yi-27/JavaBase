package day19;

// 接口的使用
public class USBTest {
	public static void main(String[] args) {
		Computer c =  new Computer();
		// 1. 创建了接口的非匿名实现类的非匿名对象
		Flash flash = new Flash();
		c.transferData(flash);
		
		// 2. 创建了接口的非匿名实现类的匿名对象
		c.transferData(new Flash());
		
		// 3. 创建了接口的匿名实现类的非匿名对象
		USB phone = new USB() {
			
			@Override
			public void stop() {
				// TODO Auto-generated method stub
				System.out.println("手机开始工作");
			}
			
			@Override
			public void start() {
				// TODO Auto-generated method stub
				System.out.println("手机结束工作");
			}
		};
		
		// 4. 创建了接口的匿名实现类的匿名对象
		c.transferData(new USB() {
			
			@Override
			public void stop() {
				// TODO Auto-generated method stub
				System.out.println("MP3开始工作");
			}
			
			@Override
			public void start() {
				// TODO Auto-generated method stub
				System.out.println("MP3结束工作");
			}
		});
 	}
	
}

class Computer{
	
	public void transferData(USB usb) { // USB usb = new Flash();这里形参USB是接口，但是其实传来的是实际的子类实现对象
		usb.start();
		System.out.println("传输数据");
		usb.stop();
	}
	
}

interface USB{
	void start();
	void stop();
}

class Flash implements USB{

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("U盘开始工作");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("U盘结束工作");
	}
	
}