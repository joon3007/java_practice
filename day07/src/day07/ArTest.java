package day07;

import java.util.Scanner;

public class ArTest {
	public static void main(String[] args) {
		// ����
		// ������ ȫ���� ������
		// ��� ������� 100���������� ����Ѵ�.
		int[] arIncome = new int[3];
		String[] arBranch = { "������", "ȫ����", "������" };
		Scanner sc = new Scanner(System.in);
		int total = 0;
		double avg = 0.0;

		for (int i = 0; i < arIncome.length; i++) {
			System.out.println(arBranch[i] + " ����� �Է�(����:����)");
			arIncome[i] = sc.nextInt();
			// �� ������� ���ϴ� ����
			total += arIncome[i];
		}
		avg = Double.parseDouble(String.format("%.2f", (double) total / arIncome.length));

		System.out.println("���� �� ����� : " + total + "����");
		System.out.println("���� ��� ����� : " + avg + "����");

		// ��� ����׺��� ���� ������ �μ�Ƽ�� �������� ���
		// �μ�Ƽ�����
		// ������
		// ȫ����

		// �μ�Ƽ�� ������ ���ٸ� �ش���� ������ ���
		// �μ�Ƽ�����
		// �ش���� ����
		int count = 0;
		System.out.println("���μ�Ƽ�� �����");
		for (int i = 0; i < arBranch.length; i++) {
			if (arIncome[i] > avg) {
				System.out.println(arBranch[i]);
				count++;
			}
		}
		if (count == 0)
			System.out.println("�ش���� ����");

		
	}
}
