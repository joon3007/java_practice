package day04;

import java.util.Scanner;

public class OperTask {
	public static void main(String[] args) {
		// �Է� ���� ���� �������� �Ǽ����� �Ǵ� �� ����ϱ�
		// ���� �Է� :

		String val = "";
		String n1Msg = "���ڸ� �Է��ϼ���.";
		String result = "";

		Scanner sc = new Scanner(System.in);
		val = sc.next();
		
		result = val.contains(".") ? "�Ǽ�" : "����";

		System.out.println(result);

	}
}
