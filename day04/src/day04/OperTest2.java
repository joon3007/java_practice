package day04;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class OperTest2 {
	public static void main(String[] args) {
		// 두 정수 입력
		// 두 수가 같을때
		int num1 = 0;
		int num2 = 0;
		int result = 0;
		String result2 = "";

		String n1Msg = "정수 1을 입력하세요.";
		String n2Msg = "정수 2을 입력하세요.";
		String n3Msg = "두 수가 같습니다.";
		String n4Msg = "큰 값 : %d";
		String msg = "";

		num1 = Integer.parseInt(JOptionPane.showInputDialog(n1Msg));
		num2 = Integer.parseInt(JOptionPane.showInputDialog(n2Msg));

		//큰 값을 출력
		result = num1 > num2 ? num1 : num1 == num2 ? -9999 : num2;
		String resultMsg = result == -9999 ? n3Msg : n4Msg;
		//두 수가 같거나 num2이 크다면 false부분인 이영영으로 온다.
		//한 번 더 삼항 연산자를 사용해서 판단해준다.
		
		msg = String.format(resultMsg, result);
		JOptionPane.showMessageDialog(null, msg);
	}
}
