package day04;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class IfTest {
	public static void main(String[] args) {
		//��� ��
		String n1Msg = "ù��° ���� �Է�";
		String n2Msg = "�ι�° ���� �Է�";
		String result = "";
		int num1 = Integer.parseInt(JOptionPane.showInputDialog(n1Msg));
		int num2 = Integer.parseInt(JOptionPane.showInputDialog(n2Msg));
		
		if (num1 > num2) {
			result = "ū �� : " + num1;
		}else if(num1 < num2) {
			result = "ū �� : " + num2;			
		}else {
			result = "�� ���� �����ϴ�.";
		}
		
		JOptionPane.showMessageDialog(null, result);
	}
}
