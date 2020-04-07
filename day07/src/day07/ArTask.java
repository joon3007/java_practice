package day07;

import java.util.Scanner;

public class ArTask {
	public static void main(String[] args) {
		// *초급*//
		// 100 ~ 1 까지 배열에 넣고 출력
		int[] arNum = new int[100];

		for (int i = 0; i < arNum.length; i++) {
			arNum[i] = i + 1;
			System.out.println(arNum[i]);
		}
		// 1 ~ 100까지 중 짝수만 배열에 넣고 출력
		for (int i = 0; i < arNum.length / 2; i++) {
			arNum[i] = (i + 1) * 2;
			System.out.println(arNum[i]);
		}
		// 1 ~ 10까지 배열에 넣고 총 합 출력
		int[] arNum2 = new int[10];
		int total = 0;
		for (int i = 0; i < arNum.length / 2; i++) {
			arNum[i] = i + 1;
			total += arNum[i];
		}
		System.out.println(total);

		// *중급*//
		// A~F까지 배열에 넣고 출력
		char[] arInt = new char[6];
		for (int i = 0; i < arInt.length; i++) {
			arInt[i] = (char) (65 + i);
			System.out.printf("%c", arInt[i]);
		}
		// A~F까지 중 e를 제외하고 배열에 넣고 출력
		char[] arInt2 = new char[6];
		for (int i = 0; i < arInt2.length; i++) {
			if (65 + i == 'C')
				continue;
			arInt2[i] = (char) (65 + i);
			System.out.printf("%c", arInt2[i]);
		}
		System.out.println();

		// 5개의 정수를 입력받고 최대값과 최소값 출력하기
		Scanner sc = new Scanner(System.in);
		int[] arInt3 = new int[5];
		int max = 0, min = 0;
		for (int i = 0; i < arInt3.length; i++) {
			System.out.printf("%d번째 정수를 입력해주세요.", i + 1);
			if (i == 0) {
				max = sc.nextInt();
				min = max;
				continue;
			}
			int tem = sc.nextInt();
			if (max < tem) {
				max = tem;
			} else if (min > tem)
				min = tem;
		}
		System.out.println("최대값 : " + max + " 최솟값 : " + min);

		// *고급*//
		// 문자열을 입력받고(한글제외) 소문자는 대문자로 변경해서 출력

		System.out.println("문자열을 입력해주세요.");
		String msg = sc.next();
		for (int i = 0; i < msg.length(); i++) {
			if (msg.charAt(i) > 96)
				System.out.printf("%c", msg.charAt(i) - 32);
			else
				System.out.println(msg.charAt(i));
		}
		System.out.println();

		// 정수 입력받고 한글로 변경해서 출력
		System.out.println("정수를 입력해주세요.");
		String korNum = "공일이삼사오육칠팔구";
		String msg2 = sc.next();
		for (int i = 0; i < msg2.length(); i++)
			System.out.printf("%s", korNum.charAt(msg2.charAt(i) - 48));
		System.out.println();
		// 입력 예)1024
		// 출력 예)일공이사

	}
}
