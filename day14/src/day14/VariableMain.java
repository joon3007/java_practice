package day14;

public class VariableMain {
	public static void main(String[] args) {
		VariableTest v = new VariableTest();
		//��� ��ü�� �����ϴ� �����ʹ� �ݵ�� static!
		
		v.increase_s();
		v.increase_s();
		v.increase_s();
		v.increase_s();
		v.increase_s();
		
		v = new VariableTest();
		VariableTest v2 = new VariableTest();
		System.out.println(v2.data_s);
		
		v.increase_s();
		v.increase_s();
		v.increase_s();
		v.increase_s();
		v.increase_s();
		
//		v.increase();
//		v.increase();
//		v.increase();
//		v.increase();
//		v.increase();
//		
//		v = new VariableTest();
//		
//		v.increase();
//		v.increase();
//		v.increase();
//		v.increase();
//		v.increase();
		
	}
}
