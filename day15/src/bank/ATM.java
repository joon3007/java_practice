package bank;

import java.util.Random;
import java.util.Scanner;

public class ATM {
	public static void main(String[] args) {
		String msg = "1.��������\n2.��������\n3.�츮����\n4.������";
		String menu = "1.���� ����\n2.�Ա��ϱ�\n3.����ϱ�\n4.�ܾ���ȸ\n5.���¹�ȣ ã��\n6.���� ����";

		Scanner sc = new Scanner(System.in);
		int choice = 0, menu_choice = 0;

		String account = "", pw = "", phone = "", name = "";
		int money = 0;

		Random r = new Random();
		
		//Bank�ʵ忡 �����ϱ� ���� ���
		//(�α���, �ߺ��˻�)
		Bank b = new Bank();
		
		//�޼ҵ� ��� �� ����� ��� ���� ��ü
		Bank temp_obj = null;

		//��Ģ�� �ο�
		String[] bank_name = {"��������", "��������", "�츮����"};
		
		while (true) {
			//flag
			//����ڰ� �޴��� ���������� �����ٸ� true
			boolean check = false;
			System.out.println(msg);
			choice = sc.nextInt();

			if (choice == 4) {
				break;
			}
			for(int i=0; i<Bank.arBank.length; i++) {
				if(choice == i+1) {
					check = true;
				}
			}
			//�����ȣ�� �ƴ� �ٸ� ��ȣ�� ������ ��
			if(!check) {continue;}
			
			while (true) {
				System.out.println(menu);
				menu_choice = sc.nextInt();

				if (menu_choice == 6) {
					break;
				}

				switch (menu_choice) {
				// ���°���
				// ���¹�ȣ�� ����, �ߺ� �ȵ� ������ ���� �ݺ�
				// �ڵ��� ��ȣ�� ����(Ư�����ڴ� ���� �ʴ´�)
				// ��й�ȣ�� 4�ڸ�(�ƴ� �� ���ѹݺ�)
				// ��й�ȣ ��ȣȭ
				// �� �۾� ��� �Ϸ�� �ش� ��ü arBank[?][?]�� �ֱ�
				case 1:
					// 100000~999999
					// 0~899999 + 100000
					while (true) {
						//���¹�ȣ ����(6�ڸ�)
						account = "" + (r.nextInt(900000) + 100000);
						if (b.checkDup_account(account) == null) {
							//�ߺ��� ���ٸ� Ż��
							break;
						}
					}
					System.out.print("������ : ");
					name = sc.next();

					while(true) {
						boolean flag = false;
						System.out.print("��й�ȣ(4�ڸ�) : ");
						pw = sc.next();
						//���� �˻�(4�ڸ��� �ƴϸ� ���� �ݺ�)
						if(pw.length() != 4) {continue;}
						
						//'����'�� �ƴ� ���� �˻�
						for (int i = 0; i < pw.length(); i++) {
							char c = pw.charAt(i);
							if(c < 48 || c > 57) {
								flag = true;
							}
						}
						//�������� ��й�ȣ �Է½� Ż��
						if(!flag) {break;}
					}
					
					while(true) {
						boolean flag = false;
						System.out.print("�ڵ��� ��ȣ('-'����) : ");
						phone = sc.next();
						//���� �˻�
						if(phone.length() != 11) {continue;}
						
						//'����'�� �ƴ� ���� �˻�
						for (int i = 0; i < phone.length(); i++) {
							char c = phone.charAt(i);
							if(c < 48 || c > 57) {
								flag = true;
							}
						}
						
						//�������� �ڵ��� ��ȣ�� �Է��ߴٸ� Ż��
						if(!flag && b.checkDup_phone(phone) == null) {break;}
					}
					
					//��� �� �Է����� �� ���� ����
					temp_obj = Bank.getInstance(choice);
					temp_obj.name = name;
					temp_obj.account = account;
					temp_obj.phone = phone;
					//��ȣȭ�� �� ����
					temp_obj.pw = b.encrypt(pw);

					//�ش� ������ ���� ��������(choice-1) : ��
					//���° ������(Bank.arCnt[choice-1]) : ��
					
					Bank.arBank[choice-1][Bank.arCnt[choice-1]] = temp_obj;
//					System.out.println(Bank.arBank[choice-1][Bank.arCnt[choice-1]]);
					//�ش� ���� �� �� 1����
					Bank.arCnt[choice-1]++;
					System.out.println("���� ���� ����!");
					System.out.println(name + "���� ���¹�ȣ : " + account);
					break;
				// �Ա�(Ÿ�� �Ա� �Ұ�)
				case 2:
					System.out.print("���¹�ȣ : ");
					account = sc.next();
					System.out.print("��й�ȣ : ");
					pw = sc.next();
					
					//�α��� ������ �ش� ��ü�� ���ϵȴ�.
					temp_obj = b.login(account, pw);
					if(temp_obj != null) {
						//�α��� ������ ����
//						System.out.println(temp_obj.bank_num);
						if(temp_obj.bank_num != choice-1) {
							//���� �����ȣ�� ���� ���� �ִ� ������ �ٸ���
							//�Ա� �Ұ�
							System.out.println(bank_name[temp_obj.bank_num]+ "���� �Ա� �����մϴ�.");
							continue;
						}
						System.out.print("�Աݾ� : ");
						money = sc.nextInt();
						temp_obj.deposit(money);
						System.out.println("�Ա� ����");
					}else {
						System.out.println("�Ա� ���� / ���¹�ȣ Ȥ�� ��й�ȣ ����");
					}
					break;
				// ���
				case 3:
					System.out.print("���¹�ȣ : ");
					account = sc.next();
					System.out.print("��й�ȣ : ");
					pw = sc.next();
					
					temp_obj = b.login(account, pw);
					if(temp_obj != null) {
						System.out.print("��ݾ� : ");
						money = sc.nextInt();
						//�ܾ� �����̸� false, �����̸� true ����
						if(temp_obj.withdraw(money)) {
							System.out.println("��� ����");
							System.out.println("���� �ܾ� : " + temp_obj.money + "��");
						}else {
							System.out.println("��� ���� / �ܾ� ����");
						}
					}else {
						System.out.println("��� ���� / ���¹�ȣ Ȥ�� ��й�ȣ ����");
					}
					break;
				// �ܾ���ȸ
				case 4:
					System.out.print("���¹�ȣ : ");
					account = sc.next();
					System.out.print("��й�ȣ : ");
					pw = sc.next();
					
					temp_obj = b.login(account, pw);
					if(temp_obj != null) {
						//189, 190��° �� ��� ���� ���
//						System.out.println(temp_obj.toString());
						System.out.println(temp_obj);
					}else {
						System.out.println("���¹�ȣ Ȥ�� ��й�ȣ ����");
					}
					break;
				// ���� ã��
				case 5:
					//�ڵ�����ȣ, ��й�ȣ
					System.out.print("������ �Է��� �ڵ��� ��ȣ : ");
					phone = sc.next();
					
					temp_obj = b.checkDup_phone(phone);
					if(temp_obj != null) {
						System.out.print("��й�ȣ : ");
						pw = sc.next();
						//���� ��й�ȣ�� ��ȣȭ�� �Ǿ� �ֱ� ������
						//����ڰ� �Է��� ��й�ȣ�� ��ȣȭ ���ش�.
						if(temp_obj.pw.equals(b.encrypt(pw))) {
							//���ο� ���¹�ȣ ����
							while(true) {
								account = "" + (r.nextInt(900000) + 100000);
								if(b.checkDup_account(account) == null) {break;}
							}
							//���Ӱ� ������ ���¹�ȣ�� ����
							temp_obj.account = account;
							System.out.println("����Ȯ�� �Ϸ�");
							System.out.println("���ο� ���¹�ȣ : " + account);
						}
					}else {
						System.out.println("��ϵ��� ���� ��ȣ�Դϴ�.");
					}
					break;
				}
			}
		}
	}
}
