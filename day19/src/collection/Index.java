package collection;

import java.util.ArrayList;
import java.util.Scanner;

public class Index {
	public static void main(String[] args) {
		int choice = 0;

		User u = new User();
		Scanner sc = new Scanner(System.in);
		ArrayList<String> user = null;
		while (true) {
			System.out.println("1.ȸ������\n2.�α���\n3.������");
			choice = sc.nextInt();

			if (choice == 3) {
				break;
			}

			switch (choice) {
			case 1:
				user = new ArrayList<String>();
				System.out.print("���̵� : ");
				user.add(sc.next());
				System.out.print("��й�ȣ : ");
				user.add(sc.next());
				System.out.print("�̸� : ");
				user.add(sc.next());
				
				u.signIn(user);
				break;
			case 2:
				if (u.getSession() == null) {
					System.out.print("���̵� : ");
					String id = sc.next();
					System.out.print("��й�ȣ : ");
					String pw = sc.next();
					u.login(id, pw);
				} else
					System.out.println("�̹� �α��� ���Դϴ�.");
				break;
			case 3:
				u.logout();
				continue;
			default:
			}
		}
	}
}
