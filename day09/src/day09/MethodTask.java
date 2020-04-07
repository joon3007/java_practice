package day09;

import java.util.Scanner;

public class MethodTask {
	// 1 ~ 10 까지 println()으로 출력하는 메소드
	void printNum() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i + 1);
		}
	}

	// 1 ~10까지의 합을 구해주는 메소드
	int sumNumber() {
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += i + 1;
		}
		return sum;
	}

	// 1~n까지의 합을 println()으로 출력해주는 메소드
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

	// 홀수를 짝수로, 짝수를 홀수로 바꿔주는 메소드
	String changeEvenAndOdd(String msg) {
		if (msg.equals("짝수")) {
			return "홀수";
		} else if (msg.equals("홀수"))
			return "짝수";
		else
			return "error";
	}

	// 대문자를 소문자로 변경해주는 메소드
	void changeText(String msg) {
		for (int i = 0; i < msg.length(); i++) {
			if (msg.charAt(i) >= 65 && msg.charAt(i) <= 90) 
				System.out.print((char) (msg.charAt(i) + 32));
			else
				System.out.print((char) (msg.charAt(i) - 32));
		}
	}

	// 한글을 정수로 변경해주는 메소드
	int changeHangle(String msg) {
		String result = "";
		String hangle = "영일이삼사오륙칠팔구";
		for (int i = 0; i < msg.length(); i++) {
			result += hangle.indexOf(msg.charAt(i));
		}
		return Integer.parseInt(result);
	}

	public static void main(String[] args) {
		MethodTask func = new MethodTask();
		System.out.println(func.changeHangle("팔일영오"));
		func.changeText("aDSs");
	}
}
