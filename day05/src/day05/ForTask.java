package day05;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class ForTask {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ��� ������ for���� �ѹ��� ����Ѵ�.
		// �ʱⰪ�� 0���� �����Ѵ�.
		// �������� 1�� �����Ѵ�.
		// 100 ~ 1 ��� (50�� �ݺ�)
		// 1 ~ 10�� ���
		// 1 ~n ���� ���
		// A ~ F���� ���
		// A ~ F���� C ���� ��� (5���ݺ�)
		// aBcDeF ... Z���
		// 012012012���
		// ������ ���(1�� ~ 9��)

		// 1.100 ~ 1 ���
		for (int i = 0; i < 100; i++) {
			System.out.println(100 - i);
		}
		// 2. 1 ~ 10�� ���
		int result = 0;
		for (int i = 0; i < 10; i++) {
			result += i + 1;
		}
		System.out.println(result);

		// 3. 1 ~ n ���� ���
		String n1Msg = "���ڸ� �Է��ϼ���.";
		int num = Integer.parseInt(JOptionPane.showInputDialog(n1Msg));
		for (int i = 0; i < num; i++) {
			System.out.println(i + 1);
		}

		// 4. A ~ F���� ���
		for (int i = 0; i < 6; i++) {
			System.out.printf("%c", 65 + i);
		}
		System.out.println();
		// 5. A ~ F���� C ���� ���
		for (int i = 0; i < 6; i++) {
			if ((char) 65 + i == 'C')
				continue;
			System.out.printf("%c", 65 + i);
		}
		System.out.println();
		// 6. aBcDeF ... Z���
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

		// 7. 012012012 ���
		for (int i = 0; i < 9; i++) {
			System.out.printf("%d ", i % 3);
		}
		System.out.println();

		// 8. ������ ���(1�� ~ 9��) (������ �Ѱ��� ���)

		for (int i = 0; i < 72; i++) {
			System.out.printf("%d x %d = %d \n", 
					(i / 9 + 2), (i % 9 + 1), (i / 9 + 2) * (i % 9 + 1));
		}
		// 1~100���� �� ¦���� ���(50��)
		for (int i = 0; i < 50; i++) {
			System.out.printf("%d ", (i + 1) * 2);
		}
		System.out.println();

	}

}
