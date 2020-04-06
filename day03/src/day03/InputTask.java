package day03;

import java.util.Scanner;

public class InputTask {
	public static void main(String[] args) {
		// 두 정수를 입력밥고(next() 사용)
		// 두 정수의 합 출력
		Scanner sc = new Scanner(System.in);

		int val1 = 0;
		int val2 = 0;
		int result = 0;
		String msg = "";

		String n1Msg = "첫번째 정수 :  ";
		String n2Msg = "두번째 정수 :  ";

		System.out.print(n1Msg);
		//val1 = Integer.parseInt(sc.next());
		val1 = sc.nextInt();
		System.out.print(n2Msg);
		//val2 = Integer.parseInt(sc.next());
		val2 = sc.nextInt();
		result = val1 + val2;
		//String.format("서식문자", 값); : 문자열 값
		
		msg = String.format("%d + %d = %d", val1, val2, result);
		System.out.printf(msg);
	}
}
