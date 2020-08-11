package day23;

public class EcmDef {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int i = Integer.parseInt(args[0]);
			int j = Integer.parseInt(args[1]);
			
			int result = ecm(i, j);
			System.out.println(result);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (ArithmeticException e) {
			// TODO: handle exception
			// 除0
			e.printStackTrace();
		} catch (EcDef e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public static int ecm(int i, int j) throws EcDef {
		if(i < 0 || j < 0) {
			// 抛出自定义异常
			throw new EcDef("分子或分母为负数了！");
		}
		return i / j;
	}
}
