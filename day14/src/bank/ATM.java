package bank;

import java.util.Scanner;

public class ATM {
	public static void main(String[] args) {
		String msg = "1. �������� \n2. ��������\n3. �츮����\n ������";
		String menu = "1. ���°���\n2. �Ա��ϱ�\n3. ����ϱ�\n4. �ܾ���ȸ \n. 5.���¹�ȣ ã�� \n6. ���� ����";
		
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
				//���°���
				case 1:
				//�Ա�
				case 2:
				//���
				case 3:
				//�ܾ���ȸ
				case 4:
				//���� ã��
				case 5:
				//���༱������
				case 6:
				default:
				}
			}
			
		}
	}
}
