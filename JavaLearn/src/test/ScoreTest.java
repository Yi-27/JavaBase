package test;

import java.util.Scanner;
import java.util.Vector;

/**
 * 
 * @author Yi-27
 * @Time:2020年7月2日 下午4:21:21
 * @Description:
 * 利用Vector代替数组处理，从键盘读取学生成绩（负数表示输入结束），找出最高分，并输出学生成绩等级
 * 数组一旦创建，长度固定不变， 但是 向量类java.util.Vector可以根据需要动态伸缩
 * 
 * Vector v = new Vector();
 * v.addElement(Object obj); // 向向量中添加元素
 * Object obj = v.elementAt(0); // 按下标取出元素
 * v.size(); // 计算向量的长度
 * 
 * 与最高分相差10分内 A等，20分内B等，30分内C等，其它D等
 * 
 */
public class ScoreTest {
	
	public static void main(String[] args) {
		// 1. 实例化Scanner，用于从键盘获取学生成绩
		Scanner scan = new Scanner(System.in); 
		
		// 2. 创建Vector对象，相当于数组
		Vector v = new Vector();
		
		int maxScore = 0;
		
		// 3. for(;;)给Vector中添加数据
		for(;;) {
			System.out.println("输入学生成绩（以负数代表输入结束）");
			int score = scan.nextInt();
			if(score < 0) {
				break;
			}
			if(score > 100) {
				System.out.println("输入的数据非法，请重新输入");
				continue;
			}
			// jdk5.0之前
//			Integer inScore = new Integer(score);
//			v.addElement(inScore); // 多态
			
			// jdk5.0之后
			v.addElement(score); // 自动装箱
			
			if(maxScore < score) {
				maxScore = score;
			}
		}
		// 4. 输入负数时，终止循环
		
		// 5. 获取学生成绩的最大值
		
		// 6. 遍历Vector得到每个学生的成绩，并与最大成绩比较，得到每个学生的等级
		char level;
		for(int i = 0; i < v.size(); i++) {
			Object obj = v.elementAt(i);
			
			// jdk5.0之前
//			Integer inScore = (Integer)obj;
//			int score = inScore.intValue();
			
			// jdk5.0之后
			int score = (int)obj; // 其实应该先拆成Integer再拆成int，但可以这样一步到位
			
			if(maxScore - score <= 10) {
				level = 'A';
			}else if(maxScore - score <= 20) {
				level = 'B';
			}else if(maxScore - score <= 30) {
				level = 'C';
			}else {
				level = 'D';
			}
			System.out.println("学生-" + i + " 成绩：" + score + " 等级：" + level);
			
		}
	}
	
}
