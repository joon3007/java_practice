package day03;

import java.util.Scanner;

public class InputTask {
	public static void main(String[] args) {
		// �� ������ �Է¹��(next() ���)
		// �� ������ �� ���
		Scanner sc = new Scanner(System.in);

		int val1 = 0;
		int val2 = 0;
		int result = 0;
		String msg = "";

		String n1Msg = "ù��° ���� :  ";
		String n2Msg = "�ι�° ���� :  ";

		System.out.print(n1Msg);
		//val1 = Integer.parseInt(sc.next());
		val1 = sc.nextInt();
		System.out.print(n2Msg);
		//val2 = Integer.parseInt(sc.next());
		val2 = sc.nextInt();
		result = val1 + val2;
		//String.format("���Ĺ���", ��); : ���ڿ� ��
		
		msg = String.format("%d + %d = %d", val1, val2, result);
		System.out.printf(msg);
	}
}
