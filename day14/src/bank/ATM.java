package bank;

import java.util.Scanner;

public class ATM {
	public static void main(String[] args) {
		String msg = "1. 신한은행 \n2. 국민은행\n3. 우리은행\n 나가기";
		String menu = "1. 계좌개설\n2. 입금하기\n3. 출금하기\n4. 잔액조회 \n. 5.계좌번호 찾기 \n6. 은행 선택";
		
		Scanner sc = new Scanner(System.in);
		int choice = 0, menu_choice = 0;
		
		while(true) {
			System.out.println(msg);
			choice = sc.nextInt();
			
			if(choice == 4) {break;}
			
			while(true) {
				System.out.println(menu);
				menu_choice = sc.nextInt();
				switch(menu_choice) {
				//계좌개설
				case 1:
				//입금
				case 2:
				//출금
				case 3:
				//잔액조회
				case 4:
				//계좌 찾기
				case 5:
				//은행선택으로
				case 6:
				default:
				}
			}
			
		}
	}
}
