package day02;

public class Encryption {
	public static void main(String[] args) {
		//���� pw
		String pw = "1q2w3e4r";
		//��ȣȭ
		String en_pw = "";
		//��ȣȭ
		String de_pw = "";
		//key��
		int key = 3;
		
		//��ȣȭ
		for (int i = 0 ; i< pw.length();i++) {
			en_pw += (char)(pw.charAt(i) * key);
			
		}
		System.out.printf("���� : %s\n",pw);
		System.out.printf("��ȣȭ : %s\n",en_pw);
		
		//��ȣȭ
		for (int i = 0 ; i< en_pw.length(); i++) {
			de_pw += (char)(en_pw.charAt(i) / key);
			
		}
		System.out.printf("��ȣȭ : %s\n",de_pw);
	}
}
