package day03;

import javax.swing.JOptionPane;

public class Dialog {
	public static void main(String[] args) {
//		JOptionPane.showMessageDialog(null, "�ȳ�");
//		String name = JOptionPane.showInputDialog("�̸��� �Է��ϼ���.");
//		JOptionPane.showMessageDialog(null, name + "�� ȯ���մϴ�.");

		// �� ������ �Է¹ް� ��� ������ ���
		// �� : ���� / ����
		// ������ : ���� % ���� (�� : 10 % 3 == 1)

		int num1 = 0;
		int num2 = 0;
		
		String n1Msg = "����1�� �Է��ϼ���.";
		String n2Msg = "����2�� �Է��ϼ���.";
		String result = "";
		
		num1 = Integer.parseInt(JOptionPane.showInputDialog(n1Msg));
		num2 = Integer.parseInt(JOptionPane.showInputDialog(n2Msg));
		int val = num1 / num2;
		int rest = num1 % num2;

		result = String.format("[���]\n�� : %d\n������ : %d\n", val, rest);
		JOptionPane.showMessageDialog(null, result);

	}
}
