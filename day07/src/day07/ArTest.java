package day07;

import java.util.Scanner;

public class ArTest {
	public static void main(String[] args) {
		// 구찌
		// 강남점 홍대점 신촌점
		// 평균 매출액은 100원단위까지 출력한다.
		int[] arIncome = new int[3];
		String[] arBranch = { "강남점", "홍대점", "신촌점" };
		Scanner sc = new Scanner(System.in);
		int total = 0;
		double avg = 0.0;

		for (int i = 0; i < arIncome.length; i++) {
			System.out.println(arBranch[i] + " 매출액 입력(단위:만원)");
			arIncome[i] = sc.nextInt();
			// 총 매출액을 구하는 영역
			total += arIncome[i];
		}
		avg = Double.parseDouble(String.format("%.2f", (double) total / arIncome.length));

		System.out.println("구찌 총 매출액 : " + total + "만원");
		System.out.println("구찌 평균 매출액 : " + avg + "만원");

		// 평균 매출액보다 높은 매장은 인센티브 매장으로 출력
		// 인센티브매장
		// 강남점
		// 홍대점

		// 인센티브 매장이 없다면 해당사항 없음을 출력
		// 인센티브매장
		// 해당사항 없음
		int count = 0;
		System.out.println("★인센티브 매장★");
		for (int i = 0; i < arBranch.length; i++) {
			if (arIncome[i] > avg) {
				System.out.println(arBranch[i]);
				count++;
			}
		}
		if (count == 0)
			System.out.println("해당사항 없음");

		
	}
}
