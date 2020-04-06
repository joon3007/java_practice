package day02;

public class Encryption {
	public static void main(String[] args) {
		//기존 pw
		String pw = "1q2w3e4r";
		//암호화
		String en_pw = "";
		//복호화
		String de_pw = "";
		//key값
		int key = 3;
		
		//암호화
		for (int i = 0 ; i< pw.length();i++) {
			en_pw += (char)(pw.charAt(i) * key);
			
		}
		System.out.printf("기존 : %s\n",pw);
		System.out.printf("암호화 : %s\n",en_pw);
		
		//복호화
		for (int i = 0 ; i< en_pw.length(); i++) {
			de_pw += (char)(en_pw.charAt(i) / key);
			
		}
		System.out.printf("복호화 : %s\n",de_pw);
	}
}
