package day07;

import java.util.Scanner;

public class ArTask {
	public static void main(String[] args) {
		// *�ʱ�*//
		// 100 ~ 1 ���� �迭�� �ְ� ���
		int[] arNum = new int[100];

		for (int i = 0; i < arNum.length; i++) {
			arNum[i] = i + 1;
			System.out.println(arNum[i]);
		}
		// 1 ~ 100���� �� ¦���� �迭�� �ְ� ���
		for (int i = 0; i < arNum.length / 2; i++) {
			arNum[i] = (i + 1) * 2;
			System.out.println(arNum[i]);
		}
		// 1 ~ 10���� �迭�� �ְ� �� �� ���
		int[] arNum2 = new int[10];
		int total = 0;
		for (int i = 0; i < arNum.length / 2; i++) {
			arNum[i] = i + 1;
			total += arNum[i];
		}
		System.out.println(total);

		// *�߱�*//
		// A~F���� �迭�� �ְ� ���
		char[] arInt = new char[6];
		for (int i = 0; i < arInt.length; i++) {
			arInt[i] = (char) (65 + i);
			System.out.printf("%c", arInt[i]);
		}
		// A~F���� �� e�� �����ϰ� �迭�� �ְ� ���
		char[] arInt2 = new char[6];
		for (int i = 0; i < arInt2.length; i++) {
			if (65 + i == 'C')
				continue;
			arInt2[i] = (char) (65 + i);
			System.out.printf("%c", arInt2[i]);
		}
		System.out.println();

		// 5���� ������ �Է¹ް� �ִ밪�� �ּҰ� ����ϱ�
		Scanner sc = new Scanner(System.in);
		int[] arInt3 = new int[5];
		int max = 0, min = 0;
		for (int i = 0; i < arInt3.length; i++) {
			System.out.printf("%d��° ������ �Է����ּ���.", i + 1);
			if (i == 0) {
				max = sc.nextInt();
				min = max;
				continue;
			}
			int tem = sc.nextInt();
			if (max < tem) {
				max = tem;
			} else if (min > tem)
				min = tem;
		}
		System.out.println("�ִ밪 : " + max + " �ּڰ� : " + min);

		// *���*//
		// ���ڿ��� �Է¹ް�(�ѱ�����) �ҹ��ڴ� �빮�ڷ� �����ؼ� ���

		System.out.println("���ڿ��� �Է����ּ���.");
		String msg = sc.next();
		for (int i = 0; i < msg.length(); i++) {
			if (msg.charAt(i) > 96)
				System.out.printf("%c", msg.charAt(i) - 32);
			else
				System.out.println(msg.charAt(i));
		}
		System.out.println();

		// ���� �Է¹ް� �ѱ۷� �����ؼ� ���
		System.out.println("������ �Է����ּ���.");
		String korNum = "�����̻�����ĥ�ȱ�";
		String msg2 = sc.next();
		for (int i = 0; i < msg2.length(); i++)
			System.out.printf("%s", korNum.charAt(msg2.charAt(i) - 48));
		System.out.println();
		// �Է� ��)1024
		// ��� ��)�ϰ��̻�

	}
}
