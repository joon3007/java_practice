package day04;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class OperTest2 {
	public static void main(String[] args) {
		// �� ���� �Է�
		// �� ���� ������
		int num1 = 0;
		int num2 = 0;
		int result = 0;
		String result2 = "";

		String n1Msg = "���� 1�� �Է��ϼ���.";
		String n2Msg = "���� 2�� �Է��ϼ���.";
		String n3Msg = "�� ���� �����ϴ�.";
		String n4Msg = "ū �� : %d";
		String msg = "";

		num1 = Integer.parseInt(JOptionPane.showInputDialog(n1Msg));
		num2 = Integer.parseInt(JOptionPane.showInputDialog(n2Msg));

		//ū ���� ���
		result = num1 > num2 ? num1 : num1 == num2 ? -9999 : num2;
		String resultMsg = result == -9999 ? n3Msg : n4Msg;
		//�� ���� ���ų� num2�� ũ�ٸ� false�κ��� �̿������� �´�.
		//�� �� �� ���� �����ڸ� ����ؼ� �Ǵ����ش�.
		
		msg = String.format(resultMsg, result);
		JOptionPane.showMessageDialog(null, msg);
	}
}
