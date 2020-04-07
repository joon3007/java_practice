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
			System.out.println("1.회원가입\n2.로그인\n3.나가기");
			choice = sc.nextInt();

			if (choice == 3) {
				break;
			}

			switch (choice) {
			case 1:
				user = new ArrayList<String>();
				System.out.print("아이디 : ");
				user.add(sc.next());
				System.out.print("비밀번호 : ");
				user.add(sc.next());
				System.out.print("이름 : ");
				user.add(sc.next());
				
				u.signIn(user);
				break;
			case 2:
				if (u.getSession() == null) {
					System.out.print("아이디 : ");
					String id = sc.next();
					System.out.print("비밀번호 : ");
					String pw = sc.next();
					u.login(id, pw);
				} else
					System.out.println("이미 로그인 중입니다.");
				break;
			case 3:
				u.logout();
				continue;
			default:
			}
		}
	}
}
