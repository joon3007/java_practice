package day09;

import java.util.Scanner;

public class MethodTask {
	// 1 ~ 10 ���� println()���� ����ϴ� �޼ҵ�
	void printNum() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i + 1);
		}
	}

	// 1 ~10������ ���� �����ִ� �޼ҵ�
	int sumNumber() {
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += i + 1;
		}
		return sum;
	}

	// 1~n������ ���� println()���� ������ִ� �޼ҵ�
	void sumNNum(int n) {
		// return sum value between 1 ~ n
		// parameter
		// 1. type integer
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += i + 1;
		}
		System.out.println(sum);
	}

	// Ȧ���� ¦����, ¦���� Ȧ���� �ٲ��ִ� �޼ҵ�
	String changeEvenAndOdd(String msg) {
		if (msg.equals("¦��")) {
			return "Ȧ��";
		} else if (msg.equals("Ȧ��"))
			return "¦��";
		else
			return "error";
	}

	// �빮�ڸ� �ҹ��ڷ� �������ִ� �޼ҵ�
	void changeText(String msg) {
		for (int i = 0; i < msg.length(); i++) {
			if (msg.charAt(i) >= 65 && msg.charAt(i) <= 90) 
				System.out.print((char) (msg.charAt(i) + 32));
			else
				System.out.print((char) (msg.charAt(i) - 32));
		}
	}

	// �ѱ��� ������ �������ִ� �޼ҵ�
	int changeHangle(String msg) {
		String result = "";
		String hangle = "�����̻�����ĥ�ȱ�";
		for (int i = 0; i < msg.length(); i++) {
			result += hangle.indexOf(msg.charAt(i));
		}
		return Integer.parseInt(result);
	}

	public static void main(String[] args) {
		MethodTask func = new MethodTask();
		System.out.println(func.changeHangle("���Ͽ���"));
		func.changeText("aDSs");
	}
}
