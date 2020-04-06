package day05;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class ForTask {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 모든 문제는 for문을 한번만 출력한다.
		// 초기값은 0으로 고정한다.
		// 증감량은 1로 고정한다.
		// 100 ~ 1 출력 (50번 반복)
		// 1 ~ 10합 출력
		// 1 ~n 까지 출력
		// A ~ F까지 출력
		// A ~ F까지 C 뺴고 출력 (5번반복)
		// aBcDeF ... Z출력
		// 012012012출력
		// 구구단 출력(1단 ~ 9단)

		// 1.100 ~ 1 출력
		for (int i = 0; i < 100; i++) {
			System.out.println(100 - i);
		}
		// 2. 1 ~ 10합 출력
		int result = 0;
		for (int i = 0; i < 10; i++) {
			result += i + 1;
		}
		System.out.println(result);

		// 3. 1 ~ n 까지 출력
		String n1Msg = "숫자를 입력하세요.";
		int num = Integer.parseInt(JOptionPane.showInputDialog(n1Msg));
		for (int i = 0; i < num; i++) {
			System.out.println(i + 1);
		}

		// 4. A ~ F까지 출력
		for (int i = 0; i < 6; i++) {
			System.out.printf("%c", 65 + i);
		}
		System.out.println();
		// 5. A ~ F까지 C 빼고 출력
		for (int i = 0; i < 6; i++) {
			if ((char) 65 + i == 'C')
				continue;
			System.out.printf("%c", 65 + i);
		}
		System.out.println();
		// 6. aBcDeF ... Z출력
		int tem = 0;
		for (int i = 0; i < 26; i++) {

//			if (i % 2 == 0) 
//				tem = 97 + i;
//			else 
//				tem = 65 + i;
//			System.out.printf("%c", tem);
			System.out.printf("%c", i%2 ==0 ? 97+i : 65+i);
		}
		System.out.println();

		// 7. 012012012 출력
		for (int i = 0; i < 9; i++) {
			System.out.printf("%d ", i % 3);
		}
		System.out.println();

		// 8. 구구단 출력(1단 ~ 9단) (변수는 한개만 사용)

		for (int i = 0; i < 72; i++) {
			System.out.printf("%d x %d = %d \n", 
					(i / 9 + 2), (i % 9 + 1), (i / 9 + 2) * (i % 9 + 1));
		}
		// 1~100까지 중 짝수반 출력(50번)
		for (int i = 0; i < 50; i++) {
			System.out.printf("%d ", (i + 1) * 2);
		}
		System.out.println();

	}

}
