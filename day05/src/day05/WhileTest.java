package day05;

import java.util.Scanner;

public class WhileTest {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String msg = "�縷�� ���� �����ϴ� ���� ��\n ���� ���� ���� ������ �����ϼ���.\n";
		String choiceMsg = "1.ȣ���� \n2.��\n3.������\n4.��\n5.��\n6.������\n�Է� :\n";

		String answer1 = "������";
		String answer2 = "���";
		String answer3 = "�ڽ�";
		String answer4 = "����";
		String answer5 = "���";
		String errMsg = "�ٽ� �õ����ּ���";

		String result = "";
		int choice = 0;
		boolean check = false;
		
		while(choice != 6) {
			result = "";
			check = false;
			System.out.println(msg + choiceMsg);
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				result = answer1;
				break;
			case 2:
				result = answer2;
				break;
			case 3:
				result = answer3;
				break;
			case 4:
				result = answer4;
				break;
			case 5:
				result = answer5;
				break;
			case 6 :
				check = true;
				break;
			default:
				result = errMsg;
				check = true;
			}
	
			if (!check) {
				result = "����� " + result + "��(��) ���Ƚ��ϴ�.";
			}
			System.out.println(result);
		}
	}
}
