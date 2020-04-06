package day04;

import java.util.Scanner;

public class OperTask {
	public static void main(String[] args) {
		// 입력 받은 값이 정수인지 실수인지 판단 후 출력하기
		// 숫자 입력 :

		String val = "";
		String n1Msg = "숫자를 입력하세요.";
		String result = "";

		Scanner sc = new Scanner(System.in);
		val = sc.next();
		
		result = val.contains(".") ? "실수" : "정수";

		System.out.println(result);

	}
}
