package day03;

import javax.swing.JOptionPane;

public class Dialog {
	public static void main(String[] args) {
//		JOptionPane.showMessageDialog(null, "안녕");
//		String name = JOptionPane.showInputDialog("이름을 입력하세요.");
//		JOptionPane.showMessageDialog(null, name + "님 환영합니다.");

		// 두 정수를 입력받고 몫과 나머지 출력
		// 목 : 정수 / 정수
		// 나머지 : 정수 % 정수 (예 : 10 % 3 == 1)

		int num1 = 0;
		int num2 = 0;
		
		String n1Msg = "정수1을 입력하세요.";
		String n2Msg = "정수2을 입력하세요.";
		String result = "";
		
		num1 = Integer.parseInt(JOptionPane.showInputDialog(n1Msg));
		num2 = Integer.parseInt(JOptionPane.showInputDialog(n2Msg));
		int val = num1 / num2;
		int rest = num1 % num2;

		result = String.format("[결과]\n몫 : %d\n나머지 : %d\n", val, rest);
		JOptionPane.showMessageDialog(null, result);

	}
}
