package day04;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		
		String msg = "�縷�� ���� �����ϴ� ���� ��\n ���� ���� ���� ������ �����ϼ���.\n�Է� :\n";
		String choiceMsg = "1.ȣ���� \n2.��\n3.������\n4.��\n5.��";
		
		String answer1 = "������";
		String answer2 = "���";
		String answer3 = "�ڽ�";
		String answer4 = "����";
		String answer5 = "���";
		String errMsg = "�ٽ� �õ����ּ���";
		
		System.out.println(msg+choiceMsg);
		choice = sc.nextInt();
		
		//����ڰ� �Է��� ������ �ϳ��� ���Ѵ�.
		//���̶�� false�κ��� �� �̻� ���� �ʴ´�.
		String result = choice == 1? answer1:
			choice == 2? answer2:
				choice == 3? answer3:
					choice == 4? answer4:
						choice == 5? answer5:
							errMsg;
				
		//errMsg�� ���� �״�� ����ؾ� �ϹǷ� ���� �����ڸ� �ѹ� �� ����Ѵ�.
		result = result.equals(errMsg) ? result : "����� "+result+"��(��) ���Ƚ��ϴ�";
		System.out.println(result);
	}
}
