package day09;

public class MethodTest {

	public int add(int num1, int num2) {
		// TODO Auto-generated method stub
		return num1 + num2;
	}
	
	//�������� ������ �޼ҵ� �Ҽ��� 2��° ������
	public String divide(int num1, int num2) {
		// TODO Auto-generated method stub
		if (num2 != 0)
			return String.format("%.2f", (double)num1 / num2);
		else
			return "error";
	}
	
	//test
	public static void main(String[] args) {
		MethodTest cal = new MethodTest();
		System.out.println(cal.divide(10, 3));
	}
	
}
